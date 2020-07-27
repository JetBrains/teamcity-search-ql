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
		ANCESTOR_OR_SELF=15, OR=16, AND=17, NOT=18, STRING=19, IDENT=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LLET", "ULET", "LET", "WSP", "OR", "AND", "NOT", "STRING", 
			"IDENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27I\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\"\n\5\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\7\n\63\n\n\f\n\16\n\66\13"+
		"\n\3\n\3\n\3\13\3\13\3\13\6\13=\n\13\r\13\16\13>\3\13\3\13\3\f\6\fD\n"+
		"\f\r\f\16\fE\3\f\3\f\3\64\2\r\3\2\5\2\7\2\t\2\13\2\r\22\17\23\21\24\23"+
		"\25\25\26\27\27\3\2\b\3\2\62;\3\2c|\3\2C\\\5\2\13\f\17\17\"\"\5\2\13\f"+
		"\17\17$$\4\2\60\60aa\2I\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2"+
		"\t!\3\2\2\2\13#\3\2\2\2\r%\3\2\2\2\17(\3\2\2\2\21,\3\2\2\2\23\60\3\2\2"+
		"\2\25<\3\2\2\2\27C\3\2\2\2\31\32\t\2\2\2\32\4\3\2\2\2\33\34\t\3\2\2\34"+
		"\6\3\2\2\2\35\36\t\4\2\2\36\b\3\2\2\2\37\"\5\7\4\2 \"\5\5\3\2!\37\3\2"+
		"\2\2! \3\2\2\2\"\n\3\2\2\2#$\t\5\2\2$\f\3\2\2\2%&\7q\2\2&\'\7t\2\2\'\16"+
		"\3\2\2\2()\7c\2\2)*\7p\2\2*+\7f\2\2+\20\3\2\2\2,-\7p\2\2-.\7q\2\2./\7"+
		"v\2\2/\22\3\2\2\2\60\64\7$\2\2\61\63\n\6\2\2\62\61\3\2\2\2\63\66\3\2\2"+
		"\2\64\65\3\2\2\2\64\62\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7$\2\2"+
		"8\24\3\2\2\29=\5\t\5\2:=\5\3\2\2;=\t\7\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2"+
		"\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\b\13\2\2A\26\3\2\2\2BD\t"+
		"\5\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\b\f\3\2H\30"+
		"\3\2\2\2\b\2!\64<>E\4\3\13\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}