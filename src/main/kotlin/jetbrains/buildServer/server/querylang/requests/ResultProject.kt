package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.Project

data class ResultProject(val projects: MutableList<Project> = mutableListOf()) : QueryResult