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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, OR=23, AND=24, NOT=25, 
		STRING=26, IDENT=27, WS=28;
	public static final int
		RULE_start = 0, RULE_and = 1, RULE_or = 2, RULE_not = 3, RULE_objectId = 4, 
		RULE_objectType = 5, RULE_parameterValue = 6, RULE_find = 7, RULE_fbuildConf = 8, 
		RULE_fvcsRoot = 9, RULE_fproject = 10, RULE_ftemplate = 11, RULE_fbuildConfOrTemp = 12, 
		RULE_conditionInSubproject = 13, RULE_filter = 14, RULE_condition = 15, 
		RULE_filterOrCondition = 16, RULE_idFilter = 17, RULE_projectFilter = 18, 
		RULE_parentFilter = 19, RULE_triggerFilter = 20, RULE_stepFilter = 21, 
		RULE_featureFilter = 22, RULE_typeFilter = 23, RULE_parameterFilter = 24, 
		RULE_parValueFilter = 25, RULE_enabledFilter = 26, RULE_ancestorFilter = 27, 
		RULE_ancestorOrSelfFilter = 28, RULE_templateDepFilter = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "and", "or", "not", "objectId", "objectType", "parameterValue", 
			"find", "fbuildConf", "fvcsRoot", "fproject", "ftemplate", "fbuildConfOrTemp", 
			"conditionInSubproject", "filter", "condition", "filterOrCondition", 
			"idFilter", "projectFilter", "parentFilter", "triggerFilter", "stepFilter", 
			"featureFilter", "typeFilter", "parameterFilter", "parValueFilter", "enabledFilter", 
			"ancestorFilter", "ancestorOrSelfFilter", "templateDepFilter"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'find'", "'buildConf'", "'vcsRoot'", "'project'", "'template'", 
			"'buildConfOrTemp'", "'in'", "'with'", "'('", "')'", "'id'", "'parent'", 
			"'trigger'", "'step'", "'feature'", "'type'", "'param'", "'='", "'val'", 
			"'enabled'", "'ancestor'", "'ancestorOrSelf'", "'or'", "'and'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "OR", 
			"AND", "NOT", "STRING", "IDENT", "WS"
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
		public FindContext find() {
			return getRuleContext(FindContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QLangGrammarParser.EOF, 0); }
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
			setState(60);
			find();
			setState(61);
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
			setState(63);
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
			setState(65);
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
			setState(67);
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
			setState(69);
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
			setState(71);
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
			setState(73);
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

	public static class FindContext extends ParserRuleContext {
		public FbuildConfContext fbuildConf() {
			return getRuleContext(FbuildConfContext.class,0);
		}
		public FprojectContext fproject() {
			return getRuleContext(FprojectContext.class,0);
		}
		public FtemplateContext ftemplate() {
			return getRuleContext(FtemplateContext.class,0);
		}
		public FbuildConfOrTempContext fbuildConfOrTemp() {
			return getRuleContext(FbuildConfOrTempContext.class,0);
		}
		public FvcsRootContext fvcsRoot() {
			return getRuleContext(FvcsRootContext.class,0);
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
		enterRule(_localctx, 14, RULE_find);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(76);
				fbuildConf();
				}
				break;
			case T__3:
				{
				setState(77);
				fproject();
				}
				break;
			case T__4:
				{
				setState(78);
				ftemplate();
				}
				break;
			case T__5:
				{
				setState(79);
				fbuildConfOrTemp();
				}
				break;
			case T__2:
				{
				setState(80);
				fvcsRoot();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FbuildConfContext extends ParserRuleContext {
		public ConditionInSubprojectContext conditionInSubproject() {
			return getRuleContext(ConditionInSubprojectContext.class,0);
		}
		public FbuildConfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fbuildConf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFbuildConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFbuildConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFbuildConf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FbuildConfContext fbuildConf() throws RecognitionException {
		FbuildConfContext _localctx = new FbuildConfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fbuildConf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__1);
			setState(84);
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

	public static class FvcsRootContext extends ParserRuleContext {
		public ConditionInSubprojectContext conditionInSubproject() {
			return getRuleContext(ConditionInSubprojectContext.class,0);
		}
		public FvcsRootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fvcsRoot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFvcsRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFvcsRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFvcsRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FvcsRootContext fvcsRoot() throws RecognitionException {
		FvcsRootContext _localctx = new FvcsRootContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fvcsRoot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__2);
			setState(87);
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

	public static class FprojectContext extends ParserRuleContext {
		public ConditionInSubprojectContext conditionInSubproject() {
			return getRuleContext(ConditionInSubprojectContext.class,0);
		}
		public FprojectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fproject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFproject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFproject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFproject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FprojectContext fproject() throws RecognitionException {
		FprojectContext _localctx = new FprojectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fproject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__3);
			setState(90);
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

	public static class FtemplateContext extends ParserRuleContext {
		public ConditionInSubprojectContext conditionInSubproject() {
			return getRuleContext(ConditionInSubprojectContext.class,0);
		}
		public FtemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ftemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFtemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFtemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFtemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FtemplateContext ftemplate() throws RecognitionException {
		FtemplateContext _localctx = new FtemplateContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ftemplate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__4);
			setState(93);
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

	public static class FbuildConfOrTempContext extends ParserRuleContext {
		public ConditionInSubprojectContext conditionInSubproject() {
			return getRuleContext(ConditionInSubprojectContext.class,0);
		}
		public FbuildConfOrTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fbuildConfOrTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).enterFbuildConfOrTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangGrammarListener ) ((QLangGrammarListener)listener).exitFbuildConfOrTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLangGrammarVisitor ) return ((QLangGrammarVisitor<? extends T>)visitor).visitFbuildConfOrTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FbuildConfOrTempContext fbuildConfOrTemp() throws RecognitionException {
		FbuildConfOrTempContext _localctx = new FbuildConfOrTempContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fbuildConfOrTemp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__5);
			setState(96);
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
		enterRule(_localctx, 26, RULE_conditionInSubproject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(98);
					match(T__6);
					setState(99);
					objectId();
					}
				}

				setState(102);
				match(T__7);
				setState(103);
				condition(0);
				}
				break;
			case 2:
				{
				setState(104);
				match(T__6);
				setState(105);
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
		enterRule(_localctx, 28, RULE_filter);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				idFilter();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				projectFilter();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				parentFilter();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				triggerFilter();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				stepFilter();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(113);
				featureFilter();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 7);
				{
				setState(114);
				typeFilter();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				parameterFilter();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 9);
				{
				setState(116);
				parValueFilter();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 10);
				{
				setState(117);
				enabledFilter();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 11);
				{
				setState(118);
				ancestorFilter();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 12);
				{
				setState(119);
				ancestorOrSelfFilter();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 13);
				{
				setState(120);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
				{
				_localctx = new ConditionFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(124);
				filter();
				}
				break;
			case T__8:
				{
				_localctx = new ConditionBracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(T__8);
				setState(126);
				condition(0);
				setState(127);
				match(T__9);
				}
				break;
			case NOT:
				{
				_localctx = new ConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				not();
				setState(130);
				condition(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(142);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionAndContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(134);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(135);
						and();
						setState(136);
						condition(3);
						}
						break;
					case 2:
						{
						_localctx = new ConditionOrContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(138);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(139);
						or();
						setState(140);
						condition(2);
						}
						break;
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		enterRule(_localctx, 32, RULE_filterOrCondition);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
				_localctx = new SingleFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				filter();
				}
				break;
			case T__8:
				_localctx = new MultFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(T__8);
				setState(149);
				condition(0);
				setState(150);
				match(T__9);
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
		enterRule(_localctx, 34, RULE_idFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__10);
			setState(155);
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
		enterRule(_localctx, 36, RULE_projectFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__3);
			setState(158);
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
		enterRule(_localctx, 38, RULE_parentFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__11);
			setState(161);
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
		enterRule(_localctx, 40, RULE_triggerFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__12);
			setState(164);
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
		enterRule(_localctx, 42, RULE_stepFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__13);
			setState(167);
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
		enterRule(_localctx, 44, RULE_featureFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__14);
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

	public static class TypeFilterContext extends ParserRuleContext {
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
		enterRule(_localctx, 46, RULE_typeFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172);
			match(T__15);
			}
			setState(173);
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
		enterRule(_localctx, 48, RULE_parameterFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(175);
			match(T__16);
			}
			setState(176);
			((ParameterFilterContext)_localctx).parameterName = match(IDENT);
			setState(177);
			match(T__17);
			setState(178);
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
		enterRule(_localctx, 50, RULE_parValueFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(180);
			match(T__18);
			}
			setState(181);
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
		enterRule(_localctx, 52, RULE_enabledFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__19);
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
		enterRule(_localctx, 54, RULE_ancestorFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__20);
			setState(186);
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
		enterRule(_localctx, 56, RULE_ancestorOrSelfFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__21);
			setState(189);
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
		enterRule(_localctx, 58, RULE_templateDepFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__4);
			setState(192);
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
		case 15:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00c5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\tT\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\5\17g\n\17\3\17\3\17\3\17\3\17\5\17m\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20|\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0087\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0091\n\21\f\21\16\21\u0094\13\21"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u009b\n\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\2\3  \2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<\2\2\2\u00bd\2>\3\2\2\2\4A\3\2\2\2\6"+
		"C\3\2\2\2\bE\3\2\2\2\nG\3\2\2\2\fI\3\2\2\2\16K\3\2\2\2\20M\3\2\2\2\22"+
		"U\3\2\2\2\24X\3\2\2\2\26[\3\2\2\2\30^\3\2\2\2\32a\3\2\2\2\34l\3\2\2\2"+
		"\36{\3\2\2\2 \u0086\3\2\2\2\"\u009a\3\2\2\2$\u009c\3\2\2\2&\u009f\3\2"+
		"\2\2(\u00a2\3\2\2\2*\u00a5\3\2\2\2,\u00a8\3\2\2\2.\u00ab\3\2\2\2\60\u00ae"+
		"\3\2\2\2\62\u00b1\3\2\2\2\64\u00b6\3\2\2\2\66\u00b9\3\2\2\28\u00bb\3\2"+
		"\2\2:\u00be\3\2\2\2<\u00c1\3\2\2\2>?\5\20\t\2?@\7\2\2\3@\3\3\2\2\2AB\7"+
		"\32\2\2B\5\3\2\2\2CD\7\31\2\2D\7\3\2\2\2EF\7\33\2\2F\t\3\2\2\2GH\7\35"+
		"\2\2H\13\3\2\2\2IJ\7\35\2\2J\r\3\2\2\2KL\7\34\2\2L\17\3\2\2\2MS\7\3\2"+
		"\2NT\5\22\n\2OT\5\26\f\2PT\5\30\r\2QT\5\32\16\2RT\5\24\13\2SN\3\2\2\2"+
		"SO\3\2\2\2SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T\21\3\2\2\2UV\7\4\2\2VW\5\34"+
		"\17\2W\23\3\2\2\2XY\7\5\2\2YZ\5\34\17\2Z\25\3\2\2\2[\\\7\6\2\2\\]\5\34"+
		"\17\2]\27\3\2\2\2^_\7\7\2\2_`\5\34\17\2`\31\3\2\2\2ab\7\b\2\2bc\5\34\17"+
		"\2c\33\3\2\2\2de\7\t\2\2eg\5\n\6\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\n"+
		"\2\2im\5 \21\2jk\7\t\2\2km\5\n\6\2lf\3\2\2\2lj\3\2\2\2m\35\3\2\2\2n|\5"+
		"$\23\2o|\5&\24\2p|\5(\25\2q|\5*\26\2r|\5,\27\2s|\5.\30\2t|\5\60\31\2u"+
		"|\5\62\32\2v|\5\64\33\2w|\5\66\34\2x|\58\35\2y|\5:\36\2z|\5<\37\2{n\3"+
		"\2\2\2{o\3\2\2\2{p\3\2\2\2{q\3\2\2\2{r\3\2\2\2{s\3\2\2\2{t\3\2\2\2{u\3"+
		"\2\2\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|\37\3\2\2\2}"+
		"~\b\21\1\2~\u0087\5\36\20\2\177\u0080\7\13\2\2\u0080\u0081\5 \21\2\u0081"+
		"\u0082\7\f\2\2\u0082\u0087\3\2\2\2\u0083\u0084\5\b\5\2\u0084\u0085\5 "+
		"\21\5\u0085\u0087\3\2\2\2\u0086}\3\2\2\2\u0086\177\3\2\2\2\u0086\u0083"+
		"\3\2\2\2\u0087\u0092\3\2\2\2\u0088\u0089\f\4\2\2\u0089\u008a\5\4\3\2\u008a"+
		"\u008b\5 \21\5\u008b\u0091\3\2\2\2\u008c\u008d\f\3\2\2\u008d\u008e\5\6"+
		"\4\2\u008e\u008f\5 \21\4\u008f\u0091\3\2\2\2\u0090\u0088\3\2\2\2\u0090"+
		"\u008c\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093!\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u009b\5\36\20\2\u0096\u0097"+
		"\7\13\2\2\u0097\u0098\5 \21\2\u0098\u0099\7\f\2\2\u0099\u009b\3\2\2\2"+
		"\u009a\u0095\3\2\2\2\u009a\u0096\3\2\2\2\u009b#\3\2\2\2\u009c\u009d\7"+
		"\r\2\2\u009d\u009e\5\n\6\2\u009e%\3\2\2\2\u009f\u00a0\7\6\2\2\u00a0\u00a1"+
		"\5\"\22\2\u00a1\'\3\2\2\2\u00a2\u00a3\7\16\2\2\u00a3\u00a4\5\"\22\2\u00a4"+
		")\3\2\2\2\u00a5\u00a6\7\17\2\2\u00a6\u00a7\5\"\22\2\u00a7+\3\2\2\2\u00a8"+
		"\u00a9\7\20\2\2\u00a9\u00aa\5\"\22\2\u00aa-\3\2\2\2\u00ab\u00ac\7\21\2"+
		"\2\u00ac\u00ad\5\"\22\2\u00ad/\3\2\2\2\u00ae\u00af\7\22\2\2\u00af\u00b0"+
		"\5\f\7\2\u00b0\61\3\2\2\2\u00b1\u00b2\7\23\2\2\u00b2\u00b3\7\35\2\2\u00b3"+
		"\u00b4\7\24\2\2\u00b4\u00b5\5\16\b\2\u00b5\63\3\2\2\2\u00b6\u00b7\7\25"+
		"\2\2\u00b7\u00b8\5\16\b\2\u00b8\65\3\2\2\2\u00b9\u00ba\7\26\2\2\u00ba"+
		"\67\3\2\2\2\u00bb\u00bc\7\27\2\2\u00bc\u00bd\5\"\22\2\u00bd9\3\2\2\2\u00be"+
		"\u00bf\7\30\2\2\u00bf\u00c0\5\"\22\2\u00c0;\3\2\2\2\u00c1\u00c2\7\7\2"+
		"\2\u00c2\u00c3\5\"\22\2\u00c3=\3\2\2\2\nSfl{\u0086\u0090\u0092\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}