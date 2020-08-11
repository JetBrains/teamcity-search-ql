package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.*

object StringFilterBuilder {
    fun createFilter(filter: StringFilter, context: Any?): ObjectFilter<String> {
        return when(filter) {
            is EqualsStringFilter -> {
                ObjectFilter { str ->
                    str == filter.str
                }
            }
            is PrefixStringFilter -> {
                ObjectFilter { str ->
                    str.startsWith(filter.str)
                }
            }
            is SuffixStringFilter -> {
                ObjectFilter { str ->
                    str.endsWith(filter.str)
                }
            }
            is SubstringFilter -> {
                ObjectFilter { str ->
                    str.contains(filter.str)
                }
            }
            else -> throw IllegalStateException("Unknown StringFilter")
        }
    }
}