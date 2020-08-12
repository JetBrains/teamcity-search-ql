package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast_old.*
import java.lang.IllegalStateException

object MainQueryVisitor : QLangGrammarBaseVisitor<MainQuery>() {

    override fun visitStart(ctx: QLangGrammarParser.StartContext?): MainQuery {
        return if (ctx!!.find() != null) ctx.find().accept(this)
               else ctx.partialQuery().accept(this)
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

    override fun visitPartialQuery(ctx: QLangGrammarParser.PartialQueryContext?): MainQuery {
        val condition: ConditionAST<Filter> = ctx!!.condition().accept(anyFilterConditionVisitor)
        val queryVars = TypeDeduce().deduceQueryType(condition, 1)
        return MultipleMainQuery(queryVars)
    }
}