package jetbrains.buildServer.server.querylang.ast

abstract class ConditionFilter<Object, NestedObject> : Filter<Object>, Evaluator<NestedObject> {
    abstract val condition: ConditionAST<NestedObject>

    abstract fun buildFrom(filter: ObjectFilter<NestedObject>, context: Any? = null): ObjectFilter<Object>

    open fun evalFilter(filter: Filter<NestedObject>): EvalResult<NestedObject> = EvalResult(filter.build(), listOf())

    val objectFilter: ObjectFilter<NestedObject> by lazy { condition.build(null) }

    override fun build(context: Any?): ObjectFilter<Object> = buildFrom(objectFilter, context)

    override fun eval(): EvalResult<NestedObject> = condition.eval()

    override fun createStr(): String = """${names.first()} ${condition.createStr()}"""

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
}