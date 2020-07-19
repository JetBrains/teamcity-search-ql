package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.MainQuery

class RequestClient(
    private val queryHandler: QueryHandler,
    private val resultPrinter: ResultPrinter? = null
) {
    fun process(query: MainQuery): QueryResult<*> {
        val res = queryHandler.makeRequest(query)
        resultPrinter?.display(res)
        return res
    }
}