package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.vcs.SVcsRoot

class VcsRoot(override val externalId: String) : TeamCityObject {
    constructor(svcs: SVcsRoot) : this(svcs.externalId)
}