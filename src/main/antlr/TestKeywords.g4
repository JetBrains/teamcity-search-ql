lexer grammar TestKeywords;

fragment DIGIT: [0-9] ;
fragment LLET: [a-z] ;
fragment ULET: [A-Z] ;
fragment LET: ULET | LLET ;
fragment WSP: [ \t\r\n] ;


OR : 'or' ;
AND: 'and';
NOT: 'not';

ID : 'id' ;
PROJECT : 'project' ;
TEMPLATE : 'template' ;
BUILD_CONFIGURATION : 'buildConfiguration' ;
VCS_ROOT : 'vcsRoot' ;
PARENT : 'parent' ;
TRIGGER : 'trigger' ;
STEP : 'step' ;
FEATURE : 'feature' ;
TYPE : 'type' ;
PARAM : 'param' ;
VAL : 'val' ;
ENABLED : 'enabled' ;
ANCESTOR : 'ancestor' ;
ANCESTOR_OR_SELF : 'ancestorOrSelf' ;
RULES : 'rules' ;
DEPENDENCY : 'dependency' ;
ARTIFACT : 'artifact' ;
SNAPSHOT : 'snapshot' ;
ALL : 'all' ;

STRING: '"' (~[\t\r\n"] | '""')* '"';
IDENT: (LET | DIGIT | '_' | '.' | '-')+;

SUFFIXS : '*' (IDENT | STRING) ;
PREFIXS : (IDENT | STRING) '*' ;
SUBSTRINGS : '*' (IDENT | STRING) '*' ;
WS : [ \t\r\n]+ -> skip ;