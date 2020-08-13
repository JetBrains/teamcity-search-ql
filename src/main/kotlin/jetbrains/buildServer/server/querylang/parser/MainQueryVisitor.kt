package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import java.lang.IllegalStateException

object MainQueryVisitor : QLangGrammarBaseVisitor<MainQuery>() {

    override fun visitStart(ctx: QLangGrammarParser.StartContext?): MainQuery {
        return if (ctx!!.find() != null) ctx.find().accept(this)
               else ctx.partialQuery().accept(this)
    }

    override fun visitFind(ctx: QLangGrammarParser.FindContext?): MainQuery {
        val objectKeywords = ctx!!.multipleObjects().objectKeyword()
        val queries: List<TopLevelQuery> = objectKeywords.map { objKeyword ->
            when (objKeyword.getChild(0)) {
                is QLangGrammarParser.ProjectKewordContext -> {
                    ProjectTopLevelQuery(ctx.conditionInSubproject().accept(ConditionVisitor(ProjectTopLevelQuery::class))) as TopLevelQuery
                }
                is QLangGrammarParser.BuildConfKewordContext -> {
                    BuildConfTopLevelQuery(ctx.conditionInSubproject().accept(ConditionVisitor(BuildConfTopLevelQuery::class)))
                }
                is QLangGrammarParser.TemplateKeywordContext -> {
                    TemplateTopLevelQuery(ctx.conditionInSubproject().accept(ConditionVisitor(TemplateTopLevelQuery::class)))
                }
                is QLangGrammarParser.VcsRootKeywordContext -> {
                    VcsRootTopLevelQuery(ctx.conditionInSubproject().accept(ConditionVisitor(VcsRootTopLevelQuery::class)))
                }
                else -> throw IllegalStateException("Unknown keyword in search query")
            }
        }
        return MainQuery(queries)
    }

    override fun visitPartialQuery(ctx: QLangGrammarParser.PartialQueryContext?): MainQuery {
        /*val condition: ConditionAST<Filter> = ctx!!.condition().accept(anyFilterConditionVisitor)
        val queryVars = TypeDeduce().deduceQueryType(condition, 1)

         */
        return MainQuery(emptyList())
    }
}