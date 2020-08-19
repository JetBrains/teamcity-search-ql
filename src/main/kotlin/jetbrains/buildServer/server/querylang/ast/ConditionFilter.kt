package jetbrains.buildServer.server.querylang.ast

abstract class ConditionFilter<Object, NestedObject> : Filter<Object>, ConditionContainer<NestedObject> {
    abstract fun buildFrom(filter: RealObjectFilter<NestedObject>): RealObjectFilter<Object>

    private val conditionFilter: RealObjectFilter<NestedObject> by lazy { condition.build() }

    override fun build(): RealObjectFilter<Object> = buildFrom(conditionFilter)

    override fun evalInner(): EvalResult<NestedObject> = condition.eval()

    override fun createStr(): String = """${names.first()} ${condition.createStr()}"""

    fun transformedEval(): Pair<ObjectFilter<Object>, List<NestedObject>> {
        val (remFilter, objs) = eval()
        if (remFilter is RealObjectFilter) {
            return Pair(buildFrom(remFilter), objs)
        }
        else {
            return Pair(NoneObjectFilter(), objs)
        }
    }
}