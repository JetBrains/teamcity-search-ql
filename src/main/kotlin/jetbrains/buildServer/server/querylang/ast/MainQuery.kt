package jetbrains.buildServer.server.querylang.ast

sealed class MainQuery

data class FindMultipleTypes(val findQueries: List<TopLevelQuery<*>>) : MainQuery(), Printable {
    override fun createStr(): String {
        return "find ${findQueries.joinToString(separator = ",") { it.names.first() }} with ${findQueries.first().condition.createStr()}"
    }

    override fun toString() = createStr()
}