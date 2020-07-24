package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.parser.TypeDeduce


fun main() {
    val parser = QueryParser()

    val query = "type vcsTrigger"

    val parsed = parser.parse(query) as MultipleMainQuery

    parsed.queries.forEach {
        println(it)
    }
}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
