package jetbrains.buildServer.server.querylang.ast_old

object StringFilterBuilder : FilterBuilder<StringFilter, String> {
    override fun buildFilter(filter: StringFilter, context: Any?): ObjectFilter<String> {
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

    override fun build(context: Any?): ObjectFilter<String> {
        throw java.lang.IllegalStateException("Can't call build() from StringFilterBuilder, use buildFilter(...)")
    }
}