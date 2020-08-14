lexer grammar Keywords;

@lexer::header {
package jetbrains.buildServer.server.querylang.parser;

import jetbrains.buildServer.server.querylang.ast.*;
import java.util.*;
}

@lexer::members {
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
        putToKeywords(AllFilterModifier.Companion.getNames(), QLangGrammarParser.ALL);
        putToKeywords(OptionFilter.Companion.getNames(), QLangGrammarParser.OPTION);
        putToKeywords(CleanFilter.Companion.getNames(), QLangGrammarParser.CLEAN);
        putToKeywords(RevRuleFilter.Companion.getNames(), QLangGrammarParser.REV_RULE);
        putToKeywords(VcsRootEntryFilter.Companion.getNames(), QLangGrammarParser.VCS_ENTRY);
    }

    private void putToKeywords(List<String> filterNames, Integer tokenType) {
        filterNames.forEach(name -> {
            keywords.put(name, tokenType);
        });
    }
}

tokens {
       PROJECT, TEMPLATE, BUILD_CONFIGURATION, VCS_ROOT,
       ID, PARENT, TRIGGER, STEP, FEATURE, TYPE, PARAM, VAL,
       ENABLED, ANCESTOR, RULES, DEPENDENCY,
       ARTIFACT, SNAPSHOT, ALL, OPTION, CLEAN, REV_RULE, VCS_ENTRY
}

fragment DIGIT: [0-9] ;
fragment LLET: [a-z] ;
fragment ULET: [A-Z] ;
fragment LET: ULET | LLET ;
fragment WSP: [ \t\r\n] ;


OR : 'or' ;
AND: 'and';
NOT: 'not';

STRING: '"' (~[\t\r\n"] | '""')* '"';
IDENT: (LET | DIGIT | '_' | '.' | '-')+
{
   if ( keywords.containsKey(getText()) ) {
       setType(keywords.get(getText()));
   }
}
;

SUFFIXS : '*' (IDENT | STRING) ;
PREFIXS : (IDENT | STRING) '*' ;
SUBSTRINGS : '*' (IDENT | STRING) '*' ;
WS : [ \t\r\n]+ -> skip ;

