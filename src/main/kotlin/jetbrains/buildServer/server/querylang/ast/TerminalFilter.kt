package jetbrains.buildServer.server.querylang.ast

interface TerminalFilter : Filter

interface StringTerminalFilter : TerminalFilter {
    val str: String
    override fun createStr(): String {
        return "${names[0]} $str"
    }
}