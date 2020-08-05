// Generated from TestKeywords.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TestKeywords extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OR=1, AND=2, NOT=3, ID=4, PROJECT=5, TEMPLATE=6, BUILD_CONFIGURATION=7, 
		VCS_ROOT=8, PARENT=9, TRIGGER=10, STEP=11, FEATURE=12, TYPE=13, PARAM=14, 
		VAL=15, ENABLED=16, ANCESTOR=17, RULES=18, DEPENDENCY=19, ARTIFACT=20, 
		SNAPSHOT=21, ALL=22, STRING=23, IDENT=24, SUFFIXS=25, PREFIXS=26, SUBSTRINGS=27, 
		WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LLET", "ULET", "LET", "WSP", "OR", "AND", "NOT", "ID", "PROJECT", 
			"TEMPLATE", "BUILD_CONFIGURATION", "VCS_ROOT", "PARENT", "TRIGGER", "STEP", 
			"FEATURE", "TYPE", "PARAM", "VAL", "ENABLED", "ANCESTOR", "RULES", "DEPENDENCY", 
			"ARTIFACT", "SNAPSHOT", "ALL", "STRING", "IDENT", "SUFFIXS", "PREFIXS", 
			"SUBSTRINGS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'or'", "'and'", "'not'", "'id'", "'project'", "'template'", "'buildConfiguration'", 
			"'vcsRoot'", "'parent'", "'trigger'", "'step'", "'feature'", "'type'", 
			"'param'", "'val'", "'enabled'", "'ancestor'", "'rules'", "'dependency'", 
			"'artifact'", "'snapshot'", "'all'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OR", "AND", "NOT", "ID", "PROJECT", "TEMPLATE", "BUILD_CONFIGURATION", 
			"VCS_ROOT", "PARENT", "TRIGGER", "STEP", "FEATURE", "TYPE", "PARAM", 
			"VAL", "ENABLED", "ANCESTOR", "RULES", "DEPENDENCY", "ARTIFACT", "SNAPSHOT", 
			"ALL", "STRING", "IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "WS"
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


	public TestKeywords(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TestKeywords.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u0119\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5N\n\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00f3"+
		"\n\35\f\35\16\35\u00f6\13\35\3\35\3\35\3\36\3\36\3\36\6\36\u00fd\n\36"+
		"\r\36\16\36\u00fe\3\37\3\37\3\37\5\37\u0104\n\37\3 \3 \5 \u0108\n \3 "+
		"\3 \3!\3!\3!\5!\u010f\n!\3!\3!\3\"\6\"\u0114\n\"\r\"\16\"\u0115\3\"\3"+
		"\"\2\2#\3\2\5\2\7\2\t\2\13\2\r\3\17\4\21\5\23\6\25\7\27\b\31\t\33\n\35"+
		"\13\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\61\25\63\26\65\27\67\309\31;"+
		"\32=\33?\34A\35C\36\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\"\"\5\2"+
		"\13\f\17\17$$\4\2/\60aa\2\u011d\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tM\3\2\2\2\13O\3"+
		"\2\2\2\rQ\3\2\2\2\17T\3\2\2\2\21X\3\2\2\2\23\\\3\2\2\2\25_\3\2\2\2\27"+
		"g\3\2\2\2\31p\3\2\2\2\33\u0083\3\2\2\2\35\u008b\3\2\2\2\37\u0092\3\2\2"+
		"\2!\u009a\3\2\2\2#\u009f\3\2\2\2%\u00a7\3\2\2\2\'\u00ac\3\2\2\2)\u00b2"+
		"\3\2\2\2+\u00b6\3\2\2\2-\u00be\3\2\2\2/\u00c7\3\2\2\2\61\u00cd\3\2\2\2"+
		"\63\u00d8\3\2\2\2\65\u00e1\3\2\2\2\67\u00ea\3\2\2\29\u00ee\3\2\2\2;\u00fc"+
		"\3\2\2\2=\u0100\3\2\2\2?\u0107\3\2\2\2A\u010b\3\2\2\2C\u0113\3\2\2\2E"+
		"F\t\2\2\2F\4\3\2\2\2GH\t\3\2\2H\6\3\2\2\2IJ\t\4\2\2J\b\3\2\2\2KN\5\7\4"+
		"\2LN\5\5\3\2MK\3\2\2\2ML\3\2\2\2N\n\3\2\2\2OP\t\5\2\2P\f\3\2\2\2QR\7q"+
		"\2\2RS\7t\2\2S\16\3\2\2\2TU\7c\2\2UV\7p\2\2VW\7f\2\2W\20\3\2\2\2XY\7p"+
		"\2\2YZ\7q\2\2Z[\7v\2\2[\22\3\2\2\2\\]\7k\2\2]^\7f\2\2^\24\3\2\2\2_`\7"+
		"r\2\2`a\7t\2\2ab\7q\2\2bc\7l\2\2cd\7g\2\2de\7e\2\2ef\7v\2\2f\26\3\2\2"+
		"\2gh\7v\2\2hi\7g\2\2ij\7o\2\2jk\7r\2\2kl\7n\2\2lm\7c\2\2mn\7v\2\2no\7"+
		"g\2\2o\30\3\2\2\2pq\7d\2\2qr\7w\2\2rs\7k\2\2st\7n\2\2tu\7f\2\2uv\7E\2"+
		"\2vw\7q\2\2wx\7p\2\2xy\7h\2\2yz\7k\2\2z{\7i\2\2{|\7w\2\2|}\7t\2\2}~\7"+
		"c\2\2~\177\7v\2\2\177\u0080\7k\2\2\u0080\u0081\7q\2\2\u0081\u0082\7p\2"+
		"\2\u0082\32\3\2\2\2\u0083\u0084\7x\2\2\u0084\u0085\7e\2\2\u0085\u0086"+
		"\7u\2\2\u0086\u0087\7T\2\2\u0087\u0088\7q\2\2\u0088\u0089\7q\2\2\u0089"+
		"\u008a\7v\2\2\u008a\34\3\2\2\2\u008b\u008c\7r\2\2\u008c\u008d\7c\2\2\u008d"+
		"\u008e\7t\2\2\u008e\u008f\7g\2\2\u008f\u0090\7p\2\2\u0090\u0091\7v\2\2"+
		"\u0091\36\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094\7t\2\2\u0094\u0095\7"+
		"k\2\2\u0095\u0096\7i\2\2\u0096\u0097\7i\2\2\u0097\u0098\7g\2\2\u0098\u0099"+
		"\7t\2\2\u0099 \3\2\2\2\u009a\u009b\7u\2\2\u009b\u009c\7v\2\2\u009c\u009d"+
		"\7g\2\2\u009d\u009e\7r\2\2\u009e\"\3\2\2\2\u009f\u00a0\7h\2\2\u00a0\u00a1"+
		"\7g\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4\7w\2\2\u00a4"+
		"\u00a5\7t\2\2\u00a5\u00a6\7g\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7v\2\2\u00a8"+
		"\u00a9\7{\2\2\u00a9\u00aa\7r\2\2\u00aa\u00ab\7g\2\2\u00ab&\3\2\2\2\u00ac"+
		"\u00ad\7r\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7c\2\2"+
		"\u00b0\u00b1\7o\2\2\u00b1(\3\2\2\2\u00b2\u00b3\7x\2\2\u00b3\u00b4\7c\2"+
		"\2\u00b4\u00b5\7n\2\2\u00b5*\3\2\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7"+
		"p\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7d\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc"+
		"\7g\2\2\u00bc\u00bd\7f\2\2\u00bd,\3\2\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0"+
		"\7p\2\2\u00c0\u00c1\7e\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7u\2\2\u00c3"+
		"\u00c4\7v\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7t\2\2\u00c6.\3\2\2\2\u00c7"+
		"\u00c8\7t\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7g\2\2"+
		"\u00cb\u00cc\7u\2\2\u00cc\60\3\2\2\2\u00cd\u00ce\7f\2\2\u00ce\u00cf\7"+
		"g\2\2\u00cf\u00d0\7r\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3"+
		"\7f\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7e\2\2\u00d6"+
		"\u00d7\7{\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7t\2\2\u00da"+
		"\u00db\7v\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7h\2\2\u00dd\u00de\7c\2\2"+
		"\u00de\u00df\7e\2\2\u00df\u00e0\7v\2\2\u00e0\64\3\2\2\2\u00e1\u00e2\7"+
		"u\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7r\2\2\u00e5\u00e6"+
		"\7u\2\2\u00e6\u00e7\7j\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7v\2\2\u00e9"+
		"\66\3\2\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7n\2\2\u00ed"+
		"8\3\2\2\2\u00ee\u00f4\7$\2\2\u00ef\u00f3\n\6\2\2\u00f0\u00f1\7$\2\2\u00f1"+
		"\u00f3\7$\2\2\u00f2\u00ef\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f7\u00f8\7$\2\2\u00f8:\3\2\2\2\u00f9\u00fd\5\t\5\2\u00fa"+
		"\u00fd\5\3\2\2\u00fb\u00fd\t\7\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff<\3\2\2\2\u0100\u0103\7,\2\2\u0101\u0104\5;\36\2\u0102"+
		"\u0104\59\35\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104>\3\2\2\2"+
		"\u0105\u0108\5;\36\2\u0106\u0108\59\35\2\u0107\u0105\3\2\2\2\u0107\u0106"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\7,\2\2\u010a@\3\2\2\2\u010b\u010e"+
		"\7,\2\2\u010c\u010f\5;\36\2\u010d\u010f\59\35\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7,\2\2\u0111B\3\2\2\2\u0112"+
		"\u0114\t\5\2\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\b\"\2\2\u0118"+
		"D\3\2\2\2\f\2M\u00f2\u00f4\u00fc\u00fe\u0103\u0107\u010e\u0115\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}