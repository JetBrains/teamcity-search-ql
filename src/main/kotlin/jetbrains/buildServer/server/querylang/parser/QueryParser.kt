package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast_old.*
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

object QueryParser {

    init {
        FilterTypeRegistration.connectFilterType(ProjectConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(BuildConfConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(TemplateConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(ParHolderConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(VcsRootConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(VcsRootEntryConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(DependencyConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(SnapshotDepConditionContainer::class.java)
        FilterTypeRegistration.connectFilterType(ArtifactDepConditionContainer::class.java)
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
        lexer.removeErrorListeners()
        lexer.addErrorListener(ErrorListener())
        val tokens = CommonTokenStream(lexer)
        return GrammarParser(tokens)
    }
}