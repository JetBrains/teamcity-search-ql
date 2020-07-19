package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.serverSide.SProject

data class Project(var externalId: String) : TeamCityObject {
    constructor(sproject: SProject): this(sproject.externalId)
}