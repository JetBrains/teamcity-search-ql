Search query language plugin
----------------------------

This plugin is used to search for objects in teamcity project tree. 
Plugin is only available for system administrator and project admins in the `Search` tab in the adminstration menu.
You can search 4 types of objects for now: projects, build configurations, build configuration templates and vcs roots.


#### Query

Query has the following structure:  
`find <Object to search> with <condition on object>`

Object is `project`, `configuration`, `template` or `vcsRoot`

Condition is a logical expression with filters and logical operators: `and`, `or` and `not`.  
For example: `id ID1 and (type TYPE1 or type TYPE2)`

Filter consists of a name and a body(filters on strings are exception).
For almost all filters body is a condition, but for parameters it has the following form: `<string_condition> = <string_condition>`.  
If filter has just a single filter as a condition than the braces can be omitted. Otherwise, the braces are required.
So with simple condition(=single subfilter) `trigger type vcsTrigger` and `trigger( type vcsTrigger )` are both possible 
and with composite condition only `trigger(type vcsTrigger and param path=abc)` is correct.  
Filter examples:  
`id Project1` - id filter with condition on string(in this case that string equals "Project1")  
`id (Project1 or Project2)` - in this case this is a composite condition on string -- id should be equal "Project1" or "Project2"  
`param path = abc` - parameter filter, accepts parameters with name "path" and value "abc"  
`param (path or url) = (abc or def)` - same but with composite conditions on name and value

Also a filter could have some modifiers, for example `find configuration with step[all, withInherited] type JPS`.
`all` modifier states tha all sub-objects(in this case all build steps) should satisfy condition. And also there should be at least one step.
And `withInherited` modifier states that sub-objects(again build steps) inherited from a template also should be taken in the consideration.
So this query will return build configurations, that have at least one steps, and all steps(including inherited) should have type `JPS`
 
There are 4 types of string filters:
1) exact match (e.g. `path`) 
2) prefix match (e.g. `path*`)
3) suffix match (e.g. `*path`)
4) any string (e.g. `*`)

and they could be combined in the condition of filters, that can contain string subfilters(e.g `id *project1`, `type vcs*`, `type (vcs* or *trigger)`, etc.)  
By default, all comparisons are case-insensitive, if you want the case match too, add `^` before the string filter(e.g `^*Project1` will match strings that end exactly with string "Project1")

If the string has a special symbol, then it should be surrounded by `"`.
String could be used without double quotes, if it consists only of the following symbols: [A-Z], [a-z], ".", "-", "_".
The `"` should be duplicated inside of the string.  
For example:  
`name "Project@1"` - filter for object with name `Project@1`  
`type *"simple:t"*` -- filter for object with type name that contains substring `simple:t`  
`id ^ *"project"*` -- filter for object with id that contains substring `project` and with the same letter case  
`param "long url" = *"/login.html"` -- filter for objects that has param `long url` and value of this parameter ends with `/login.html`

#### Examples:
`find project with id Project1` - find all projects(not more than one in this case) with external id equals to Project1

`find vcsRoot with type jetbrains.git` - find vcs roots with type `jetbrains.git`

`find template with parent id Project1` - find all templates that belong to the project with id `Project1`

`find configuration with project id Project1 and trigger type vcsRoot` - find build configuration that lies in the subtree of project with id Project1 and has at least one trigger with type vcsRoot

`find configuration with project ( (id Project1 or id Project2) and not id Project3 )` - find build configuration that lies in the subtree of project with id `Project1` or `Project2` and doesn't lie in the subtree of `Project3`

`find configuration with step[all] type gradle-runner` - find configuration that have at least one step and all(because of `all` modifier) its steps have type `gradle-runner`.

`find configuration with dependency (template (trigger[all] type vcsTrigger and step type JPS) and snapshot option path=abc and artifact[all] rules "** =>")` -
find configuration that have a dependency(if not specified, then any dependency. See `dependency` filter description) on another configuration, that inherits all settings from a template, that has all triggers with type vcsTrigger and has at least one step with type JPS.
And `snapshot option path=abc` states that there should be a snapshot dependency on such configuration. And `artifact rules *"** =>"*` states that there should be at least one artifact dependency on such configuration and all artifact dependencies should contain `** =>` in theier artifact rules.

#### Important default behaviour
1) If filter on some OBJECT has `all` modifier, then by default if at least one sub-objects matches the condition, then the OBJECT is accepted.
2) If filter on some OBJECT has `withInherited` modifier, then by default only sub-objects without inherited(from template or project) will be considered.
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
