package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.vcs.SVcsRoot

class VcsRoot(val description: String) : TeamCityObject {
    constructor(svcs: SVcsRoot) : this(svcs.externalId)
}