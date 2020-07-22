package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.TeamCityObject

class QueryResult(val objects: MutableList<TeamCityObject> = mutableListOf()) {
    fun join(other: QueryResult): QueryResult {
        objects.addAll(other.objects)
        return this
    }
}