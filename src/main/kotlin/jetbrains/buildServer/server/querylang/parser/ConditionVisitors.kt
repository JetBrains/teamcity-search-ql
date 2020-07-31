package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*

inline fun <reified T: Filter> getConditionVisitor(): ConditionVisitor<T> {
    return ConditionVisitor<T>(FilterVisitor<T>(T::class), T::class)
}

internal val projectConditionVisitor = getConditionVisitor<ProjectFilterType>()
internal val buildConfConditionVisitor = getConditionVisitor<BuildConfFilterType>()
internal val tempConditionVisitor = getConditionVisitor<TemplateFilterType>()
internal val vcsRootConditionVisitor = getConditionVisitor<VcsRootFilterType>()
internal val parHolderConditionVisitor = getConditionVisitor<ParameterHolderFilterType>()

internal val anyFilterConditionVisitor = getConditionVisitor<Filter>()

internal val vcsRootEntryConditionVisitor = getConditionVisitor<VcsRootEntryFilter>()
internal val dependencyConditionVisitor = getConditionVisitor<DependencyFilterType>()