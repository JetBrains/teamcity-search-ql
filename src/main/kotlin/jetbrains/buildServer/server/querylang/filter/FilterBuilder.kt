package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*

interface FilterBuilder<T : Filter, S> {
    fun createFilter(filter : T, context : Any? = null) : ObjectFilter<S>

    fun createFilter(
        condition: ConditionAST<T>,
        context: Any? = null
    ): ObjectFilter<S> {
        return when (condition) {
            is OrConditionNode -> {
                val filter1 = createFilter(condition.left, context)
                val filter2 = createFilter(condition.right, context)
                ObjectFilter {obj ->
                    filter1.accepts(obj) || filter2.accepts(obj)
                }
            }
            is AndConditionNode -> {
                val filter1 = createFilter(condition.left, context)
                val filter2 = createFilter(condition.right, context)
                ObjectFilter {obj ->
                    filter1.accepts(obj) && filter2.accepts(obj)
                }
            }
            is NotConditionNode -> {
                val filter = createFilter(condition.cond, context)
                ObjectFilter {obj ->
                    !filter.accepts(obj)
                }
            }
            is FilterConditionNode -> {
                println(condition.filter is StringFilter)
                this.createFilter(condition.filter, context)
            }
        }
    }
}