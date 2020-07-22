package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.FindMultipleTypes
import jetbrains.buildServer.server.querylang.ast.MainQuery

interface QueryHandler {
    fun makeRequest(multQuery: FindMultipleTypes): QueryResult
}