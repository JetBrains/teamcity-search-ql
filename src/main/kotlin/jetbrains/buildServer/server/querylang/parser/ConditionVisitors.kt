package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*

inline fun <reified T: Filter> getConditionVisitor(): ConditionVisitor<T> {
    return ConditionVisitor<T>(FilterVisitor<T>(T::class), T::class)
}

internal val projectConditionVisitor = getConditionVisitor<ProjectFilter>()
internal val buildConfConditionVisitor = getConditionVisitor<BuildConfFilter>()
internal val tempConditionVisitor = getConditionVisitor<TempFilter>()
internal val vcsRootConditionVisitor = getConditionVisitor<VcsRootFilter>()
internal val parHolderConditionVisitor = getConditionVisitor<ParameterHolderFilter>()

internal val anyFilterConditionVisitor = getConditionVisitor<Filter>()

internal fun String.fromIdentOrString(): String {
    if (this.length <= 1) {
        return this
    }

    var res = this

    if (this.first() == '"') {
        res = res.drop(1)
    }

    if (this.last() == '"') {
        res = res.dropLast(1)
    }

    return res
}