package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.parser.QueryParser

class RequestClient(
    private val queryHandler: QueryHandler,
    private val resultPrinter: ResultPrinter? = null
) {
    val parser = QueryParser()
    fun process(squery: String): QueryResult {
        val query = parser.parse(squery)
        val res = queryHandler.makeRequest(query)
        resultPrinter?.display(res)
        return res
    }
}