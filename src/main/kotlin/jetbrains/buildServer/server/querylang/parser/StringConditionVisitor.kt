package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast_old.*

object StringConditionVisitor : QLangGrammarBaseVisitor<ConditionAST<StringFilter>>() {
    override fun visitSingleStringFilter(ctx: QLangGrammarParser.SingleStringFilterContext?): ConditionAST<StringFilter> {
        return FilterConditionNode(
            ctx!!.stringFilter().accept(StringFilterVisitor)
        )
    }

    override fun visitMultipleStringFilter(ctx: QLangGrammarParser.MultipleStringFilterContext?): ConditionAST<StringFilter> {
        return ctx!!.stringCondition().accept(this)
    }

    override fun visitStringConditionAnd(ctx: QLangGrammarParser.StringConditionAndContext?): ConditionAST<StringFilter> {
        return AndConditionNode(
            ctx!!.stringCondition(0).accept(this),
            ctx.stringCondition(1).accept(this)
        )
    }

    override fun visitStringConditionOr(ctx: QLangGrammarParser.StringConditionOrContext?): ConditionAST<StringFilter> {
        return OrConditionNode(
            ctx!!.stringCondition(0).accept(this),
            ctx.stringCondition(1).accept(this)
        )
    }

    override fun visitStringConditionNot(ctx: QLangGrammarParser.StringConditionNotContext?): ConditionAST<StringFilter> {
        return NotConditionNode(
            ctx!!.stringCondition().accept(this)
        )
    }

    override fun visitStringConditionFilter(ctx: QLangGrammarParser.StringConditionFilterContext?): ConditionAST<StringFilter> {
        return FilterConditionNode(
            ctx!!.stringFilter().accept(StringFilterVisitor)
        )
    }
}