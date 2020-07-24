package jetbrains.buildServer.server.querylang.ast

sealed class MainQuery

data class FindMultipleTypes(val findQueries: List<TopLevelQuery>) : MainQuery()