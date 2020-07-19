package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.serverSide.SBuildType

class BuildConfiguration(externalId: String) : BuildConfOrTemp(externalId) {
    constructor(buildType: SBuildType): this(buildType.externalId)
}