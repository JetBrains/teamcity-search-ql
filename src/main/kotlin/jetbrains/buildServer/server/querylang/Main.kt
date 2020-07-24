package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.parser.TypeDeduce


fun main() {
    val query = FilterConditionNode(TypeFilter("vcsTrigger"))
    TypeDeduce().deduceQueryType(query, 1).forEach {
        println(it.wrap())
    }
    /*
    while (true)
        println(AutoCompletion().complete(readLine()!!))

     */
}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
