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
		ANCESTOR_OR_SELF=31;
	public static final int
		RULE_start = 0, RULE_and = 1, RULE_or = 2, RULE_not = 3, RULE_identOrString = 4, 
		RULE_objectId = 5, RULE_objectType = 6, RULE_parameterValue = 7, RULE_parameterName = 8, 
		RULE_vcsRootKeyword = 9, RULE_buildConfKeword = 10, RULE_projectKeword = 11, 
		RULE_templateKeyword = 12, RULE_partialQuery = 13, RULE_find = 14, RULE_multipleObjects = 15, 
		RULE_objectKeyword = 16, RULE_conditionInSubproject = 17, RULE_filter = 18, 
		RULE_condition = 19, RULE_filterOrCondition = 20, RULE_stringFilterOrCondition = 21, 
		RULE_idFilter = 22, RULE_projectFilter = 23, RULE_parentFilter = 24, RULE_triggerFilter = 25, 
		RULE_stepFilter = 26, RULE_featureFilter = 27, RULE_typeFilter = 28, RULE_parameterFilter = 29, 
		RULE_parValueFilter = 30, RULE_enabledFilter = 31, RULE_ancestorFilter = 32, 
		RULE_ancestorOrSelfFilter = 33, RULE_templateDepFilter = 34, RULE_stringCondition = 35, 
		RULE_stringFilter = 36, RULE_stringEqualsFilter = 37, RULE_stringPrefixFilter = 38, 
		RULE_stringSuffixFilter = 39, RULE_stringSubstringFilter = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "and", "or", "not", "identOrString", "objectId", "objectType", 
			"parameterValue", "parameterName", "vcsRootKeyword", "buildConfKeword", 
			"projectKeword", "templateKeyword", "partialQuery", "find", "multipleObjects", 
			"objectKeyword", "conditionInSubproject", "filter", "condition", "filterOrCondition", 
			"stringFilterOrCondition", "idFilter", "projectFilter", "parentFilter", 
			"triggerFilter", "stepFilter", "featureFilter", "typeFilter", "parameterFilter", 
			"parValueFilter", "enabledFilter", "ancestorFilter", "ancestorOrSelfFilter", 
			"templateDepFilter", "stringCondition", "stringFilter", "stringEqualsFilter", 
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
			"FEATURE", "TYPE", "PARAM", "VAL", "ENABLED", "ANCESTOR", "ANCESTOR_OR_SELF"
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
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(82);
				find();
				}
				break;
			case T__4:
			case NOT:
			case PROJECT:
			case TEMPLATE:
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
				{
				setState(83);
				partialQuery();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(86);
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
			setState(88);
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
			setState(90);
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
			setState(92);
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

	public static class IdentOrStringContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(QLangGrammarParser.IDENT, 0); }
		public TerminalNode STRING() { return getToken(QLangGrammarParser.STRING, 0); }
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
		enterRule(_localctx, 8, RULE_identOrString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==IDENT) ) {
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
		enterRule(_localctx, 10, RULE_objectId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
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
		enterRule(_localctx, 12, RULE_objectType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
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
		enterRule(_localctx, 14, RULE_parameterValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
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
		enterRule(_localctx, 16, RULE_parameterName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
		enterRule(_localctx, 18, RULE_vcsRootKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
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
		enterRule(_localctx, 20, RULE_buildConfKeword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
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
		enterRule(_localctx, 22, RULE_projectKeword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
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
		enterRule(_localctx, 24, RULE_templateKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
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
		enterRule(_localctx, 26, RULE_partialQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
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
		enterRule(_localctx, 28, RULE_find);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__0);
			setState(115);
			multipleObjects();
			setState(116);
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
		enterRule(_localctx, 30, RULE_multipleObjects);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			objectKeyword();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(119);
				match(T__1);
				setState(120);
				objectKeyword();
				}
				}
				setState(125);
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
		enterRule(_localctx, 32, RULE_objectKeyword);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				projectKeword();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				templateKeyword();
				}
				break;
			case BUILD_CONFIGURATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				buildConfKeword();
				}
				break;
			case VCS_ROOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
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
		enterRule(_localctx, 34, RULE_conditionInSubproject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(132);
					match(T__2);
					setState(133);
					objectId();
					}
				}

				setState(136);
				match(T__3);
				setState(137);
				condition(0);
				}
				break;
			case 2:
				{
				setState(138);
				match(T__2);
				setState(139);
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
		enterRule(_localctx, 36, RULE_filter);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				idFilter();
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				projectFilter();
				}
				break;
			case PARENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				parentFilter();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				triggerFilter();
				}
				break;
			case STEP:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				stepFilter();
				}
				break;
			case FEATURE:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				featureFilter();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 7);
				{
				setState(148);
				typeFilter();
				}
				break;
			case PARAM:
				enterOuterAlt(_localctx, 8);
				{
				setState(149);
				parameterFilter();
				}
				break;
			case VAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(150);
				parValueFilter();
				}
				break;
			case ENABLED:
				enterOuterAlt(_localctx, 10);
				{
				setState(151);
				enabledFilter();
				}
				break;
			case ANCESTOR:
				enterOuterAlt(_localctx, 11);
				{
				setState(152);
				ancestorFilter();
				}
				break;
			case ANCESTOR_OR_SELF:
				enterOuterAlt(_localctx, 12);
				{
				setState(153);
				ancestorOrSelfFilter();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 13);
				{
				setState(154);
				templateDepFilter();
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
			case TEMPLATE:
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
				{
				_localctx = new ConditionFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(158);
				filter();
				}
				break;
			case T__4:
				{
				_localctx = new ConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(T__4);
				setState(160);
				condition(0);
				setState(161);
				match(T__5);
				}
				break;
			case NOT:
				{
				_localctx = new ConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				not();
				setState(164);
				condition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionAndContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(168);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(169);
						and();
						setState(170);
						condition(3);
						}
						break;
					case 2:
						{
						_localctx = new ConditionOrContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(172);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(173);
						or();
						setState(174);
						condition(2);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 40, RULE_filterOrCondition);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
			case TEMPLATE:
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
				_localctx = new SingleFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				filter();
				}
				break;
			case T__4:
				_localctx = new MultFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(T__4);
				setState(183);
				condition(0);
				setState(184);
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
		enterRule(_localctx, 42, RULE_stringFilterOrCondition);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
			case SUFFIXS:
			case PREFIXS:
			case SUBSTRINGS:
				_localctx = new SingleStringFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				stringFilter();
				}
				break;
			case T__4:
				_localctx = new MultipleStringFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(T__4);
				setState(190);
				stringCondition(0);
				setState(191);
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
		enterRule(_localctx, 44, RULE_idFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(ID);
			setState(196);
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
		enterRule(_localctx, 46, RULE_projectFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(PROJECT);
			setState(199);
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
		enterRule(_localctx, 48, RULE_parentFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(PARENT);
			setState(202);
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
		enterRule(_localctx, 50, RULE_triggerFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(TRIGGER);
			setState(205);
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
		enterRule(_localctx, 52, RULE_stepFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(STEP);
			setState(208);
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
		enterRule(_localctx, 54, RULE_featureFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(FEATURE);
			setState(211);
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
		enterRule(_localctx, 56, RULE_typeFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(TYPE);
			setState(214);
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
		enterRule(_localctx, 58, RULE_parameterFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(PARAM);
			setState(217);
			parameterName();
			setState(218);
			match(T__6);
			setState(219);
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
		enterRule(_localctx, 60, RULE_parValueFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(VAL);
			setState(222);
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
		enterRule(_localctx, 62, RULE_enabledFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
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
		enterRule(_localctx, 64, RULE_ancestorFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(ANCESTOR);
			setState(227);
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
		enterRule(_localctx, 66, RULE_ancestorOrSelfFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(ANCESTOR_OR_SELF);
			setState(230);
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
		enterRule(_localctx, 68, RULE_templateDepFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(TEMPLATE);
			setState(233);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_stringCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
			case SUFFIXS:
			case PREFIXS:
			case SUBSTRINGS:
				{
				_localctx = new StringConditionFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(236);
				stringFilter();
				}
				break;
			case T__4:
				{
				_localctx = new StringConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(T__4);
				setState(238);
				stringCondition(0);
				setState(239);
				match(T__5);
				}
				break;
			case NOT:
				{
				_localctx = new StringConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				not();
				setState(242);
				stringCondition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new StringConditionAndContext(new StringConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stringCondition);
						setState(246);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(247);
						and();
						setState(248);
						stringCondition(3);
						}
						break;
					case 2:
						{
						_localctx = new StringConditionOrContext(new StringConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stringCondition);
						setState(250);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(251);
						or();
						setState(252);
						stringCondition(2);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 72, RULE_stringFilter);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				stringEqualsFilter();
				}
				break;
			case PREFIXS:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				stringPrefixFilter();
				}
				break;
			case SUFFIXS:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				stringSuffixFilter();
				}
				break;
			case SUBSTRINGS:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
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
		enterRule(_localctx, 74, RULE_stringEqualsFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
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
		enterRule(_localctx, 76, RULE_stringPrefixFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
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
		enterRule(_localctx, 78, RULE_stringSuffixFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
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
		enterRule(_localctx, 80, RULE_stringSubstringFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
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
		case 19:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 35:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\5\2W\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\7\21|\n\21\f\21\16\21\177\13\21\3\22\3\22\3\22"+
		"\3\22\5\22\u0085\n\22\3\23\3\23\5\23\u0089\n\23\3\23\3\23\3\23\3\23\5"+
		"\23\u008f\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u009e\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00a9\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00b3\n"+
		"\25\f\25\16\25\u00b6\13\25\3\26\3\26\3\26\3\26\3\26\5\26\u00bd\n\26\3"+
		"\27\3\27\3\27\3\27\3\27\5\27\u00c4\n\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$"+
		"\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u00f7\n%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\7%\u0101\n%\f%\16%\u0104\13%\3&\3&\3&\3&\5&\u010a\n&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3*\2\4(H+\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPR\2\3\3\2\r\16\2\u010a\2V\3\2\2\2\4Z\3\2\2\2\6\\"+
		"\3\2\2\2\b^\3\2\2\2\n`\3\2\2\2\fb\3\2\2\2\16d\3\2\2\2\20f\3\2\2\2\22h"+
		"\3\2\2\2\24j\3\2\2\2\26l\3\2\2\2\30n\3\2\2\2\32p\3\2\2\2\34r\3\2\2\2\36"+
		"t\3\2\2\2 x\3\2\2\2\"\u0084\3\2\2\2$\u008e\3\2\2\2&\u009d\3\2\2\2(\u00a8"+
		"\3\2\2\2*\u00bc\3\2\2\2,\u00c3\3\2\2\2.\u00c5\3\2\2\2\60\u00c8\3\2\2\2"+
		"\62\u00cb\3\2\2\2\64\u00ce\3\2\2\2\66\u00d1\3\2\2\28\u00d4\3\2\2\2:\u00d7"+
		"\3\2\2\2<\u00da\3\2\2\2>\u00df\3\2\2\2@\u00e2\3\2\2\2B\u00e4\3\2\2\2D"+
		"\u00e7\3\2\2\2F\u00ea\3\2\2\2H\u00f6\3\2\2\2J\u0109\3\2\2\2L\u010b\3\2"+
		"\2\2N\u010d\3\2\2\2P\u010f\3\2\2\2R\u0111\3\2\2\2TW\5\36\20\2UW\5\34\17"+
		"\2VT\3\2\2\2VU\3\2\2\2WX\3\2\2\2XY\7\2\2\3Y\3\3\2\2\2Z[\7\13\2\2[\5\3"+
		"\2\2\2\\]\7\n\2\2]\7\3\2\2\2^_\7\f\2\2_\t\3\2\2\2`a\t\2\2\2a\13\3\2\2"+
		"\2bc\5,\27\2c\r\3\2\2\2de\5\n\6\2e\17\3\2\2\2fg\5,\27\2g\21\3\2\2\2hi"+
		"\5\n\6\2i\23\3\2\2\2jk\7\26\2\2k\25\3\2\2\2lm\7\25\2\2m\27\3\2\2\2no\7"+
		"\23\2\2o\31\3\2\2\2pq\7\24\2\2q\33\3\2\2\2rs\5(\25\2s\35\3\2\2\2tu\7\3"+
		"\2\2uv\5 \21\2vw\5$\23\2w\37\3\2\2\2x}\5\"\22\2yz\7\4\2\2z|\5\"\22\2{"+
		"y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~!\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0085\5\30\r\2\u0081\u0085\5\32\16\2\u0082\u0085\5\26\f\2\u0083\u0085"+
		"\5\24\13\2\u0084\u0080\3\2\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2"+
		"\u0084\u0083\3\2\2\2\u0085#\3\2\2\2\u0086\u0087\7\5\2\2\u0087\u0089\5"+
		"\f\7\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\7\6\2\2\u008b\u008f\5(\25\2\u008c\u008d\7\5\2\2\u008d\u008f\5\f"+
		"\7\2\u008e\u0088\3\2\2\2\u008e\u008c\3\2\2\2\u008f%\3\2\2\2\u0090\u009e"+
		"\5.\30\2\u0091\u009e\5\60\31\2\u0092\u009e\5\62\32\2\u0093\u009e\5\64"+
		"\33\2\u0094\u009e\5\66\34\2\u0095\u009e\58\35\2\u0096\u009e\5:\36\2\u0097"+
		"\u009e\5<\37\2\u0098\u009e\5> \2\u0099\u009e\5@!\2\u009a\u009e\5B\"\2"+
		"\u009b\u009e\5D#\2\u009c\u009e\5F$\2\u009d\u0090\3\2\2\2\u009d\u0091\3"+
		"\2\2\2\u009d\u0092\3\2\2\2\u009d\u0093\3\2\2\2\u009d\u0094\3\2\2\2\u009d"+
		"\u0095\3\2\2\2\u009d\u0096\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u0098\3\2"+
		"\2\2\u009d\u0099\3\2\2\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\'\3\2\2\2\u009f\u00a0\b\25\1\2\u00a0\u00a9\5&\24"+
		"\2\u00a1\u00a2\7\7\2\2\u00a2\u00a3\5(\25\2\u00a3\u00a4\7\b\2\2\u00a4\u00a9"+
		"\3\2\2\2\u00a5\u00a6\5\b\5\2\u00a6\u00a7\5(\25\5\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u009f\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a9\u00b4\3\2"+
		"\2\2\u00aa\u00ab\f\4\2\2\u00ab\u00ac\5\4\3\2\u00ac\u00ad\5(\25\5\u00ad"+
		"\u00b3\3\2\2\2\u00ae\u00af\f\3\2\2\u00af\u00b0\5\6\4\2\u00b0\u00b1\5("+
		"\25\4\u00b1\u00b3\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5)\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b7\u00bd\5&\24\2\u00b8\u00b9\7\7\2\2\u00b9\u00ba"+
		"\5(\25\2\u00ba\u00bb\7\b\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc"+
		"\u00b8\3\2\2\2\u00bd+\3\2\2\2\u00be\u00c4\5J&\2\u00bf\u00c0\7\7\2\2\u00c0"+
		"\u00c1\5H%\2\u00c1\u00c2\7\b\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00be\3\2\2"+
		"\2\u00c3\u00bf\3\2\2\2\u00c4-\3\2\2\2\u00c5\u00c6\7\27\2\2\u00c6\u00c7"+
		"\5\f\7\2\u00c7/\3\2\2\2\u00c8\u00c9\7\23\2\2\u00c9\u00ca\5*\26\2\u00ca"+
		"\61\3\2\2\2\u00cb\u00cc\7\30\2\2\u00cc\u00cd\5*\26\2\u00cd\63\3\2\2\2"+
		"\u00ce\u00cf\7\31\2\2\u00cf\u00d0\5*\26\2\u00d0\65\3\2\2\2\u00d1\u00d2"+
		"\7\32\2\2\u00d2\u00d3\5*\26\2\u00d3\67\3\2\2\2\u00d4\u00d5\7\33\2\2\u00d5"+
		"\u00d6\5*\26\2\u00d69\3\2\2\2\u00d7\u00d8\7\34\2\2\u00d8\u00d9\5\16\b"+
		"\2\u00d9;\3\2\2\2\u00da\u00db\7\35\2\2\u00db\u00dc\5\22\n\2\u00dc\u00dd"+
		"\7\t\2\2\u00dd\u00de\5\20\t\2\u00de=\3\2\2\2\u00df\u00e0\7\36\2\2\u00e0"+
		"\u00e1\5\20\t\2\u00e1?\3\2\2\2\u00e2\u00e3\7\37\2\2\u00e3A\3\2\2\2\u00e4"+
		"\u00e5\7 \2\2\u00e5\u00e6\5*\26\2\u00e6C\3\2\2\2\u00e7\u00e8\7!\2\2\u00e8"+
		"\u00e9\5*\26\2\u00e9E\3\2\2\2\u00ea\u00eb\7\24\2\2\u00eb\u00ec\5*\26\2"+
		"\u00ecG\3\2\2\2\u00ed\u00ee\b%\1\2\u00ee\u00f7\5J&\2\u00ef\u00f0\7\7\2"+
		"\2\u00f0\u00f1\5H%\2\u00f1\u00f2\7\b\2\2\u00f2\u00f7\3\2\2\2\u00f3\u00f4"+
		"\5\b\5\2\u00f4\u00f5\5H%\5\u00f5\u00f7\3\2\2\2\u00f6\u00ed\3\2\2\2\u00f6"+
		"\u00ef\3\2\2\2\u00f6\u00f3\3\2\2\2\u00f7\u0102\3\2\2\2\u00f8\u00f9\f\4"+
		"\2\2\u00f9\u00fa\5\4\3\2\u00fa\u00fb\5H%\5\u00fb\u0101\3\2\2\2\u00fc\u00fd"+
		"\f\3\2\2\u00fd\u00fe\5\6\4\2\u00fe\u00ff\5H%\4\u00ff\u0101\3\2\2\2\u0100"+
		"\u00f8\3\2\2\2\u0100\u00fc\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103I\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u010a"+
		"\5L\'\2\u0106\u010a\5N(\2\u0107\u010a\5P)\2\u0108\u010a\5R*\2\u0109\u0105"+
		"\3\2\2\2\u0109\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a"+
		"K\3\2\2\2\u010b\u010c\5\n\6\2\u010cM\3\2\2\2\u010d\u010e\7\20\2\2\u010e"+
		"O\3\2\2\2\u010f\u0110\7\17\2\2\u0110Q\3\2\2\2\u0111\u0112\7\21\2\2\u0112"+
		"S\3\2\2\2\21V}\u0084\u0088\u008e\u009d\u00a8\u00b2\u00b4\u00bc\u00c3\u00f6"+
		"\u0100\u0102\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}