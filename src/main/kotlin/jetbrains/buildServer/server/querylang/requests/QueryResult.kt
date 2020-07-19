package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.TeamCityObject

interface QueryResult<T : TeamCityObject> {
    val objects: MutableList<T>
}