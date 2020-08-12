package jetbrains.buildServer.server.querylang.ast_old

data class EvalResult<T>(val filter: ObjectFilter<T>, val objects: List<T>)