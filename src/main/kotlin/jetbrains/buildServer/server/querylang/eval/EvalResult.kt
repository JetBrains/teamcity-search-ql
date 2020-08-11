package jetbrains.buildServer.server.querylang.eval

import jetbrains.buildServer.server.querylang.ast.ObjectFilter

data class EvalResult<T>(val filter: ObjectFilter<T>, val objects: List<T>)