package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.requests.QueryResult
import jetbrains.buildServer.server.querylang.requests.ResultPrinter

object EmptyResultPrinter: ResultPrinter {
    override fun display(res: QueryResult<*>) {

    }
}