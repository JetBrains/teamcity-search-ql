package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

class ConditionVisitor<T : Filter>(
        val filterVisitor: FilterVisitor<T>,
        val filterType: KClass<T>
) : QLangGrammarBaseVisitor<ConditionAST<T>>() {

    override fun visitConditionInSubproject(ctx: QLangGrammarParser.ConditionInSubprojectContext?): ConditionAST<T> {
        var condition1: ConditionAST<T>? = null
        if (ctx!!.objectId() != null) {
            condition1 = FilterConditionNode<T>(
                    filterType.safeCast(
                        SProjectFilter(FilterConditionNode(IdFilter(ctx.objectId().text)))
                    ) ?: throw IllegalStateException("visitConditionInSubproject was invoked from wrong context")
            )
        }
        var condition2: ConditionAST<T>? = null
        if (ctx.condition() != null) {
            condition2 = this.visit(ctx.condition())
        }

        if (condition1 != null && condition2 != null) {
            return AndConditionNode(
                    condition1,
                    condition2
            )
        }
        return condition1 ?: condition2!!
    }

    override fun visitSingleFilter(ctx: QLangGrammarParser.SingleFilterContext?): ConditionAST<T> {
        return FilterConditionNode(ctx!!.filter().accept(filterVisitor))
    }

    override fun visitMultFilter(ctx: QLangGrammarParser.MultFilterContext?): ConditionAST<T> {
        return ctx!!.condition().accept(this)
    }

    override fun visitConditionAnd(ctx: QLangGrammarParser.ConditionAndContext?): ConditionAST<T> {
        return AndConditionNode(
                ctx!!.condition(0).accept(this),
                ctx.condition(1).accept(this)
        )
    }

    override fun visitConditionOr(ctx: QLangGrammarParser.ConditionOrContext?): ConditionAST<T> {
        return OrConditionNode(
                ctx!!.condition(0).accept(this),
                ctx.condition(1).accept(this)
        )
    }

    override fun visitConditionNot(ctx: QLangGrammarParser.ConditionNotContext?): ConditionAST<T> {
        return NotConditionNode(
                ctx!!.condition().accept(this)
        )
    }

    override fun visitConditionBraces(ctx: QLangGrammarParser.ConditionBracesContext?): ConditionAST<T> {
        return ctx!!.condition().accept(this)
    }

    override fun visitConditionFilter(ctx: QLangGrammarParser.ConditionFilterContext?): ConditionAST<T> {
        return FilterConditionNode(ctx!!.filter().accept(filterVisitor))
    }
}