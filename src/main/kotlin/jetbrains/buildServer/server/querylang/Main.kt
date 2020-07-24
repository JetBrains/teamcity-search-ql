package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.parser.TypeDeduce


fun main() {
    val autoCompl = AutoCompletion(null)

    while (true) {
        println(autoCompl.complete(readLine()!!))
    }
}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
