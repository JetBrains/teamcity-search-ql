package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.FullQuery
import jetbrains.buildServer.server.querylang.ast.PartialQuery
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.serverSide.TeamCityProperties

class RequestClient(
    private val queryHandler: QueryHandler,
    private val resultPrinter: ResultPrinter? = null
) {
    val RESULTS_LIMIT_NAME = "teamcity.internal.searchQL.maxResults"

    val parser = QueryParser

    fun process(squery: String): QueryResult {
        val parsed = parser.parse(squery)
        val query = when (parsed) {
            is FullQuery -> parsed
            is PartialQuery -> parsed.fullQueries.first()
        }
        val limit = TeamCityProperties.getInteger(RESULTS_LIMIT_NAME, 100)
        val res = QueryResult(queryHandler.makeRequest(query).objects.take(limit).toMutableList())
        resultPrinter?.display(res)
        return res
    }
}