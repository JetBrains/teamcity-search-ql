// Generated from QLangGrammar.g4 by ANTLR 4.8

    package jetbrains.buildServer.server.querylang.parser;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, OR=23, AND=24, NOT=25, 
		STRING=26, IDENT=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "DIGIT", "LLET", "ULET", 
			"LET", "WSP", "OR", "AND", "NOT", "STRING", "IDENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'find'", "'buildConf'", "'vcsRoot'", "'project'", "'with'", "'template'", 
			"'buildConfOrTemp'", "'in'", "'('", "')'", "'id'", "'parent'", "'trigger'", 
			"'step'", "'feature'", "'type'", "'param'", "'='", "'val'", "'enabled'", 
			"'ancestor'", "'ancestorOrSelf'", "'or'", "'and'", "'not'"
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u0106\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\5\33\u00e2\n\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \6 \u00f3\n \r \16 \u00f4\3 \3 \3"+
		"!\3!\3!\6!\u00fc\n!\r!\16!\u00fd\3\"\6\"\u0101\n\"\r\"\16\"\u0102\3\""+
		"\3\"\3\u00f4\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\2\61\2\63\2\65\2\67"+
		"\29\31;\32=\33?\34A\35C\36\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\""+
		"\"\5\2\13\f\17\17$$\4\2\60\60aa\2\u0106\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5J\3\2\2\2\7T\3\2\2\2\t\\\3\2\2"+
		"\2\13d\3\2\2\2\ri\3\2\2\2\17r\3\2\2\2\21\u0082\3\2\2\2\23\u0085\3\2\2"+
		"\2\25\u0087\3\2\2\2\27\u0089\3\2\2\2\31\u008c\3\2\2\2\33\u0093\3\2\2\2"+
		"\35\u009b\3\2\2\2\37\u00a0\3\2\2\2!\u00a8\3\2\2\2#\u00ad\3\2\2\2%\u00b3"+
		"\3\2\2\2\'\u00b5\3\2\2\2)\u00b9\3\2\2\2+\u00c1\3\2\2\2-\u00ca\3\2\2\2"+
		"/\u00d9\3\2\2\2\61\u00db\3\2\2\2\63\u00dd\3\2\2\2\65\u00e1\3\2\2\2\67"+
		"\u00e3\3\2\2\29\u00e5\3\2\2\2;\u00e8\3\2\2\2=\u00ec\3\2\2\2?\u00f0\3\2"+
		"\2\2A\u00fb\3\2\2\2C\u0100\3\2\2\2EF\7h\2\2FG\7k\2\2GH\7p\2\2HI\7f\2\2"+
		"I\4\3\2\2\2JK\7d\2\2KL\7w\2\2LM\7k\2\2MN\7n\2\2NO\7f\2\2OP\7E\2\2PQ\7"+
		"q\2\2QR\7p\2\2RS\7h\2\2S\6\3\2\2\2TU\7x\2\2UV\7e\2\2VW\7u\2\2WX\7T\2\2"+
		"XY\7q\2\2YZ\7q\2\2Z[\7v\2\2[\b\3\2\2\2\\]\7r\2\2]^\7t\2\2^_\7q\2\2_`\7"+
		"l\2\2`a\7g\2\2ab\7e\2\2bc\7v\2\2c\n\3\2\2\2de\7y\2\2ef\7k\2\2fg\7v\2\2"+
		"gh\7j\2\2h\f\3\2\2\2ij\7v\2\2jk\7g\2\2kl\7o\2\2lm\7r\2\2mn\7n\2\2no\7"+
		"c\2\2op\7v\2\2pq\7g\2\2q\16\3\2\2\2rs\7d\2\2st\7w\2\2tu\7k\2\2uv\7n\2"+
		"\2vw\7f\2\2wx\7E\2\2xy\7q\2\2yz\7p\2\2z{\7h\2\2{|\7Q\2\2|}\7t\2\2}~\7"+
		"V\2\2~\177\7g\2\2\177\u0080\7o\2\2\u0080\u0081\7r\2\2\u0081\20\3\2\2\2"+
		"\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\22\3\2\2\2\u0085\u0086\7"+
		"*\2\2\u0086\24\3\2\2\2\u0087\u0088\7+\2\2\u0088\26\3\2\2\2\u0089\u008a"+
		"\7k\2\2\u008a\u008b\7f\2\2\u008b\30\3\2\2\2\u008c\u008d\7r\2\2\u008d\u008e"+
		"\7c\2\2\u008e\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7p\2\2\u0091"+
		"\u0092\7v\2\2\u0092\32\3\2\2\2\u0093\u0094\7v\2\2\u0094\u0095\7t\2\2\u0095"+
		"\u0096\7k\2\2\u0096\u0097\7i\2\2\u0097\u0098\7i\2\2\u0098\u0099\7g\2\2"+
		"\u0099\u009a\7t\2\2\u009a\34\3\2\2\2\u009b\u009c\7u\2\2\u009c\u009d\7"+
		"v\2\2\u009d\u009e\7g\2\2\u009e\u009f\7r\2\2\u009f\36\3\2\2\2\u00a0\u00a1"+
		"\7h\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7v\2\2\u00a4"+
		"\u00a5\7w\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7g\2\2\u00a7 \3\2\2\2\u00a8"+
		"\u00a9\7v\2\2\u00a9\u00aa\7{\2\2\u00aa\u00ab\7r\2\2\u00ab\u00ac\7g\2\2"+
		"\u00ac\"\3\2\2\2\u00ad\u00ae\7r\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7t"+
		"\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7o\2\2\u00b2$\3\2\2\2\u00b3\u00b4"+
		"\7?\2\2\u00b4&\3\2\2\2\u00b5\u00b6\7x\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8"+
		"\7n\2\2\u00b8(\3\2\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7d\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7g\2\2\u00bf"+
		"\u00c0\7f\2\2\u00c0*\3\2\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7p\2\2\u00c3"+
		"\u00c4\7e\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7v\2\2"+
		"\u00c7\u00c8\7q\2\2\u00c8\u00c9\7t\2\2\u00c9,\3\2\2\2\u00ca\u00cb\7c\2"+
		"\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf"+
		"\7u\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7t\2\2\u00d2"+
		"\u00d3\7Q\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7U\2\2\u00d5\u00d6\7g\2\2"+
		"\u00d6\u00d7\7n\2\2\u00d7\u00d8\7h\2\2\u00d8.\3\2\2\2\u00d9\u00da\t\2"+
		"\2\2\u00da\60\3\2\2\2\u00db\u00dc\t\3\2\2\u00dc\62\3\2\2\2\u00dd\u00de"+
		"\t\4\2\2\u00de\64\3\2\2\2\u00df\u00e2\5\63\32\2\u00e0\u00e2\5\61\31\2"+
		"\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\66\3\2\2\2\u00e3\u00e4"+
		"\t\5\2\2\u00e48\3\2\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7t\2\2\u00e7:\3"+
		"\2\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7f\2\2\u00eb"+
		"<\3\2\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee\7q\2\2\u00ee\u00ef\7v\2\2\u00ef"+
		">\3\2\2\2\u00f0\u00f2\7$\2\2\u00f1\u00f3\n\6\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00f7\7$\2\2\u00f7@\3\2\2\2\u00f8\u00fc\5\65\33\2\u00f9\u00fc"+
		"\5/\30\2\u00fa\u00fc\t\7\2\2\u00fb\u00f8\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00feB\3\2\2\2\u00ff\u0101\t\5\2\2\u0100\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\b\"\2\2\u0105D\3\2\2\2\b\2\u00e1\u00f4\u00fb\u00fd\u0102\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}