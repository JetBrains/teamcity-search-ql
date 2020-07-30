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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, OR=8, AND=9, NOT=10, 
		STRING=11, IDENT=12, SUFFIXS=13, PREFIXS=14, SUBSTRINGS=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "DIGIT", "LLET", 
			"ULET", "LET", "WSP", "OR", "AND", "NOT", "STRING", "IDENT", "SUFFIXS", 
			"PREFIXS", "SUBSTRINGS", "WS"
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
			"IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "WS"
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
		case 16:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\5\fK\n\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21^\n\21\f\21\16\21a\13"+
		"\21\3\21\3\21\3\22\3\22\3\22\6\22h\n\22\r\22\16\22i\3\22\3\22\3\23\3\23"+
		"\3\23\5\23q\n\23\3\24\3\24\5\24u\n\24\3\24\3\24\3\25\3\25\3\25\5\25|\n"+
		"\25\3\25\3\25\3\26\6\26\u0081\n\26\r\26\16\26\u0082\3\26\3\26\2\2\27\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\2\31\2\33\n\35\13\37\f"+
		"!\r#\16%\17\'\20)\21+\22\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\"\""+
		"\5\2\13\f\17\17$$\4\2/\60aa\2\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\62\3\2\2\2\7\64\3\2\2\2\t\67\3\2\2\2"+
		"\13<\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21B\3\2\2\2\23D\3\2\2\2\25F\3\2\2"+
		"\2\27J\3\2\2\2\31L\3\2\2\2\33N\3\2\2\2\35Q\3\2\2\2\37U\3\2\2\2!Y\3\2\2"+
		"\2#g\3\2\2\2%m\3\2\2\2\'t\3\2\2\2)x\3\2\2\2+\u0080\3\2\2\2-.\7h\2\2./"+
		"\7k\2\2/\60\7p\2\2\60\61\7f\2\2\61\4\3\2\2\2\62\63\7.\2\2\63\6\3\2\2\2"+
		"\64\65\7k\2\2\65\66\7p\2\2\66\b\3\2\2\2\678\7y\2\289\7k\2\29:\7v\2\2:"+
		";\7j\2\2;\n\3\2\2\2<=\7*\2\2=\f\3\2\2\2>?\7+\2\2?\16\3\2\2\2@A\7?\2\2"+
		"A\20\3\2\2\2BC\t\2\2\2C\22\3\2\2\2DE\t\3\2\2E\24\3\2\2\2FG\t\4\2\2G\26"+
		"\3\2\2\2HK\5\25\13\2IK\5\23\n\2JH\3\2\2\2JI\3\2\2\2K\30\3\2\2\2LM\t\5"+
		"\2\2M\32\3\2\2\2NO\7q\2\2OP\7t\2\2P\34\3\2\2\2QR\7c\2\2RS\7p\2\2ST\7f"+
		"\2\2T\36\3\2\2\2UV\7p\2\2VW\7q\2\2WX\7v\2\2X \3\2\2\2Y_\7$\2\2Z^\n\6\2"+
		"\2[\\\7$\2\2\\^\7$\2\2]Z\3\2\2\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`b\3\2\2\2a_\3\2\2\2bc\7$\2\2c\"\3\2\2\2dh\5\27\f\2eh\5\21\t\2fh\t\7"+
		"\2\2gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2"+
		"\2\2kl\b\22\2\2l$\3\2\2\2mp\7,\2\2nq\5#\22\2oq\5!\21\2pn\3\2\2\2po\3\2"+
		"\2\2q&\3\2\2\2ru\5#\22\2su\5!\21\2tr\3\2\2\2ts\3\2\2\2uv\3\2\2\2vw\7,"+
		"\2\2w(\3\2\2\2x{\7,\2\2y|\5#\22\2z|\5!\21\2{y\3\2\2\2{z\3\2\2\2|}\3\2"+
		"\2\2}~\7,\2\2~*\3\2\2\2\177\u0081\t\5\2\2\u0080\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\b\26\3\2\u0085,\3\2\2\2\f\2J]_gipt{\u0082\4\3\22\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}