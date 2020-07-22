grammar QLangGrammar;

@header {
    package jetbrains.buildServer.server.querylang.parser;
}

fragment DIGIT: [0-9] ;
fragment LLET: [a-z] ;
fragment ULET: [A-Z] ;
fragment LET: ULET | LLET ;
fragment WSP: [ \t\r\n] ;


PROJECT : 'project' ;
BUILD_CONF : 'buildConf' ;
TEMPLATE : 'template' ;
VCS_ROOT : 'vcsRoot' ;
OR : 'or' ;
AND: 'and';
NOT: 'not';

STRING: '"' (~[\t\r\n"])+? '"';
IDENT: (LET | DIGIT | '_' | '.')+ ;
WS : [ \t\r\n]+ -> skip ;

start: find EOF ;

and : AND ;
or : OR ;
not: NOT ;

objectId : IDENT ;
objectType : IDENT ;
parameterValue : STRING;

vcsRootKeyword : VCS_ROOT;
buildConfKeword : BUILD_CONF;
projectKeword : PROJECT;
templateKeyword : TEMPLATE;

find: 'find' multipleObjects conditionInSubproject;
multipleObjects : objectKeyword (',' objectKeyword)*;
objectKeyword : projectKeword
              | templateKeyword
              | buildConfKeword
              | vcsRootKeyword
              ;

conditionInSubproject : (('in' objectId)? 'with' condition | 'in' objectId) ;

filter : idFilter
       | projectFilter
       | parentFilter
       | triggerFilter
       | stepFilter
       | featureFilter
       | typeFilter
       | parameterFilter
       | parValueFilter
       | enabledFilter
       | ancestorFilter
       | ancestorOrSelfFilter
       | templateDepFilter
       ;

condition : filter                     #conditionFilter
          | '(' condition ')'          #conditionBraces
          | not condition              #conditionNot
          | condition and condition    #conditionAnd
          | condition or condition     #conditionOr
          ;

filterOrCondition : filter               #singleFilter
                  | '(' condition ')'    #multFilter
                  ;

idFilter : 'id' objectId;
projectFilter : 'project' filterOrCondition;
parentFilter : 'parent' filterOrCondition ;
triggerFilter : 'trigger' filterOrCondition ;
stepFilter : 'step' filterOrCondition ;
featureFilter : 'feature' filterOrCondition ;
typeFilter : ('type') objectType ;
parameterFilter : ('param')  parameterName=IDENT '=' parameterValue ;
parValueFilter : ('val') parameterValue ;
enabledFilter : 'enabled';
ancestorFilter : 'ancestor' filterOrCondition;
ancestorOrSelfFilter : 'ancestorOrSelf' filterOrCondition ;
templateDepFilter : 'template' filterOrCondition ;
