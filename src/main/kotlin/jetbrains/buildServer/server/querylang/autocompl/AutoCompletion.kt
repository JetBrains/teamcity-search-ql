package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.parser.QLangGrammarLexer
import jetbrains.buildServer.server.querylang.parser.QLangGrammarParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNodeImpl
import org.antlr.v4.runtime.tree.ParseTree
import java.lang.IllegalStateException

object AutoCompletion {
    fun comlete(input: String): List<String>? {
        val stream = CharStreams.fromString(input)
        val lexer = QLangGrammarLexer(stream)
        val tokens = CommonTokenStream(lexer)
        val parser = QLangGrammarParser(tokens)
        val treeNode: ParserRuleContext = parser.find()
        val trace = getFilterTrace(treeNode, input) ?: return null
        val variants = Completer.suggest(trace.dropLast(1), trace.last(), 10)
        return variants
    }

    private fun getFilterTrace(rootNode: ParserRuleContext, input: String): List<String>? {
        var node: ParseTree = rootNode
        val trace = mutableListOf<String>()
        loop@ while (true) {
            if (node.childCount == 0) {
                if (node is ErrorNodeImpl
                        && node.text.startsWith("<")
                        && node.text.endsWith(">")
                ) {
                    trace.add("")
                }
                else {
                    if (node is QLangGrammarParser.ParameterValueContext) {
                        trace.add(input
                                .substringAfterLast("\"", "")
                                .substringBefore("\"")
                        )
                    } else {
                        trace.add(node.text)
                    }
                }
                break
            }
            if (node is QLangGrammarParser.FilterContext) {
                trace.add(
                        when (node.getChild(0)) {
                            is QLangGrammarParser.IdFilterContext -> "id"
                            is QLangGrammarParser.ProjectFilterContext -> "project"
                            is QLangGrammarParser.ParentFilterContext -> "parent"
                            is QLangGrammarParser.TriggerFilterContext -> "trigger"
                            is QLangGrammarParser.StepFilterContext -> "step"
                            is QLangGrammarParser.FeatureFilterContext -> "feature"
                            is QLangGrammarParser.TypeFilterContext -> "type"
                            is QLangGrammarParser.ParameterFilterContext -> "param"
                            is QLangGrammarParser.EnabledFilterContext -> "enabled"
                            is QLangGrammarParser.AncestorFilterContext -> "ancestor"
                            is QLangGrammarParser.AncestorOrSelfFilterContext -> "ancestorOrSelf"
                            is QLangGrammarParser.TemplateDepFilterContext -> "template"
                            else -> throw IllegalStateException("Unkonw filter")
                        }
                )
            }

            if (node is QLangGrammarParser.FindContext) {
                trace.add(
                        when (node.getChild(1)) {
                            is QLangGrammarParser.FprojectContext -> "project"
                            is QLangGrammarParser.FbuildConfContext -> "buildConf"
                            is QLangGrammarParser.FbuildConfOrTempContext -> "buildConfOrTemp"
                            is QLangGrammarParser.FtemplateContext -> "template"
                            is QLangGrammarParser.FvcsRootContext -> "vcsRoot"
                            is ErrorNodeImpl -> {node = node.getChild(1); continue@loop}
                            else -> throw IllegalStateException("Unkonw find query")
                        }
                )
            }

            when (node) {
                is QLangGrammarParser.ConditionBracesContext -> {
                    node = node.condition()
                }
                is QLangGrammarParser.MultFilterContext -> {
                    node = node.condition()
                }
                is QLangGrammarParser.ParameterFilterContext -> {
                    if (node.IDENT() != null) {
                        trace.add(input.substring(node.IDENT().symbol.startIndex))
                    }
                    else {
                        trace.add("")
                    }
                    break@loop
                }
                else -> {
                    val n = node.childCount
                    node = node.getChild(n - 1)
                }
            }
        }
        if (trace.isNotEmpty() && !input.endsWith(trace.last())) {
            return null
        }
        return trace
    }
}