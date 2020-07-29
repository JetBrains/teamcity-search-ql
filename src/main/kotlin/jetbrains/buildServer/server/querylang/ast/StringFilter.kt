package jetbrains.buildServer.server.querylang.ast

interface StringFilter : Filter

data class EqualsStringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = str
}

data class PrefixStringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = str + '*'
}

data class SuffixStringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str
}

data class SubstringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str + '*'
}