package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.VcsRoot

data class ResultVcsRoot(override val objects: MutableList<VcsRoot>) : QueryResult<VcsRoot>