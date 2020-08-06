package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import org.antlr.v4.runtime.ParserRuleContext
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

inline fun <reified T : Filter> getFilterVisitor(): FilterVisitor<T> {
    return FilterVisitor<T>(T::class)
}

class FilterVisitor<T : Filter>(
    val filterType: KClass<T>
) : QLangGrammarBaseVisitor<T>() {

    private fun Filter.transform(ctx: ParserRuleContext): T {
        val res = filterType.safeCast(this)
            ?: throw ParsingException("Not suitable filter '${ctx.start.text}' at position ${ctx.start.startIndex}")

        ctx.children.forEach {child ->
            if (child is QLangGrammarParser.ModifierListContext) {
                return res.applyModifierList(child)
            }
        }
        return res
    }

    private fun<T : Filter> T.applyModifierList(
        ctx: QLangGrammarParser.ModifierListContext?
    ): T {
        if (ctx == null) {
            return this
        }
        ctx.filterModifier().forEach { mod ->
            ModifierVisitor.visitAndApply(mod, this)
        }
        return this
    }

    override fun visitIdFilter(ctx: QLangGrammarParser.IdFilterContext?) =
        IdFilter(
            ctx!!.objectId().stringFilterOrCondition().accept(StringConditionVisitor)
        ).transform(ctx)

    override fun visitProjectFilter(ctx: QLangGrammarParser.ProjectFilterContext?) =
        ProjectFilter(
            ctx!!.filterOrCondition().accept(projectConditionVisitor)
        ).transform(ctx)

    override fun visitParentFilter(ctx: QLangGrammarParser.ParentFilterContext?) =
        ParentFilter(
            ctx!!.filterOrCondition().accept(projectConditionVisitor)
        ).transform(ctx)

    override fun visitTriggerFilter(ctx: QLangGrammarParser.TriggerFilterContext?) =
        TriggerFilter(
            ctx!!.filterOrCondition().accept(parHolderConditionVisitor)
        ).transform(ctx)

    override fun visitStepFilter(ctx: QLangGrammarParser.StepFilterContext?) =
        StepFilter(
            ctx!!.filterOrCondition().accept(parHolderConditionVisitor)
        ).transform(ctx)

    override fun visitFeatureFilter(ctx: QLangGrammarParser.FeatureFilterContext?) =
        FeatureFilter(
            ctx!!.filterOrCondition().accept(parHolderConditionVisitor)
        ).transform(ctx)

    override fun visitTypeFilter(ctx: QLangGrammarParser.TypeFilterContext?) =
        TypeFilter(ctx!!.objectType().stringFilterOrCondition().accept(StringConditionVisitor)).transform(ctx)

    override fun visitParameterFilter(ctx: QLangGrammarParser.ParameterFilterContext?) =
        ParameterFilter(
            ctx!!.parameterName().stringFilterOrCondition().accept(StringConditionVisitor),
            ctx.parameterValue().stringFilterOrCondition().accept(StringConditionVisitor)
        ).transform(ctx)

    override fun visitParValueFilter(ctx: QLangGrammarParser.ParValueFilterContext?) =
        ValueFilter(
            ctx!!.parameterValue().stringFilterOrCondition().accept(StringConditionVisitor)
        ).transform(ctx)

    override fun visitEnabledFilter(ctx: QLangGrammarParser.EnabledFilterContext?) =
        EnabledFilter(true).transform(ctx!!)

    override fun visitAncestorFilter(ctx: QLangGrammarParser.AncestorFilterContext?) =
        AncestorFilter(
            ctx!!.filterOrCondition().accept(projectConditionVisitor)
        ).transform(ctx)

    override fun visitTemplateDepFilter(ctx: QLangGrammarParser.TemplateDepFilterContext?) =
        TempDepFilter(
            ctx!!.filterOrCondition().accept(tempConditionVisitor)
        ).transform(ctx)

    override fun visitVcsRootFilter(ctx: QLangGrammarParser.VcsRootFilterContext?) =
        VcsRootFilter(
            ctx!!.filterOrCondition().accept(vcsRootEntryConditionVisitor)
        ).transform(ctx)

    override fun visitCheckoutRulesFilter(ctx: QLangGrammarParser.CheckoutRulesFilterContext?) =
        CheckoutRulesFilter(
            ctx!!.checkoutRulesString().accept(StringConditionVisitor)
        ).transform(ctx)

    override fun visitDependencyFilter(ctx: QLangGrammarParser.DependencyFilterContext?) =
        DependencyFilter(
            ctx!!.filterOrCondition().accept(dependencyConditionVisitor)
        ).transform(ctx)

    override fun visitArtifactFilter(ctx: QLangGrammarParser.ArtifactFilterContext?) =
        ArtifactFilter().transform(ctx!!)

    override fun visitSnapshotFilter(ctx: QLangGrammarParser.SnapshotFilterContext?) =
        SnapshotFilter().transform(ctx!!)

    override fun visitOptionFilter(ctx: QLangGrammarParser.OptionFilterContext?) =
        OptionFilter(
            ctx!!.parameterName().accept(StringConditionVisitor),
            ctx.parameterValue().accept(StringConditionVisitor)
        ).transform(ctx)
}