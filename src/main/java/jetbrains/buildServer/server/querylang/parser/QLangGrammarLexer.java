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
		ANY_STRING=18, WS=19;
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
			"IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "ANY_STRING", "WS"
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
			"WS"
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
	        putToKeywords(ProjectTopLevelQuery.Companion.getNames(), QLangGrammarParser.PROJECT);
	        putToKeywords(BuildConfTopLevelQuery.Companion.getNames(), QLangGrammarParser.BUILD_CONFIGURATION);
	        putToKeywords(TemplateTopLevelQuery.Companion.getNames(), QLangGrammarParser.TEMPLATE);
	        putToKeywords(VcsRootTopLevelQuery.Companion.getNames(), QLangGrammarParser.VCS_ROOT);

	        putToKeywords(IdFilter.Companion.getNames() , QLangGrammarParser.ID);
	        putToKeywords(ProjectFilter.Companion.getNames(), QLangGrammarParser.PROJECT);
	        putToKeywords(TemplateFilter.Companion.getNames(), QLangGrammarParser.TEMPLATE);
	        putToKeywords(ParentFilter.Companion.getNames(), QLangGrammarParser.PARENT);
	        putToKeywords(TriggerFilter.Companion.getNames(), QLangGrammarParser.TRIGGER);
	        putToKeywords(StepFilter.Companion.getNames(), QLangGrammarParser.STEP);
	        putToKeywords(FeatureFilter.Companion.getNames(), QLangGrammarParser.FEATURE);
	        putToKeywords(TypeFilter.Companion.getNames(), QLangGrammarParser.TYPE);
	        putToKeywords(ParameterFilter.Companion.getNames(), QLangGrammarParser.PARAM);
	        putToKeywords(ValueFilter.Companion.getNames(), QLangGrammarParser.VAL);
	        putToKeywords(EnabledFilter.Companion.getNames(), QLangGrammarParser.ENABLED);
	        putToKeywords(AncestorFilter.Companion.getNames(), QLangGrammarParser.ANCESTOR);
	        putToKeywords(RulesFilter.Companion.getNames(), QLangGrammarParser.RULES);
	        putToKeywords(DependencyFilter.Companion.getNames(), QLangGrammarParser.DEPENDENCY);
	        putToKeywords(ArtifactFilter.Companion.getNames(), QLangGrammarParser.ARTIFACT);
	        putToKeywords(SnapshotFilter.Companion.getNames(), QLangGrammarParser.SNAPSHOT);
	        putToKeywords(WithInheritedFilterModifier.Companion.getNames(), QLangGrammarParser.WITH_INHERITED);
	        putToKeywords(OptionFilter.Companion.getNames(), QLangGrammarParser.OPTION);
	        putToKeywords(CleanFilter.Companion.getNames(), QLangGrammarParser.CLEAN);
	        putToKeywords(RevRuleFilter.Companion.getNames(), QLangGrammarParser.REV_RULE);
	        putToKeywords(VcsRootEntryFilter.Companion.getNames(), QLangGrammarParser.VCS_ENTRY);
	        putToKeywords(NameFilter.Companion.getNames(), QLangGrammarParser.NAME);
	        putToKeywords(ResolvedFilterModifier.Companion.getNames(), QLangGrammarParser.RESOLVED);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0092\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\5\16U\n\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\7\23h\n\23\f\23\16\23k\13\23\3\23\3\23"+
		"\3\24\3\24\3\24\6\24r\n\24\r\24\16\24s\3\24\3\24\3\25\3\25\3\25\5\25{"+
		"\n\25\3\26\3\26\5\26\177\n\26\3\26\3\26\3\27\3\27\3\27\5\27\u0086\n\27"+
		"\3\27\3\27\3\30\3\30\3\31\6\31\u008d\n\31\r\31\16\31\u008e\3\31\3\31\2"+
		"\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\33\2\35"+
		"\2\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\61\25\3\2\b\3\2\62;\3\2c|\3\2"+
		"C\\\5\2\13\f\17\17\"\"\5\2\13\f\17\17$$\4\2/\60aa\2\u0096\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\3\63\3\2\2\2\58\3\2\2\2\7:\3\2\2\2\t=\3\2\2\2\13B\3\2\2\2\rD\3"+
		"\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31"+
		"P\3\2\2\2\33T\3\2\2\2\35V\3\2\2\2\37X\3\2\2\2![\3\2\2\2#_\3\2\2\2%c\3"+
		"\2\2\2\'q\3\2\2\2)w\3\2\2\2+~\3\2\2\2-\u0082\3\2\2\2/\u0089\3\2\2\2\61"+
		"\u008c\3\2\2\2\63\64\7h\2\2\64\65\7k\2\2\65\66\7p\2\2\66\67\7f\2\2\67"+
		"\4\3\2\2\289\7.\2\29\6\3\2\2\2:;\7k\2\2;<\7p\2\2<\b\3\2\2\2=>\7y\2\2>"+
		"?\7k\2\2?@\7v\2\2@A\7j\2\2A\n\3\2\2\2BC\7*\2\2C\f\3\2\2\2DE\7+\2\2E\16"+
		"\3\2\2\2FG\7?\2\2G\20\3\2\2\2HI\7]\2\2I\22\3\2\2\2JK\7_\2\2K\24\3\2\2"+
		"\2LM\t\2\2\2M\26\3\2\2\2NO\t\3\2\2O\30\3\2\2\2PQ\t\4\2\2Q\32\3\2\2\2R"+
		"U\5\31\r\2SU\5\27\f\2TR\3\2\2\2TS\3\2\2\2U\34\3\2\2\2VW\t\5\2\2W\36\3"+
		"\2\2\2XY\7q\2\2YZ\7t\2\2Z \3\2\2\2[\\\7c\2\2\\]\7p\2\2]^\7f\2\2^\"\3\2"+
		"\2\2_`\7p\2\2`a\7q\2\2ab\7v\2\2b$\3\2\2\2ci\7$\2\2dh\n\6\2\2ef\7$\2\2"+
		"fh\7$\2\2gd\3\2\2\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2"+
		"ki\3\2\2\2lm\7$\2\2m&\3\2\2\2nr\5\33\16\2or\5\25\13\2pr\t\7\2\2qn\3\2"+
		"\2\2qo\3\2\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\b\24"+
		"\2\2v(\3\2\2\2wz\7,\2\2x{\5\'\24\2y{\5%\23\2zx\3\2\2\2zy\3\2\2\2{*\3\2"+
		"\2\2|\177\5\'\24\2}\177\5%\23\2~|\3\2\2\2~}\3\2\2\2\177\u0080\3\2\2\2"+
		"\u0080\u0081\7,\2\2\u0081,\3\2\2\2\u0082\u0085\7,\2\2\u0083\u0086\5\'"+
		"\24\2\u0084\u0086\5%\23\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\7,\2\2\u0088.\3\2\2\2\u0089\u008a\7,\2\2\u008a"+
		"\60\3\2\2\2\u008b\u008d\t\5\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2"+
		"\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\b\31\3\2\u0091\62\3\2\2\2\f\2Tgiqsz~\u0085\u008e\4\3\24\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}