package jetbrains.buildServer.server.querylang.requests

object ConsoleResultPrinter : ResultPrinter {
    override fun display(res: QueryResult) {
        when(res) {
            is ResultProject -> {
                println("Build Configurations:")
                res.projects.forEach { println(it) }
            }
            is ResultBuildConfiguration -> {
                println("Projects:")
                res.buildConfs.forEach { println(it) }
            }
        }
    }
}