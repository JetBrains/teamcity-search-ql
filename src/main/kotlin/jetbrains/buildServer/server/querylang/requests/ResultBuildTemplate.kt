package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildTemplate

data class ResultBuildTemplate(val templates: List<BuildTemplate>) : QueryResult