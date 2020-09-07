package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ui.objects.TeamCityObjectResult

class QueryResult(
    val objects: MutableList<TeamCityObjectResult<*>> = mutableListOf(),
    val objectsTotal: Int = objects.size
)