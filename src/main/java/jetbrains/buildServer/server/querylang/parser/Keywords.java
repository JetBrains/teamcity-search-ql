// Generated from Keywords.g4 by ANTLR 4.8

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
		PROJECT=1, TEMPLATE=2, BUILD_CONFIGURATION=3, VCS_ROOT=4, ID=5, PARENT=6, 
		TRIGGER=7, STEP=8, FEATURE=9, TYPE=10, PARAM=11, VAL=12, ENABLED=13, ANCESTOR=14, 
		RULES=15, DEPENDENCY=16, ARTIFACT=17, SNAPSHOT=18, WITH_INHERITED=19, 
		OPTION=20, CLEAN=21, REV_RULE=22, VCS_ENTRY=23, NAME=24, RESOLVED=25, 
		ALL=26, OR=27, AND=28, NOT=29, STRING=30, IDENT=31, SUFFIXS=32, PREFIXS=33, 
		SUBSTRINGS=34, ANY_STRING=35, WS=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LLET", "ULET", "LET", "WSP", "OR", "AND", "NOT", "STRING", 
			"IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "ANY_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'or'", "'and'", "'not'", null, null, null, null, null, 
			"'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROJECT", "TEMPLATE", "BUILD_CONFIGURATION", "VCS_ROOT", "ID", 
			"PARENT", "TRIGGER", "STEP", "FEATURE", "TYPE", "PARAM", "VAL", "ENABLED", 
			"ANCESTOR", "RULES", "DEPENDENCY", "ARTIFACT", "SNAPSHOT", "WITH_INHERITED", 
			"OPTION", "CLEAN", "REV_RULE", "VCS_ENTRY", "NAME", "RESOLVED", "ALL", 
			"OR", "AND", "NOT", "STRING", "IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", 
			"ANY_STRING", "WS"
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
		case 9:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&g\b\1\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13"+
		"\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\5\5*\n\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\7\n=\n\n\f\n\16\n@\13\n\3\n\3\n\3\13\3\13\3\13\6\13G"+
		"\n\13\r\13\16\13H\3\13\3\13\3\f\3\f\3\f\5\fP\n\f\3\r\3\r\5\rT\n\r\3\r"+
		"\3\r\3\16\3\16\3\16\5\16[\n\16\3\16\3\16\3\17\3\17\3\20\6\20b\n\20\r\20"+
		"\16\20c\3\20\3\20\2\2\21\3\2\5\2\7\2\t\2\13\2\r\35\17\36\21\37\23 \25"+
		"!\27\"\31#\33$\35%\37&\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\"\"\5"+
		"\2\13\f\17\17$$\4\2/\60aa\2k\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t)\3\2\2\2\13+\3\2"+
		"\2\2\r-\3\2\2\2\17\60\3\2\2\2\21\64\3\2\2\2\238\3\2\2\2\25F\3\2\2\2\27"+
		"L\3\2\2\2\31S\3\2\2\2\33W\3\2\2\2\35^\3\2\2\2\37a\3\2\2\2!\"\t\2\2\2\""+
		"\4\3\2\2\2#$\t\3\2\2$\6\3\2\2\2%&\t\4\2\2&\b\3\2\2\2\'*\5\7\4\2(*\5\5"+
		"\3\2)\'\3\2\2\2)(\3\2\2\2*\n\3\2\2\2+,\t\5\2\2,\f\3\2\2\2-.\7q\2\2./\7"+
		"t\2\2/\16\3\2\2\2\60\61\7c\2\2\61\62\7p\2\2\62\63\7f\2\2\63\20\3\2\2\2"+
		"\64\65\7p\2\2\65\66\7q\2\2\66\67\7v\2\2\67\22\3\2\2\28>\7$\2\29=\n\6\2"+
		"\2:;\7$\2\2;=\7$\2\2<9\3\2\2\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2"+
		"?A\3\2\2\2@>\3\2\2\2AB\7$\2\2B\24\3\2\2\2CG\5\t\5\2DG\5\3\2\2EG\t\7\2"+
		"\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2"+
		"\2JK\b\13\2\2K\26\3\2\2\2LO\7,\2\2MP\5\25\13\2NP\5\23\n\2OM\3\2\2\2ON"+
		"\3\2\2\2P\30\3\2\2\2QT\5\25\13\2RT\5\23\n\2SQ\3\2\2\2SR\3\2\2\2TU\3\2"+
		"\2\2UV\7,\2\2V\32\3\2\2\2WZ\7,\2\2X[\5\25\13\2Y[\5\23\n\2ZX\3\2\2\2ZY"+
		"\3\2\2\2[\\\3\2\2\2\\]\7,\2\2]\34\3\2\2\2^_\7,\2\2_\36\3\2\2\2`b\t\5\2"+
		"\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\b\20\3\2f \3\2"+
		"\2\2\f\2)<>FHOSZc\4\3\13\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}