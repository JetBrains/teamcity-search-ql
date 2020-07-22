package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.serverSide.BuildTypeTemplate

class BuildTemplate(override val externalId: String) : TeamCityObject{
    constructor(stemplate: BuildTypeTemplate) : this(stemplate.externalId)
}