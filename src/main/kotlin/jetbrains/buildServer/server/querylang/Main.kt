package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.server.querylang.autocompl.Completer
import jetbrains.buildServer.server.querylang.parser.QueryParser

fun main() {
    val parser = QueryParser
    val completer = Completer(null)
    val autoCompl = AutoCompletion(null, completer)

    while (true) {
        autoCompl.complete(readLine()!!).forEach {
            println("${it.result} -- ${it.meta}")
        }
    }


}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
