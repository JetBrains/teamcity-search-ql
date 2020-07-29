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
		PROJECT=1, TEMPLATE=2, BUILD_CONFIGURATION=3, VCS_ROOT=4, ID=5, PARENT=6, 
		TRIGGER=7, STEP=8, FEATURE=9, TYPE=10, PARAM=11, VAL=12, ENABLED=13, ANCESTOR=14, 
		ANCESTOR_OR_SELF=15, OR=16, AND=17, NOT=18, STRING=19, IDENT=20, SUFFIXS=21, 
		PREFIXS=22, SUBSTRINGS=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LLET", "ULET", "LET", "WSP", "OR", "AND", "NOT", "STRING", 
			"IDENT", "SUFFIXS", "PREFIXS", "SUBSTRINGS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'or'", "'and'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROJECT", "TEMPLATE", "BUILD_CONFIGURATION", "VCS_ROOT", "ID", 
			"PARENT", "TRIGGER", "STEP", "FEATURE", "TYPE", "PARAM", "VAL", "ENABLED", 
			"ANCESTOR", "ANCESTOR_OR_SELF", "OR", "AND", "NOT", "STRING", "IDENT", 
			"SUFFIXS", "PREFIXS", "SUBSTRINGS", "WS"
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
	        putToKeywords(SProjectFilter.Companion.getNames(), QLangGrammarParser.PROJECT);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32a\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\5\5(\n\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\7\n9\n\n\f\n\16\n<\13\n\3\n\3\n\3\13\3\13\3\13\6\13C\n\13\r\13\16\13"+
		"D\3\13\3\13\3\f\3\f\3\f\5\fL\n\f\3\r\3\r\5\rP\n\r\3\r\3\r\3\16\3\16\3"+
		"\16\5\16W\n\16\3\16\3\16\3\17\6\17\\\n\17\r\17\16\17]\3\17\3\17\3:\2\20"+
		"\3\2\5\2\7\2\t\2\13\2\r\22\17\23\21\24\23\25\25\26\27\27\31\30\33\31\35"+
		"\32\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\"\"\5\2\13\f\17\17$$\4\2"+
		"/\60aa\2d\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2"+
		"\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2"+
		"\5!\3\2\2\2\7#\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2\r+\3\2\2\2\17.\3\2\2\2"+
		"\21\62\3\2\2\2\23\66\3\2\2\2\25B\3\2\2\2\27H\3\2\2\2\31O\3\2\2\2\33S\3"+
		"\2\2\2\35[\3\2\2\2\37 \t\2\2\2 \4\3\2\2\2!\"\t\3\2\2\"\6\3\2\2\2#$\t\4"+
		"\2\2$\b\3\2\2\2%(\5\7\4\2&(\5\5\3\2\'%\3\2\2\2\'&\3\2\2\2(\n\3\2\2\2)"+
		"*\t\5\2\2*\f\3\2\2\2+,\7q\2\2,-\7t\2\2-\16\3\2\2\2./\7c\2\2/\60\7p\2\2"+
		"\60\61\7f\2\2\61\20\3\2\2\2\62\63\7p\2\2\63\64\7q\2\2\64\65\7v\2\2\65"+
		"\22\3\2\2\2\66:\7$\2\2\679\n\6\2\28\67\3\2\2\29<\3\2\2\2:;\3\2\2\2:8\3"+
		"\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7$\2\2>\24\3\2\2\2?C\5\t\5\2@C\5\3\2\2AC"+
		"\t\7\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E"+
		"F\3\2\2\2FG\b\13\2\2G\26\3\2\2\2HK\7,\2\2IL\5\25\13\2JL\5\23\n\2KI\3\2"+
		"\2\2KJ\3\2\2\2L\30\3\2\2\2MP\5\25\13\2NP\5\23\n\2OM\3\2\2\2ON\3\2\2\2"+
		"PQ\3\2\2\2QR\7,\2\2R\32\3\2\2\2SV\7,\2\2TW\5\25\13\2UW\5\23\n\2VT\3\2"+
		"\2\2VU\3\2\2\2WX\3\2\2\2XY\7,\2\2Y\34\3\2\2\2Z\\\t\5\2\2[Z\3\2\2\2\\]"+
		"\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\17\3\2`\36\3\2\2\2\13\2\':"+
		"BDKOV]\4\3\13\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}