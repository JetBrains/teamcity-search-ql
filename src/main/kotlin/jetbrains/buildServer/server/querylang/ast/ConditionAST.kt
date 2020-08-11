package jetbrains.buildServer.server.querylang.ast


sealed class ConditionAST<out T: Filter> : Printable

data class NotConditionNode<T : Filter>(
        val cond: ConditionAST<T>
) : ConditionAST<T>()
{
        override fun createStr(): String {
                return "not ${cond.createStr()}"
        }
}

data class AndConditionNode<T : Filter>(
        val left: ConditionAST<T>,
        val right: ConditionAST<T>
) : ConditionAST<T>() {
        override fun createStr(): String {
                return "${left.createStr()} and ${right.createStr()}"
        }
}

data class OrConditionNode<T : Filter>(
        val left: ConditionAST<T>,
        val right: ConditionAST<T>
) : ConditionAST<T>() {
        override fun createStr(): String {
                return "${left.createStr()} or ${right.createStr()}"
        }
}

data class FilterConditionNode<T : Filter>(val filter: T) : ConditionAST<T>() {
        override fun createStr(): String {
                return filter.createStr()
        }
}

data class EmptyConditionNode<T : Filter>(private val placeholder: String = "") : ConditionAST<T>() {
        override fun createStr(): String {
                return ""
        }
}