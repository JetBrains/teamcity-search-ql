package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.ast.ConditionAST
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

class ConditionVisitor<NestedObj>(
    val parentFilter: KClass<out ConditionContainer<NestedObj>>
) : QLangGrammarBaseVisitor<RealConditionAST<NestedObj>>()
{
    private val filterVisitor = FilterVisitor(parentFilter)

    override fun visitConditionInSubproject(ctx: QLangGrammarParser.ConditionInSubprojectContext?): RealConditionAST<NestedObj> {
        var condition1: RealConditionAST<NestedObj>? = null
        if (ctx!!.objectId() != null) {
            condition1 = FilterConditionNode(
                        ProjectFilter(FilterConditionNode(IdFilter(
                            FilterConditionNode(EqualsStringFilter(ctx.objectId().text)))
                        )).checkAndCast(parentFilter)
                     ?: throw IllegalStateException("visitConditionInSubproject was invoked from wrong context")
            )
        }
        var condition2: RealConditionAST<NestedObj>? = null
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

    override fun visitSingleFilter(ctx: QLangGrammarParser.SingleFilterContext?): RealConditionAST<NestedObj> {
        return FilterConditionNode(ctx!!.filter().accept(filterVisitor))
    }

    override fun visitMultFilter(ctx: QLangGrammarParser.MultFilterContext?): RealConditionAST<NestedObj> {
        return ctx!!.condition().accept(this)
    }

    override fun visitConditionAnd(ctx: QLangGrammarParser.ConditionAndContext?): RealConditionAST<NestedObj> {
        return AndConditionNode(
                ctx!!.condition(0).accept(this),
                ctx.condition(1).accept(this)
        )
    }

    override fun visitConditionOr(ctx: QLangGrammarParser.ConditionOrContext?): RealConditionAST<NestedObj> {
        return OrConditionNode(
                ctx!!.condition(0).accept(this),
                ctx.condition(1).accept(this)
        )
    }

    override fun visitConditionNot(ctx: QLangGrammarParser.ConditionNotContext?): RealConditionAST<NestedObj> {
        return NotConditionNode(
                ctx!!.condition().accept(this)
        )
    }

    override fun visitConditionBraces(ctx: QLangGrammarParser.ConditionBracesContext?): RealConditionAST<NestedObj> {
        return ctx!!.condition().accept(this)
    }

    override fun visitConditionFilter(ctx: QLangGrammarParser.ConditionFilterContext?): RealConditionAST<NestedObj> {
        return FilterConditionNode(ctx!!.filter().accept(filterVisitor))
    }
}