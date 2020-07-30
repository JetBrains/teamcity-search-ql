package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

object QueryParser {

    init {
        FilterTypeRegistration.connectFilterType(ProjectComplexFilter::class.java)
        FilterTypeRegistration.connectFilterType(BuildConfComplexFilter::class.java)
        FilterTypeRegistration.connectFilterType(TemplateComplexFilter::class.java)
        FilterTypeRegistration.connectFilterType(ParHolderComplexFilter::class.java)
        FilterTypeRegistration.connectFilterType(VcsRootComplexFilter::class.java)
        FilterTypeRegistration.connectFilterType(VcsRootEntryComplexFilter::class.java)
    }

    fun parse(input: String): MainQuery {
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