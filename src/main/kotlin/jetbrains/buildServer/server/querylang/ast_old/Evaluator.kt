package jetbrains.buildServer.server.querylang.ast_old


interface Evaluator<T: Filter, S : Any> {
    fun eval(condition: ConditionAST<T>): EvalResult<S> {
        return when (condition) {
            is OrConditionNode -> {
                val lres = eval(condition.left)
                val rres = eval(condition.right)

                EvalResult(lres.filter.or(rres.filter), lres.objects.union(rres.objects).toList())
            }

            is AndConditionNode -> {
                val lres = eval(condition.left)
                val rres = eval(condition.right)

                val objects = lres.objects.intersect(rres.objects) + lres.objects.filter { rres.filter.accepts(it) } +
                        rres.objects.filter {lres.filter.accepts(it)}

                EvalResult(lres.filter.and(rres.filter), objects.toSet().toList())
            }

            is NotConditionNode -> {
                val res = evalCondition(condition.cond)

                EvalResult(res.not(), emptyList())
            }

            is FilterConditionNode -> {
                evalFilter(condition.filter)
            }

            is EmptyConditionNode -> {
                EvalResult(ObjectFilter {true}, emptyList())
            }
        }
    }

    fun eval(): EvalResult<S>

    fun evalCondition(condition: ConditionAST<T>): ObjectFilter<S>

    fun evalFilter(filter: T): EvalResult<S>
}