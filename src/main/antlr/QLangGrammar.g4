grammar QLangGrammar;
import Keywords;

@parser::header {
    package jetbrains.buildServer.server.querylang.parser;
}

start: (find | partialQuery) EOF ;

and : AND ;
or : OR ;
not: NOT ;

objectId : IDENT ;
objectType : IDENT ;
parameterValue : STRING;

vcsRootKeyword : VCS_ROOT;
buildConfKeword : BUILD_CONF ;
projectKeword : PROJECT ;
templateKeyword : TEMPLATE;

partialQuery : condition ;

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

idFilter : ID objectId;
projectFilter : PROJECT filterOrCondition;
parentFilter : PARENT filterOrCondition ;
triggerFilter : TRIGGER filterOrCondition ;
stepFilter : STEP filterOrCondition ;
featureFilter : FEATURE filterOrCondition ;
typeFilter : TYPE objectType ;
parameterFilter : PARAM  parameterName=IDENT '=' parameterValue ;
parValueFilter : VAL parameterValue ;
enabledFilter : ENABLED;
ancestorFilter : ANCESTOR filterOrCondition;
ancestorOrSelfFilter : ANCESTOR_OR_SELF filterOrCondition ;
templateDepFilter : TEMPLATE filterOrCondition ;
