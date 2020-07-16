package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.VcsRoot

data class ResultVcsRoot(val vcsRoots: List<VcsRoot>) : QueryResult