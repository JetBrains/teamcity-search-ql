package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion

fun main() {
    while (true)
        println(AutoCompletion().complete(readLine()!!))
}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
