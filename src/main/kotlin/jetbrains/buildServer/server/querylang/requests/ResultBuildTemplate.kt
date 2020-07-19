package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildTemplate

data class ResultBuildTemplate(override val objects: MutableList<BuildTemplate>) : QueryResult<BuildTemplate>