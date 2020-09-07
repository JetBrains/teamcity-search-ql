package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ui.objects.TeamCityObjectResult

object ConsoleResultPrinter : ResultPrinter {
    override fun display(res: QueryResult) {
        res.objects.forEach { obj: TeamCityObjectResult<*> ->
            println(obj.externalId)
        }
    }
}