package jetbrains.buildServer.server.querylang.ast

interface TerminalFilter : Filter

interface StringTerminalFilter : TerminalFilter {
    val str: String
    override fun createStr(): String {
        return "${names[0]} ${getString()}"
    }

    private fun getString(): String {
        if (str.all { it.isDigit() || it.isLetter() || it in listOf('.', '-', '_') }) {
            return str
        }
        else {
            return "\"$str\""
        }
    }
}