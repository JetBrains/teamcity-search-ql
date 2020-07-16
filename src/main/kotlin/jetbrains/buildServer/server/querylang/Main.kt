package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion

fun main() {
    /*
    val client = RequestClient(InternalApiQueryHandler(ProjectManagerImpl()), ConsoleResultPrinter)

    var input = ""
    while (true) {
        val ninput = readLine()!!
        if (ninput == "go") break
        input += "\n" + ninput
    }
    val query = QueryParser().parse(input)
    client.process(query)

     */
    println(AutoCompletion.comlete(readLine()!!))
}

//find buildConf: (project: (subprojects id:_Root)) (trig: (type: vcsTrigger) (opt:(triggerRules = "+:user=ilya:**")))
