package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.serverSide.SBuildType

class BuildConfiguration(override val externalId: String) : TeamCityObject {
    constructor(buildType: SBuildType): this(buildType.externalId)
}