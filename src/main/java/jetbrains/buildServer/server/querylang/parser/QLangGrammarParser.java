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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, OR=8, AND=9, NOT=10, 
		STRING=11, IDENT=12, SUFFIXS=13, PREFIXS=14, SUBSTRINGS=15, WS=16, PROJECT=17, 
		TEMPLATE=18, BUILD_CONFIGURATION=19, VCS_ROOT=20, ID=21, PARENT=22, TRIGGER=23, 
		STEP=24, FEATURE=25, TYPE=26, PARAM=27, VAL=28, ENABLED=29, ANCESTOR=30, 
		ANCESTOR_OR_SELF=31, RULES=32;
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
		RULE_ancestorOrSelfFilter = 35, RULE_templateDepFilter = 36, RULE_vcsRootFilter = 37, 
		RULE_checkoutRulesFilter = 38, RULE_stringCondition = 39, RULE_stringFilter = 40, 
		RULE_stringEqualsFilter = 41, RULE_stringPrefixFilter = 42, RULE_stringSuffixFilter = 43, 
		RULE_stringSubstringFilter = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "and", "or", "not", "filterKeyword", "identOrString", "objectId", 
			"objectType", "parameterValue", "parameterName", "checkoutRulesString", 
			"vcsRootKeyword", "buildConfKeword", "projectKeword", "templateKeyword", 
			"partialQuery", "find", "multipleObjects", "objectKeyword", "conditionInSubproject", 
			"filter", "condition", "filterOrCondition", "stringFilterOrCondition", 
			"idFilter", "projectFilter", "parentFilter", "triggerFilter", "stepFilter", 
			"featureFilter", "typeFilter", "parameterFilter", "parValueFilter", "enabledFilter", 
			"ancestorFilter", "ancestorOrSelfFilter", "templateDepFilter", "vcsRootFilter", 
			"checkoutRulesFilter", "stringCondition", "stringFilter", "stringEqualsFilter", 
			"stringPrefixFilter", "stringSuffixFilter", "stringSubstringFilter"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'find'", "','", "'in'", "'with'", "'('", "')'", "'='", "'or'", 
			"'and'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "OR", "AND", "NOT", "STRING", 
			"IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "WS", "PROJECT", "TEMPLATE", 
			"BUILD_CONFIGURATION", "VCS_ROOT", "ID", "PARENT", "TRIGGER", "STEP", 
			"FEATURE", "TYPE", "PARAM", "VAL", "ENABLED", "ANCESTOR", "ANCESTOR_OR_SELF", 
			"RULES"
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
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(90);
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
			case ANCESTOR_OR_SELF:
			case RULES:
				{
				setState(91);
				partialQuery();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(94);
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
			setState(96);
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
			setState(98);
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
			setState(100);
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
		public TerminalNode ANCESTOR_OR_SELF() { return getToken(QLangGrammarParser.ANCESTOR_OR_SELF, 0); }
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
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROJECT) | (1L << TEMPLATE) | (1L << BUILD_CONFIGURATION) | (1L << VCS_ROOT) | (1L << PARENT) | (1L << TRIGGER) | (1L << STEP) | (1L << FEATURE) | (1L << TYPE) | (1L << PARAM) | (1L << VAL) | (1L << ENABLED) | (1L << ANCESTOR) | (1L << ANCESTOR_OR_SELF))) != 0)) ) {
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
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(IDENT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
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
			case ANCESTOR_OR_SELF:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
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
			setState(109);
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
		public IdentOrStringContext identOrString() {
			return getRuleContext(IdentOrStringContext.class,0);
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
			setState(111);
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
			setState(113);
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
		public IdentOrStringContext identOrString() {
			return getRuleContext(IdentOrStringContext.class,0);
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
			setState(115);
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
			setState(117);
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
			setState(119);
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
			setState(121);
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
			setState(123);
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
			setState(125);
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
			setState(127);
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
			setState(129);
			match(T__0);
			setState(130);
			multipleObjects();
			setState(131);
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
			setState(133);
			objectKeyword();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(134);
				match(T__1);
				setState(135);
				objectKeyword();
				}
				}
				setState(140);
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
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				projectKeword();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				templateKeyword();
				}
				break;
			case BUILD_CONFIGURATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				buildConfKeword();
				}
				break;
			case VCS_ROOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
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
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(147);
					match(T__2);
					setState(148);
					objectId();
					}
				}

				setState(151);
				match(T__3);
				setState(152);
				condition(0);
				}
				break;
			case 2:
				{
				setState(153);
				match(T__2);
				setState(154);
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
		public AncestorOrSelfFilterContext ancestorOrSelfFilter() {
			return getRuleContext(AncestorOrSelfFilterContext.class,0);
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
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				idFilter();
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				projectFilter();
				}
				break;
			case PARENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				parentFilter();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				triggerFilter();
				}
				break;
			case STEP:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				stepFilter();
				}
				break;
			case FEATURE:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				featureFilter();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 7);
				{
				setState(163);
				typeFilter();
				}
				break;
			case PARAM:
				enterOuterAlt(_localctx, 8);
				{
				setState(164);
				parameterFilter();
				}
				break;
			case VAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(165);
				parValueFilter();
				}
				break;
			case ENABLED:
				enterOuterAlt(_localctx, 10);
				{
				setState(166);
				enabledFilter();
				}
				break;
			case ANCESTOR:
				enterOuterAlt(_localctx, 11);
				{
				setState(167);
				ancestorFilter();
				}
				break;
			case ANCESTOR_OR_SELF:
				enterOuterAlt(_localctx, 12);
				{
				setState(168);
				ancestorOrSelfFilter();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 13);
				{
				setState(169);
				templateDepFilter();
				}
				break;
			case VCS_ROOT:
				enterOuterAlt(_localctx, 14);
				{
				setState(170);
				vcsRootFilter();
				}
				break;
			case RULES:
				enterOuterAlt(_localctx, 15);
				{
				setState(171);
				checkoutRulesFilter();
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
			setState(183);
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
			case ANCESTOR_OR_SELF:
			case RULES:
				{
				_localctx = new ConditionFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(175);
				filter();
				}
				break;
			case T__4:
				{
				_localctx = new ConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(T__4);
				setState(177);
				condition(0);
				setState(178);
				match(T__5);
				}
				break;
			case NOT:
				{
				_localctx = new ConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				not();
				setState(181);
				condition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(193);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionAndContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(185);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(186);
						and();
						setState(187);
						condition(3);
						}
						break;
					case 2:
						{
						_localctx = new ConditionOrContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(189);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(190);
						or();
						setState(191);
						condition(2);
						}
						break;
					}
					} 
				}
				setState(197);
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
			setState(203);
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
			case ANCESTOR_OR_SELF:
			case RULES:
				_localctx = new SingleFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				filter();
				}
				break;
			case T__4:
				_localctx = new MultFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(T__4);
				setState(200);
				condition(0);
				setState(201);
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
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
			case SUFFIXS:
			case PREFIXS:
			case SUBSTRINGS:
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
			case ANCESTOR_OR_SELF:
				_localctx = new SingleStringFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				stringFilter();
				}
				break;
			case T__4:
				_localctx = new MultipleStringFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(T__4);
				setState(207);
				stringCondition(0);
				setState(208);
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
			setState(212);
			match(ID);
			setState(213);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(PROJECT);
			setState(216);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(PARENT);
			setState(219);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(TRIGGER);
			setState(222);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(STEP);
			setState(225);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(FEATURE);
			setState(228);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(TYPE);
			setState(231);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(PARAM);
			setState(234);
			parameterName();
			setState(235);
			match(T__6);
			setState(236);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(VAL);
			setState(239);
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
			setState(241);
			match(ENABLED);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(ANCESTOR);
			setState(244);
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

	public static class AncestorOrSelfFilterContext extends ParserRuleContext {
		public TerminalNode ANCESTOR_OR_SELF() { return getToken(QLangGrammarParser.ANCESTOR_OR_SELF, 0); }
		public FilterOrConditionContext filterOrCondition() {
			return getRuleContext(FilterOrConditionContext.class,0);
		}
		public AncestorOrSelfFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ancestorOrSelfFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterAncestorOrSelfFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitAncestorOrSelfFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitAncestorOrSelfFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AncestorOrSelfFilterContext ancestorOrSelfFilter() throws RecognitionException {
		AncestorOrSelfFilterContext _localctx = new AncestorOrSelfFilterContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ancestorOrSelfFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(ANCESTOR_OR_SELF);
			setState(247);
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
		enterRule(_localctx, 72, RULE_templateDepFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(TEMPLATE);
			setState(250);
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
		enterRule(_localctx, 74, RULE_vcsRootFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(VCS_ROOT);
			setState(253);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(RULES);
			setState(256);
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
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_stringCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
			case SUFFIXS:
			case PREFIXS:
			case SUBSTRINGS:
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
			case ANCESTOR_OR_SELF:
				{
				_localctx = new StringConditionFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(259);
				stringFilter();
				}
				break;
			case T__4:
				{
				_localctx = new StringConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				match(T__4);
				setState(261);
				stringCondition(0);
				setState(262);
				match(T__5);
				}
				break;
			case NOT:
				{
				_localctx = new StringConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				not();
				setState(265);
				stringCondition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new StringConditionAndContext(new StringConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stringCondition);
						setState(269);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(270);
						and();
						setState(271);
						stringCondition(3);
						}
						break;
					case 2:
						{
						_localctx = new StringConditionOrContext(new StringConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stringCondition);
						setState(273);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(274);
						or();
						setState(275);
						stringCondition(2);
						}
						break;
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 80, RULE_stringFilter);
		try {
			setState(286);
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
			case ANCESTOR_OR_SELF:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				stringEqualsFilter();
				}
				break;
			case PREFIXS:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				stringPrefixFilter();
				}
				break;
			case SUFFIXS:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				stringSuffixFilter();
				}
				break;
			case SUBSTRINGS:
				enterOuterAlt(_localctx, 4);
				{
				setState(285);
				stringSubstringFilter();
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
		enterRule(_localctx, 82, RULE_stringEqualsFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
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
		enterRule(_localctx, 84, RULE_stringPrefixFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
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
		enterRule(_localctx, 86, RULE_stringSuffixFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
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
		enterRule(_localctx, 88, RULE_stringSubstringFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 39:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u012b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\5\2_\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\7\5\7n\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\7\23\u008b\n\23\f\23\16\23\u008e\13\23\3\24\3\24\3\24\3\24"+
		"\5\24\u0094\n\24\3\25\3\25\5\25\u0098\n\25\3\25\3\25\3\25\3\25\5\25\u009e"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u00af\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00ba\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00c4\n"+
		"\27\f\27\16\27\u00c7\13\27\3\30\3\30\3\30\3\30\3\30\5\30\u00ce\n\30\3"+
		"\31\3\31\3\31\3\31\3\31\5\31\u00d5\n\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3"+
		"\'\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u010e\n)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\7)\u0118\n)\f)\16)\u011b\13)\3*\3*\3*\3*\5*\u0121\n*\3+\3+\3,\3,"+
		"\3-\3-\3.\3.\3.\2\4,P/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:<>@BDFHJLNPRTVXZ\2\3\4\2\23\26\30!\2\u0121\2^\3\2\2\2\4"+
		"b\3\2\2\2\6d\3\2\2\2\bf\3\2\2\2\nh\3\2\2\2\fm\3\2\2\2\16o\3\2\2\2\20q"+
		"\3\2\2\2\22s\3\2\2\2\24u\3\2\2\2\26w\3\2\2\2\30y\3\2\2\2\32{\3\2\2\2\34"+
		"}\3\2\2\2\36\177\3\2\2\2 \u0081\3\2\2\2\"\u0083\3\2\2\2$\u0087\3\2\2\2"+
		"&\u0093\3\2\2\2(\u009d\3\2\2\2*\u00ae\3\2\2\2,\u00b9\3\2\2\2.\u00cd\3"+
		"\2\2\2\60\u00d4\3\2\2\2\62\u00d6\3\2\2\2\64\u00d9\3\2\2\2\66\u00dc\3\2"+
		"\2\28\u00df\3\2\2\2:\u00e2\3\2\2\2<\u00e5\3\2\2\2>\u00e8\3\2\2\2@\u00eb"+
		"\3\2\2\2B\u00f0\3\2\2\2D\u00f3\3\2\2\2F\u00f5\3\2\2\2H\u00f8\3\2\2\2J"+
		"\u00fb\3\2\2\2L\u00fe\3\2\2\2N\u0101\3\2\2\2P\u010d\3\2\2\2R\u0120\3\2"+
		"\2\2T\u0122\3\2\2\2V\u0124\3\2\2\2X\u0126\3\2\2\2Z\u0128\3\2\2\2\\_\5"+
		"\"\22\2]_\5 \21\2^\\\3\2\2\2^]\3\2\2\2_`\3\2\2\2`a\7\2\2\3a\3\3\2\2\2"+
		"bc\7\13\2\2c\5\3\2\2\2de\7\n\2\2e\7\3\2\2\2fg\7\f\2\2g\t\3\2\2\2hi\t\2"+
		"\2\2i\13\3\2\2\2jn\7\16\2\2kn\7\r\2\2ln\5\n\6\2mj\3\2\2\2mk\3\2\2\2ml"+
		"\3\2\2\2n\r\3\2\2\2op\5\60\31\2p\17\3\2\2\2qr\5\f\7\2r\21\3\2\2\2st\5"+
		"\60\31\2t\23\3\2\2\2uv\5\f\7\2v\25\3\2\2\2wx\5\60\31\2x\27\3\2\2\2yz\7"+
		"\26\2\2z\31\3\2\2\2{|\7\25\2\2|\33\3\2\2\2}~\7\23\2\2~\35\3\2\2\2\177"+
		"\u0080\7\24\2\2\u0080\37\3\2\2\2\u0081\u0082\5,\27\2\u0082!\3\2\2\2\u0083"+
		"\u0084\7\3\2\2\u0084\u0085\5$\23\2\u0085\u0086\5(\25\2\u0086#\3\2\2\2"+
		"\u0087\u008c\5&\24\2\u0088\u0089\7\4\2\2\u0089\u008b\5&\24\2\u008a\u0088"+
		"\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"%\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0094\5\34\17\2\u0090\u0094\5\36\20"+
		"\2\u0091\u0094\5\32\16\2\u0092\u0094\5\30\r\2\u0093\u008f\3\2\2\2\u0093"+
		"\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094\'\3\2\2\2"+
		"\u0095\u0096\7\5\2\2\u0096\u0098\5\16\b\2\u0097\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\6\2\2\u009a\u009e\5,\27\2\u009b"+
		"\u009c\7\5\2\2\u009c\u009e\5\16\b\2\u009d\u0097\3\2\2\2\u009d\u009b\3"+
		"\2\2\2\u009e)\3\2\2\2\u009f\u00af\5\62\32\2\u00a0\u00af\5\64\33\2\u00a1"+
		"\u00af\5\66\34\2\u00a2\u00af\58\35\2\u00a3\u00af\5:\36\2\u00a4\u00af\5"+
		"<\37\2\u00a5\u00af\5> \2\u00a6\u00af\5@!\2\u00a7\u00af\5B\"\2\u00a8\u00af"+
		"\5D#\2\u00a9\u00af\5F$\2\u00aa\u00af\5H%\2\u00ab\u00af\5J&\2\u00ac\u00af"+
		"\5L\'\2\u00ad\u00af\5N(\2\u00ae\u009f\3\2\2\2\u00ae\u00a0\3\2\2\2\u00ae"+
		"\u00a1\3\2\2\2\u00ae\u00a2\3\2\2\2\u00ae\u00a3\3\2\2\2\u00ae\u00a4\3\2"+
		"\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00a7\3\2\2\2\u00ae"+
		"\u00a8\3\2\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af+\3\2\2\2\u00b0\u00b1"+
		"\b\27\1\2\u00b1\u00ba\5*\26\2\u00b2\u00b3\7\7\2\2\u00b3\u00b4\5,\27\2"+
		"\u00b4\u00b5\7\b\2\2\u00b5\u00ba\3\2\2\2\u00b6\u00b7\5\b\5\2\u00b7\u00b8"+
		"\5,\27\5\u00b8\u00ba\3\2\2\2\u00b9\u00b0\3\2\2\2\u00b9\u00b2\3\2\2\2\u00b9"+
		"\u00b6\3\2\2\2\u00ba\u00c5\3\2\2\2\u00bb\u00bc\f\4\2\2\u00bc\u00bd\5\4"+
		"\3\2\u00bd\u00be\5,\27\5\u00be\u00c4\3\2\2\2\u00bf\u00c0\f\3\2\2\u00c0"+
		"\u00c1\5\6\4\2\u00c1\u00c2\5,\27\4\u00c2\u00c4\3\2\2\2\u00c3\u00bb\3\2"+
		"\2\2\u00c3\u00bf\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6-\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ce\5*\26\2"+
		"\u00c9\u00ca\7\7\2\2\u00ca\u00cb\5,\27\2\u00cb\u00cc\7\b\2\2\u00cc\u00ce"+
		"\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00ce/\3\2\2\2\u00cf"+
		"\u00d5\5R*\2\u00d0\u00d1\7\7\2\2\u00d1\u00d2\5P)\2\u00d2\u00d3\7\b\2\2"+
		"\u00d3\u00d5\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d5\61"+
		"\3\2\2\2\u00d6\u00d7\7\27\2\2\u00d7\u00d8\5\16\b\2\u00d8\63\3\2\2\2\u00d9"+
		"\u00da\7\23\2\2\u00da\u00db\5.\30\2\u00db\65\3\2\2\2\u00dc\u00dd\7\30"+
		"\2\2\u00dd\u00de\5.\30\2\u00de\67\3\2\2\2\u00df\u00e0\7\31\2\2\u00e0\u00e1"+
		"\5.\30\2\u00e19\3\2\2\2\u00e2\u00e3\7\32\2\2\u00e3\u00e4\5.\30\2\u00e4"+
		";\3\2\2\2\u00e5\u00e6\7\33\2\2\u00e6\u00e7\5.\30\2\u00e7=\3\2\2\2\u00e8"+
		"\u00e9\7\34\2\2\u00e9\u00ea\5\20\t\2\u00ea?\3\2\2\2\u00eb\u00ec\7\35\2"+
		"\2\u00ec\u00ed\5\24\13\2\u00ed\u00ee\7\t\2\2\u00ee\u00ef\5\22\n\2\u00ef"+
		"A\3\2\2\2\u00f0\u00f1\7\36\2\2\u00f1\u00f2\5\22\n\2\u00f2C\3\2\2\2\u00f3"+
		"\u00f4\7\37\2\2\u00f4E\3\2\2\2\u00f5\u00f6\7 \2\2\u00f6\u00f7\5.\30\2"+
		"\u00f7G\3\2\2\2\u00f8\u00f9\7!\2\2\u00f9\u00fa\5.\30\2\u00faI\3\2\2\2"+
		"\u00fb\u00fc\7\24\2\2\u00fc\u00fd\5.\30\2\u00fdK\3\2\2\2\u00fe\u00ff\7"+
		"\26\2\2\u00ff\u0100\5.\30\2\u0100M\3\2\2\2\u0101\u0102\7\"\2\2\u0102\u0103"+
		"\5\26\f\2\u0103O\3\2\2\2\u0104\u0105\b)\1\2\u0105\u010e\5R*\2\u0106\u0107"+
		"\7\7\2\2\u0107\u0108\5P)\2\u0108\u0109\7\b\2\2\u0109\u010e\3\2\2\2\u010a"+
		"\u010b\5\b\5\2\u010b\u010c\5P)\5\u010c\u010e\3\2\2\2\u010d\u0104\3\2\2"+
		"\2\u010d\u0106\3\2\2\2\u010d\u010a\3\2\2\2\u010e\u0119\3\2\2\2\u010f\u0110"+
		"\f\4\2\2\u0110\u0111\5\4\3\2\u0111\u0112\5P)\5\u0112\u0118\3\2\2\2\u0113"+
		"\u0114\f\3\2\2\u0114\u0115\5\6\4\2\u0115\u0116\5P)\4\u0116\u0118\3\2\2"+
		"\2\u0117\u010f\3\2\2\2\u0117\u0113\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011aQ\3\2\2\2\u011b\u0119\3\2\2\2\u011c"+
		"\u0121\5T+\2\u011d\u0121\5V,\2\u011e\u0121\5X-\2\u011f\u0121\5Z.\2\u0120"+
		"\u011c\3\2\2\2\u0120\u011d\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u011f\3\2"+
		"\2\2\u0121S\3\2\2\2\u0122\u0123\5\f\7\2\u0123U\3\2\2\2\u0124\u0125\7\20"+
		"\2\2\u0125W\3\2\2\2\u0126\u0127\7\17\2\2\u0127Y\3\2\2\2\u0128\u0129\7"+
		"\21\2\2\u0129[\3\2\2\2\22^m\u008c\u0093\u0097\u009d\u00ae\u00b9\u00c3"+
		"\u00c5\u00cd\u00d4\u010d\u0117\u0119\u0120";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}