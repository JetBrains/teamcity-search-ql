package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.TeamCityObject

class QueryResult(val objects: List<TeamCityObject> = mutableListOf())