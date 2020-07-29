grammar QLangGrammar;
import Keywords;

@parser::header {
    package jetbrains.buildServer.server.querylang.parser;
}

start: (find | partialQuery) EOF ;

and : AND ;
or : OR ;
not: NOT ;

filterKeyword : PROJECT | TEMPLATE | BUILD_CONFIGURATION | VCS_ROOT
                 | PARENT | TRIGGER | STEP | FEATURE | TYPE | PARAM | VAL
                 | ENABLED | ANCESTOR | ANCESTOR_OR_SELF
                 ;
identOrString : IDENT | STRING | filterKeyword;

objectId : stringFilterOrCondition ;
objectType : identOrString ;
parameterValue : stringFilterOrCondition;
parameterName : identOrString;

vcsRootKeyword : VCS_ROOT;
buildConfKeword : BUILD_CONFIGURATION ;
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

stringFilterOrCondition : stringFilter             #singleStringFilter
                        | '(' stringCondition ')'  #multipleStringFilter
                        ;


idFilter : ID objectId ;
projectFilter : PROJECT filterOrCondition ;
parentFilter : PARENT filterOrCondition ;
triggerFilter : TRIGGER filterOrCondition ;
stepFilter : STEP filterOrCondition ;
featureFilter : FEATURE filterOrCondition ;
typeFilter : TYPE objectType ;
parameterFilter : PARAM  parameterName '=' parameterValue ;
parValueFilter : VAL parameterValue ;
enabledFilter : ENABLED ;
ancestorFilter : ANCESTOR filterOrCondition ;
ancestorOrSelfFilter : ANCESTOR_OR_SELF filterOrCondition ;
templateDepFilter : TEMPLATE filterOrCondition ;


stringCondition : stringFilter                         #stringConditionFilter
                | '(' stringCondition ')'              #stringConditionBraces
                | not stringCondition                  #stringConditionNot
                | stringCondition and stringCondition  #stringConditionAnd
                | stringCondition or stringCondition   #stringConditionOr
                ;

stringFilter : stringEqualsFilter
             | stringPrefixFilter
             | stringSuffixFilter
             | stringSubstringFilter
             ;

stringEqualsFilter : identOrString ;
stringPrefixFilter : PREFIXS ;
stringSuffixFilter : SUFFIXS ;
stringSubstringFilter : SUBSTRINGS ;
