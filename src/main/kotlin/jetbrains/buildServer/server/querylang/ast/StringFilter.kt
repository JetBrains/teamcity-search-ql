package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.toIdentOrString

interface StringFilter : Filter

data class EqualsStringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = str.toIdentOrString()
}

data class PrefixStringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = str.toIdentOrString() + '*'
}

data class SuffixStringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str.toIdentOrString()
}

data class SubstringFilter(val str: String) : StringFilter {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str.toIdentOrString() + '*'
}