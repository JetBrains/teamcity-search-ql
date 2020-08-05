package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.filter.VcsRootEntryFilterBuilder.toMyVcsRootEntry
import jetbrains.buildServer.serverSide.BuildTypeEx
import jetbrains.buildServer.serverSide.BuildTypeTemplate
import java.lang.IllegalStateException

object TemplateFilterBuilder : FilterBuilder<TemplateFilterType, BuildTypeTemplate> {
    override fun createFilter(filter: TemplateFilterType, context: Any?): ObjectFilter<BuildTypeTemplate> {
        return when(filter) {
            is ProjectFilter -> {
                val projectFilter = ProjectFilterBuilder.createFilter(ProjectFilter(filter.condition))
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is IdFilter -> {
                val condition = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {buildType ->
                    condition.accepts(buildType.externalId)
                }
            }
            is TriggerFilter -> {
                ObjectFilter {buildType ->
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType.buildTriggersCollection.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter {buildType ->
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType.buildRunners.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter {buildType ->
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType.buildFeatures.any {feature ->
                        condition.accepts(feature)
                    }
                }
            }
            is ParentFilter -> {
                val projectFilter = ProjectFilterBuilder.createFilter(filter.condition)
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is VcsRootFilter -> {
                val vcsFilter = VcsRootEntryFilterBuilder.createFilter(filter.condition)
                ObjectFilter {buildType ->
                    buildType.vcsRootEntries.any {vcsFilter.accepts(it.toMyVcsRootEntry())}
                }
            }
            is ParameterFilter -> {
                val stringFilter = StringFilterBuilder.createFilter(filter.valueCondition)
                ObjectFilter {buildType ->
                    val params = if (filter.includeInherited) buildType.parameters
                                 else buildType.ownParameters
                    params.any<String, String> {(key, value) ->
                        key == filter.option && stringFilter.accepts(value)
                    }
                }
            }
            is DependencyFilter -> {
                ObjectFilter {buildType ->
                    val dependencyFilter = DependencyFilterBuilder.createFilter(filter.condition, buildType)
                    buildType.dependencies.any {dependencyFilter.accepts(it.dependOn)}
                            || buildType.artifactDependencies.any {dependencyFilter.accepts(it.sourceBuildType)}
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow TemplateFilterType")
        }
    }
}