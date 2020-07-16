package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*

inline fun <reified T: Filter> getConditionVisitor(): ConditionVisitor<T> {
    return ConditionVisitor<T>(FilterVisitor<T>(T::class), T::class)
}

internal val projectConditionVisitor = getConditionVisitor<ProjectFilter>()
internal val buildConfConditionVisitor = getConditionVisitor<BuildConfFilter>()
internal val tempConditionVisitor = getConditionVisitor<TempFilter>()
internal val buildConfOrTempConditionVisitor = getConditionVisitor<BcOrTempFilter>()
internal val vcsRootConditionVisitor = getConditionVisitor<VcsRootFilter>()
internal val parHolderConditionVisitor = getConditionVisitor<ParameterHolderFilter>()