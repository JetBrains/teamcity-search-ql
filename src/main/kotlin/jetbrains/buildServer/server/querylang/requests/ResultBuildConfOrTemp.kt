package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfOrTemp

data class ResultBuildConfOrTemp(val buildObjects: List<BuildConfOrTemp>) : QueryResult