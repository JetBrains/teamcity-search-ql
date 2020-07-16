package jetbrains.buildServer.server.querylang.ast

sealed class ConditionAST<out T: Filter>

data class NotConditionNode<T : Filter>(
        val cond: ConditionAST<T>
) : ConditionAST<T>()

data class AndConditionNode<T : Filter>(
        val left: ConditionAST<T>,
        val right: ConditionAST<T>
) : ConditionAST<T>()

data class OrConditionNode<T : Filter>(
        val left: ConditionAST<T>,
        val right: ConditionAST<T>
) : ConditionAST<T>()

data class FilterConditionNode<T : Filter>(val filter: T) : ConditionAST<T>()