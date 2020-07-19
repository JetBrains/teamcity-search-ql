package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.Project

data class ResultProject(override val objects: MutableList<Project> = mutableListOf()) : QueryResult<Project>