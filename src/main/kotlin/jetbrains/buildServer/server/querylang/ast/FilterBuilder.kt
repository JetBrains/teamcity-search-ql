package jetbrains.buildServer.server.querylang.ast

interface FilterBuilder<FObject> {
    fun build(context: Any? = null): ObjectFilter<FObject>
}