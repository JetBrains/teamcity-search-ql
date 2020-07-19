package jetbrains.buildServer.server.querylang.requests

object ConsoleResultPrinter : ResultPrinter {
    override fun display(res: QueryResult<*>) {
        when(res) {
            is ResultProject -> {
                println("Build Configurations:")
                res.objects.forEach { println(it) }
            }
            is ResultBuildConfiguration -> {
                println("Projects:")
                res.objects.forEach { println(it) }
            }
        }
    }
}