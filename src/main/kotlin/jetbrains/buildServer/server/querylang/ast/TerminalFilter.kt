package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.toIdentOrString

interface TerminalFilter : Filter

interface StringTerminalFilter : TerminalFilter {
    val str: String
    override fun createStr(): String {
        return "${names[0]} ${getString()}"
    }

    private fun getString(): String {
        return str.toIdentOrString()
    }
}

interface EmptyTerminalFilter : TerminalFilter {
    override fun createStr() = names.first()
}