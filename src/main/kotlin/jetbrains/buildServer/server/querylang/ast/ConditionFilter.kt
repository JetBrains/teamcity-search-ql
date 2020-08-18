package jetbrains.buildServer.server.querylang.ast

abstract class ConditionFilter<Object, NestedObject> : Filter<Object>, ConditionContainer<NestedObject>() {
    abstract fun buildFrom(filter: ObjectFilter<NestedObject>): ObjectFilter<Object>

    val objectFilter: ObjectFilter<NestedObject> by lazy { condition.build() }

    override fun build(): ObjectFilter<Object> = buildFrom(objectFilter)

    override fun evalInner(): EvalResult<NestedObject> = condition.eval()

    override fun createStr(): String = """${names.first()} ${condition.createStr()}"""
}