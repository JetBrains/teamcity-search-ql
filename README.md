TeamCity Search Query Language plugin
-------------------------------------

This plugin implements a search for objects in TeamCity project model. 
The functionality is only available for system administrator and project admins via the `Search` tab in the administration menu.
Currently it supports searching 4 types of entities: projects, build configurations, build configuration templates and VCS roots.

# Query structure

`find <entity type(s)> [in <project ID>] with <condition>`

# Examples of queries

- `find vcsRoot with type jetbrains.git` 
    > find VCS roots with type `jetbrains.git`;

- `find configuration, template in Project1 with trigger type vcsTrigger`
 
    > find build configurations and templates that lie in the subtree of a project with an id Project1 and has at least one trigger with the type vcsTrigger;

- `find project with configuration (feature type pullRequests or vcs param branchSpec = *pull*)`
    
    > find projects that contain build configurations with either Pull Requests build feature configured
      or a VCS root with a branch specification matching certain pattern attached. 
                                                                                                    
# More information

Source code: https://github.com/JetBrains/teamcity-search-ql

Download link: https://plugins.jetbrains.com/plugin/15051-searchql

Please refer to FOR_USERS.md for a draft of the user documentation and to FOR_DEVS.md if you are thinking of contributing to the plugin.
