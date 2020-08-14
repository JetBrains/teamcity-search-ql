package jetbrains.buildServer.server.querylang.ast

sealed class ConditionAST<in NestedObject> : FilterBuilder<NestedObject>, Printable

sealed class RealConditionAST<in NestedObject> : ConditionAST<NestedObject>()

class NoneConditionAST<NestedObject> : ConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return RealObjectFilter {true}
    }

    override fun createStr(): String {
        return ""
    }
}

data class NotConditionNode<NestedObject>(
    val cond: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return cond.build(context).not()
    }

    override fun createStr(): String = "(not ${cond.createStr()})"
}

data class AndConditionNode<NestedObject>(
    val left: RealConditionAST<NestedObject>,
    val right: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return left.build(context).and(right.build(context))
    }

    override fun createStr(): String = "(${left.createStr()} and ${right.createStr()})"
}

data class OrConditionNode<NestedObject>(
    val left: RealConditionAST<NestedObject>,
    val right: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return left.build(context).or(right.build(context))
    }

    override fun createStr(): String = "(${left.createStr()} or ${right.createStr()})"
}

data class FilterConditionNode<NestedObject>(val filter: Filter<NestedObject>) : RealConditionAST<NestedObject>(){
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return filter.build(context)
    }

    override fun createStr(): String = filter.createStr()
}