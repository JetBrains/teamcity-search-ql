package jetbrains.buildServer.server.querylang.ast

sealed class ConditionAST<NestedObject> : FilterBuilder<NestedObject>, Printable

sealed class RealConditionAST<NestedObject> : ConditionAST<NestedObject>()

class NoneConditionAST<NestedObject> : ConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return NoneObjectFilter()
    }

    override fun createStr(): String {
        return ""
    }
}

class NotConditionNode<NestedObject>(
    val cond: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return cond.build(context)
    }

    override fun createStr(): String = "(not ${cond.createStr()})"
}

class AndConditionNode<NestedObject>(
    val left: RealConditionAST<NestedObject>,
    val right: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return left.build(context).and(right.build(context))
    }

    override fun createStr(): String = "(${left.createStr()} and ${right.createStr()})"
}

class OrConditionNode<NestedObject>(
    val left: RealConditionAST<NestedObject>,
    val right: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return left.build(context).or(right.build(context))
    }

    override fun createStr(): String = "(${left.createStr()} or ${right.createStr()})"
}

class FilterConditionNode<NestedObject>(val filter: Filter<NestedObject>) : RealConditionAST<NestedObject>(){
    override fun build(context: Any?): ObjectFilter<NestedObject> {
        return filter.build(context)
    }

    override fun createStr(): String = filter.createStr()
}