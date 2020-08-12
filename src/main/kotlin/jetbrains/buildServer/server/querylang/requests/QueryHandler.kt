package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast_old.MainQuery

interface QueryHandler {
    fun makeRequest(multQuery: MainQuery): QueryResult
}