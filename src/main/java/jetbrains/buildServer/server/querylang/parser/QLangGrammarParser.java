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
		STRING=11, IDENT=12, WS=13, PROJECT=14, TEMPLATE=15, BUILD_CONFIGURATION=16, 
		VCS_ROOT=17, ID=18, PARENT=19, TRIGGER=20, STEP=21, FEATURE=22, TYPE=23, 
		PARAM=24, VAL=25, ENABLED=26, ANCESTOR=27, ANCESTOR_OR_SELF=28;
	public static final int
		RULE_start = 0, RULE_and = 1, RULE_or = 2, RULE_not = 3, RULE_objectId = 4, 
		RULE_objectType = 5, RULE_parameterValue = 6, RULE_vcsRootKeyword = 7, 
		RULE_buildConfKeword = 8, RULE_projectKeword = 9, RULE_templateKeyword = 10, 
		RULE_partialQuery = 11, RULE_find = 12, RULE_multipleObjects = 13, RULE_objectKeyword = 14, 
		RULE_conditionInSubproject = 15, RULE_filter = 16, RULE_condition = 17, 
		RULE_filterOrCondition = 18, RULE_idFilter = 19, RULE_projectFilter = 20, 
		RULE_parentFilter = 21, RULE_triggerFilter = 22, RULE_stepFilter = 23, 
		RULE_featureFilter = 24, RULE_typeFilter = 25, RULE_parameterFilter = 26, 
		RULE_parValueFilter = 27, RULE_enabledFilter = 28, RULE_ancestorFilter = 29, 
		RULE_ancestorOrSelfFilter = 30, RULE_templateDepFilter = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "and", "or", "not", "objectId", "objectType", "parameterValue", 
			"vcsRootKeyword", "buildConfKeword", "projectKeword", "templateKeyword", 
			"partialQuery", "find", "multipleObjects", "objectKeyword", "conditionInSubproject", 
			"filter", "condition", "filterOrCondition", "idFilter", "projectFilter", 
			"parentFilter", "triggerFilter", "stepFilter", "featureFilter", "typeFilter", 
			"parameterFilter", "parValueFilter", "enabledFilter", "ancestorFilter", 
			"ancestorOrSelfFilter", "templateDepFilter"
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
			"IDENT", "WS", "PROJECT", "TEMPLATE", "BUILD_CONFIGURATION", "VCS_ROOT", 
			"ID", "PARENT", "TRIGGER", "STEP", "FEATURE", "TYPE", "PARAM", "VAL", 
			"ENABLED", "ANCESTOR", "ANCESTOR_OR_SELF"
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(64);
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
				setState(65);
				partialQuery();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(68);
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
			setState(70);
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
			setState(72);
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
			setState(74);
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

	public static class ObjectIdContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(QLangGrammarParser.IDENT, 0); }
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
		enterRule(_localctx, 8, RULE_objectId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(IDENT);
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
		public TerminalNode IDENT() { return getToken(QLangGrammarParser.IDENT, 0); }
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
		enterRule(_localctx, 10, RULE_objectType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(IDENT);
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
		public TerminalNode STRING() { return getToken(QLangGrammarParser.STRING, 0); }
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
		enterRule(_localctx, 12, RULE_parameterValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(STRING);
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
		enterRule(_localctx, 14, RULE_vcsRootKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
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
		enterRule(_localctx, 16, RULE_buildConfKeword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
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
		enterRule(_localctx, 18, RULE_projectKeword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
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
		enterRule(_localctx, 20, RULE_templateKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
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
		enterRule(_localctx, 22, RULE_partialQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		enterRule(_localctx, 24, RULE_find);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__0);
			setState(93);
			multipleObjects();
			setState(94);
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
		enterRule(_localctx, 26, RULE_multipleObjects);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			objectKeyword();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(97);
				match(T__1);
				setState(98);
				objectKeyword();
				}
				}
				setState(103);
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
		enterRule(_localctx, 28, RULE_objectKeyword);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				projectKeword();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				templateKeyword();
				}
				break;
			case BUILD_CONFIGURATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				buildConfKeword();
				}
				break;
			case VCS_ROOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
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
		enterRule(_localctx, 30, RULE_conditionInSubproject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(110);
					match(T__2);
					setState(111);
					objectId();
					}
				}

				setState(114);
				match(T__3);
				setState(115);
				condition(0);
				}
				break;
			case 2:
				{
				setState(116);
				match(T__2);
				setState(117);
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
		enterRule(_localctx, 32, RULE_filter);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				idFilter();
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				projectFilter();
				}
				break;
			case PARENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				parentFilter();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				triggerFilter();
				}
				break;
			case STEP:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				stepFilter();
				}
				break;
			case FEATURE:
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				featureFilter();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 7);
				{
				setState(126);
				typeFilter();
				}
				break;
			case PARAM:
				enterOuterAlt(_localctx, 8);
				{
				setState(127);
				parameterFilter();
				}
				break;
			case VAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(128);
				parValueFilter();
				}
				break;
			case ENABLED:
				enterOuterAlt(_localctx, 10);
				{
				setState(129);
				enabledFilter();
				}
				break;
			case ANCESTOR:
				enterOuterAlt(_localctx, 11);
				{
				setState(130);
				ancestorFilter();
				}
				break;
			case ANCESTOR_OR_SELF:
				enterOuterAlt(_localctx, 12);
				{
				setState(131);
				ancestorOrSelfFilter();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 13);
				{
				setState(132);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
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

				setState(136);
				filter();
				}
				break;
			case T__4:
				{
				_localctx = new ConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(T__4);
				setState(138);
				condition(0);
				setState(139);
				match(T__5);
				}
				break;
			case NOT:
				{
				_localctx = new ConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				not();
				setState(142);
				condition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(154);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionAndContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(146);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(147);
						and();
						setState(148);
						condition(3);
						}
						break;
					case 2:
						{
						_localctx = new ConditionOrContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(150);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(151);
						or();
						setState(152);
						condition(2);
						}
						break;
					}
					} 
				}
				setState(158);
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
		enterRule(_localctx, 36, RULE_filterOrCondition);
		try {
			setState(164);
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
				setState(159);
				filter();
				}
				break;
			case T__4:
				_localctx = new MultFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(T__4);
				setState(161);
				condition(0);
				setState(162);
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
		enterRule(_localctx, 38, RULE_idFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(ID);
			setState(167);
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
		enterRule(_localctx, 40, RULE_projectFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(PROJECT);
			setState(170);
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
		enterRule(_localctx, 42, RULE_parentFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(PARENT);
			setState(173);
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
		enterRule(_localctx, 44, RULE_triggerFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(TRIGGER);
			setState(176);
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
		enterRule(_localctx, 46, RULE_stepFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(STEP);
			setState(179);
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
		enterRule(_localctx, 48, RULE_featureFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(FEATURE);
			setState(182);
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
		enterRule(_localctx, 50, RULE_typeFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(TYPE);
			setState(185);
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
		public Token parameterName;
		public TerminalNode PARAM() { return getToken(QLangGrammarParser.PARAM, 0); }
		public ParameterValueContext parameterValue() {
			return getRuleContext(ParameterValueContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(QLangGrammarParser.IDENT, 0); }
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
		enterRule(_localctx, 52, RULE_parameterFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(PARAM);
			setState(188);
			((ParameterFilterContext)_localctx).parameterName = match(IDENT);
			setState(189);
			match(T__6);
			setState(190);
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
		enterRule(_localctx, 54, RULE_parValueFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(VAL);
			setState(193);
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
		enterRule(_localctx, 56, RULE_enabledFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
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
		enterRule(_localctx, 58, RULE_ancestorFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(ANCESTOR);
			setState(198);
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
		enterRule(_localctx, 60, RULE_ancestorOrSelfFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ANCESTOR_OR_SELF);
			setState(201);
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
		enterRule(_localctx, 62, RULE_templateDepFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(TEMPLATE);
			setState(204);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return condition_sempred((ConditionContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00d1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\5\2E\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\7\17f\n\17\f\17\16\17i\13\17\3\20\3\20\3\20\3\20\5\20o\n"+
		"\20\3\21\3\21\5\21s\n\21\3\21\3\21\3\21\3\21\5\21y\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0088\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0093\n\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u009d\n\23\f\23\16\23\u00a0\13\23\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00a7\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3"+
		" \3 \3!\3!\3!\3!\2\3$\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@\2\2\2\u00c8\2D\3\2\2\2\4H\3\2\2\2\6J\3\2\2\2\bL\3"+
		"\2\2\2\nN\3\2\2\2\fP\3\2\2\2\16R\3\2\2\2\20T\3\2\2\2\22V\3\2\2\2\24X\3"+
		"\2\2\2\26Z\3\2\2\2\30\\\3\2\2\2\32^\3\2\2\2\34b\3\2\2\2\36n\3\2\2\2 x"+
		"\3\2\2\2\"\u0087\3\2\2\2$\u0092\3\2\2\2&\u00a6\3\2\2\2(\u00a8\3\2\2\2"+
		"*\u00ab\3\2\2\2,\u00ae\3\2\2\2.\u00b1\3\2\2\2\60\u00b4\3\2\2\2\62\u00b7"+
		"\3\2\2\2\64\u00ba\3\2\2\2\66\u00bd\3\2\2\28\u00c2\3\2\2\2:\u00c5\3\2\2"+
		"\2<\u00c7\3\2\2\2>\u00ca\3\2\2\2@\u00cd\3\2\2\2BE\5\32\16\2CE\5\30\r\2"+
		"DB\3\2\2\2DC\3\2\2\2EF\3\2\2\2FG\7\2\2\3G\3\3\2\2\2HI\7\13\2\2I\5\3\2"+
		"\2\2JK\7\n\2\2K\7\3\2\2\2LM\7\f\2\2M\t\3\2\2\2NO\7\16\2\2O\13\3\2\2\2"+
		"PQ\7\16\2\2Q\r\3\2\2\2RS\7\r\2\2S\17\3\2\2\2TU\7\23\2\2U\21\3\2\2\2VW"+
		"\7\22\2\2W\23\3\2\2\2XY\7\20\2\2Y\25\3\2\2\2Z[\7\21\2\2[\27\3\2\2\2\\"+
		"]\5$\23\2]\31\3\2\2\2^_\7\3\2\2_`\5\34\17\2`a\5 \21\2a\33\3\2\2\2bg\5"+
		"\36\20\2cd\7\4\2\2df\5\36\20\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2"+
		"h\35\3\2\2\2ig\3\2\2\2jo\5\24\13\2ko\5\26\f\2lo\5\22\n\2mo\5\20\t\2nj"+
		"\3\2\2\2nk\3\2\2\2nl\3\2\2\2nm\3\2\2\2o\37\3\2\2\2pq\7\5\2\2qs\5\n\6\2"+
		"rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\6\2\2uy\5$\23\2vw\7\5\2\2wy\5\n\6\2"+
		"xr\3\2\2\2xv\3\2\2\2y!\3\2\2\2z\u0088\5(\25\2{\u0088\5*\26\2|\u0088\5"+
		",\27\2}\u0088\5.\30\2~\u0088\5\60\31\2\177\u0088\5\62\32\2\u0080\u0088"+
		"\5\64\33\2\u0081\u0088\5\66\34\2\u0082\u0088\58\35\2\u0083\u0088\5:\36"+
		"\2\u0084\u0088\5<\37\2\u0085\u0088\5> \2\u0086\u0088\5@!\2\u0087z\3\2"+
		"\2\2\u0087{\3\2\2\2\u0087|\3\2\2\2\u0087}\3\2\2\2\u0087~\3\2\2\2\u0087"+
		"\177\3\2\2\2\u0087\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0082\3\2\2"+
		"\2\u0087\u0083\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086"+
		"\3\2\2\2\u0088#\3\2\2\2\u0089\u008a\b\23\1\2\u008a\u0093\5\"\22\2\u008b"+
		"\u008c\7\7\2\2\u008c\u008d\5$\23\2\u008d\u008e\7\b\2\2\u008e\u0093\3\2"+
		"\2\2\u008f\u0090\5\b\5\2\u0090\u0091\5$\23\5\u0091\u0093\3\2\2\2\u0092"+
		"\u0089\3\2\2\2\u0092\u008b\3\2\2\2\u0092\u008f\3\2\2\2\u0093\u009e\3\2"+
		"\2\2\u0094\u0095\f\4\2\2\u0095\u0096\5\4\3\2\u0096\u0097\5$\23\5\u0097"+
		"\u009d\3\2\2\2\u0098\u0099\f\3\2\2\u0099\u009a\5\6\4\2\u009a\u009b\5$"+
		"\23\4\u009b\u009d\3\2\2\2\u009c\u0094\3\2\2\2\u009c\u0098\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f%\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a1\u00a7\5\"\22\2\u00a2\u00a3\7\7\2\2\u00a3\u00a4"+
		"\5$\23\2\u00a4\u00a5\7\b\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6"+
		"\u00a2\3\2\2\2\u00a7\'\3\2\2\2\u00a8\u00a9\7\24\2\2\u00a9\u00aa\5\n\6"+
		"\2\u00aa)\3\2\2\2\u00ab\u00ac\7\20\2\2\u00ac\u00ad\5&\24\2\u00ad+\3\2"+
		"\2\2\u00ae\u00af\7\25\2\2\u00af\u00b0\5&\24\2\u00b0-\3\2\2\2\u00b1\u00b2"+
		"\7\26\2\2\u00b2\u00b3\5&\24\2\u00b3/\3\2\2\2\u00b4\u00b5\7\27\2\2\u00b5"+
		"\u00b6\5&\24\2\u00b6\61\3\2\2\2\u00b7\u00b8\7\30\2\2\u00b8\u00b9\5&\24"+
		"\2\u00b9\63\3\2\2\2\u00ba\u00bb\7\31\2\2\u00bb\u00bc\5\f\7\2\u00bc\65"+
		"\3\2\2\2\u00bd\u00be\7\32\2\2\u00be\u00bf\7\16\2\2\u00bf\u00c0\7\t\2\2"+
		"\u00c0\u00c1\5\16\b\2\u00c1\67\3\2\2\2\u00c2\u00c3\7\33\2\2\u00c3\u00c4"+
		"\5\16\b\2\u00c49\3\2\2\2\u00c5\u00c6\7\34\2\2\u00c6;\3\2\2\2\u00c7\u00c8"+
		"\7\35\2\2\u00c8\u00c9\5&\24\2\u00c9=\3\2\2\2\u00ca\u00cb\7\36\2\2\u00cb"+
		"\u00cc\5&\24\2\u00cc?\3\2\2\2\u00cd\u00ce\7\21\2\2\u00ce\u00cf\5&\24\2"+
		"\u00cfA\3\2\2\2\fDgnrx\u0087\u0092\u009c\u009e\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}