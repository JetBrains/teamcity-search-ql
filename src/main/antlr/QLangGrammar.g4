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
                 | ENABLED | ANCESTOR | ANCESTOR_OR_SELF | RULES | DEPENDENCY
                 | ARTIFACT | SNAPSHOT | ALL
                 ;
identOrString : IDENT | STRING | filterKeyword;

objectId : stringFilterOrCondition ;
objectType : identOrString ;
parameterValue : stringFilterOrCondition;
parameterName : identOrString;
checkoutRulesString : stringFilterOrCondition ;

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
       | vcsRootFilter
       | checkoutRulesFilter
       | dependencyFilter
       | artifactFilter
       | snapshotFilter
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
projectFilter : PROJECT modifierList? filterOrCondition ;
parentFilter : PARENT modifierList? filterOrCondition ;
triggerFilter : TRIGGER modifierList? filterOrCondition ;
stepFilter : STEP modifierList? filterOrCondition ;
featureFilter : FEATURE modifierList? filterOrCondition ;
typeFilter : TYPE modifierList? objectType ;
parameterFilter : PARAM modifierList?  parameterName '=' parameterValue ;
parValueFilter : VAL modifierList? parameterValue ;
enabledFilter : ENABLED modifierList?;
ancestorFilter : ANCESTOR modifierList? filterOrCondition ;
ancestorOrSelfFilter : ANCESTOR_OR_SELF modifierList? filterOrCondition ;
templateDepFilter : TEMPLATE modifierList? filterOrCondition ;
vcsRootFilter : VCS_ROOT modifierList? filterOrCondition ;
checkoutRulesFilter : RULES modifierList? checkoutRulesString ;
dependencyFilter : DEPENDENCY modifierList? filterOrCondition ;
artifactFilter : ARTIFACT modifierList?;
snapshotFilter : SNAPSHOT modifierList?;


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


filterModifier : allModifier ;
modifierList : '[' filterModifier (',' filterModifier)*? ']' ;


allModifier : ALL ;