// Generated from /home/ilya/projects/teamcity/external-repos/query-lang/src/main/antlr/Keywords.g4 by ANTLR 4.8

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
public class Keywords extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROJECT=1, TEMPLATE=2, ID=3, PARENT=4, TRIGGER=5, STEP=6, FEATURE=7, TYPE=8, 
		PARAM=9, VAL=10, ENABLED=11, ANCESTOR=12, ANCESTOR_OR_SELF=13, BUILD_CONF=14, 
		VCS_ROOT=15, OR=16, AND=17, NOT=18, STRING=19, IDENT=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LLET", "ULET", "LET", "WSP", "BUILD_CONF", "VCS_ROOT", "OR", 
			"AND", "NOT", "STRING", "IDENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'buildConfiguration'", "'vcsRoot'", "'or'", "'and'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROJECT", "TEMPLATE", "ID", "PARENT", "TRIGGER", "STEP", "FEATURE", 
			"TYPE", "PARAM", "VAL", "ENABLED", "ANCESTOR", "ANCESTOR_OR_SELF", "BUILD_CONF", 
			"VCS_ROOT", "OR", "AND", "NOT", "STRING", "IDENT", "WS"
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


	    Map<String, Integer> keywords = new HashMap<String, Integer>() {{
	        put(IdFilter.Companion.getNames().get(0) , QLangGrammarParser.ID);
	        put(SProjectFilter.Companion.getNames().get(0), QLangGrammarParser.PROJECT);
	        put(TempDepFilter.Companion.getNames().get(0), QLangGrammarParser.TEMPLATE);
	        put(ParentFilter.Companion.getNames().get(0), QLangGrammarParser.PARENT);
	        put(TriggerFilter.Companion.getNames().get(0), QLangGrammarParser.TRIGGER);
	        put(StepFilter.Companion.getNames().get(0), QLangGrammarParser.STEP);
	        put(FeatureFilter.Companion.getNames().get(0), QLangGrammarParser.FEATURE);
	        put(TypeFilter.Companion.getNames().get(0), QLangGrammarParser.TYPE);
	        put(ParameterFilter.Companion.getNames().get(0), QLangGrammarParser.PARAM);
	        put(ValueFilter.Companion.getNames().get(0), QLangGrammarParser.VAL);
	        put(EnabledFilter.Companion.getNames().get(0), QLangGrammarParser.ENABLED);
	        put(AncestorFilter.Companion.getNames().get(0), QLangGrammarParser.ANCESTOR);
	        put(AncestorOrSelfFilter.Companion.getNames().get(0), QLangGrammarParser.ANCESTOR_OR_SELF);
	    }};


	public Keywords(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Keywords.g4"; }

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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5&\n\5"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\f\3\f\7\fR\n\f\f\f\16\fU\13\f\3\f\3\f\3\r\3"+
		"\r\3\r\6\r\\\n\r\r\r\16\r]\3\r\3\r\3\16\6\16c\n\16\r\16\16\16d\3\16\3"+
		"\16\3S\2\17\3\2\5\2\7\2\t\2\13\2\r\20\17\21\21\22\23\23\25\24\27\25\31"+
		"\26\33\27\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\"\"\5\2\13\f\17\17"+
		"$$\4\2\60\60aa\2h\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3"+
		"\2\2\2\7!\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17<\3\2\2\2\21D\3"+
		"\2\2\2\23G\3\2\2\2\25K\3\2\2\2\27O\3\2\2\2\31[\3\2\2\2\33b\3\2\2\2\35"+
		"\36\t\2\2\2\36\4\3\2\2\2\37 \t\3\2\2 \6\3\2\2\2!\"\t\4\2\2\"\b\3\2\2\2"+
		"#&\5\7\4\2$&\5\5\3\2%#\3\2\2\2%$\3\2\2\2&\n\3\2\2\2\'(\t\5\2\2(\f\3\2"+
		"\2\2)*\7d\2\2*+\7w\2\2+,\7k\2\2,-\7n\2\2-.\7f\2\2./\7E\2\2/\60\7q\2\2"+
		"\60\61\7p\2\2\61\62\7h\2\2\62\63\7k\2\2\63\64\7i\2\2\64\65\7w\2\2\65\66"+
		"\7t\2\2\66\67\7c\2\2\678\7v\2\289\7k\2\29:\7q\2\2:;\7p\2\2;\16\3\2\2\2"+
		"<=\7x\2\2=>\7e\2\2>?\7u\2\2?@\7T\2\2@A\7q\2\2AB\7q\2\2BC\7v\2\2C\20\3"+
		"\2\2\2DE\7q\2\2EF\7t\2\2F\22\3\2\2\2GH\7c\2\2HI\7p\2\2IJ\7f\2\2J\24\3"+
		"\2\2\2KL\7p\2\2LM\7q\2\2MN\7v\2\2N\26\3\2\2\2OS\7$\2\2PR\n\6\2\2QP\3\2"+
		"\2\2RU\3\2\2\2ST\3\2\2\2SQ\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7$\2\2W\30\3"+
		"\2\2\2X\\\5\t\5\2Y\\\5\3\2\2Z\\\t\7\2\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2"+
		"\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\r\2\2`\32\3\2\2\2ac\t\5"+
		"\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\b\16\3\2g\34"+
		"\3\2\2\2\b\2%S[]d\4\3\r\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}