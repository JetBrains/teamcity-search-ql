package jetbrains.buildServer.server.querylang.eval

import jetbrains.buildServer.server.querylang.ast.Filter
import jetbrains.buildServer.server.querylang.ast.*


interface Evaluator {
    private fun<S : Any> eval(trace: List<Class<out Filter>>, lastFilter: ConditionContainer<*, S>, condition: ConditionAST<*>): EvalResult<S> {
        return when (condition) {
            is OrConditionNode -> {
                val lres = eval(trace, lastFilter, condition.left)
                val rres = eval(trace, lastFilter, condition.right)

                EvalResult(lres.filter.or(rres.filter), lres.objects.union(rres.objects).toList())
            }

            is AndConditionNode -> {
                val lres = eval(trace, lastFilter, condition.left)
                val rres = eval(trace, lastFilter, condition.right)

                val objects = lres.objects.intersect(rres.objects) + lres.objects.filter { rres.filter.accepts(it) } +
                        rres.objects.filter {lres.filter.accepts(it)}

                EvalResult(lres.filter.and(rres.filter), objects.toSet().toList())
            }

            is NotConditionNode -> {
                val res = evalFilter(lastFilter, condition.cond)

                EvalResult(res.not(), emptyList())
            }

            is FilterConditionNode -> {

                return if (condition.filter is ConditionContainer<*, *>) {
                    val a = condition.filter
                    val projectEvalResult = eval(trace, condition.filter, condition.filter.condition)

                }
                else {
                    val res = evalFilter(lastFilter, condition)

                    EvalResult(res, emptyList())
                }
            }

            is EmptyConditionNode -> {
                EvalResult(ObjectFilter {true}, emptyList())
            }
        }
    }

    private fun <T: Filter, S> evalFilter(lastFilter: FilterBuilder<T, S>, condition: ConditionAST<T>): ObjectFilter<S> {
        return lastFilter.buildFilter(condition)
    }
}