package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.MainQuery

class RequestClient(
        val queryHandler: QueryHandler,
        val resultPrinter: ResultPrinter
) {
    fun process(query: MainQuery): QueryResult {
        val res = queryHandler.makeRequest(query)
        resultPrinter.display(res)
        return res
    }
}