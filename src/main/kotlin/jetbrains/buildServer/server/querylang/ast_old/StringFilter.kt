package jetbrains.buildServer.server.querylang.ast_old

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

fun retrieveEquals(condition: ConditionAST<StringFilter>) : List<String>? {
    fun retrieveEqualsReq(condition: ConditionAST<StringFilter>) : Set<String>? {
        when (condition) {
            is FilterConditionNode -> {
                val filter = condition.filter
                if (filter is EqualsStringFilter) {
                    return setOf(filter.str)
                }
                return null
            }

            is OrConditionNode -> {
                val lefts = retrieveEqualsReq(condition.left)
                val rights = retrieveEqualsReq(condition.right)

                if (lefts == null || rights == null) {
                    return null
                }
                return lefts.union(rights)
            }
            is AndConditionNode -> {
                val lefts = retrieveEqualsReq(condition.left)
                val rights = retrieveEqualsReq(condition.right)

                if (lefts == null && rights == null) {
                    return null
                }

                return lefts.orEmpty().intersect(rights.orEmpty())
            }
            is NotConditionNode -> {
                return null
            }

            is EmptyConditionNode ->
                return emptySet()
        }
    }
    val vars = retrieveEqualsReq(condition) ?: return null

    val filter = StringFilterBuilder.buildFilter(condition)

    return vars.filter {filter.accepts(it)}
}