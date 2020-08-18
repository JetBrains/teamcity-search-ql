// Generated from QLangGrammar.g4 by ANTLR 4.8

    package jetbrains.buildServer.server.querylang.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLangGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OR=10, AND=11, NOT=12, STRING=13, IDENT=14, SUFFIXS=15, PREFIXS=16, SUBSTRINGS=17, 
		ANY_STRING=18, WS=19, PROJECT=20, TEMPLATE=21, BUILD_CONFIGURATION=22, 
		VCS_ROOT=23, ID=24, PARENT=25, TRIGGER=26, STEP=27, FEATURE=28, TYPE=29, 
		PARAM=30, VAL=31, ENABLED=32, ANCESTOR=33, RULES=34, DEPENDENCY=35, ARTIFACT=36, 
		SNAPSHOT=37, WITH_INHERITED=38, OPTION=39, CLEAN=40, REV_RULE=41, VCS_ENTRY=42, 
		NAME=43, RESOLVED=44, ALL=45;
	public static final int
		RULE_start = 0, RULE_and = 1, RULE_or = 2, RULE_not = 3, RULE_filterKeyword = 4, 
		RULE_identOrString = 5, RULE_objectId = 6, RULE_objectType = 7, RULE_parameterValue = 8, 
		RULE_parameterName = 9, RULE_checkoutRulesString = 10, RULE_vcsRootKeyword = 11, 
		RULE_buildConfKeword = 12, RULE_projectKeword = 13, RULE_templateKeyword = 14, 
		RULE_partialQuery = 15, RULE_find = 16, RULE_multipleObjects = 17, RULE_objectKeyword = 18, 
		RULE_conditionInSubproject = 19, RULE_filter = 20, RULE_condition = 21, 
		RULE_filterOrCondition = 22, RULE_stringFilterOrCondition = 23, RULE_idFilter = 24, 
		RULE_projectFilter = 25, RULE_parentFilter = 26, RULE_triggerFilter = 27, 
		RULE_stepFilter = 28, RULE_featureFilter = 29, RULE_typeFilter = 30, RULE_parameterFilter = 31, 
		RULE_parValueFilter = 32, RULE_enabledFilter = 33, RULE_ancestorFilter = 34, 
		RULE_templateDepFilter = 35, RULE_vcsRootFilter = 36, RULE_vcsRootEntryFilter = 37, 
		RULE_checkoutRulesFilter = 38, RULE_dependencyFilter = 39, RULE_artifactFilter = 40, 
		RULE_snapshotFilter = 41, RULE_optionFilter = 42, RULE_cleanFilter = 43, 
		RULE_revRuleFilter = 44, RULE_nameFilter = 45, RULE_stringCondition = 46, 
		RULE_stringFilter = 47, RULE_stringEqualsFilter = 48, RULE_stringPrefixFilter = 49, 
		RULE_stringSuffixFilter = 50, RULE_stringSubstringFilter = 51, RULE_anyStringFilter = 52, 
		RULE_filterModifier = 53, RULE_modifierList = 54, RULE_withInheritedModifier = 55, 
		RULE_resolvedModifier = 56, RULE_allModifier = 57;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "and", "or", "not", "filterKeyword", "identOrString", "objectId", 
			"objectType", "parameterValue", "parameterName", "checkoutRulesString", 
			"vcsRootKeyword", "buildConfKeword", "projectKeword", "templateKeyword", 
			"partialQuery", "find", "multipleObjects", "objectKeyword", "conditionInSubproject", 
			"filter", "condition", "filterOrCondition", "stringFilterOrCondition", 
			"idFilter", "projectFilter", "parentFilter", "triggerFilter", "stepFilter", 
			"featureFilter", "typeFilter", "parameterFilter", "parValueFilter", "enabledFilter", 
			"ancestorFilter", "templateDepFilter", "vcsRootFilter", "vcsRootEntryFilter", 
			"checkoutRulesFilter", "dependencyFilter", "artifactFilter", "snapshotFilter", 
			"optionFilter", "cleanFilter", "revRuleFilter", "nameFilter", "stringCondition", 
			"stringFilter", "stringEqualsFilter", "stringPrefixFilter", "stringSuffixFilter", 
			"stringSubstringFilter", "anyStringFilter", "filterModifier", "modifierList", 
			"withInheritedModifier", "resolvedModifier", "allModifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'find'", "','", "'in'", "'with'", "'('", "')'", "'='", "'['", 
			"']'", "'or'", "'and'", "'not'", null, null, null, null, null, "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "OR", "AND", 
			"NOT", "STRING", "IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "ANY_STRING", 
			"WS", "PROJECT", "TEMPLATE", "BUILD_CONFIGURATION", "VCS_ROOT", "ID", 
			"PARENT", "TRIGGER", "STEP", "FEATURE", "TYPE", "PARAM", "VAL", "ENABLED", 
			"ANCESTOR", "RULES", "DEPENDENCY", "ARTIFACT", "SNAPSHOT", "WITH_INHERITED", 
			"OPTION", "CLEAN", "REV_RULE", "VCS_ENTRY", "NAME", "RESOLVED", "ALL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "QLangGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLangGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(QLangGrammarParser.EOF, 0); }
		public FindContext find() {
			return getRuleContext(FindContext.class,0);
		}
		public PartialQueryContext partialQuery() {
			return getRuleContext(PartialQueryContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(116);
				find();
				}
				break;
			case T__4:
			case NOT:
			case PROJECT:
			case TEMPLATE:
			case VCS_ROOT:
			case ID:
			case PARENT:
			case TRIGGER:
			case STEP:
			case FEATURE:
			case TYPE:
			case PARAM:
			case VAL:
			case ENABLED:
			case ANCESTOR:
			case RULES:
			case DEPENDENCY:
			case ARTIFACT:
			case SNAPSHOT:
			case OPTION:
			case CLEAN:
			case REV_RULE:
			case VCS_ENTRY:
			case NAME:
				{
				setState(117);
				partialQuery();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(120);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(QLangGrammarParser.AND, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(AND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(QLangGrammarParser.OR, 0); }
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(OR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(QLangGrammarParser.NOT, 0); }
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(NOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterKeywordContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(QLangGrammarParser.PROJECT, 0); }
		public TerminalNode TEMPLATE() { return getToken(QLangGrammarParser.TEMPLATE, 0); }
		public TerminalNode BUILD_CONFIGURATION() { return getToken(QLangGrammarParser.BUILD_CONFIGURATION, 0); }
		public TerminalNode VCS_ROOT() { return getToken(QLangGrammarParser.VCS_ROOT, 0); }
		public TerminalNode PARENT() { return getToken(QLangGrammarParser.PARENT, 0); }
		public TerminalNode TRIGGER() { return getToken(QLangGrammarParser.TRIGGER, 0); }
		public TerminalNode STEP() { return getToken(QLangGrammarParser.STEP, 0); }
		public TerminalNode FEATURE() { return getToken(QLangGrammarParser.FEATURE, 0); }
		public TerminalNode TYPE() { return getToken(QLangGrammarParser.TYPE, 0); }
		public TerminalNode PARAM() { return getToken(QLangGrammarParser.PARAM, 0); }
		public TerminalNode VAL() { return getToken(QLangGrammarParser.VAL, 0); }
		public TerminalNode ENABLED() { return getToken(QLangGrammarParser.ENABLED, 0); }
		public TerminalNode ANCESTOR() { return getToken(QLangGrammarParser.ANCESTOR, 0); }
		public TerminalNode RULES() { return getToken(QLangGrammarParser.RULES, 0); }
		public TerminalNode DEPENDENCY() { return getToken(QLangGrammarParser.DEPENDENCY, 0); }
		public TerminalNode ARTIFACT() { return getToken(QLangGrammarParser.ARTIFACT, 0); }
		public TerminalNode SNAPSHOT() { return getToken(QLangGrammarParser.SNAPSHOT, 0); }
		public TerminalNode VCS_ENTRY() { return getToken(QLangGrammarParser.VCS_ENTRY, 0); }
		public TerminalNode REV_RULE() { return getToken(QLangGrammarParser.REV_RULE, 0); }
		public TerminalNode CLEAN() { return getToken(QLangGrammarParser.CLEAN, 0); }
		public TerminalNode OPTION() { return getToken(QLangGrammarParser.OPTION, 0); }
		public TerminalNode RESOLVED() { return getToken(QLangGrammarParser.RESOLVED, 0); }
		public TerminalNode ALL() { return getToken(QLangGrammarParser.ALL, 0); }
		public TerminalNode WITH_INHERITED() { return getToken(QLangGrammarParser.WITH_INHERITED, 0); }
		public FilterKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFilterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFilterKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFilterKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterKeywordContext filterKeyword() throws RecognitionException {
		FilterKeywordContext _localctx = new FilterKeywordContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_filterKeyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROJECT) | (1L << TEMPLATE) | (1L << BUILD_CONFIGURATION) | (1L << VCS_ROOT) | (1L << PARENT) | (1L << TRIGGER) | (1L << STEP) | (1L << FEATURE) | (1L << TYPE) | (1L << PARAM) | (1L << VAL) | (1L << ENABLED) | (1L << ANCESTOR) | (1L << RULES) | (1L << DEPENDENCY) | (1L << ARTIFACT) | (1L << SNAPSHOT) | (1L << WITH_INHERITED) | (1L << OPTION) | (1L << CLEAN) | (1L << REV_RULE) | (1L << VCS_ENTRY) | (1L << RESOLVED) | (1L << ALL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentOrStringContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(QLangGrammarParser.IDENT, 0); }
		public TerminalNode STRING() { return getToken(QLangGrammarParser.STRING, 0); }
		public FilterKeywordContext filterKeyword() {
			return getRuleContext(FilterKeywordContext.class,0);
		}
		public IdentOrStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identOrString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterIdentOrString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitIdentOrString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitIdentOrString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentOrStringContext identOrString() throws RecognitionException {
		IdentOrStringContext _localctx = new IdentOrStringContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identOrString);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(IDENT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(STRING);
				}
				break;
			case PROJECT:
			case TEMPLATE:
			case BUILD_CONFIGURATION:
			case VCS_ROOT:
			case PARENT:
			case TRIGGER:
			case STEP:
			case FEATURE:
			case TYPE:
			case PARAM:
			case VAL:
			case ENABLED:
			case ANCESTOR:
			case RULES:
			case DEPENDENCY:
			case ARTIFACT:
			case SNAPSHOT:
			case WITH_INHERITED:
			case OPTION:
			case CLEAN:
			case REV_RULE:
			case VCS_ENTRY:
			case RESOLVED:
			case ALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				filterKeyword();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectIdContext extends ParserRuleContext {
		public StringFilterOrConditionContext stringFilterOrCondition() {
			return getRuleContext(StringFilterOrConditionContext.class,0);
		}
		public ObjectIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterObjectId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitObjectId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitObjectId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectIdContext objectId() throws RecognitionException {
		ObjectIdContext _localctx = new ObjectIdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_objectId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			stringFilterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectTypeContext extends ParserRuleContext {
		public StringFilterOrConditionContext stringFilterOrCondition() {
			return getRuleContext(StringFilterOrConditionContext.class,0);
		}
		public ObjectTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterObjectType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitObjectType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitObjectType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectTypeContext objectType() throws RecognitionException {
		ObjectTypeContext _localctx = new ObjectTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_objectType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			stringFilterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterValueContext extends ParserRuleContext {
		public StringFilterOrConditionContext stringFilterOrCondition() {
			return getRuleContext(StringFilterOrConditionContext.class,0);
		}
		public ParameterValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterParameterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitParameterValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitParameterValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterValueContext parameterValue() throws RecognitionException {
		ParameterValueContext _localctx = new ParameterValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameterValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			stringFilterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterNameContext extends ParserRuleContext {
		public StringFilterOrConditionContext stringFilterOrCondition() {
			return getRuleContext(StringFilterOrConditionContext.class,0);
		}
		public ParameterNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterParameterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitParameterName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitParameterName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterNameContext parameterName() throws RecognitionException {
		ParameterNameContext _localctx = new ParameterNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameterName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			stringFilterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckoutRulesStringContext extends ParserRuleContext {
		public StringFilterOrConditionContext stringFilterOrCondition() {
			return getRuleContext(StringFilterOrConditionContext.class,0);
		}
		public CheckoutRulesStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkoutRulesString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterCheckoutRulesString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitCheckoutRulesString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitCheckoutRulesString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckoutRulesStringContext checkoutRulesString() throws RecognitionException {
		CheckoutRulesStringContext _localctx = new CheckoutRulesStringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_checkoutRulesString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			stringFilterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VcsRootKeywordContext extends ParserRuleContext {
		public TerminalNode VCS_ROOT() { return getToken(QLangGrammarParser.VCS_ROOT, 0); }
		public VcsRootKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vcsRootKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterVcsRootKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitVcsRootKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitVcsRootKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VcsRootKeywordContext vcsRootKeyword() throws RecognitionException {
		VcsRootKeywordContext _localctx = new VcsRootKeywordContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_vcsRootKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(VCS_ROOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuildConfKewordContext extends ParserRuleContext {
		public TerminalNode BUILD_CONFIGURATION() { return getToken(QLangGrammarParser.BUILD_CONFIGURATION, 0); }
		public BuildConfKewordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buildConfKeword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterBuildConfKeword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitBuildConfKeword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitBuildConfKeword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuildConfKewordContext buildConfKeword() throws RecognitionException {
		BuildConfKewordContext _localctx = new BuildConfKewordContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_buildConfKeword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(BUILD_CONFIGURATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProjectKewordContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(QLangGrammarParser.PROJECT, 0); }
		public ProjectKewordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projectKeword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterProjectKeword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitProjectKeword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitProjectKeword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectKewordContext projectKeword() throws RecognitionException {
		ProjectKewordContext _localctx = new ProjectKewordContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_projectKeword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(PROJECT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateKeywordContext extends ParserRuleContext {
		public TerminalNode TEMPLATE() { return getToken(QLangGrammarParser.TEMPLATE, 0); }
		public TemplateKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterTemplateKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitTemplateKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitTemplateKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateKeywordContext templateKeyword() throws RecognitionException {
		TemplateKeywordContext _localctx = new TemplateKeywordContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_templateKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(TEMPLATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartialQueryContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public PartialQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partialQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterPartialQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitPartialQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitPartialQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartialQueryContext partialQuery() throws RecognitionException {
		PartialQueryContext _localctx = new PartialQueryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_partialQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			condition(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FindContext extends ParserRuleContext {
		public MultipleObjectsContext multipleObjects() {
			return getRuleContext(MultipleObjectsContext.class,0);
		}
		public ConditionInSubprojectContext conditionInSubproject() {
			return getRuleContext(ConditionInSubprojectContext.class,0);
		}
		public FindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_find; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindContext find() throws RecognitionException {
		FindContext _localctx = new FindContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_find);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__0);
			setState(156);
			multipleObjects();
			setState(157);
			conditionInSubproject();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleObjectsContext extends ParserRuleContext {
		public List<ObjectKeywordContext> objectKeyword() {
			return getRuleContexts(ObjectKeywordContext.class);
		}
		public ObjectKeywordContext objectKeyword(int i) {
			return getRuleContext(ObjectKeywordContext.class,i);
		}
		public MultipleObjectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleObjects; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterMultipleObjects(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitMultipleObjects(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitMultipleObjects(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleObjectsContext multipleObjects() throws RecognitionException {
		MultipleObjectsContext _localctx = new MultipleObjectsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_multipleObjects);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			objectKeyword();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(160);
				match(T__1);
				setState(161);
				objectKeyword();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectKeywordContext extends ParserRuleContext {
		public ProjectKewordContext projectKeword() {
			return getRuleContext(ProjectKewordContext.class,0);
		}
		public TemplateKeywordContext templateKeyword() {
			return getRuleContext(TemplateKeywordContext.class,0);
		}
		public BuildConfKewordContext buildConfKeword() {
			return getRuleContext(BuildConfKewordContext.class,0);
		}
		public VcsRootKeywordContext vcsRootKeyword() {
			return getRuleContext(VcsRootKeywordContext.class,0);
		}
		public ObjectKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterObjectKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitObjectKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitObjectKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectKeywordContext objectKeyword() throws RecognitionException {
		ObjectKeywordContext _localctx = new ObjectKeywordContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_objectKeyword);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				projectKeword();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				templateKeyword();
				}
				break;
			case BUILD_CONFIGURATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				buildConfKeword();
				}
				break;
			case VCS_ROOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				vcsRootKeyword();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionInSubprojectContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ObjectIdContext objectId() {
			return getRuleContext(ObjectIdContext.class,0);
		}
		public ConditionInSubprojectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionInSubproject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterConditionInSubproject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitConditionInSubproject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitConditionInSubproject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionInSubprojectContext conditionInSubproject() throws RecognitionException {
		ConditionInSubprojectContext _localctx = new ConditionInSubprojectContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditionInSubproject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(173);
					match(T__2);
					setState(174);
					objectId();
					}
				}

				setState(177);
				match(T__3);
				setState(178);
				condition(0);
				}
				break;
			case 2:
				{
				setState(179);
				match(T__2);
				setState(180);
				objectId();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public IdFilterContext idFilter() {
			return getRuleContext(IdFilterContext.class,0);
		}
		public ProjectFilterContext projectFilter() {
			return getRuleContext(ProjectFilterContext.class,0);
		}
		public ParentFilterContext parentFilter() {
			return getRuleContext(ParentFilterContext.class,0);
		}
		public TriggerFilterContext triggerFilter() {
			return getRuleContext(TriggerFilterContext.class,0);
		}
		public StepFilterContext stepFilter() {
			return getRuleContext(StepFilterContext.class,0);
		}
		public FeatureFilterContext featureFilter() {
			return getRuleContext(FeatureFilterContext.class,0);
		}
		public TypeFilterContext typeFilter() {
			return getRuleContext(TypeFilterContext.class,0);
		}
		public ParameterFilterContext parameterFilter() {
			return getRuleContext(ParameterFilterContext.class,0);
		}
		public ParValueFilterContext parValueFilter() {
			return getRuleContext(ParValueFilterContext.class,0);
		}
		public EnabledFilterContext enabledFilter() {
			return getRuleContext(EnabledFilterContext.class,0);
		}
		public AncestorFilterContext ancestorFilter() {
			return getRuleContext(AncestorFilterContext.class,0);
		}
		public TemplateDepFilterContext templateDepFilter() {
			return getRuleContext(TemplateDepFilterContext.class,0);
		}
		public VcsRootFilterContext vcsRootFilter() {
			return getRuleContext(VcsRootFilterContext.class,0);
		}
		public CheckoutRulesFilterContext checkoutRulesFilter() {
			return getRuleContext(CheckoutRulesFilterContext.class,0);
		}
		public DependencyFilterContext dependencyFilter() {
			return getRuleContext(DependencyFilterContext.class,0);
		}
		public ArtifactFilterContext artifactFilter() {
			return getRuleContext(ArtifactFilterContext.class,0);
		}
		public SnapshotFilterContext snapshotFilter() {
			return getRuleContext(SnapshotFilterContext.class,0);
		}
		public OptionFilterContext optionFilter() {
			return getRuleContext(OptionFilterContext.class,0);
		}
		public CleanFilterContext cleanFilter() {
			return getRuleContext(CleanFilterContext.class,0);
		}
		public RevRuleFilterContext revRuleFilter() {
			return getRuleContext(RevRuleFilterContext.class,0);
		}
		public VcsRootEntryFilterContext vcsRootEntryFilter() {
			return getRuleContext(VcsRootEntryFilterContext.class,0);
		}
		public NameFilterContext nameFilter() {
			return getRuleContext(NameFilterContext.class,0);
		}
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_filter);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				idFilter();
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				projectFilter();
				}
				break;
			case PARENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				parentFilter();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				triggerFilter();
				}
				break;
			case STEP:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				stepFilter();
				}
				break;
			case FEATURE:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				featureFilter();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 7);
				{
				setState(189);
				typeFilter();
				}
				break;
			case PARAM:
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				parameterFilter();
				}
				break;
			case VAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(191);
				parValueFilter();
				}
				break;
			case ENABLED:
				enterOuterAlt(_localctx, 10);
				{
				setState(192);
				enabledFilter();
				}
				break;
			case ANCESTOR:
				enterOuterAlt(_localctx, 11);
				{
				setState(193);
				ancestorFilter();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 12);
				{
				setState(194);
				templateDepFilter();
				}
				break;
			case VCS_ROOT:
				enterOuterAlt(_localctx, 13);
				{
				setState(195);
				vcsRootFilter();
				}
				break;
			case RULES:
				enterOuterAlt(_localctx, 14);
				{
				setState(196);
				checkoutRulesFilter();
				}
				break;
			case DEPENDENCY:
				enterOuterAlt(_localctx, 15);
				{
				setState(197);
				dependencyFilter();
				}
				break;
			case ARTIFACT:
				enterOuterAlt(_localctx, 16);
				{
				setState(198);
				artifactFilter();
				}
				break;
			case SNAPSHOT:
				enterOuterAlt(_localctx, 17);
				{
				setState(199);
				snapshotFilter();
				}
				break;
			case OPTION:
				enterOuterAlt(_localctx, 18);
				{
				setState(200);
				optionFilter();
				}
				break;
			case CLEAN:
				enterOuterAlt(_localctx, 19);
				{
				setState(201);
				cleanFilter();
				}
				break;
			case REV_RULE:
				enterOuterAlt(_localctx, 20);
				{
				setState(202);
				revRuleFilter();
				}
				break;
			case VCS_ENTRY:
				enterOuterAlt(_localctx, 21);
				{
				setState(203);
				vcsRootEntryFilter();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 22);
				{
				setState(204);
				nameFilter();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionBracesContext extends ConditionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionBracesContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterConditionBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitConditionBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitConditionBraces(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionNotContext extends ConditionContext {
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionNotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterConditionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitConditionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitConditionNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionFilterContext extends ConditionContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public ConditionFilterContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterConditionFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitConditionFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitConditionFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionAndContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public ConditionAndContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterConditionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitConditionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitConditionAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionOrContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public ConditionOrContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterConditionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitConditionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitConditionOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
			case TEMPLATE:
			case VCS_ROOT:
			case ID:
			case PARENT:
			case TRIGGER:
			case STEP:
			case FEATURE:
			case TYPE:
			case PARAM:
			case VAL:
			case ENABLED:
			case ANCESTOR:
			case RULES:
			case DEPENDENCY:
			case ARTIFACT:
			case SNAPSHOT:
			case OPTION:
			case CLEAN:
			case REV_RULE:
			case VCS_ENTRY:
			case NAME:
				{
				_localctx = new ConditionFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(208);
				filter();
				}
				break;
			case T__4:
				{
				_localctx = new ConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(T__4);
				setState(210);
				condition(0);
				setState(211);
				match(T__5);
				}
				break;
			case NOT:
				{
				_localctx = new ConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				not();
				setState(214);
				condition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(226);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionAndContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(218);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(219);
						and();
						setState(220);
						condition(3);
						}
						break;
					case 2:
						{
						_localctx = new ConditionOrContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(222);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(223);
						or();
						setState(224);
						condition(2);
						}
						break;
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FilterOrConditionContext extends ParserRuleContext {
		public FilterOrConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterOrCondition; }
	 
		public FilterOrConditionContext() { }
		public void copyFrom(FilterOrConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleFilterContext extends FilterOrConditionContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public SingleFilterContext(FilterOrConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterSingleFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitSingleFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitSingleFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultFilterContext extends FilterOrConditionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public MultFilterContext(FilterOrConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterMultFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitMultFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitMultFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterOrConditionContext filterOrCondition() throws RecognitionException {
		FilterOrConditionContext _localctx = new FilterOrConditionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_filterOrCondition);
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
			case TEMPLATE:
			case VCS_ROOT:
			case ID:
			case PARENT:
			case TRIGGER:
			case STEP:
			case FEATURE:
			case TYPE:
			case PARAM:
			case VAL:
			case ENABLED:
			case ANCESTOR:
			case RULES:
			case DEPENDENCY:
			case ARTIFACT:
			case SNAPSHOT:
			case OPTION:
			case CLEAN:
			case REV_RULE:
			case VCS_ENTRY:
			case NAME:
				_localctx = new SingleFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				filter();
				}
				break;
			case T__4:
				_localctx = new MultFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				match(T__4);
				setState(233);
				condition(0);
				setState(234);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringFilterOrConditionContext extends ParserRuleContext {
		public StringFilterOrConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringFilterOrCondition; }
	 
		public StringFilterOrConditionContext() { }
		public void copyFrom(StringFilterOrConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultipleStringFilterContext extends StringFilterOrConditionContext {
		public StringConditionContext stringCondition() {
			return getRuleContext(StringConditionContext.class,0);
		}
		public MultipleStringFilterContext(StringFilterOrConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterMultipleStringFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitMultipleStringFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitMultipleStringFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleStringFilterContext extends StringFilterOrConditionContext {
		public StringFilterContext stringFilter() {
			return getRuleContext(StringFilterContext.class,0);
		}
		public SingleStringFilterContext(StringFilterOrConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterSingleStringFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitSingleStringFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitSingleStringFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringFilterOrConditionContext stringFilterOrCondition() throws RecognitionException {
		StringFilterOrConditionContext _localctx = new StringFilterOrConditionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stringFilterOrCondition);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
			case SUFFIXS:
			case PREFIXS:
			case SUBSTRINGS:
			case ANY_STRING:
			case PROJECT:
			case TEMPLATE:
			case BUILD_CONFIGURATION:
			case VCS_ROOT:
			case PARENT:
			case TRIGGER:
			case STEP:
			case FEATURE:
			case TYPE:
			case PARAM:
			case VAL:
			case ENABLED:
			case ANCESTOR:
			case RULES:
			case DEPENDENCY:
			case ARTIFACT:
			case SNAPSHOT:
			case WITH_INHERITED:
			case OPTION:
			case CLEAN:
			case REV_RULE:
			case VCS_ENTRY:
			case RESOLVED:
			case ALL:
				_localctx = new SingleStringFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				stringFilter();
				}
				break;
			case T__4:
				_localctx = new MultipleStringFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(T__4);
				setState(240);
				stringCondition(0);
				setState(241);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdFilterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QLangGrammarParser.ID, 0); }
		public ObjectIdContext objectId() {
			return getRuleContext(ObjectIdContext.class,0);
		}
		public IdFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterIdFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitIdFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitIdFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdFilterContext idFilter() throws RecognitionException {
		IdFilterContext _localctx = new IdFilterContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_idFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(ID);
			setState(246);
			objectId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProjectFilterContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(QLangGrammarParser.PROJECT, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public ProjectFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projectFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterProjectFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitProjectFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitProjectFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectFilterContext projectFilter() throws RecognitionException {
		ProjectFilterContext _localctx = new ProjectFilterContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_projectFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(PROJECT);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(249);
				modifierList();
				}
			}

			setState(252);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParentFilterContext extends ParserRuleContext {
		public TerminalNode PARENT() { return getToken(QLangGrammarParser.PARENT, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public ParentFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterParentFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitParentFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitParentFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentFilterContext parentFilter() throws RecognitionException {
		ParentFilterContext _localctx = new ParentFilterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parentFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(PARENT);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(255);
				modifierList();
				}
			}

			setState(258);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerFilterContext extends ParserRuleContext {
		public TerminalNode TRIGGER() { return getToken(QLangGrammarParser.TRIGGER, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TriggerFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterTriggerFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitTriggerFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitTriggerFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerFilterContext triggerFilter() throws RecognitionException {
		TriggerFilterContext _localctx = new TriggerFilterContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_triggerFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(TRIGGER);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(261);
				modifierList();
				}
			}

			setState(264);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepFilterContext extends ParserRuleContext {
		public TerminalNode STEP() { return getToken(QLangGrammarParser.STEP, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public StepFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStepFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStepFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStepFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepFilterContext stepFilter() throws RecognitionException {
		StepFilterContext _localctx = new StepFilterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_stepFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(STEP);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(267);
				modifierList();
				}
			}

			setState(270);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureFilterContext extends ParserRuleContext {
		public TerminalNode FEATURE() { return getToken(QLangGrammarParser.FEATURE, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public FeatureFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFeatureFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFeatureFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFeatureFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureFilterContext featureFilter() throws RecognitionException {
		FeatureFilterContext _localctx = new FeatureFilterContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_featureFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(FEATURE);
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(273);
				modifierList();
				}
			}

			setState(276);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeFilterContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(QLangGrammarParser.TYPE, 0); }
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TypeFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterTypeFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitTypeFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitTypeFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeFilterContext typeFilter() throws RecognitionException {
		TypeFilterContext _localctx = new TypeFilterContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_typeFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(TYPE);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(279);
				modifierList();
				}
			}

			setState(282);
			objectType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterFilterContext extends ParserRuleContext {
		public TerminalNode PARAM() { return getToken(QLangGrammarParser.PARAM, 0); }
		public ParameterNameContext parameterName() {
			return getRuleContext(ParameterNameContext.class,0);
		}
		public ParameterValueContext parameterValue() {
			return getRuleContext(ParameterValueContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public ParameterFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterParameterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitParameterFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitParameterFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterFilterContext parameterFilter() throws RecognitionException {
		ParameterFilterContext _localctx = new ParameterFilterContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_parameterFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(PARAM);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(285);
				modifierList();
				}
			}

			setState(288);
			parameterName();
			setState(289);
			match(T__6);
			setState(290);
			parameterValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParValueFilterContext extends ParserRuleContext {
		public TerminalNode VAL() { return getToken(QLangGrammarParser.VAL, 0); }
		public ParameterValueContext parameterValue() {
			return getRuleContext(ParameterValueContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public ParValueFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parValueFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterParValueFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitParValueFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitParValueFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParValueFilterContext parValueFilter() throws RecognitionException {
		ParValueFilterContext _localctx = new ParValueFilterContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_parValueFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(VAL);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(293);
				modifierList();
				}
			}

			setState(296);
			parameterValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnabledFilterContext extends ParserRuleContext {
		public TerminalNode ENABLED() { return getToken(QLangGrammarParser.ENABLED, 0); }
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public EnabledFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enabledFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterEnabledFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitEnabledFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitEnabledFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnabledFilterContext enabledFilter() throws RecognitionException {
		EnabledFilterContext _localctx = new EnabledFilterContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_enabledFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(ENABLED);
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(299);
				modifierList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AncestorFilterContext extends ParserRuleContext {
		public TerminalNode ANCESTOR() { return getToken(QLangGrammarParser.ANCESTOR, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public AncestorFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ancestorFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterAncestorFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitAncestorFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitAncestorFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AncestorFilterContext ancestorFilter() throws RecognitionException {
		AncestorFilterContext _localctx = new AncestorFilterContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ancestorFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(ANCESTOR);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(303);
				modifierList();
				}
			}

			setState(306);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateDepFilterContext extends ParserRuleContext {
		public TerminalNode TEMPLATE() { return getToken(QLangGrammarParser.TEMPLATE, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TemplateDepFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateDepFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterTemplateDepFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitTemplateDepFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitTemplateDepFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateDepFilterContext templateDepFilter() throws RecognitionException {
		TemplateDepFilterContext _localctx = new TemplateDepFilterContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_templateDepFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(TEMPLATE);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(309);
				modifierList();
				}
			}

			setState(312);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VcsRootFilterContext extends ParserRuleContext {
		public TerminalNode VCS_ROOT() { return getToken(QLangGrammarParser.VCS_ROOT, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public VcsRootFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vcsRootFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterVcsRootFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitVcsRootFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitVcsRootFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VcsRootFilterContext vcsRootFilter() throws RecognitionException {
		VcsRootFilterContext _localctx = new VcsRootFilterContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_vcsRootFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(VCS_ROOT);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(315);
				modifierList();
				}
			}

			setState(318);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VcsRootEntryFilterContext extends ParserRuleContext {
		public TerminalNode VCS_ENTRY() { return getToken(QLangGrammarParser.VCS_ENTRY, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public VcsRootEntryFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vcsRootEntryFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterVcsRootEntryFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitVcsRootEntryFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitVcsRootEntryFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VcsRootEntryFilterContext vcsRootEntryFilter() throws RecognitionException {
		VcsRootEntryFilterContext _localctx = new VcsRootEntryFilterContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_vcsRootEntryFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(VCS_ENTRY);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(321);
				modifierList();
				}
			}

			setState(324);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckoutRulesFilterContext extends ParserRuleContext {
		public TerminalNode RULES() { return getToken(QLangGrammarParser.RULES, 0); }
		public CheckoutRulesStringContext checkoutRulesString() {
			return getRuleContext(CheckoutRulesStringContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public CheckoutRulesFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkoutRulesFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterCheckoutRulesFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitCheckoutRulesFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitCheckoutRulesFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckoutRulesFilterContext checkoutRulesFilter() throws RecognitionException {
		CheckoutRulesFilterContext _localctx = new CheckoutRulesFilterContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_checkoutRulesFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(RULES);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(327);
				modifierList();
				}
			}

			setState(330);
			checkoutRulesString();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DependencyFilterContext extends ParserRuleContext {
		public TerminalNode DEPENDENCY() { return getToken(QLangGrammarParser.DEPENDENCY, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public DependencyFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependencyFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterDependencyFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitDependencyFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitDependencyFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependencyFilterContext dependencyFilter() throws RecognitionException {
		DependencyFilterContext _localctx = new DependencyFilterContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_dependencyFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(DEPENDENCY);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(333);
				modifierList();
				}
			}

			setState(336);
			filterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArtifactFilterContext extends ParserRuleContext {
		public TerminalNode ARTIFACT() { return getToken(QLangGrammarParser.ARTIFACT, 0); }
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public ArtifactFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_artifactFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterArtifactFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitArtifactFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitArtifactFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArtifactFilterContext artifactFilter() throws RecognitionException {
		ArtifactFilterContext _localctx = new ArtifactFilterContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_artifactFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(ARTIFACT);
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(339);
				modifierList();
				}
				break;
			}
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(342);
				filterOrCondition();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SnapshotFilterContext extends ParserRuleContext {
		public TerminalNode SNAPSHOT() { return getToken(QLangGrammarParser.SNAPSHOT, 0); }
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public SnapshotFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_snapshotFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterSnapshotFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitSnapshotFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitSnapshotFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SnapshotFilterContext snapshotFilter() throws RecognitionException {
		SnapshotFilterContext _localctx = new SnapshotFilterContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_snapshotFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(SNAPSHOT);
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(346);
				modifierList();
				}
				break;
			}
			setState(350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(349);
				filterOrCondition();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionFilterContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(QLangGrammarParser.OPTION, 0); }
		public ParameterNameContext parameterName() {
			return getRuleContext(ParameterNameContext.class,0);
		}
		public ParameterValueContext parameterValue() {
			return getRuleContext(ParameterValueContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public OptionFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterOptionFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitOptionFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitOptionFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionFilterContext optionFilter() throws RecognitionException {
		OptionFilterContext _localctx = new OptionFilterContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_optionFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(OPTION);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(353);
				modifierList();
				}
			}

			setState(356);
			parameterName();
			setState(357);
			match(T__6);
			setState(358);
			parameterValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CleanFilterContext extends ParserRuleContext {
		public TerminalNode CLEAN() { return getToken(QLangGrammarParser.CLEAN, 0); }
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public CleanFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cleanFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterCleanFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitCleanFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitCleanFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CleanFilterContext cleanFilter() throws RecognitionException {
		CleanFilterContext _localctx = new CleanFilterContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_cleanFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(CLEAN);
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(361);
				modifierList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RevRuleFilterContext extends ParserRuleContext {
		public TerminalNode REV_RULE() { return getToken(QLangGrammarParser.REV_RULE, 0); }
		public StringFilterOrConditionContext stringFilterOrCondition() {
			return getRuleContext(StringFilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public RevRuleFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_revRuleFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterRevRuleFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitRevRuleFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitRevRuleFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RevRuleFilterContext revRuleFilter() throws RecognitionException {
		RevRuleFilterContext _localctx = new RevRuleFilterContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_revRuleFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(REV_RULE);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(365);
				modifierList();
				}
			}

			setState(368);
			stringFilterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameFilterContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QLangGrammarParser.NAME, 0); }
		public StringFilterOrConditionContext stringFilterOrCondition() {
			return getRuleContext(StringFilterOrConditionContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public NameFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterNameFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitNameFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitNameFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameFilterContext nameFilter() throws RecognitionException {
		NameFilterContext _localctx = new NameFilterContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nameFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(NAME);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(371);
				modifierList();
				}
			}

			setState(374);
			stringFilterOrCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringConditionContext extends ParserRuleContext {
		public StringConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringCondition; }
	 
		public StringConditionContext() { }
		public void copyFrom(StringConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringConditionFilterContext extends StringConditionContext {
		public StringFilterContext stringFilter() {
			return getRuleContext(StringFilterContext.class,0);
		}
		public StringConditionFilterContext(StringConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringConditionFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringConditionFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringConditionFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConditionAndContext extends StringConditionContext {
		public List<StringConditionContext> stringCondition() {
			return getRuleContexts(StringConditionContext.class);
		}
		public StringConditionContext stringCondition(int i) {
			return getRuleContext(StringConditionContext.class,i);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public StringConditionAndContext(StringConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringConditionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringConditionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringConditionAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConditionBracesContext extends StringConditionContext {
		public StringConditionContext stringCondition() {
			return getRuleContext(StringConditionContext.class,0);
		}
		public StringConditionBracesContext(StringConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringConditionBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringConditionBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringConditionBraces(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConditionOrContext extends StringConditionContext {
		public List<StringConditionContext> stringCondition() {
			return getRuleContexts(StringConditionContext.class);
		}
		public StringConditionContext stringCondition(int i) {
			return getRuleContext(StringConditionContext.class,i);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public StringConditionOrContext(StringConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringConditionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringConditionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringConditionOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConditionNotContext extends StringConditionContext {
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public StringConditionContext stringCondition() {
			return getRuleContext(StringConditionContext.class,0);
		}
		public StringConditionNotContext(StringConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringConditionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringConditionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringConditionNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConditionContext stringCondition() throws RecognitionException {
		return stringCondition(0);
	}

	private StringConditionContext stringCondition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringConditionContext _localctx = new StringConditionContext(_ctx, _parentState);
		StringConditionContext _prevctx = _localctx;
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_stringCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
			case SUFFIXS:
			case PREFIXS:
			case SUBSTRINGS:
			case ANY_STRING:
			case PROJECT:
			case TEMPLATE:
			case BUILD_CONFIGURATION:
			case VCS_ROOT:
			case PARENT:
			case TRIGGER:
			case STEP:
			case FEATURE:
			case TYPE:
			case PARAM:
			case VAL:
			case ENABLED:
			case ANCESTOR:
			case RULES:
			case DEPENDENCY:
			case ARTIFACT:
			case SNAPSHOT:
			case WITH_INHERITED:
			case OPTION:
			case CLEAN:
			case REV_RULE:
			case VCS_ENTRY:
			case RESOLVED:
			case ALL:
				{
				_localctx = new StringConditionFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(377);
				stringFilter();
				}
				break;
			case T__4:
				{
				_localctx = new StringConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(378);
				match(T__4);
				setState(379);
				stringCondition(0);
				setState(380);
				match(T__5);
				}
				break;
			case NOT:
				{
				_localctx = new StringConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(382);
				not();
				setState(383);
				stringCondition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(397);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(395);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new StringConditionAndContext(new StringConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stringCondition);
						setState(387);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(388);
						and();
						setState(389);
						stringCondition(3);
						}
						break;
					case 2:
						{
						_localctx = new StringConditionOrContext(new StringConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stringCondition);
						setState(391);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(392);
						or();
						setState(393);
						stringCondition(2);
						}
						break;
					}
					} 
				}
				setState(399);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StringFilterContext extends ParserRuleContext {
		public StringEqualsFilterContext stringEqualsFilter() {
			return getRuleContext(StringEqualsFilterContext.class,0);
		}
		public StringPrefixFilterContext stringPrefixFilter() {
			return getRuleContext(StringPrefixFilterContext.class,0);
		}
		public StringSuffixFilterContext stringSuffixFilter() {
			return getRuleContext(StringSuffixFilterContext.class,0);
		}
		public StringSubstringFilterContext stringSubstringFilter() {
			return getRuleContext(StringSubstringFilterContext.class,0);
		}
		public AnyStringFilterContext anyStringFilter() {
			return getRuleContext(AnyStringFilterContext.class,0);
		}
		public StringFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringFilterContext stringFilter() throws RecognitionException {
		StringFilterContext _localctx = new StringFilterContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_stringFilter);
		try {
			setState(405);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
			case PROJECT:
			case TEMPLATE:
			case BUILD_CONFIGURATION:
			case VCS_ROOT:
			case PARENT:
			case TRIGGER:
			case STEP:
			case FEATURE:
			case TYPE:
			case PARAM:
			case VAL:
			case ENABLED:
			case ANCESTOR:
			case RULES:
			case DEPENDENCY:
			case ARTIFACT:
			case SNAPSHOT:
			case WITH_INHERITED:
			case OPTION:
			case CLEAN:
			case REV_RULE:
			case VCS_ENTRY:
			case RESOLVED:
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				stringEqualsFilter();
				}
				break;
			case PREFIXS:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				stringPrefixFilter();
				}
				break;
			case SUFFIXS:
				enterOuterAlt(_localctx, 3);
				{
				setState(402);
				stringSuffixFilter();
				}
				break;
			case SUBSTRINGS:
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				stringSubstringFilter();
				}
				break;
			case ANY_STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				anyStringFilter();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringEqualsFilterContext extends ParserRuleContext {
		public IdentOrStringContext identOrString() {
			return getRuleContext(IdentOrStringContext.class,0);
		}
		public StringEqualsFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringEqualsFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringEqualsFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringEqualsFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringEqualsFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringEqualsFilterContext stringEqualsFilter() throws RecognitionException {
		StringEqualsFilterContext _localctx = new StringEqualsFilterContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_stringEqualsFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			identOrString();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringPrefixFilterContext extends ParserRuleContext {
		public TerminalNode PREFIXS() { return getToken(QLangGrammarParser.PREFIXS, 0); }
		public StringPrefixFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringPrefixFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringPrefixFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringPrefixFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringPrefixFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringPrefixFilterContext stringPrefixFilter() throws RecognitionException {
		StringPrefixFilterContext _localctx = new StringPrefixFilterContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_stringPrefixFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(PREFIXS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringSuffixFilterContext extends ParserRuleContext {
		public TerminalNode SUFFIXS() { return getToken(QLangGrammarParser.SUFFIXS, 0); }
		public StringSuffixFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringSuffixFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringSuffixFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringSuffixFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringSuffixFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringSuffixFilterContext stringSuffixFilter() throws RecognitionException {
		StringSuffixFilterContext _localctx = new StringSuffixFilterContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_stringSuffixFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(SUFFIXS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringSubstringFilterContext extends ParserRuleContext {
		public TerminalNode SUBSTRINGS() { return getToken(QLangGrammarParser.SUBSTRINGS, 0); }
		public StringSubstringFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringSubstringFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterStringSubstringFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitStringSubstringFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitStringSubstringFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringSubstringFilterContext stringSubstringFilter() throws RecognitionException {
		StringSubstringFilterContext _localctx = new StringSubstringFilterContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_stringSubstringFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(SUBSTRINGS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyStringFilterContext extends ParserRuleContext {
		public TerminalNode ANY_STRING() { return getToken(QLangGrammarParser.ANY_STRING, 0); }
		public AnyStringFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyStringFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterAnyStringFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitAnyStringFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitAnyStringFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyStringFilterContext anyStringFilter() throws RecognitionException {
		AnyStringFilterContext _localctx = new AnyStringFilterContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_anyStringFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(ANY_STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterModifierContext extends ParserRuleContext {
		public WithInheritedModifierContext withInheritedModifier() {
			return getRuleContext(WithInheritedModifierContext.class,0);
		}
		public ResolvedModifierContext resolvedModifier() {
			return getRuleContext(ResolvedModifierContext.class,0);
		}
		public AllModifierContext allModifier() {
			return getRuleContext(AllModifierContext.class,0);
		}
		public FilterModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFilterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFilterModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFilterModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterModifierContext filterModifier() throws RecognitionException {
		FilterModifierContext _localctx = new FilterModifierContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_filterModifier);
		try {
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WITH_INHERITED:
				enterOuterAlt(_localctx, 1);
				{
				setState(417);
				withInheritedModifier();
				}
				break;
			case RESOLVED:
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
				resolvedModifier();
				}
				break;
			case ALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(419);
				allModifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierListContext extends ParserRuleContext {
		public List<FilterModifierContext> filterModifier() {
			return getRuleContexts(FilterModifierContext.class);
		}
		public FilterModifierContext filterModifier(int i) {
			return getRuleContext(FilterModifierContext.class,i);
		}
		public ModifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterModifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitModifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitModifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierListContext modifierList() throws RecognitionException {
		ModifierListContext _localctx = new ModifierListContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_modifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(T__7);
			setState(423);
			filterModifier();
			setState(428);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(424);
					match(T__1);
					setState(425);
					filterModifier();
					}
					} 
				}
				setState(430);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(431);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithInheritedModifierContext extends ParserRuleContext {
		public TerminalNode WITH_INHERITED() { return getToken(QLangGrammarParser.WITH_INHERITED, 0); }
		public WithInheritedModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withInheritedModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterWithInheritedModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitWithInheritedModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitWithInheritedModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithInheritedModifierContext withInheritedModifier() throws RecognitionException {
		WithInheritedModifierContext _localctx = new WithInheritedModifierContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_withInheritedModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(WITH_INHERITED);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResolvedModifierContext extends ParserRuleContext {
		public TerminalNode RESOLVED() { return getToken(QLangGrammarParser.RESOLVED, 0); }
		public ResolvedModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resolvedModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterResolvedModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitResolvedModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitResolvedModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResolvedModifierContext resolvedModifier() throws RecognitionException {
		ResolvedModifierContext _localctx = new ResolvedModifierContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_resolvedModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(RESOLVED);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllModifierContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(QLangGrammarParser.ALL, 0); }
		public AllModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterAllModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitAllModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitAllModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllModifierContext allModifier() throws RecognitionException {
		AllModifierContext _localctx = new AllModifierContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_allModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(ALL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 46:
			return stringCondition_sempred((StringConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean stringCondition_sempred(StringConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u01ba\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\5\2"+
		"y\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7\u0088\n"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00a5"+
		"\n\23\f\23\16\23\u00a8\13\23\3\24\3\24\3\24\3\24\5\24\u00ae\n\24\3\25"+
		"\3\25\5\25\u00b2\n\25\3\25\3\25\3\25\3\25\5\25\u00b8\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\5\26\u00d0\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00db\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u00e5\n\27\f\27\16\27\u00e8\13\27\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u00ef\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u00f6\n\31\3\32\3\32\3"+
		"\32\3\33\3\33\5\33\u00fd\n\33\3\33\3\33\3\34\3\34\5\34\u0103\n\34\3\34"+
		"\3\34\3\35\3\35\5\35\u0109\n\35\3\35\3\35\3\36\3\36\5\36\u010f\n\36\3"+
		"\36\3\36\3\37\3\37\5\37\u0115\n\37\3\37\3\37\3 \3 \5 \u011b\n \3 \3 \3"+
		"!\3!\5!\u0121\n!\3!\3!\3!\3!\3\"\3\"\5\"\u0129\n\"\3\"\3\"\3#\3#\5#\u012f"+
		"\n#\3$\3$\5$\u0133\n$\3$\3$\3%\3%\5%\u0139\n%\3%\3%\3&\3&\5&\u013f\n&"+
		"\3&\3&\3\'\3\'\5\'\u0145\n\'\3\'\3\'\3(\3(\5(\u014b\n(\3(\3(\3)\3)\5)"+
		"\u0151\n)\3)\3)\3*\3*\5*\u0157\n*\3*\5*\u015a\n*\3+\3+\5+\u015e\n+\3+"+
		"\5+\u0161\n+\3,\3,\5,\u0165\n,\3,\3,\3,\3,\3-\3-\5-\u016d\n-\3.\3.\5."+
		"\u0171\n.\3.\3.\3/\3/\5/\u0177\n/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\5\60\u0184\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\7\60\u018e\n\60\f\60\16\60\u0191\13\60\3\61\3\61\3\61\3\61\3\61\5\61"+
		"\u0198\n\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\3\67\5\67\u01a7\n\67\38\38\38\38\78\u01ad\n8\f8\168\u01b0\138\38\38\3"+
		"9\39\3:\3:\3;\3;\3;\3\u01ae\4,^<\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt\2\3\5\2\26\31\33"+
		",./\2\u01c5\2x\3\2\2\2\4|\3\2\2\2\6~\3\2\2\2\b\u0080\3\2\2\2\n\u0082\3"+
		"\2\2\2\f\u0087\3\2\2\2\16\u0089\3\2\2\2\20\u008b\3\2\2\2\22\u008d\3\2"+
		"\2\2\24\u008f\3\2\2\2\26\u0091\3\2\2\2\30\u0093\3\2\2\2\32\u0095\3\2\2"+
		"\2\34\u0097\3\2\2\2\36\u0099\3\2\2\2 \u009b\3\2\2\2\"\u009d\3\2\2\2$\u00a1"+
		"\3\2\2\2&\u00ad\3\2\2\2(\u00b7\3\2\2\2*\u00cf\3\2\2\2,\u00da\3\2\2\2."+
		"\u00ee\3\2\2\2\60\u00f5\3\2\2\2\62\u00f7\3\2\2\2\64\u00fa\3\2\2\2\66\u0100"+
		"\3\2\2\28\u0106\3\2\2\2:\u010c\3\2\2\2<\u0112\3\2\2\2>\u0118\3\2\2\2@"+
		"\u011e\3\2\2\2B\u0126\3\2\2\2D\u012c\3\2\2\2F\u0130\3\2\2\2H\u0136\3\2"+
		"\2\2J\u013c\3\2\2\2L\u0142\3\2\2\2N\u0148\3\2\2\2P\u014e\3\2\2\2R\u0154"+
		"\3\2\2\2T\u015b\3\2\2\2V\u0162\3\2\2\2X\u016a\3\2\2\2Z\u016e\3\2\2\2\\"+
		"\u0174\3\2\2\2^\u0183\3\2\2\2`\u0197\3\2\2\2b\u0199\3\2\2\2d\u019b\3\2"+
		"\2\2f\u019d\3\2\2\2h\u019f\3\2\2\2j\u01a1\3\2\2\2l\u01a6\3\2\2\2n\u01a8"+
		"\3\2\2\2p\u01b3\3\2\2\2r\u01b5\3\2\2\2t\u01b7\3\2\2\2vy\5\"\22\2wy\5 "+
		"\21\2xv\3\2\2\2xw\3\2\2\2yz\3\2\2\2z{\7\2\2\3{\3\3\2\2\2|}\7\r\2\2}\5"+
		"\3\2\2\2~\177\7\f\2\2\177\7\3\2\2\2\u0080\u0081\7\16\2\2\u0081\t\3\2\2"+
		"\2\u0082\u0083\t\2\2\2\u0083\13\3\2\2\2\u0084\u0088\7\20\2\2\u0085\u0088"+
		"\7\17\2\2\u0086\u0088\5\n\6\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\r\3\2\2\2\u0089\u008a\5\60\31\2\u008a\17\3"+
		"\2\2\2\u008b\u008c\5\60\31\2\u008c\21\3\2\2\2\u008d\u008e\5\60\31\2\u008e"+
		"\23\3\2\2\2\u008f\u0090\5\60\31\2\u0090\25\3\2\2\2\u0091\u0092\5\60\31"+
		"\2\u0092\27\3\2\2\2\u0093\u0094\7\31\2\2\u0094\31\3\2\2\2\u0095\u0096"+
		"\7\30\2\2\u0096\33\3\2\2\2\u0097\u0098\7\26\2\2\u0098\35\3\2\2\2\u0099"+
		"\u009a\7\27\2\2\u009a\37\3\2\2\2\u009b\u009c\5,\27\2\u009c!\3\2\2\2\u009d"+
		"\u009e\7\3\2\2\u009e\u009f\5$\23\2\u009f\u00a0\5(\25\2\u00a0#\3\2\2\2"+
		"\u00a1\u00a6\5&\24\2\u00a2\u00a3\7\4\2\2\u00a3\u00a5\5&\24\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"%\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ae\5\34\17\2\u00aa\u00ae\5\36\20"+
		"\2\u00ab\u00ae\5\32\16\2\u00ac\u00ae\5\30\r\2\u00ad\u00a9\3\2\2\2\u00ad"+
		"\u00aa\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\'\3\2\2\2"+
		"\u00af\u00b0\7\5\2\2\u00b0\u00b2\5\16\b\2\u00b1\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\6\2\2\u00b4\u00b8\5,\27\2\u00b5"+
		"\u00b6\7\5\2\2\u00b6\u00b8\5\16\b\2\u00b7\u00b1\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b8)\3\2\2\2\u00b9\u00d0\5\62\32\2\u00ba\u00d0\5\64\33\2\u00bb"+
		"\u00d0\5\66\34\2\u00bc\u00d0\58\35\2\u00bd\u00d0\5:\36\2\u00be\u00d0\5"+
		"<\37\2\u00bf\u00d0\5> \2\u00c0\u00d0\5@!\2\u00c1\u00d0\5B\"\2\u00c2\u00d0"+
		"\5D#\2\u00c3\u00d0\5F$\2\u00c4\u00d0\5H%\2\u00c5\u00d0\5J&\2\u00c6\u00d0"+
		"\5N(\2\u00c7\u00d0\5P)\2\u00c8\u00d0\5R*\2\u00c9\u00d0\5T+\2\u00ca\u00d0"+
		"\5V,\2\u00cb\u00d0\5X-\2\u00cc\u00d0\5Z.\2\u00cd\u00d0\5L\'\2\u00ce\u00d0"+
		"\5\\/\2\u00cf\u00b9\3\2\2\2\u00cf\u00ba\3\2\2\2\u00cf\u00bb\3\2\2\2\u00cf"+
		"\u00bc\3\2\2\2\u00cf\u00bd\3\2\2\2\u00cf\u00be\3\2\2\2\u00cf\u00bf\3\2"+
		"\2\2\u00cf\u00c0\3\2\2\2\u00cf\u00c1\3\2\2\2\u00cf\u00c2\3\2\2\2\u00cf"+
		"\u00c3\3\2\2\2\u00cf\u00c4\3\2\2\2\u00cf\u00c5\3\2\2\2\u00cf\u00c6\3\2"+
		"\2\2\u00cf\u00c7\3\2\2\2\u00cf\u00c8\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf"+
		"\u00ca\3\2\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00cf\u00ce\3\2\2\2\u00d0+\3\2\2\2\u00d1\u00d2\b\27\1\2\u00d2\u00db"+
		"\5*\26\2\u00d3\u00d4\7\7\2\2\u00d4\u00d5\5,\27\2\u00d5\u00d6\7\b\2\2\u00d6"+
		"\u00db\3\2\2\2\u00d7\u00d8\5\b\5\2\u00d8\u00d9\5,\27\5\u00d9\u00db\3\2"+
		"\2\2\u00da\u00d1\3\2\2\2\u00da\u00d3\3\2\2\2\u00da\u00d7\3\2\2\2\u00db"+
		"\u00e6\3\2\2\2\u00dc\u00dd\f\4\2\2\u00dd\u00de\5\4\3\2\u00de\u00df\5,"+
		"\27\5\u00df\u00e5\3\2\2\2\u00e0\u00e1\f\3\2\2\u00e1\u00e2\5\6\4\2\u00e2"+
		"\u00e3\5,\27\4\u00e3\u00e5\3\2\2\2\u00e4\u00dc\3\2\2\2\u00e4\u00e0\3\2"+
		"\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"-\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ef\5*\26\2\u00ea\u00eb\7\7\2\2"+
		"\u00eb\u00ec\5,\27\2\u00ec\u00ed\7\b\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00e9"+
		"\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ef/\3\2\2\2\u00f0\u00f6\5`\61\2\u00f1"+
		"\u00f2\7\7\2\2\u00f2\u00f3\5^\60\2\u00f3\u00f4\7\b\2\2\u00f4\u00f6\3\2"+
		"\2\2\u00f5\u00f0\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f6\61\3\2\2\2\u00f7\u00f8"+
		"\7\32\2\2\u00f8\u00f9\5\16\b\2\u00f9\63\3\2\2\2\u00fa\u00fc\7\26\2\2\u00fb"+
		"\u00fd\5n8\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2"+
		"\2\u00fe\u00ff\5.\30\2\u00ff\65\3\2\2\2\u0100\u0102\7\33\2\2\u0101\u0103"+
		"\5n8\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\5.\30\2\u0105\67\3\2\2\2\u0106\u0108\7\34\2\2\u0107\u0109\5n8\2"+
		"\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b"+
		"\5.\30\2\u010b9\3\2\2\2\u010c\u010e\7\35\2\2\u010d\u010f\5n8\2\u010e\u010d"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\5.\30\2\u0111"+
		";\3\2\2\2\u0112\u0114\7\36\2\2\u0113\u0115\5n8\2\u0114\u0113\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\5.\30\2\u0117=\3\2\2\2"+
		"\u0118\u011a\7\37\2\2\u0119\u011b\5n8\2\u011a\u0119\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\5\20\t\2\u011d?\3\2\2\2\u011e"+
		"\u0120\7 \2\2\u011f\u0121\5n8\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2"+
		"\2\u0121\u0122\3\2\2\2\u0122\u0123\5\24\13\2\u0123\u0124\7\t\2\2\u0124"+
		"\u0125\5\22\n\2\u0125A\3\2\2\2\u0126\u0128\7!\2\2\u0127\u0129\5n8\2\u0128"+
		"\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\5\22"+
		"\n\2\u012bC\3\2\2\2\u012c\u012e\7\"\2\2\u012d\u012f\5n8\2\u012e\u012d"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012fE\3\2\2\2\u0130\u0132\7#\2\2\u0131\u0133"+
		"\5n8\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\5.\30\2\u0135G\3\2\2\2\u0136\u0138\7\27\2\2\u0137\u0139\5n8\2\u0138"+
		"\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\5."+
		"\30\2\u013bI\3\2\2\2\u013c\u013e\7\31\2\2\u013d\u013f\5n8\2\u013e\u013d"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\5.\30\2\u0141"+
		"K\3\2\2\2\u0142\u0144\7,\2\2\u0143\u0145\5n8\2\u0144\u0143\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\5.\30\2\u0147M\3\2\2\2"+
		"\u0148\u014a\7$\2\2\u0149\u014b\5n8\2\u014a\u0149\3\2\2\2\u014a\u014b"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\5\26\f\2\u014dO\3\2\2\2\u014e"+
		"\u0150\7%\2\2\u014f\u0151\5n8\2\u0150\u014f\3\2\2\2\u0150\u0151\3\2\2"+
		"\2\u0151\u0152\3\2\2\2\u0152\u0153\5.\30\2\u0153Q\3\2\2\2\u0154\u0156"+
		"\7&\2\2\u0155\u0157\5n8\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0159\3\2\2\2\u0158\u015a\5.\30\2\u0159\u0158\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015aS\3\2\2\2\u015b\u015d\7\'\2\2\u015c\u015e\5n8\2\u015d\u015c"+
		"\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0161\5.\30\2\u0160"+
		"\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161U\3\2\2\2\u0162\u0164\7)\2\2\u0163"+
		"\u0165\5n8\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2\2"+
		"\2\u0166\u0167\5\24\13\2\u0167\u0168\7\t\2\2\u0168\u0169\5\22\n\2\u0169"+
		"W\3\2\2\2\u016a\u016c\7*\2\2\u016b\u016d\5n8\2\u016c\u016b\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016dY\3\2\2\2\u016e\u0170\7+\2\2\u016f\u0171\5n8\2\u0170"+
		"\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\5\60"+
		"\31\2\u0173[\3\2\2\2\u0174\u0176\7-\2\2\u0175\u0177\5n8\2\u0176\u0175"+
		"\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\5\60\31\2"+
		"\u0179]\3\2\2\2\u017a\u017b\b\60\1\2\u017b\u0184\5`\61\2\u017c\u017d\7"+
		"\7\2\2\u017d\u017e\5^\60\2\u017e\u017f\7\b\2\2\u017f\u0184\3\2\2\2\u0180"+
		"\u0181\5\b\5\2\u0181\u0182\5^\60\5\u0182\u0184\3\2\2\2\u0183\u017a\3\2"+
		"\2\2\u0183\u017c\3\2\2\2\u0183\u0180\3\2\2\2\u0184\u018f\3\2\2\2\u0185"+
		"\u0186\f\4\2\2\u0186\u0187\5\4\3\2\u0187\u0188\5^\60\5\u0188\u018e\3\2"+
		"\2\2\u0189\u018a\f\3\2\2\u018a\u018b\5\6\4\2\u018b\u018c\5^\60\4\u018c"+
		"\u018e\3\2\2\2\u018d\u0185\3\2\2\2\u018d\u0189\3\2\2\2\u018e\u0191\3\2"+
		"\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190_\3\2\2\2\u0191\u018f"+
		"\3\2\2\2\u0192\u0198\5b\62\2\u0193\u0198\5d\63\2\u0194\u0198\5f\64\2\u0195"+
		"\u0198\5h\65\2\u0196\u0198\5j\66\2\u0197\u0192\3\2\2\2\u0197\u0193\3\2"+
		"\2\2\u0197\u0194\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198"+
		"a\3\2\2\2\u0199\u019a\5\f\7\2\u019ac\3\2\2\2\u019b\u019c\7\22\2\2\u019c"+
		"e\3\2\2\2\u019d\u019e\7\21\2\2\u019eg\3\2\2\2\u019f\u01a0\7\23\2\2\u01a0"+
		"i\3\2\2\2\u01a1\u01a2\7\24\2\2\u01a2k\3\2\2\2\u01a3\u01a7\5p9\2\u01a4"+
		"\u01a7\5r:\2\u01a5\u01a7\5t;\2\u01a6\u01a3\3\2\2\2\u01a6\u01a4\3\2\2\2"+
		"\u01a6\u01a5\3\2\2\2\u01a7m\3\2\2\2\u01a8\u01a9\7\n\2\2\u01a9\u01ae\5"+
		"l\67\2\u01aa\u01ab\7\4\2\2\u01ab\u01ad\5l\67\2\u01ac\u01aa\3\2\2\2\u01ad"+
		"\u01b0\3\2\2\2\u01ae\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b1\3\2"+
		"\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b2\7\13\2\2\u01b2o\3\2\2\2\u01b3\u01b4"+
		"\7(\2\2\u01b4q\3\2\2\2\u01b5\u01b6\7.\2\2\u01b6s\3\2\2\2\u01b7\u01b8\7"+
		"/\2\2\u01b8u\3\2\2\2+x\u0087\u00a6\u00ad\u00b1\u00b7\u00cf\u00da\u00e4"+
		"\u00e6\u00ee\u00f5\u00fc\u0102\u0108\u010e\u0114\u011a\u0120\u0128\u012e"+
		"\u0132\u0138\u013e\u0144\u014a\u0150\u0156\u0159\u015d\u0160\u0164\u016c"+
		"\u0170\u0176\u0183\u018d\u018f\u0197\u01a6\u01ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}