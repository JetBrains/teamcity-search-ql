package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.serverSide.BuildTypeTemplate

class BuildTemplate(externalId: String) : BuildConfOrTemp(externalId) {
    constructor(stemplate: BuildTypeTemplate) : this(stemplate.externalId)
}