package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project

object ConsoleResultPrinter : ResultPrinter {
    override fun display(res: QueryResult) {
        res.objects.forEach { obj ->
            println(obj)
        }
    }
}