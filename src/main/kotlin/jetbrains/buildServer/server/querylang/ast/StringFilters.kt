package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.WParam
import jetbrains.buildServer.server.querylang.toIdentOrString

data class EqualsStringFilter(val str: String) : Filter<String>, ObjectEvaluator<String>() {
    override val names = emptyList<String>()
    override fun createStr() = str.toIdentOrString()

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.equals(str, true)}
    }

    override fun evalSimple(): List<String> {
        return listOf(str)
    }
}

data class PrefixStringFilter(val str: String) : Filter<String> {
    override val names = emptyList<String>()
    override fun createStr() = str.toIdentOrString() + '*'

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.startsWith(str, true)}
    }
}

data class SuffixStringFilter(val str: String) : Filter<String> {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str.toIdentOrString()

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.endsWith(str, true)}
    }
}

data class SubstringFilter(val str: String) : Filter<String> {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str.toIdentOrString() + '*'

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.contains(str, true)}
    }
}

data class StringParamFilter(
    val nameCondition: ConditionAST<String>,
    val valueCondition:  ConditionAST<String>
) : Filter<WParam> {
    override val names: List<String> = emptyList()
    override fun createStr() = "${nameCondition.createStr()}=${valueCondition.createStr()}"

    val nameFilter:RealObjectFilter<String> by lazy { nameCondition.build() }
    val valueFilter:RealObjectFilter<String> by lazy { valueCondition.build() }

    override fun build():RealObjectFilter<WParam> {
        return RealObjectFilter {obj ->
            nameFilter.accepts(obj.name) && valueFilter.accepts(obj.value)
        }
    }
}

data class AnyStringFilter(
    private val placeholder: String = ""
) : Filter<String> {
    override val names: List<String> = emptyList()
    override fun createStr() = "*"

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {true}
    }
}

fun retrieveEquals(condition: ConditionAST<String>) : List<String>? {
    fun retrieveEqualsReq(condition: ConditionAST<String>) : Set<String>? {
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
            is NoneConditionAST -> {
                return null
            }
        }
    }
    val vars = retrieveEqualsReq(condition) ?: return null

    val filter = condition.build()

    return vars.filter {filter.accepts(it)}
}