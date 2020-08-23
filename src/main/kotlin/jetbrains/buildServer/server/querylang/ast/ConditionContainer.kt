package jetbrains.buildServer.server.querylang.ast

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

                val res = lres.objects.unite(rres.objects)

                EvalResult(
                    lres.filter.or(rres.filter),
                    res
                )
            }

            is AndConditionNode -> {
                val lres = this.left.eval()
                val rres = this.right.eval()

                val (inter, left, right) = lres.objects.intersectAndDiff(rres.objects)
                if (lres.filter !is NoneObjectFilter) {
                    inter.addAll(right.filter {lres.filter.accepts(it)})
                }
                if (rres.filter !is NoneObjectFilter) {
                    inter.addAll(left.filter { rres.filter.accepts(it) })
                }

                EvalResult(
                    lres.filter.and(rres.filter),
                    inter
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