package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.ast.BuildConfTopLevelQuery
import jetbrains.buildServer.server.querylang.ast.FullQuery
import jetbrains.buildServer.server.querylang.parser.QueryParser

fun main() {
    val query = readLine()!!

    val parsed = QueryParser.parse(query, true) as FullQuery

    val squery = parsed.queries.first() as BuildConfTopLevelQuery
    println(squery.splitCondition())
}