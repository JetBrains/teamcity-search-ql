package jetbrains.buildServer.server.querylang.ast_old


interface ConditionContainer<T : Filter, S : Any> : Printable, Named, FilterBuilder<T, S>, Evaluator<T, S> {
    val condition: ConditionAST<T>

    override fun createStr(): String {
        return "${names[0]}(${condition.createStr()})"
    }

    override fun build(context: Any?) = buildFilter(condition, context)

    override fun evalCondition(condition: ConditionAST<T>) = buildFilter(condition)

    override fun eval(): EvalResult<S> = eval(condition)

    override fun evalFilter(filter: T): EvalResult<S> {
        return EvalResult(filter.buildRev(), listOf())
    }

    fun emptyEval(filter: T) = EvalResult(filter.buildRev(), listOf())
}