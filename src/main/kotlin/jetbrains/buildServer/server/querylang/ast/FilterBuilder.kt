package jetbrains.buildServer.server.querylang.ast

interface FilterBuilder<in FObject> {
    fun build(): ObjectFilter<FObject>
}