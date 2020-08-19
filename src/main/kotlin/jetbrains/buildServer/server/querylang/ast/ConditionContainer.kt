package jetbrains.buildServer.server.querylang.ast

data class EvalResult<NestedObject>(val filter: ObjectFilter<NestedObject>, val objects: List<NestedObject>)

interface ConditionContainer<NestedObject> : Named {
    val condition: ConditionAST<NestedObject>

    fun eval(): EvalResult<NestedObject> {
        if (Thread.currentThread().isInterrupted) {
            throw InterruptedException()
        }
        return evalInner()
    }

    fun evalInner(): EvalResult<NestedObject>

    fun evalFilterInner(filter: Filter<NestedObject>): EvalResult<NestedObject>?  {
        return if (filter is ObjectEvaluator) {
            filter.eval()
        } else {
            EvalResult(filter.build(), listOf())
        }
    }

    fun evalFilter(filter: Filter<NestedObject>): EvalResult<NestedObject> {
        return evalFilterInner(filter) ?: EvalResult(filter.build(), listOf())
    }

    fun ConditionAST<NestedObject>.eval(): EvalResult<NestedObject> {
        return when (this) {
            is OrConditionNode -> {
                val lres = this.left.eval()
                val rres = this.right.eval()

                EvalResult(
                    lres.filter.or(rres.filter),
                    lres.objects.union(rres.objects).toList()
                )
            }

            is AndConditionNode -> {
                val lres = this.left.eval()
                val rres = this.right.eval()

                val objects = lres.objects.intersect(rres.objects) + lres.objects.filter { rres.filter.accepts(it) } +
                        rres.objects.filter {lres.filter.accepts(it)}

                EvalResult(
                    lres.filter.and(rres.filter),
                    objects.toSet().toList()
                )
            }

            is NotConditionNode -> {
                val res = this.cond.build()

                EvalResult(res.not(), emptyList())
            }

            is FilterConditionNode -> {
                evalFilter(this.filter)
            }

            is NoneConditionAST -> {
                EvalResult(RealObjectFilter {false}, emptyList())
            }
        }
    }

    fun evalCondition() = condition.eval()
}