package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.MainQuery

interface QueryHandler {
    fun makeRequest(query: MainQuery): QueryResult<*>
}