package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import java.lang.IllegalStateException

object MainQueryVisitor : QLangGrammarBaseVisitor<FindMultipleTypes>() {

    override fun visitStart(ctx: QLangGrammarParser.StartContext?): FindMultipleTypes {
        return ctx!!.find().accept(this)
    }

    override fun visitFind(ctx: QLangGrammarParser.FindContext?): FindMultipleTypes {
        val objectKeywords = ctx!!.multipleObjects().objectKeyword()
        val queries = objectKeywords.map { objKeyword ->
            when (objKeyword.getChild(0)) {
                is QLangGrammarParser.ProjectKewordContext -> {
                    FindProject(ctx.conditionInSubproject().accept(projectConditionVisitor))
                }
                is QLangGrammarParser.BuildConfKewordContext -> {
                    FindBuildConf(ctx.conditionInSubproject().accept(buildConfConditionVisitor))
                }
                is QLangGrammarParser.TemplateKeywordContext -> {
                    FindTemplate(ctx.conditionInSubproject().accept(tempConditionVisitor))
                }
                is QLangGrammarParser.VcsRootKeywordContext -> {
                    FindVcsRoot(ctx.conditionInSubproject().accept(vcsRootConditionVisitor))
                }
                else -> throw IllegalStateException("Unknown keyword in search query")
            }
        }
        return FindMultipleTypes(queries)
    }
}