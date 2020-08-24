package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.WParam


interface ConditionSplitter<in T> {
    fun <L: T> ConditionAST<L>.splitCondition(): Pair<ConditionAST<L>, RealObjectFilter<L>> {
        val condition = this
        return when (condition) {
            is NotConditionNode -> {
                val (_, selectorVisitor) = condition.cond.splitCondition()
                Pair(NoneConditionAST<T>(), selectorVisitor)
            }
            is AndConditionNode -> {
                val (remCondition, pathToSelector) = condition.right.splitCondition()
                return Pair(mergeAnd(condition.left, remCondition), condition.left.build().andR(pathToSelector))
            }
            is OrConditionNode -> condition.right.splitCondition()
            is FilterConditionNode -> {
                val filter = condition.filter
                if (filter is ConditionFilter<L, *>) {
                    val (remFilter, pathFilter) = filter.split()

                    return Pair<ConditionAST<L>, RealObjectFilter<L>>(
                        remFilter?.let { FilterConditionNode(it) } ?: NoneConditionAST(),
                        pathFilter
                    )
                }
                if ((filter as? Filter<String>) is CollectorStringFilter) {
                    return Pair(
                        NoneConditionAST(),
                        filter.build()
                    )
                }
                if ((filter as? Filter<WParam>) is StringParamFilter) {
                    val sfilter = filter as StringParamFilter
                    val (remFilter, pathFilter) = sfilter.split(sfilter.valueCondition)
                    return Pair(
                        FilterConditionNode(
                            StringParamFilter(sfilter.nameCondition,
                                if (remFilter is NoneConditionAST) {
                                    FilterConditionNode(AnyStringFilter())
                                } else {
                                    remFilter
                                }
                            ) as Filter<L>
                        ),
                        filter.nameFilter.andR(pathFilter) as RealObjectFilter<L>
                    )
                }
                if ((filter as? Filter<WParam>) is CollectorStringParamFilter) {
                    return Pair(
                        NoneConditionAST(),
                        filter.build()
                    )
                }
                throw IllegalStateException("There is no CollectorStringFilter in the query")
            }
            is NoneConditionAST -> throw IllegalStateException("There is no CollectorStringFilter in the query")
        }
    }

    fun <L : T> split(condition: ConditionAST<L>) =
        condition.splitCondition()

    private fun <L: T> mergeAnd(condition1: ConditionAST<L>, condition2: ConditionAST<L>): ConditionAST<L> {
        if (condition1 is NoneConditionAST) {
            return condition2
        }
        if (condition2 is NoneConditionAST) {
            return condition1
        }
        return AndConditionNode(
            condition1 as RealConditionAST<L>,
            condition2 as RealConditionAST<L>
        )
    }
}