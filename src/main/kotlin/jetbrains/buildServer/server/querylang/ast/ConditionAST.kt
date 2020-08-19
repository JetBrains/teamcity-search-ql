package jetbrains.buildServer.server.querylang.ast

sealed class ConditionAST<in NestedObject> : FilterBuilder<NestedObject>, Printable

sealed class RealConditionAST<in NestedObject> : ConditionAST<NestedObject>()

class NoneConditionAST<NestedObject> : ConditionAST<NestedObject>() {
    override fun build(): RealObjectFilter<NestedObject> {
        return RealObjectFilter {true}
    }

    override fun createStr(): String {
        return ""
    }
}

data class NotConditionNode<NestedObject>(
    val cond: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(): RealObjectFilter<NestedObject> {
        return cond.build().notR()
    }

    override fun createStr(): String = "(not ${cond.createStr()})"
}

data class AndConditionNode<NestedObject>(
    val left: RealConditionAST<NestedObject>,
    val right: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(): RealObjectFilter<NestedObject> {
        return left.build().andR(right.build())
    }

    override fun createStr(): String = "(${left.createStr()} and ${right.createStr()})"
}

data class OrConditionNode<NestedObject>(
    val left: RealConditionAST<NestedObject>,
    val right: RealConditionAST<NestedObject>
) : RealConditionAST<NestedObject>() {
    override fun build(): RealObjectFilter<NestedObject> {
        return left.build().orR(right.build())
    }

    override fun createStr(): String = "(${left.createStr()} or ${right.createStr()})"
}

data class FilterConditionNode<NestedObject>(val filter: Filter<NestedObject>) : RealConditionAST<NestedObject>(){
    override fun build(): RealObjectFilter<NestedObject> {
        return filter.build()
    }

    override fun createStr(): String = filter.createStr()
}