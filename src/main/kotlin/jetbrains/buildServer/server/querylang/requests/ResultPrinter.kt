package jetbrains.buildServer.server.querylang.requests

interface ResultPrinter {
    fun display(res: QueryResult)
}