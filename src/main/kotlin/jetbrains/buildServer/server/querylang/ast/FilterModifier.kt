package jetbrains.buildServer.server.querylang.ast

interface FilterModifier<FilterType> : Named {
    fun apply(filter: FilterType)
}