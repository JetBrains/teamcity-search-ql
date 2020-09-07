package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.FullQuery
import jetbrains.buildServer.server.querylang.ast.PartialQuery
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.serverSide.TeamCityProperties

class RequestClient(
    private val queryHandler: QueryHandler,
    private val resultPrinter: ResultPrinter? = null
) {
    val parser = QueryParser

    fun process(squery: String, limit: Int = Int.MAX_VALUE): QueryResult {
        val parsed = parser.parse(squery)
        val query = when (parsed) {
            is FullQuery -> parsed
            is PartialQuery -> parsed.fullQueries.first()
        }
        val objects = queryHandler.makeRequest(query).objects
        val res = QueryResult(objects.take(limit).toMutableList(), objects.size)
        resultPrinter?.display(res)
        return res
    }
}