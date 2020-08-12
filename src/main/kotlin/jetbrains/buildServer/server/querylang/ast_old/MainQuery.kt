package jetbrains.buildServer.server.querylang.ast_old

sealed class MainQuery

data class FindMultipleTypes(val findQueries: List<TopLevelQuery<*, *>>) : MainQuery(), Printable {
    override fun createStr(): String {
        if (findQueries.isEmpty()) return "Error: empty query"
        return "find ${findQueries.joinToString(separator = ",") { it.names.first() }} with ${findQueries.first().condition.createStr()}"
    }

    override fun toString() = createStr()
}

data class MultipleMainQuery(val queries: List<FindMultipleTypes>) : MainQuery()