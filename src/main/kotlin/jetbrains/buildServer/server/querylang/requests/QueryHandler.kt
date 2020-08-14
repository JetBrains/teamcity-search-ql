package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.FullQuery

interface QueryHandler {
    fun makeRequest(multQuery: FullQuery): QueryResult
}