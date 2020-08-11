package jetbrains.buildServer.server.querylang.ast

data class EvalResult<T>(val filter: ObjectFilter<T>, val objects: List<T>)