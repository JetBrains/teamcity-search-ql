// Generated from QLangGrammar.g4 by ANTLR 4.8

    package jetbrains.buildServer.server.querylang.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLangGrammarParser}.
 */
public interface QLangGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(QLangGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(QLangGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(QLangGrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(QLangGrammarParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(QLangGrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(QLangGrammarParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(QLangGrammarParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(QLangGrammarParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#filterKeyword}.
	 * @param ctx the parse tree
	 */
	void enterFilterKeyword(QLangGrammarParser.FilterKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#filterKeyword}.
	 * @param ctx the parse tree
	 */
	void exitFilterKeyword(QLangGrammarParser.FilterKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#identOrString}.
	 * @param ctx the parse tree
	 */
	void enterIdentOrString(QLangGrammarParser.IdentOrStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#identOrString}.
	 * @param ctx the parse tree
	 */
	void exitIdentOrString(QLangGrammarParser.IdentOrStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#objectId}.
	 * @param ctx the parse tree
	 */
	void enterObjectId(QLangGrammarParser.ObjectIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#objectId}.
	 * @param ctx the parse tree
	 */
	void exitObjectId(QLangGrammarParser.ObjectIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#objectType}.
	 * @param ctx the parse tree
	 */
	void enterObjectType(QLangGrammarParser.ObjectTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#objectType}.
	 * @param ctx the parse tree
	 */
	void exitObjectType(QLangGrammarParser.ObjectTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#parameterValue}.
	 * @param ctx the parse tree
	 */
	void enterParameterValue(QLangGrammarParser.ParameterValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#parameterValue}.
	 * @param ctx the parse tree
	 */
	void exitParameterValue(QLangGrammarParser.ParameterValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void enterParameterName(QLangGrammarParser.ParameterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void exitParameterName(QLangGrammarParser.ParameterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#checkoutRulesString}.
	 * @param ctx the parse tree
	 */
	void enterCheckoutRulesString(QLangGrammarParser.CheckoutRulesStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#checkoutRulesString}.
	 * @param ctx the parse tree
	 */
	void exitCheckoutRulesString(QLangGrammarParser.CheckoutRulesStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#vcsRootKeyword}.
	 * @param ctx the parse tree
	 */
	void enterVcsRootKeyword(QLangGrammarParser.VcsRootKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#vcsRootKeyword}.
	 * @param ctx the parse tree
	 */
	void exitVcsRootKeyword(QLangGrammarParser.VcsRootKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#buildConfKeword}.
	 * @param ctx the parse tree
	 */
	void enterBuildConfKeword(QLangGrammarParser.BuildConfKewordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#buildConfKeword}.
	 * @param ctx the parse tree
	 */
	void exitBuildConfKeword(QLangGrammarParser.BuildConfKewordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#projectKeword}.
	 * @param ctx the parse tree
	 */
	void enterProjectKeword(QLangGrammarParser.ProjectKewordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#projectKeword}.
	 * @param ctx the parse tree
	 */
	void exitProjectKeword(QLangGrammarParser.ProjectKewordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#templateKeyword}.
	 * @param ctx the parse tree
	 */
	void enterTemplateKeyword(QLangGrammarParser.TemplateKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#templateKeyword}.
	 * @param ctx the parse tree
	 */
	void exitTemplateKeyword(QLangGrammarParser.TemplateKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#partialQuery}.
	 * @param ctx the parse tree
	 */
	void enterPartialQuery(QLangGrammarParser.PartialQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#partialQuery}.
	 * @param ctx the parse tree
	 */
	void exitPartialQuery(QLangGrammarParser.PartialQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#find}.
	 * @param ctx the parse tree
	 */
	void enterFind(QLangGrammarParser.FindContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#find}.
	 * @param ctx the parse tree
	 */
	void exitFind(QLangGrammarParser.FindContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#multipleObjects}.
	 * @param ctx the parse tree
	 */
	void enterMultipleObjects(QLangGrammarParser.MultipleObjectsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#multipleObjects}.
	 * @param ctx the parse tree
	 */
	void exitMultipleObjects(QLangGrammarParser.MultipleObjectsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#objectKeyword}.
	 * @param ctx the parse tree
	 */
	void enterObjectKeyword(QLangGrammarParser.ObjectKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#objectKeyword}.
	 * @param ctx the parse tree
	 */
	void exitObjectKeyword(QLangGrammarParser.ObjectKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#conditionInSubproject}.
	 * @param ctx the parse tree
	 */
	void enterConditionInSubproject(QLangGrammarParser.ConditionInSubprojectContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#conditionInSubproject}.
	 * @param ctx the parse tree
	 */
	void exitConditionInSubproject(QLangGrammarParser.ConditionInSubprojectContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(QLangGrammarParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(QLangGrammarParser.FilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionBraces}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionBraces(QLangGrammarParser.ConditionBracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionBraces}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionBraces(QLangGrammarParser.ConditionBracesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionNot}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionNot(QLangGrammarParser.ConditionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionNot}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionNot(QLangGrammarParser.ConditionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionFilter}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionFilter(QLangGrammarParser.ConditionFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionFilter}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionFilter(QLangGrammarParser.ConditionFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionAnd}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionAnd(QLangGrammarParser.ConditionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionAnd}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionAnd(QLangGrammarParser.ConditionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionOr}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionOr(QLangGrammarParser.ConditionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionOr}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionOr(QLangGrammarParser.ConditionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleFilter}
	 * labeled alternative in {@link QLangGrammarParser#filterOrCondition}.
	 * @param ctx the parse tree
	 */
	void enterSingleFilter(QLangGrammarParser.SingleFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleFilter}
	 * labeled alternative in {@link QLangGrammarParser#filterOrCondition}.
	 * @param ctx the parse tree
	 */
	void exitSingleFilter(QLangGrammarParser.SingleFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multFilter}
	 * labeled alternative in {@link QLangGrammarParser#filterOrCondition}.
	 * @param ctx the parse tree
	 */
	void enterMultFilter(QLangGrammarParser.MultFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multFilter}
	 * labeled alternative in {@link QLangGrammarParser#filterOrCondition}.
	 * @param ctx the parse tree
	 */
	void exitMultFilter(QLangGrammarParser.MultFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleStringFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringFilterOrCondition}.
	 * @param ctx the parse tree
	 */
	void enterSingleStringFilter(QLangGrammarParser.SingleStringFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleStringFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringFilterOrCondition}.
	 * @param ctx the parse tree
	 */
	void exitSingleStringFilter(QLangGrammarParser.SingleStringFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multipleStringFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringFilterOrCondition}.
	 * @param ctx the parse tree
	 */
	void enterMultipleStringFilter(QLangGrammarParser.MultipleStringFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multipleStringFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringFilterOrCondition}.
	 * @param ctx the parse tree
	 */
	void exitMultipleStringFilter(QLangGrammarParser.MultipleStringFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#idFilter}.
	 * @param ctx the parse tree
	 */
	void enterIdFilter(QLangGrammarParser.IdFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#idFilter}.
	 * @param ctx the parse tree
	 */
	void exitIdFilter(QLangGrammarParser.IdFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#projectFilter}.
	 * @param ctx the parse tree
	 */
	void enterProjectFilter(QLangGrammarParser.ProjectFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#projectFilter}.
	 * @param ctx the parse tree
	 */
	void exitProjectFilter(QLangGrammarParser.ProjectFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#parentFilter}.
	 * @param ctx the parse tree
	 */
	void enterParentFilter(QLangGrammarParser.ParentFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#parentFilter}.
	 * @param ctx the parse tree
	 */
	void exitParentFilter(QLangGrammarParser.ParentFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#triggerFilter}.
	 * @param ctx the parse tree
	 */
	void enterTriggerFilter(QLangGrammarParser.TriggerFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#triggerFilter}.
	 * @param ctx the parse tree
	 */
	void exitTriggerFilter(QLangGrammarParser.TriggerFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#stepFilter}.
	 * @param ctx the parse tree
	 */
	void enterStepFilter(QLangGrammarParser.StepFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#stepFilter}.
	 * @param ctx the parse tree
	 */
	void exitStepFilter(QLangGrammarParser.StepFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#featureFilter}.
	 * @param ctx the parse tree
	 */
	void enterFeatureFilter(QLangGrammarParser.FeatureFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#featureFilter}.
	 * @param ctx the parse tree
	 */
	void exitFeatureFilter(QLangGrammarParser.FeatureFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#typeFilter}.
	 * @param ctx the parse tree
	 */
	void enterTypeFilter(QLangGrammarParser.TypeFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#typeFilter}.
	 * @param ctx the parse tree
	 */
	void exitTypeFilter(QLangGrammarParser.TypeFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#parameterFilter}.
	 * @param ctx the parse tree
	 */
	void enterParameterFilter(QLangGrammarParser.ParameterFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#parameterFilter}.
	 * @param ctx the parse tree
	 */
	void exitParameterFilter(QLangGrammarParser.ParameterFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#parValueFilter}.
	 * @param ctx the parse tree
	 */
	void enterParValueFilter(QLangGrammarParser.ParValueFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#parValueFilter}.
	 * @param ctx the parse tree
	 */
	void exitParValueFilter(QLangGrammarParser.ParValueFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#enabledFilter}.
	 * @param ctx the parse tree
	 */
	void enterEnabledFilter(QLangGrammarParser.EnabledFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#enabledFilter}.
	 * @param ctx the parse tree
	 */
	void exitEnabledFilter(QLangGrammarParser.EnabledFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#ancestorFilter}.
	 * @param ctx the parse tree
	 */
	void enterAncestorFilter(QLangGrammarParser.AncestorFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#ancestorFilter}.
	 * @param ctx the parse tree
	 */
	void exitAncestorFilter(QLangGrammarParser.AncestorFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#templateDepFilter}.
	 * @param ctx the parse tree
	 */
	void enterTemplateDepFilter(QLangGrammarParser.TemplateDepFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#templateDepFilter}.
	 * @param ctx the parse tree
	 */
	void exitTemplateDepFilter(QLangGrammarParser.TemplateDepFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#vcsRootFilter}.
	 * @param ctx the parse tree
	 */
	void enterVcsRootFilter(QLangGrammarParser.VcsRootFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#vcsRootFilter}.
	 * @param ctx the parse tree
	 */
	void exitVcsRootFilter(QLangGrammarParser.VcsRootFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#vcsRootEntryFilter}.
	 * @param ctx the parse tree
	 */
	void enterVcsRootEntryFilter(QLangGrammarParser.VcsRootEntryFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#vcsRootEntryFilter}.
	 * @param ctx the parse tree
	 */
	void exitVcsRootEntryFilter(QLangGrammarParser.VcsRootEntryFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#checkoutRulesFilter}.
	 * @param ctx the parse tree
	 */
	void enterCheckoutRulesFilter(QLangGrammarParser.CheckoutRulesFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#checkoutRulesFilter}.
	 * @param ctx the parse tree
	 */
	void exitCheckoutRulesFilter(QLangGrammarParser.CheckoutRulesFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#dependencyFilter}.
	 * @param ctx the parse tree
	 */
	void enterDependencyFilter(QLangGrammarParser.DependencyFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#dependencyFilter}.
	 * @param ctx the parse tree
	 */
	void exitDependencyFilter(QLangGrammarParser.DependencyFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#artifactFilter}.
	 * @param ctx the parse tree
	 */
	void enterArtifactFilter(QLangGrammarParser.ArtifactFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#artifactFilter}.
	 * @param ctx the parse tree
	 */
	void exitArtifactFilter(QLangGrammarParser.ArtifactFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#snapshotFilter}.
	 * @param ctx the parse tree
	 */
	void enterSnapshotFilter(QLangGrammarParser.SnapshotFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#snapshotFilter}.
	 * @param ctx the parse tree
	 */
	void exitSnapshotFilter(QLangGrammarParser.SnapshotFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#optionFilter}.
	 * @param ctx the parse tree
	 */
	void enterOptionFilter(QLangGrammarParser.OptionFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#optionFilter}.
	 * @param ctx the parse tree
	 */
	void exitOptionFilter(QLangGrammarParser.OptionFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#cleanFilter}.
	 * @param ctx the parse tree
	 */
	void enterCleanFilter(QLangGrammarParser.CleanFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#cleanFilter}.
	 * @param ctx the parse tree
	 */
	void exitCleanFilter(QLangGrammarParser.CleanFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#revRuleFilter}.
	 * @param ctx the parse tree
	 */
	void enterRevRuleFilter(QLangGrammarParser.RevRuleFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#revRuleFilter}.
	 * @param ctx the parse tree
	 */
	void exitRevRuleFilter(QLangGrammarParser.RevRuleFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#nameFilter}.
	 * @param ctx the parse tree
	 */
	void enterNameFilter(QLangGrammarParser.NameFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#nameFilter}.
	 * @param ctx the parse tree
	 */
	void exitNameFilter(QLangGrammarParser.NameFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConditionFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringConditionFilter(QLangGrammarParser.StringConditionFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConditionFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringConditionFilter(QLangGrammarParser.StringConditionFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConditionAnd}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringConditionAnd(QLangGrammarParser.StringConditionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConditionAnd}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringConditionAnd(QLangGrammarParser.StringConditionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConditionBraces}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringConditionBraces(QLangGrammarParser.StringConditionBracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConditionBraces}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringConditionBraces(QLangGrammarParser.StringConditionBracesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConditionOr}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringConditionOr(QLangGrammarParser.StringConditionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConditionOr}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringConditionOr(QLangGrammarParser.StringConditionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConditionNot}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringConditionNot(QLangGrammarParser.StringConditionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConditionNot}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringConditionNot(QLangGrammarParser.StringConditionNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#stringFilter}.
	 * @param ctx the parse tree
	 */
	void enterStringFilter(QLangGrammarParser.StringFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#stringFilter}.
	 * @param ctx the parse tree
	 */
	void exitStringFilter(QLangGrammarParser.StringFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#stringEqualsFilter}.
	 * @param ctx the parse tree
	 */
	void enterStringEqualsFilter(QLangGrammarParser.StringEqualsFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#stringEqualsFilter}.
	 * @param ctx the parse tree
	 */
	void exitStringEqualsFilter(QLangGrammarParser.StringEqualsFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#stringPrefixFilter}.
	 * @param ctx the parse tree
	 */
	void enterStringPrefixFilter(QLangGrammarParser.StringPrefixFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#stringPrefixFilter}.
	 * @param ctx the parse tree
	 */
	void exitStringPrefixFilter(QLangGrammarParser.StringPrefixFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#stringSuffixFilter}.
	 * @param ctx the parse tree
	 */
	void enterStringSuffixFilter(QLangGrammarParser.StringSuffixFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#stringSuffixFilter}.
	 * @param ctx the parse tree
	 */
	void exitStringSuffixFilter(QLangGrammarParser.StringSuffixFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#stringSubstringFilter}.
	 * @param ctx the parse tree
	 */
	void enterStringSubstringFilter(QLangGrammarParser.StringSubstringFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#stringSubstringFilter}.
	 * @param ctx the parse tree
	 */
	void exitStringSubstringFilter(QLangGrammarParser.StringSubstringFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#anyStringFilter}.
	 * @param ctx the parse tree
	 */
	void enterAnyStringFilter(QLangGrammarParser.AnyStringFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#anyStringFilter}.
	 * @param ctx the parse tree
	 */
	void exitAnyStringFilter(QLangGrammarParser.AnyStringFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#filterModifier}.
	 * @param ctx the parse tree
	 */
	void enterFilterModifier(QLangGrammarParser.FilterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#filterModifier}.
	 * @param ctx the parse tree
	 */
	void exitFilterModifier(QLangGrammarParser.FilterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#modifierList}.
	 * @param ctx the parse tree
	 */
	void enterModifierList(QLangGrammarParser.ModifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#modifierList}.
	 * @param ctx the parse tree
	 */
	void exitModifierList(QLangGrammarParser.ModifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#withInheritedModifier}.
	 * @param ctx the parse tree
	 */
	void enterWithInheritedModifier(QLangGrammarParser.WithInheritedModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#withInheritedModifier}.
	 * @param ctx the parse tree
	 */
	void exitWithInheritedModifier(QLangGrammarParser.WithInheritedModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLangGrammarParser#resolvedModifier}.
	 * @param ctx the parse tree
	 */
	void enterResolvedModifier(QLangGrammarParser.ResolvedModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangGrammarParser#resolvedModifier}.
	 * @param ctx the parse tree
	 */
	void exitResolvedModifier(QLangGrammarParser.ResolvedModifierContext ctx);
}