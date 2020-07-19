package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfiguration

data class ResultBuildConfiguration(
        override val objects: MutableList<BuildConfiguration> = mutableListOf()
) : QueryResult<BuildConfiguration>