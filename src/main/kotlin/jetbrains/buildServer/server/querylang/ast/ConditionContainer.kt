package jetbrains.buildServer.server.querylang.ast


interface ConditionContainer<T : Filter, S : Any> : Printable, Named, FilterBuilder<T, S> {
    val condition: ConditionAST<T>

    override fun createStr(): String {
        return "${names[0]}(${condition.createStr()})"
    }

    override fun build(context: Any?) = buildFilter(condition, context)
}
