package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.server.querylang.autocompl.Completer

fun main() {

    val completer = Completer(null)
    val autoCompl = AutoCompletion(null, completer)

    while (true) {
        autoCompl.complete(readLine()!!).forEach {
            println(it.result)
        }
    }


}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
