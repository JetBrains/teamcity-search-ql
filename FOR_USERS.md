Search query language plugin
----------------------------

This plugin implements a search for objects in TeamCity project model. 
The functionality is only available for system administrator and project admins via the `Search` tab in the administration menu.
Currently it supports searching 4 types of objects: projects, build configurations, build configuration templates and VCS roots.

**Please note that this is a draft of the documentation.**

#### Query

A **query** has the following structure:  
`find <Object to search> with <condition on object>`

An **object** is one of the following entities: `project`, `configuration`, `template` or `vcsRoot`

A **condition** is a logical expression on filters with logical operators: `and`, `or` and `not`.  
For example: `id ID1 and (type TYPE1 or type TYPE2)`

A **filter** consists of a name and a body(filters on strings is an exception).
For almost all filters a body is a **condition**, but for parameters it has the following form: `<string_condition> = <string_condition>`.  
If a filter has just a single filter as a condition than the brackets can be omitted as in `trigger type vcsTrigger`. 
Otherwise, the brackets are required as in `trigger (type vcsTrigger and param path=abc)`

Filter examples:  
`id Project1` - id filter with a simple string condition (id == "Project1");  
`id (Project1 or Project2)` - id filter with a compound string condition;  
`param path = abc` - parameter filter, accepts parameters with name "path" and value "abc";
`param (path or url) = (abc or def)` - the same but with composite conditions on both a name and a value of the paramter.

Also a filter keyword may be followed by some modifiers, for example `find configuration with step[all, withInherited] type JPS`.
The `all` modifier states that all sub-objects (in this case all build steps of a build configuration) should satisfy the condition, 
and at least one such sub-object should be present.

And `withInherited` modifier states that sub-objects (again, here, - build steps) inherited from a template also should be taken in the consideration.
So this query will return build configurations, that have at least one steps, and all steps (including the inherited ones) should have the type `JPS`.
 
The string filters may either express an exact match (as in `path`) or use a wildcard with the usual meaning "any symbols" 
(as in `path*`, `*path`, `*path*`, `*`). The latter wildcard syntax is limited at the moment and does not allow the use of 
asterisks in the middle of the value. 

By default, all comparisons are case-insensitive, if you want the case match too, add `^` before the string filter (e.g `^*Project1` will match strings 
that end exactly with string "Project1").

If a string has a special symbol, then it should be surrounded by `"`.
String could be used without double quotes, if it consists only of the following symbols: [A-Z], [a-z], ".", "-", "_".
The `"` should be escaped by another `"` inside of the string.  

For example:  
`name "Project@1"` - filter for object with name `Project@1`;  
`type *"simple:t"*` -- filter for object with type name that contains substring `simple:t`;  
`id ^*"project"*` -- filter for object with id that contains substring `project` (case sensitive).  

#### Examples:
`find project with id Project1` - find all projects (not more than one in this case) with external id equals to Project1;

`find vcsRoot with type jetbrains.git` - find vcs roots with type `jetbrains.git`;

`find template with parent id Project1` - find all templates that belong to the project with id `Project1`;

`find configuration with project id Project1 and trigger type vcsRoot` - find build configurations that lie in the subtree of a project with an id Project1 and has at least one trigger with the type vcsRoot;

`find configuration with project (id Project1 and not id Project1_Tests)` - find build configurations that lie in the subtree of a project with an id `Project1`, but not within its sub-project `Project1_Tests`

`find configuration with step[all] type gradle-runner` - find build configurations that have at least one step and all its steps have type `gradle-runner`.

#### Important default behaviour
1) If a filter on some OBJECT allows for the `all` modifier, then by default if at least one sub-objects matches the condition, then the OBJECT is accepted.
2) If a filter on some OBJECT allows for the `withInherited` modifier, then by default no inherited settings will be considered. 
If a setting is inherited but overridden in the build configuration, it will be considered though. 
3) All string comparisons are case insensitive by default. To make a string filter case sensetive, put a `^` before it(e.g. `^ Project1` or `^Project1` or `^ *Project*`)

#### Filters description

Filters are occured in some condition, lets call an object that this condition filters an OBJECT. 
For example in query `find configuration with trigger (type vcsTrigger and param path=abc)` for filter `trigger` OBJECT will be a build configuration. 
And for filter `type`(and for filter `param`) OBJECT will be a build trigger.
And let CONDITION be the condition for the described filter. E.g. in the example above condition for filter `trigger` will be `type vcsTrigger and param path=abc`

* **id** - contains a condition on string. States that OBJECT should have an id that satisfies the CONDITION.  
  *example:* `find project with id Project1`
* **configuration** - contains a condition on build configuration. States that OBJECT should have a configuration that satisfies the CONDITION.  
  *example:* `find project with configuration[all] trigger type vcsTrigger` - find projects that have at least one defined configuration and all configurations have trigger with type `vcsTrigger`
* **project** - contains a condition on project. States that OBJECT should lie in the subtree of some project that satisfies the CONDITION  
  *example:* `find configuration with project id Project1` - find configurations that lies in the subtree of project with id `Project1`
* **vcsRoot** - contains a condition on vcs root(for projects). States that there should be a vcs root defined in the OBJECT(only project is possible in this case) and that vcs root should satisfy the condition.  
  *example:* `find project with vcsRoot id Project1_Vcs1`
* **vcs** - contains a condition on vcs root settings(for build configurations and templates). So there could be filters on vcs root and checkout rules in the condition.  
  *example:* `find configuration with vcs id Project1_Vcs1`
* **template** - contains a condition on build configuration template. If OBJECT is a project, then states that tempalte that satisfies the condition should be definded in the OBJECT. If OBJECT is configuration, then states that OBJECT should inherit settings from such template  
  *example:* `find configuration with template trigger[all] type vcsTrigger`
* **parent** - contains a condition on project. States that the OBJECT should have a parent project that satisfies the CONDITION.  
  *example:* `find configuration with parent id Project1`
* **trigger** - contains a condition on build trigger. States that the OBJECT should have a build trigger that satisfies the CONDITION.  
  *example:* `find configuration with trigger type vcsTrigger`
* **step** - contains a condition on build step. States that the OBJECT should have a build step that satisfies the CONDITION  
  *example:* `find configuration with step type JPS`
* **feature** - contains a condition on build feature. States that the OBJECT should have a build feature that satisfies the CONDITION.  
  *example:* `find template with feature type golang`
* **value** - contains a condition on string. States that the OBJECT should have a string field(parameter value, option value, checkout rules, etc.) that satisfies the CONDITION.  
  *example:* `find configuration with val *path*`
* **type:** - contains a condition on string. States that the OBJECT should have type that satisfies the CONDITION  
  *example:* `find configuration with trigger type vcsTrigger`
* **enabled** - States that the OBJECT should be enabled  
  *example:* `find configuration with trigger (type vcsTrigger and enabled)`
* **param** - contains a condition on parameter(STRING_CONDITION = STRING_CONDITION). States that the OBJECT should have a parameter that satisfies the CONDITION.  
  *example:* `find project with param path = abc`
* **ancestor** - contains a condition on project. States that the OBJECT(project) should have an ancestor(not including itself) that satisfies the CONDITION.  
  *example:* `find configuration with parent ancestor id Project1`
* **rules** - contains a filter on string. Depends on context, could be about artifact rules or checkout rules.  
* **dependency** - `dependency` is an object that contains all artifact dependencies on a particular build configuration and snapshot dependency(if there is one) on the same configuration. So this filter can contain the same subfilters as `configuration` filter(id, trigger, template, etc.) and also can `artifact` or `snapshot` subfilters.  
  *example:* `find configuration with dependency (trigger type vcsTrigger and snapshot and artifact)` - finds all configurations with dependency(snapshot and artifact at the same time) on configuration with trigger type vcsTrigger. In this case `snapshot` and `artifact` don't contain any condition and that means just that there should be dependencies of both types on a configuration.
* **artifact** - can only be a subfilter of `dependency` filter. If it has no condition just states that there should be an artifact dependency. But can contain a condition on artifact dependency properties(artifact rules, revision rules)  
  *example:* `find configuration with dependency artifact rules "=>"`
* **snapshot** - can only be a subfilter of `dependency` filter. If it has no condition just states that there should be a snapshot dependency. But can contains a condition on snapshot dependency(option)  
  *example:* `find template with dependency snapshot option sync-revisions=true`
* **clean** - can only be a subfilter of `artifact` filter. States that the option "Clean destination paths before downloading artifacts" should be selected.  
  *example:* `find configuration with dependency artifact clean`
* **revRule** - can only be a subfilter of `artifact` filter. Contains a condition on string. States that artifact dependency should contain a revision rule(the build to choose from, `the latest build`, `last sucessful`, etc) that satisfies the CONDITION.  
  *example:* `find configuration with dependency artifact revRule lastSuccessful`
* **option** - contains a condition on parameter(STRING_CONDITION = STRING_CONDITION). States that the OBJECT should have an option that satisfies the CONDITION.  
  *example:* `find configuration with option cleanBuild=true`
* **name** - contains a condition on string. States that the OBJECT should have a name that satisfies the CONDITION.  
  *example:* `find project with name (BaseProject_* or *Project1)`
* **subProject** - contains a filter on project. Can only be a `project` subfilter. States that project should have a subproject that satisfies the CONDITION.  
  *example:* `find project with subproject id *Project1`

#### Autocompletion

The plugin provides two types of the autcompltion: real time autocompletion and context autocompletion. Real time autcompletion is suggesting variants while you typing the query.
The full real time autocompletion is available only for system administator. And for project admins autocompletion is disabled for all parameter values, ids, names and parameter names of configurations, projects and templates.  
And the context autocompletion is available for everyone. To call this autocompletion put the `?` in the end of the query and it will suggest only variants that are possible in this context(but there are some exceptions).  
Example: `find configuration with parent (id Project1 or id Project2) and trigger type ?`, for this query only trigger types, that are presented in configurations that belong to project with id Project1 or id Project2, will be suggested.  
But if there is `not` operator or `all` modifier on the path to the `?` than suggested variants will depend only on the part of the context. In the case of `not` variants would depend on the context with branch that contains `not` removed.
So for example for `find configuration with parent (id Project1 or id Project2) and not (trigger type vcsTrigger and step type ?` autocompletion will consider only `parent (id Project1 or id Project2)` context.  
And in the `all` modifier case it is not guaranteed that all objects would contain suggested value, 
so for example for the query `find configuration with trigger[all] type ?` not all triggers may be of the suggested type.

#### Permissions

You can search only objects(projects, configurations, templates vcs roots) to which you have an edit permission or view settings permission.
So for example system admin will see the results for objects from the whole server and project admin of project PROJECT1 can only see objects from the subtree of this project.
The same applies to the variants suggested in the context autocompletion.