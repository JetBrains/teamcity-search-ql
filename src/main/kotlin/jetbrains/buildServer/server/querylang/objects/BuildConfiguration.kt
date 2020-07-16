package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.serverSide.SBuildType

class BuildConfiguration(description: String) : BuildConfOrTemp(description) {
    constructor(buildType: SBuildType): this(buildType.externalId)
}