package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.WParam

data class VisitorStorage<L>(
    val remCondition: ConditionAST<L>,
    val contextFilter: RealObjectFilter<L>,
    val straightFilter: RealObjectFilter<L> = contextFilter
)

interface ConditionSplitter<in T> {
    fun <L: T> ConditionAST<L>.splitCondition(): VisitorStorage<L> {
        val condition = this
        return when (condition) {
            is NotConditionNode -> {
                val (_, _, selectorStraightVisitor) = condition.cond.splitCondition()
                VisitorStorage(NoneConditionAST<T>(), selectorStraightVisitor)
            }
            is AndConditionNode -> {
                val (remCondition, pathToSelector, straightVisitor) = condition.right.splitCondition()
                return VisitorStorage(
                    mergeAnd(condition.left, remCondition),
                    condition.left.build().andR(pathToSelector),
                    straightVisitor
                )
            }
            is OrConditionNode -> condition.right.splitCondition()
            is FilterConditionNode -> {
                val filter = condition.filter
                if (filter is ConditionFilter<L, *>) {
                    return filter.split()
                }
                if ((filter as? Filter<String>) is CollectorStringFilter) {
                    return VisitorStorage(
                        NoneConditionAST(),
                        filter.build()
                    )
                }
                if ((filter as? Filter<WParam>) is StringParamFilter) {
                    val sfilter = filter as StringParamFilter
                    val (remFilter, pathFilter) = sfilter.split(sfilter.valueCondition)
                    return VisitorStorage(
                        FilterConditionNode(
                            StringParamFilter(sfilter.nameCondition,
                                if (remFilter is NoneConditionAST) {
                                    FilterConditionNode(AnyStringFilter())
                                } else {
                                    remFilter
                                }
                            ) as Filter<L>
                        ),
                        filter.buildFrom(filter.nameFilter, pathFilter) as RealObjectFilter<L>
                    )
                }
                if ((filter as? Filter<WParam>) is CollectorStringParamFilter) {
                    return VisitorStorage(
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