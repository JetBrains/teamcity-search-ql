package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfOrTemp

data class ResultBuildConfOrTemp(override val objects: MutableList<BuildConfOrTemp>) : QueryResult<BuildConfOrTemp>