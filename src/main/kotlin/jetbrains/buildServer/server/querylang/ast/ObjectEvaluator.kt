package jetbrains.buildServer.server.querylang.ast

interface ObjectEvaluator<T> : Filter<T> {
    fun evalSimple(): List<T>
    fun eval() = EvalResult(NoneObjectFilter(), evalSimple())
}