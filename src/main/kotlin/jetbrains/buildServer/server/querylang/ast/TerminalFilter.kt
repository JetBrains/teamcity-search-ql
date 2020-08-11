package jetbrains.buildServer.server.querylang.ast

interface TerminalFilter : Filter

interface StringTerminalFilter : TerminalFilter, FilterBuilder<StringFilter, String> {
    val strCondition: ConditionAST<StringFilter>
    override fun createStr(): String {
        return "${names[0]} ${getString()}"
    }

    private fun getString(): String {
        return strCondition.createStr()
    }

    override fun buildFilter(filter: StringFilter, context: Any?): ObjectFilter<String> {
        return StringFilterBuilder.buildFilter(filter, context)
    }

    override fun build(context: Any?): ObjectFilter<String> = buildFilter(strCondition, context)
}

interface StringParameterTerminalFilter : TerminalFilter, FilterBuilder<StringFilter, String> {
    val nameCondition: ConditionAST<StringFilter>
    val valCondition: ConditionAST<StringFilter>

    override fun createStr() =
        "${names.first()} (${nameCondition.createStr()})=(${valCondition.createStr()})"

    override fun buildFilter(filter: StringFilter, context: Any?): ObjectFilter<String> {
        return StringFilterBuilder.buildFilter(filter, context)
    }

    override fun build(context: Any?): ObjectFilter<String> = buildFilter(nameCondition, context)

    fun buildP(): Pair<ObjectFilter<String>, ObjectFilter<String>> =
        Pair(buildFilter(nameCondition), buildFilter(valCondition))
}

interface EmptyTerminalFilter : TerminalFilter {
    override fun createStr() = names.first()
}