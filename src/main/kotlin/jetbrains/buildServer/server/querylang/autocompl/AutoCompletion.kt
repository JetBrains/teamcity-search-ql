package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.parser.QLangGrammarLexer
import jetbrains.buildServer.server.querylang.parser.QLangGrammarParser
import jetbrains.buildServer.serverSide.ProjectManager
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNodeImpl
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.TerminalNode
import java.lang.IllegalStateException

class AutoCompletion(val projectManager: ProjectManager? = null) {
    fun complete(input: String): List<String> {
        val stream = CharStreams.fromString(input)
        val lexer = QLangGrammarLexer(stream)
        val tokens = CommonTokenStream(lexer)
        val parser = QLangGrammarParser(tokens)
        parser.removeErrorListeners()

        val start = parser.start()
        if (start.children.size > 2) {
            return emptyList()
        }

        val treeNode: ParserRuleContext = start.find()
        val trace = getFilterTrace(treeNode, input) ?: return emptyList()

        return Completer(projectManager).suggest(trace.dropLast(1), trace.last(), 10)
    }


    private fun getFilterTrace(rootNode: ParserRuleContext, input: String): List<String>? {
        var node: ParseTree = rootNode
        val trace = mutableListOf<String>()
        var lastParsedIndex = 0
        loop@ while (true) {
            if (node is QLangGrammarParser.FindContext) {
                if (node.childCount < 1) {
                    return null
                }
                if (node.children.size == 1) {
                    if (node.getChild(0).text == "find" && input.length >= 5) {
                        return listOf("")
                    }
                    return null
                }
                val child = node.getChild(1) ?: break
                when (child) {
                    is ParserRuleContext -> trace.add(child.start.text)
                }

            }

            if (node is QLangGrammarParser.FilterContext) {
                val child = node.getChild(0)
                trace.add(
                        when (child) {
                            is ParserRuleContext -> child.start.text
                            else -> throw IllegalStateException("Unknown filter")
                        }
                )
            }

            if (node.childCount == 0) {
                break
            }

            when (node) {
                is QLangGrammarParser.FindContext -> {
                    //analyzing different cases: `find pro...`, `find project wi`, etc

                    //when object name wasn't finished: `find pro`
                    if (node.getChild(1) is ErrorNodeImpl) {
                        val b = node.getChild(0) as TerminalNode
                        lastParsedIndex = b.symbol.stopIndex
                        break@loop
                    }

                    //when there is no `with` keyword
                    val node1 = node.getChild(1)
                    if (node1.childCount == 2) {
                        if (node1.getChild(1) !is QLangGrammarParser.ConditionInSubprojectContext
                        ) {
                            return null
                        }
                    }

                    //'with' keyword hasn't started
                    if (node1.childCount == 1) {
                        //get last index of 'find' keyword
                        lastParsedIndex = getIndex(node, 0)
                        return listOf(input.substring(lastParsedIndex + 1).trimStart())
                    }

                    lastParsedIndex = getLastIndex(node1)
                    node = node1.getChild(node1.childCount - 1)
                }
                is QLangGrammarParser.ConditionBracesContext -> {
                    lastParsedIndex = getIndex(node, 0)
                    node = node.condition()
                }
                is QLangGrammarParser.MultFilterContext -> {
                    lastParsedIndex = getIndex(node, 0)
                    node = node.condition()
                }
                else -> {
                    val n = node.childCount

                    if (node.parent is QLangGrammarParser.FilterContext) {
                        if (!(node.getChild(n - 1) is QLangGrammarParser.FilterOrConditionContext)) {
                            //get the last index of the filter name
                            lastParsedIndex = getIndex(node, 0)

                            //then this filter doesn't have nested filter and
                            //there is no point to go down the tree
                            break@loop
                        }
                    }

                    if (n - 2 >= 0) {
                        lastParsedIndex = getLastIndex(node)
                    }
                    node = node.getChild(n - 1)
                }
            }
        }

        val lastWord = input.substring(lastParsedIndex + 1).trimStart()
        if (lastWord.isEmpty()) {

            //if `lastWord` is empty then we complete empty string
            //but if the last symbol is not ' ' or '(' then
            //we want to complete the last word in `trace` not start the new one
            if (lastParsedIndex + 1 >= input.length || input[lastParsedIndex + 1] !in listOf(' ', '(', ')')) {
                if (trace.size == 0) {
                    return null
                }
                return trace
            }
        }
        trace.add(lastWord)
        return trace
    }

    private fun getLastIndex(node: ParseTree): Int {
        return getIndex(node, node.childCount - 2)
    }

    private fun getIndex(node: ParseTree, i: Int): Int {
        val child = node.getChild(i)
        return when (child) {
            is ParserRuleContext -> child.stop.stopIndex
            is TerminalNode -> child.symbol.stopIndex
            else -> throw IllegalStateException("Unknown node type")
        }
    }
}