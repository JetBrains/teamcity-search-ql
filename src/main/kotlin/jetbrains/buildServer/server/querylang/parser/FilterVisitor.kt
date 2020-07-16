package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import org.antlr.v4.runtime.Token
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

inline fun <reified T : Filter> getFilterVisitor(): FilterVisitor<T> {
    return FilterVisitor<T>(T::class)
}

class FilterVisitor<T : Filter>(val filterType: KClass<T>) : QLangGrammarBaseVisitor<T>() {

    private fun transform(filter: Filter, start: Token): T {
        return filterType.safeCast(filter) ?: throw ParsingException("Wrong filter")
    }

    override fun visitIdFilter(ctx: QLangGrammarParser.IdFilterContext?): T {
        return transform(
                IdFilter(ctx!!.objectId().text),
                ctx.start
        )
    }

    override fun visitProjectFilter(ctx: QLangGrammarParser.ProjectFilterContext?): T {
        return transform(
                SProjectFilter(ctx!!.filterOrCondition().accept(projectConditionVisitor)),
                ctx.start
        )
    }

    override fun visitParentFilter(ctx: QLangGrammarParser.ParentFilterContext?): T {
        return transform(
                ParentFilter(ctx!!.filterOrCondition().accept(projectConditionVisitor)),
                ctx.start
        )
    }

    override fun visitTriggerFilter(ctx: QLangGrammarParser.TriggerFilterContext?): T {
        return transform(
                TriggerFilter(ctx!!.filterOrCondition().accept(parHolderConditionVisitor)),
                ctx.start
        )
    }

    override fun visitStepFilter(ctx: QLangGrammarParser.StepFilterContext?): T {
        return transform(
                StepFilter(ctx!!.filterOrCondition().accept(parHolderConditionVisitor)),
                ctx.start
        )
    }

    override fun visitFeatureFilter(ctx: QLangGrammarParser.FeatureFilterContext?): T {
        return transform(
                FeatureFilter(ctx!!.filterOrCondition().accept(parHolderConditionVisitor)),
                ctx.start
        )
    }

    override fun visitTypeFilter(ctx: QLangGrammarParser.TypeFilterContext?): T {
        return transform(
                TypeFilter(ctx!!.objectType().text),
                ctx.start
        )
    }

    override fun visitParameterFilter(ctx: QLangGrammarParser.ParameterFilterContext?): T {
        return transform(
                ParameterFilter(ctx!!.parameterName.text, ctx.parameterValue().text.dropLast(1).drop(1)),
                ctx.start
        )
    }

    override fun visitParValueFilter(ctx: QLangGrammarParser.ParValueFilterContext?): T {
        return transform(
                ParValueFilter(ctx!!.parameterValue().text.dropLast(1).drop(1)),
                ctx.start
        )
    }

    override fun visitEnabledFilter(ctx: QLangGrammarParser.EnabledFilterContext?): T {
        return transform(
                EnabledFilter(true),
                ctx!!.start
        )
    }

    override fun visitAncestorFilter(ctx: QLangGrammarParser.AncestorFilterContext?): T {
        return transform(
                AncestorFilter(ctx!!.filterOrCondition().accept(projectConditionVisitor)),
                ctx.start
        )
    }

    override fun visitAncestorOrSelfFilter(ctx: QLangGrammarParser.AncestorOrSelfFilterContext?): T {
        return transform(
                AncestorOrSelfFilter(ctx!!.filterOrCondition().accept(projectConditionVisitor)),
                ctx.start
        )
    }

    override fun visitTemplateDepFilter(ctx: QLangGrammarParser.TemplateDepFilterContext?): T {
        return transform(
                TempDepFilter(ctx!!.filterOrCondition().accept(tempConditionVisitor)),
                ctx.start
        )
    }
}