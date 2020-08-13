package jetbrains.buildServer.server.querylang.ast

abstract class ConditionFilter<Object, NestedObject> : Filter<Object>, ConditionContainer<NestedObject> {
    abstract fun buildFrom(filter: ObjectFilter<NestedObject>, context: Any? = null): ObjectFilter<Object>

    val objectFilter: ObjectFilter<NestedObject> by lazy { condition.build(null) }

    override fun build(context: Any?): ObjectFilter<Object> = buildFrom(objectFilter, context)

    override fun eval(): EvalResult<NestedObject> = condition.eval()

    override fun createStr(): String = """${names.first()} ${condition.createStr()}"""
}