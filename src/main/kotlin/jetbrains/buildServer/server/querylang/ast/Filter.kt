package jetbrains.buildServer.server.querylang.ast

interface Filter<in FObject> : FilterBuilder<FObject>, Named, Printable {
    fun toCondition(): RealConditionAST<*> = FilterConditionNode(this)
}