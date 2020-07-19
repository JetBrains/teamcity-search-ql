package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.vcs.SVcsRoot

class VcsRoot(val externalId: String) : TeamCityObject {
    constructor(svcs: SVcsRoot) : this(svcs.externalId)
}