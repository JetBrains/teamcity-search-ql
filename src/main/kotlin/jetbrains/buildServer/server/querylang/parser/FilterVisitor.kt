package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.ast.wrappers.FVcsRootContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.WParam
import jetbrains.buildServer.server.querylang.fromIdentOrString
import org.antlr.v4.runtime.ParserRuleContext
import kotlin.reflect.KClass


class FilterVisitor<Obj>(val parentFilter: KClass<out ConditionContainer<Obj>>) : QLangGrammarBaseVisitor<Filter<Obj>>() {

    private fun Filter<Obj>.applyModifierList(
        ctx: QLangGrammarParser.ModifierListContext?
    ): Filter<Obj> {
        if (ctx == null) {
            return this
        }
        ctx.filterModifier().forEach { mod ->
            mod.accept(ModifierVisitor(this))
        }
        return this
    }

    private fun<T> Filter<T>.transform(ctx: ParserRuleContext): Filter<Obj> {
        val filter = this.checkAndCast(parentFilter) ?:
            throw ParsingException("'${parentFilter.getName()}' can't have '${this::class.getName()}' subfilter")

        for (ch in ctx.children) {
            if (ch is QLangGrammarParser.ModifierListContext) {
                filter.applyModifierList(ch)
            }
        }
        return filter
    }

    inline fun <NestedObj, reified FType: ConditionFilter<*, NestedObj>> getCondVisitor(filterClass: KClass<FType>) = ConditionVisitor(filterClass)

    override fun visitIdFilter(ctx: QLangGrammarParser.IdFilterContext?) =
        IdFilter(
            ctx!!.objectId().stringFilterOrCondition().accept(getCondVisitor(IdFilter::class))
        ).transform(ctx)

    override fun visitArchivedFilter(ctx: QLangGrammarParser.ArchivedFilterContext?)  =
        ArchivedFilter().transform(ctx!!)

    override fun visitProjectFilter(ctx: QLangGrammarParser.ProjectFilterContext?) =
        ProjectFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(ProjectFilter::class))
        ).transform(ctx)

    override fun visitParentFilter(ctx: QLangGrammarParser.ParentFilterContext?) =
        ParentFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(ParentFilter::class))
        ).transform(ctx)

    override fun visitTriggerFilter(ctx: QLangGrammarParser.TriggerFilterContext?) =
        TriggerFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(TriggerFilter::class))
        ).transform(ctx)

    override fun visitStepFilter(ctx: QLangGrammarParser.StepFilterContext?) =
        StepFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(StepFilter::class))
        ).transform(ctx)

    override fun visitFeatureFilter(ctx: QLangGrammarParser.FeatureFilterContext?) =
        FeatureFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(FeatureFilter::class))
        ).transform(ctx)

    override fun visitTypeFilter(ctx: QLangGrammarParser.TypeFilterContext?) =
        TypeFilter(ctx!!.objectType().stringFilterOrCondition().accept(getCondVisitor(TypeFilter::class))).transform(ctx)

    override fun visitParameterFilter(ctx: QLangGrammarParser.ParameterFilterContext?) =
        ParameterFilter(ctx!!.parameterFilterOrCondition().accept(getCondVisitor(ParameterFilter::class))).transform(ctx)

    override fun visitParValueFilter(ctx: QLangGrammarParser.ParValueFilterContext?) =
        ValueFilter(
            ctx!!.parameterValue().stringFilterOrCondition().accept(getCondVisitor(ValueFilter::class))
        ).transform(ctx)

    override fun visitEnabledFilter(ctx: QLangGrammarParser.EnabledFilterContext?) =
        EnabledFilter().transform(ctx!!)

    override fun visitAncestorFilter(ctx: QLangGrammarParser.AncestorFilterContext?) =
        AncestorFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(AncestorFilter::class))
        ).transform(ctx)

    override fun visitTemplateDepFilter(ctx: QLangGrammarParser.TemplateDepFilterContext?) =
        TemplateFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(TemplateFilter::class))
        ).transform(ctx)

    override fun visitVcsRootFilter(ctx: QLangGrammarParser.VcsRootFilterContext?) =
        VcsRootFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(VcsRootFilter::class))
        ).transform(ctx)

    override fun visitVcsRootEntryFilter(ctx: QLangGrammarParser.VcsRootEntryFilterContext?) =
        VcsRootEntryFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(VcsRootEntryFilter::class))
        ).transform(ctx)

    override fun visitCheckoutRulesFilter(ctx: QLangGrammarParser.CheckoutRulesFilterContext?) =
        RulesFilter(
            ctx!!.checkoutRulesString().accept(getCondVisitor(RulesFilter::class))
        ).transform(ctx)

    override fun visitDependencyFilter(ctx: QLangGrammarParser.DependencyFilterContext?) =
        DependencyFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(DependencyFilter::class))
        ).transform(ctx)

    override fun visitArtifactFilter(ctx: QLangGrammarParser.ArtifactFilterContext?) =
        ArtifactFilter(
            ctx!!.filterOrCondition()?.accept(getCondVisitor(ArtifactFilter::class)) ?: NoneConditionAST()
        ).transform(ctx)

    override fun visitSnapshotFilter(ctx: QLangGrammarParser.SnapshotFilterContext?) =
        SnapshotFilter(
            ctx!!.filterOrCondition()?.accept(getCondVisitor(SnapshotFilter::class)) ?: NoneConditionAST()
        ).transform(ctx)

    override fun visitOptionFilter(ctx: QLangGrammarParser.OptionFilterContext?) =
        OptionFilter(ctx!!.parameterFilterOrCondition().accept(getCondVisitor(OptionFilter::class))).transform(ctx)

    override fun visitNameFilter(ctx: QLangGrammarParser.NameFilterContext?) =
        NameFilter(
            ctx!!.stringFilterOrCondition().accept(getCondVisitor(NameFilter::class))
        ).transform(ctx)

    override fun visitCleanFilter(ctx: QLangGrammarParser.CleanFilterContext?) = CleanFilter().transform(ctx!!)

    override fun visitRevRuleFilter(ctx: QLangGrammarParser.RevRuleFilterContext?) =
        RevRuleFilter(
            ctx!!.stringFilterOrCondition().accept(getCondVisitor(RevRuleFilter::class))
        ).transform(ctx)

    override fun visitBuildConfFilter(ctx: QLangGrammarParser.BuildConfFilterContext?): Filter<Obj> {
        return BuildConfFilter(
            ctx!!.filterOrCondition().accept(getCondVisitor(BuildConfFilter::class))
        ).transform(ctx)
    }

    override fun visitStringEqualsFilter(ctx: QLangGrammarParser.StringEqualsFilterContext?) =
        EqualsStringFilter(ctx!!.text.fromIdentOrString()).transform(ctx)

    override fun visitStringPrefixFilter(ctx: QLangGrammarParser.StringPrefixFilterContext?) =
        PrefixStringFilter(ctx!!.PREFIXS().text.dropLast(1).fromIdentOrString()).transform(ctx)

    override fun visitStringSuffixFilter(ctx: QLangGrammarParser.StringSuffixFilterContext?) =
        SuffixStringFilter(ctx!!.SUFFIXS().text.drop(1).fromIdentOrString()).transform(ctx)

    override fun visitStringSubstringFilter(ctx: QLangGrammarParser.StringSubstringFilterContext?) =
        SubstringFilter(ctx!!.SUBSTRINGS().text.drop(1).dropLast(1).fromIdentOrString()).transform(ctx)

    override fun visitAnyStringFilter(ctx: QLangGrammarParser.AnyStringFilterContext?) =
        AnyStringFilter().transform(ctx!!)

    override fun visitCollectorStringFilter(ctx: QLangGrammarParser.CollectorStringFilterContext?) =
        CollectorStringFilter().transform(ctx!!)

    override fun visitParamStringFilterCase(ctx: QLangGrammarParser.ParamStringFilterCaseContext?): Filter<Obj> {
        return StringParamFilter(
            ctx!!.parameterName().accept(getCondVisitor(TypeFilter::class)),
            ctx.parameterValue().accept(getCondVisitor(TypeFilter::class))
        ).transform(ctx)
    }

    override fun visitParamStringCollectorCase(ctx: QLangGrammarParser.ParamStringCollectorCaseContext?): Filter<Obj> {
        return CollectorStringParamFilter().transform(ctx!!)
    }

    override fun visitCaseSensitiveStringFilter(ctx: QLangGrammarParser.CaseSensitiveStringFilterContext?): Filter<Obj> {
        val filter = ctx!!.stringFilter().accept(this) as? StringFilter
            ?: throw ParsingException("Filter at position ${ctx.start.startIndex} can't have caseSensitive modifier('^')")

        filter.isCaseSensitive = true
        return filter.transform(ctx)
    }

    override fun visitSubProjectFilter(ctx: QLangGrammarParser.SubProjectFilterContext?) =
        SubProjectFilter(
            ctx!!.accept(getCondVisitor(SubProjectFilter::class))
        ).transform(ctx)
}