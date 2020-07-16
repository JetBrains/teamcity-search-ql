package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfiguration

data class ResultBuildConfiguration(
        val buildConfs: MutableList<BuildConfiguration> = mutableListOf()
) : QueryResult