#### Creating filters

**Please note that this is an early draft of the documentation.**

TLDR  
1) Create filter class in `fitlers.kt`(create `Names` companion object, override `buildFrom` method)
2) Add new token in `Keywords.g4`(see `@lexer::members` and `tokens` there)
3) Create a new filter rule in `QLangGrammar.g4`(see `filter` rule)
4) Generate a parser with new filter(task `generateGrammarSource` in gradle)
5) Override method in the `FilterVisitor.kt` which has the same name as the rules in the `QLangGrammar.g4`
6) Register new filter in the `FilterRegistration.kt`

All filter classes are defined in `filters.kt`. All filters should implement `Filter<T>` interface.
Where `T` is the object that current filter filters. Also each filter should contain a companion object of type `Names` and propertie names - the possible names for the filter.
there is usually one name for the filter, but as an example there is two names in BuildConfFilter. Only the first name is shown in the autocompletion.  
Most filters(in fact all except the string filters) contain a condition. For example `IdFilter` contains a condition on string and `TriggerFilter` contains a condition on trigger properties(type, parametes, etc).
So the most filters are inherited from the `ConditionFilter` abstract class(may be not directly). In `abstractFilters.kt` there is some `ConditionFilter` subclusses that override some methods.  

`ConditionFilter` has two types parameters: `Obj` and `NestedObj`. `Obj` is the type of object that we filter(the same as for `Filter` interface) and `NestedObj` is the type of the object in condition.
For example `IdFilter` is inherited from a `ConditionContainer<IdContainer, String>` because it filters only objects that have an id(`IdContainer`) and the filter contains condition on string(thats why the second parameter is String).
And also for the most filters new interface should be created and objects that you want to be filtered with this filter should implement this interface.
For example for `TriggerFilter` `FTriggerContainer` interface was created and WBuildConf and WTemplate implement this interface.

Each filter inherited from `ConditionFilter` should implement the following methods: `buildFrom` and `buildVisitorFrom`.  
`buildFrom` is a method returning a `RealObjectFilter`, which takes an object and accepts or declines it(with method `accepts`). There is a lot of examples of how to implement this method.
`buildVisitFrom` usually is the same as buildFrom, but filters that could have `all` modifier should override it(may be there will be more cases). And it is already overriden in `MultipleObjectsConditionFilter` and `SingleObjectConditionFilter`.
So filters should be inherited from this classes instead. If the filter is on the single object(e.g. type - object can have only one type) then inherit from `SingleObjectConditionFilter` and if object can contain multiple subobjects(e.g. trigger - configuration could contain multiple triggers) then inherit from `MultipleObjectsConditionFilter`.

Filters can also have a modifiers. See `FilterModifiers.kt`. Modifiers should also be registered in `FilterRegistration.kt`

Context autocompletion should work out of the box, real time autocompletion for filter names will work too. And if you want to add new real time autocompletion for some values see `CompletionManager.kt`