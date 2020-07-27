lexer grammar Keywords;

@lexer::header {
package jetbrains.buildServer.server.querylang.parser;

import jetbrains.buildServer.server.querylang.ast.*;
import java.util.*;
}

@lexer::members {
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
}

tokens {
       PROJECT, TEMPLATE,
       ID, PARENT, TRIGGER, STEP, FEATURE, TYPE, PARAM, VAL,
       ENABLED, ANCESTOR, ANCESTOR_OR_SELF
}

fragment DIGIT: [0-9] ;
fragment LLET: [a-z] ;
fragment ULET: [A-Z] ;
fragment LET: ULET | LLET ;
fragment WSP: [ \t\r\n] ;


BUILD_CONF : 'buildConfiguration' ;
VCS_ROOT : 'vcsRoot' ;
OR : 'or' ;
AND: 'and';
NOT: 'not';

STRING: '"' (~[\t\r\n"])*? '"';
IDENT: (LET | DIGIT | '_' | '.')+
{
   if ( keywords.containsKey(getText()) ) {
       setType(keywords.get(getText()));
   }
}
;
WS : [ \t\r\n]+ -> skip ;

