package jetbrains.buildServer.server.querylang.ast

abstract class ObjectEvaluator<T> : Filter<T> {
    protected abstract fun evalSimple(): List<T>
    fun eval() = EvalResult(NoneObjectFilter(), evalSimple())
}