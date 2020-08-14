package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.ast.FilterRegistration
import jetbrains.buildServer.server.querylang.ast.FullQuery
import jetbrains.buildServer.server.querylang.ast.PartialQuery
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.parser.TypeDeduce

fun main() {
    val parser = QueryParser
    val filterRegistration = FilterRegistration
    val queryDeduce = TypeDeduce()

    val query = "type vcsTrigger"

    val parsed = parser.parse(query)
    if (parsed is PartialQuery) {
        parsed.fullQueries.forEach {
            println(it.createStr())
        }
    }
    else {
        println(parsed)
    }
}