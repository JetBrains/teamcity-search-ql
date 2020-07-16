package jetbrains.buildServer.server.querylang.objects

import jetbrains.buildServer.serverSide.BuildTypeTemplate

class BuildTemplate(description: String) : BuildConfOrTemp(description) {
    constructor(stemplate: BuildTypeTemplate) : this(stemplate.externalId)
}