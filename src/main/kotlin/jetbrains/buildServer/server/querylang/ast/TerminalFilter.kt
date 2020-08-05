package jetbrains.buildServer.server.querylang.ast

interface TerminalFilter : Filter

interface StringTerminalFilter : TerminalFilter {
    val strCondition: ConditionAST<StringFilter>
    override fun createStr(): String {
        return "${names[0]} ${getString()}"
    }

    private fun getString(): String {
        return strCondition.createStr()
    }
}

interface EmptyTerminalFilter : TerminalFilter {
    override fun createStr() = names.first()
}