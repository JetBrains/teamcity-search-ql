package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.FullQuery
import jetbrains.buildServer.server.querylang.ast.PartialQuery
import jetbrains.buildServer.server.querylang.parser.QueryParser

class RequestClient(
    private val queryHandler: QueryHandler,
    private val resultPrinter: ResultPrinter? = null
) {
    val parser = QueryParser

    fun process(squery: String): QueryResult {
        val parsed = parser.parse(squery)
        val query = when (parsed) {
            is FullQuery -> parsed
            is PartialQuery -> parsed.fullQueries.first()
        }
        val res = queryHandler.makeRequest(query)
        resultPrinter?.display(res)
        return res
    }
}