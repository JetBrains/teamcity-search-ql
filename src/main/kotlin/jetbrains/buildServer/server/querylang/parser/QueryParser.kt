package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.FindMultipleTypes
import jetbrains.buildServer.server.querylang.ast.MainQuery
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class QueryParser {
    fun parse(input: String): FindMultipleTypes {
        val stream = CharStreams.fromString(input)
        val parser = initParser(stream)
        parser.removeErrorListeners()
        parser.addErrorListener(ErrorListener())
        return parser.parse()
    }

    private fun initParser(s: CharStream): GrammarParser {
        val lexer = QLangGrammarLexer(s)
        val tokens = CommonTokenStream(lexer)
        return GrammarParser(tokens)
    }
}