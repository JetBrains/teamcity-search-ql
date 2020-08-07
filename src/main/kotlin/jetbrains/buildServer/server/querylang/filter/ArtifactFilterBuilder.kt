package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.ArtifactDepFilterType
import jetbrains.buildServer.server.querylang.ast.CleanFilter
import jetbrains.buildServer.server.querylang.ast.RevRuleFilter
import jetbrains.buildServer.server.querylang.ast.RulesFilter

object ArtifactFilterBuilder : FilterBuilder<ArtifactDepFilterType, DependencyFilterBuilder.MyArtifactDependency> {
    override fun createFilter(
        filter: ArtifactDepFilterType,
        context: Any?
    ): ObjectFilter<DependencyFilterBuilder.MyArtifactDependency> {
        return when(filter) {
            is RulesFilter -> {
                val conditionFilter = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {obj ->
                    conditionFilter.accepts(obj.dep.sourcePaths)
                }
            }
            is CleanFilter -> {
                ObjectFilter {obj ->
                    obj.dep.isCleanDestinationFolder
                }
            }
            is RevRuleFilter -> {
                val conditionFilter = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {obj ->
                    conditionFilter.accepts(obj.dep.revisionRule.name)
                }
            }
            else -> throw IllegalStateException("Unknown filter '${filter::class.java}' of ArtifactDependencyFilterType")
        }
    }
}