// Generated from QLangGrammar.g4 by ANTLR 4.8

package jetbrains.buildServer.server.querylang.parser;

import jetbrains.buildServer.server.querylang.ast.*;
import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLangGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OR=10, AND=11, NOT=12, STRING=13, IDENT=14, SUFFIXS=15, PREFIXS=16, SUBSTRINGS=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"DIGIT", "LLET", "ULET", "LET", "WSP", "OR", "AND", "NOT", "STRING", 
			"IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'find'", "','", "'in'", "'with'", "'('", "')'", "'='", "'['", 
			"']'", "'or'", "'and'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "OR", "AND", 
			"NOT", "STRING", "IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "WS"
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


	    Map<String, Integer> keywords = new HashMap<String, Integer>();

	    {
	        putToKeywords(FindProject.Companion.getNames(), QLangGrammarParser.PROJECT);
	        putToKeywords(FindBuildConf.Companion.getNames(), QLangGrammarParser.BUILD_CONFIGURATION);
	        putToKeywords(FindTemplate.Companion.getNames(), QLangGrammarParser.TEMPLATE);
	        putToKeywords(FindVcsRoot.Companion.getNames(), QLangGrammarParser.VCS_ROOT);

	        putToKeywords(IdFilter.Companion.getNames() , QLangGrammarParser.ID);
	        putToKeywords(ProjectFilter.Companion.getNames(), QLangGrammarParser.PROJECT);
	        putToKeywords(TempDepFilter.Companion.getNames(), QLangGrammarParser.TEMPLATE);
	        putToKeywords(ParentFilter.Companion.getNames(), QLangGrammarParser.PARENT);
	        putToKeywords(TriggerFilter.Companion.getNames(), QLangGrammarParser.TRIGGER);
	        putToKeywords(StepFilter.Companion.getNames(), QLangGrammarParser.STEP);
	        putToKeywords(FeatureFilter.Companion.getNames(), QLangGrammarParser.FEATURE);
	        putToKeywords(TypeFilter.Companion.getNames(), QLangGrammarParser.TYPE);
	        putToKeywords(ParameterFilter.Companion.getNames(), QLangGrammarParser.PARAM);
	        putToKeywords(ValueFilter.Companion.getNames(), QLangGrammarParser.VAL);
	        putToKeywords(EnabledFilter.Companion.getNames(), QLangGrammarParser.ENABLED);
	        putToKeywords(AncestorFilter.Companion.getNames(), QLangGrammarParser.ANCESTOR);
	        putToKeywords(AncestorOrSelfFilter.Companion.getNames(), QLangGrammarParser.ANCESTOR_OR_SELF);
	        putToKeywords(CheckoutRulesFilter.Companion.getNames(), QLangGrammarParser.RULES);
	        putToKeywords(DependencyFilter.Companion.getNames(), QLangGrammarParser.DEPENDENCY);
	        putToKeywords(ArtifactFilter.Companion.getNames(), QLangGrammarParser.ARTIFACT);
	        putToKeywords(SnapshotFilter.Companion.getNames(), QLangGrammarParser.SNAPSHOT);
	        putToKeywords(AllFilterModifier.Companion.getNames(), QLangGrammarParser.ALL);
	    }

	    private void putToKeywords(List<String> filterNames, Integer tokenType) {
	        filterNames.forEach(name -> {
	            keywords.put(name, tokenType);
	        });
	    }


	public QLangGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLangGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 18:
			IDENT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void IDENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			   if ( keywords.containsKey(getText()) ) {
			       setType(keywords.get(getText()));
			   }

			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\5\16S\n"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\7\23f\n\23\f\23\16\23i\13\23\3\23\3\23\3\24\3\24\3"+
		"\24\6\24p\n\24\r\24\16\24q\3\24\3\24\3\25\3\25\3\25\5\25y\n\25\3\26\3"+
		"\26\5\26}\n\26\3\26\3\26\3\27\3\27\3\27\5\27\u0084\n\27\3\27\3\27\3\30"+
		"\6\30\u0089\n\30\r\30\16\30\u008a\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\33\2\35\2\37\f!\r#\16%\17\'\20)"+
		"\21+\22-\23/\24\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\"\"\5\2\13\f"+
		"\17\17$$\4\2/\60aa\2\u0092\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\66\3\2\2\2\78\3\2\2\2\t"+
		";\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23H\3\2\2\2\25"+
		"J\3\2\2\2\27L\3\2\2\2\31N\3\2\2\2\33R\3\2\2\2\35T\3\2\2\2\37V\3\2\2\2"+
		"!Y\3\2\2\2#]\3\2\2\2%a\3\2\2\2\'o\3\2\2\2)u\3\2\2\2+|\3\2\2\2-\u0080\3"+
		"\2\2\2/\u0088\3\2\2\2\61\62\7h\2\2\62\63\7k\2\2\63\64\7p\2\2\64\65\7f"+
		"\2\2\65\4\3\2\2\2\66\67\7.\2\2\67\6\3\2\2\289\7k\2\29:\7p\2\2:\b\3\2\2"+
		"\2;<\7y\2\2<=\7k\2\2=>\7v\2\2>?\7j\2\2?\n\3\2\2\2@A\7*\2\2A\f\3\2\2\2"+
		"BC\7+\2\2C\16\3\2\2\2DE\7?\2\2E\20\3\2\2\2FG\7]\2\2G\22\3\2\2\2HI\7_\2"+
		"\2I\24\3\2\2\2JK\t\2\2\2K\26\3\2\2\2LM\t\3\2\2M\30\3\2\2\2NO\t\4\2\2O"+
		"\32\3\2\2\2PS\5\31\r\2QS\5\27\f\2RP\3\2\2\2RQ\3\2\2\2S\34\3\2\2\2TU\t"+
		"\5\2\2U\36\3\2\2\2VW\7q\2\2WX\7t\2\2X \3\2\2\2YZ\7c\2\2Z[\7p\2\2[\\\7"+
		"f\2\2\\\"\3\2\2\2]^\7p\2\2^_\7q\2\2_`\7v\2\2`$\3\2\2\2ag\7$\2\2bf\n\6"+
		"\2\2cd\7$\2\2df\7$\2\2eb\3\2\2\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2"+
		"\2hj\3\2\2\2ig\3\2\2\2jk\7$\2\2k&\3\2\2\2lp\5\33\16\2mp\5\25\13\2np\t"+
		"\7\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3"+
		"\2\2\2st\b\24\2\2t(\3\2\2\2ux\7,\2\2vy\5\'\24\2wy\5%\23\2xv\3\2\2\2xw"+
		"\3\2\2\2y*\3\2\2\2z}\5\'\24\2{}\5%\23\2|z\3\2\2\2|{\3\2\2\2}~\3\2\2\2"+
		"~\177\7,\2\2\177,\3\2\2\2\u0080\u0083\7,\2\2\u0081\u0084\5\'\24\2\u0082"+
		"\u0084\5%\23\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0086\7,\2\2\u0086.\3\2\2\2\u0087\u0089\t\5\2\2\u0088\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\b\30\3\2\u008d\60\3\2\2\2\f\2Regoqx|\u0083"+
		"\u008a\4\3\24\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}