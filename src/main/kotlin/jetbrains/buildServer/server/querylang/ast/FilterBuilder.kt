package jetbrains.buildServer.server.querylang.ast

interface FilterBuilder<in FObject> {
    fun build(context: Any? = null): ObjectFilter<FObject>
}