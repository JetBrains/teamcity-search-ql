package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.server.querylang.parser.QueryParser


fun main() {
    while (true)
        println(AutoCompletion().complete(readLine()!!))
}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
