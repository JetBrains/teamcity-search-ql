package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.lang.Exception

object QueryParser {

    fun parse(input: String, withCollector: Boolean = false): MainQuery {
        val stream = CharStreams.fromString(input)
        val parser = initParser(stream)
        parser.removeErrorListeners()
        parser.addErrorListener(ErrorListener())
        val res = parser.parse()
        validateQuery(res, withCollector)
        return res
    }

    private fun initParser(s: CharStream): GrammarParser {
        val lexer = QLangGrammarLexer(s)
        lexer.removeErrorListeners()
        lexer.addErrorListener(ErrorListener())
        val tokens = CommonTokenStream(lexer)
        return GrammarParser(tokens)
    }

    fun parseWithErrors(input: String, withCollector: Boolean): MainQuery? {
        val stream = CharStreams.fromString(input)
        val parser = initParser(stream)
        parser.removeErrorListeners()
        val res = try {
            parser.parse()
        } catch (e: Exception) {
            return null
        }
        validateQuery(res, withCollector)
        return res
    }

    fun validateQuery(condition: ConditionAST<*>, withCollector: Boolean): CollectorFilter? {
        return when(condition) {
            is AndConditionNode -> {
                validateQuery(condition.left, false)
                validateQuery(condition.right, withCollector)
            }
            is OrConditionNode -> {
                validateQuery(condition.left, false)
                validateQuery(condition.right, withCollector)
            }
            is NotConditionNode -> {
                validateQuery(condition.cond, withCollector)
            }
            is FilterConditionNode -> {
                validateQuery(condition.filter, withCollector)
            }
            else -> null
        }
    }

    fun validateQuery(filter: Filter<*>, withCollector: Boolean): CollectorFilter? {
        return when(filter) {
            is StringParamFilter -> {
                validateQuery(filter.valueCondition, withCollector)
                validateQuery(filter.valueCondition, withCollector)
            }
            is CollectorFilter -> {
                if (!withCollector) {
                    throw ParsingException("Wrong subfilter '?'")
                } else {
                    filter
                }
            }
            is ConditionContainer<*> -> {
                validateQuery(filter.condition, withCollector)
            }
            else -> null
        }
    }

    fun validateQuery(mquery: MainQuery, withCollector: Boolean) {
        when(mquery) {
            is FullQuery -> {
                validateQuery(mquery.queries.first().condition, withCollector)
            }
            is PartialQuery -> {
                validateQuery(mquery.fullQueries.first(), withCollector)
            }
        }
    }
}