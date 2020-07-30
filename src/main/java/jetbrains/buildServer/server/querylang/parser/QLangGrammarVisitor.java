// Generated from QLangGrammar.g4 by ANTLR 4.8

    package jetbrains.buildServer.server.querylang.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLangGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLangGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(QLangGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(QLangGrammarParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(QLangGrammarParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(QLangGrammarParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#filterKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterKeyword(QLangGrammarParser.FilterKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#identOrString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentOrString(QLangGrammarParser.IdentOrStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#objectId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectId(QLangGrammarParser.ObjectIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#objectType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectType(QLangGrammarParser.ObjectTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#parameterValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterValue(QLangGrammarParser.ParameterValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#parameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterName(QLangGrammarParser.ParameterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#checkoutRulesString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckoutRulesString(QLangGrammarParser.CheckoutRulesStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#vcsRootKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVcsRootKeyword(QLangGrammarParser.VcsRootKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#buildConfKeword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildConfKeword(QLangGrammarParser.BuildConfKewordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#projectKeword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjectKeword(QLangGrammarParser.ProjectKewordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#templateKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateKeyword(QLangGrammarParser.TemplateKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#partialQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialQuery(QLangGrammarParser.PartialQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#find}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFind(QLangGrammarParser.FindContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#multipleObjects}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleObjects(QLangGrammarParser.MultipleObjectsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#objectKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectKeyword(QLangGrammarParser.ObjectKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#conditionInSubproject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionInSubproject(QLangGrammarParser.ConditionInSubprojectContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(QLangGrammarParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionBraces}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBraces(QLangGrammarParser.ConditionBracesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionNot}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionNot(QLangGrammarParser.ConditionNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionFilter}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionFilter(QLangGrammarParser.ConditionFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionAnd}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionAnd(QLangGrammarParser.ConditionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionOr}
	 * labeled alternative in {@link QLangGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionOr(QLangGrammarParser.ConditionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleFilter}
	 * labeled alternative in {@link QLangGrammarParser#filterOrCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleFilter(QLangGrammarParser.SingleFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multFilter}
	 * labeled alternative in {@link QLangGrammarParser#filterOrCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultFilter(QLangGrammarParser.MultFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleStringFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringFilterOrCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStringFilter(QLangGrammarParser.SingleStringFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multipleStringFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringFilterOrCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleStringFilter(QLangGrammarParser.MultipleStringFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#idFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdFilter(QLangGrammarParser.IdFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#projectFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjectFilter(QLangGrammarParser.ProjectFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#parentFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentFilter(QLangGrammarParser.ParentFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#triggerFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerFilter(QLangGrammarParser.TriggerFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#stepFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepFilter(QLangGrammarParser.StepFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#featureFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeatureFilter(QLangGrammarParser.FeatureFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#typeFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFilter(QLangGrammarParser.TypeFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#parameterFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterFilter(QLangGrammarParser.ParameterFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#parValueFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParValueFilter(QLangGrammarParser.ParValueFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#enabledFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnabledFilter(QLangGrammarParser.EnabledFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#ancestorFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAncestorFilter(QLangGrammarParser.AncestorFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#ancestorOrSelfFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAncestorOrSelfFilter(QLangGrammarParser.AncestorOrSelfFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#templateDepFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateDepFilter(QLangGrammarParser.TemplateDepFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#vcsRootFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVcsRootFilter(QLangGrammarParser.VcsRootFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#checkoutRulesFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckoutRulesFilter(QLangGrammarParser.CheckoutRulesFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConditionFilter}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConditionFilter(QLangGrammarParser.StringConditionFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConditionAnd}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConditionAnd(QLangGrammarParser.StringConditionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConditionBraces}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConditionBraces(QLangGrammarParser.StringConditionBracesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConditionOr}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConditionOr(QLangGrammarParser.StringConditionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConditionNot}
	 * labeled alternative in {@link QLangGrammarParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConditionNot(QLangGrammarParser.StringConditionNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#stringFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFilter(QLangGrammarParser.StringFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#stringEqualsFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringEqualsFilter(QLangGrammarParser.StringEqualsFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#stringPrefixFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPrefixFilter(QLangGrammarParser.StringPrefixFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#stringSuffixFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringSuffixFilter(QLangGrammarParser.StringSuffixFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLangGrammarParser#stringSubstringFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringSubstringFilter(QLangGrammarParser.StringSubstringFilterContext ctx);
}