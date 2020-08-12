package jetbrains.buildServer.server.querylang.ast

data class EvalResult<Object>(val filter: ObjectFilter<Object>, val objects: List<Object>)

interface Evaluator<Object> {
    fun eval(): EvalResult<Object>
}