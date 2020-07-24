package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.FindMultipleTypes

interface QueryHandler {
    fun makeRequest(multQuery: FindMultipleTypes): QueryResult
}