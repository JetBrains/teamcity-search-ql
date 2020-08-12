package jetbrains.buildServer.server.querylang.ast_old

interface FilterBuilder<T : Filter, TeamCityObject> {
    fun buildFilter(filter : T, context: Any? = null): ObjectFilter<TeamCityObject>

    fun buildFilter(condition: ConditionAST<T>, context: Any? = null): ObjectFilter<TeamCityObject> {
        return when (condition) {
            is OrConditionNode -> {
                val filter1 = buildFilter(condition.left, context)
                val filter2 = buildFilter(condition.right, context)
                ObjectFilter { obj ->
                    filter1.accepts(obj) || filter2.accepts(obj)
                }
            }
            is AndConditionNode -> {
                val filter1 = buildFilter(condition.left, context)
                val filter2 = buildFilter(condition.right, context)
                ObjectFilter { obj ->
                    filter1.accepts(obj) && filter2.accepts(obj)
                }
            }
            is NotConditionNode -> {
                val filter = buildFilter(condition.cond, context)
                ObjectFilter { obj ->
                    !filter.accepts(obj)
                }
            }
            is FilterConditionNode -> {
                this.buildFilter(condition.filter, context)
            }
            is EmptyConditionNode -> {
                ObjectFilter { obj -> true}
            }
        }
    }

    fun T.buildRev(): ObjectFilter<TeamCityObject> {
        return ObjectFilter { obj ->
            buildFilter(this).accepts(obj)
        }
    }

    fun build(context: Any? = null): ObjectFilter<TeamCityObject>
}