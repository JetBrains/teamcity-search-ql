package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.filter.VcsRootEntryFilterBuilder.toMyVcsRootEntry
import jetbrains.buildServer.serverSide.BuildTypeEx
import jetbrains.buildServer.serverSide.SBuildType
import java.lang.IllegalStateException

object BuildConfFilterBuilder : FilterBuilder<BuildConfFilterType, SBuildType> {
    override fun createFilter(filter: BuildConfFilterType, context: Any?): ObjectFilter<SBuildType> {
        return when (filter) {
            is ProjectFilter -> {
                val projectFilter = ProjectFilterBuilder.createFilter(AncestorOrSelfFilter(filter.condition))
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
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType.settings.ownBuildTriggers.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter {buildType ->
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")
                    buildType.settings.ownBuildRunners.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter {buildType ->
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")
                    buildType.settings.ownBuildFeatures.any {feature ->
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
            is TempDepFilter -> {
                val tempFilter = TemplateFilterBuilder.createFilter(filter.condition)
                ObjectFilter {buildType ->
                    buildType.templates.any {tempFilter.accepts(it)}
                }
            }
            is VcsRootFilter -> {
                val vcsFilter = VcsRootEntryFilterBuilder.createFilter(filter.condition)
                ObjectFilter {buildType ->
                    buildType.vcsRootInstanceEntries.any {vcsFilter.accepts(it.toMyVcsRootEntry())}
                }
            }
            is ParameterFilter -> {
                val stringFilter = StringFilterBuilder.createFilter(filter.valueCondition)
                ObjectFilter {buildType ->
                    buildType.ownParameters.any<String, String> {(key, value) ->
                        key == filter.option && stringFilter.accepts(value)
                    }
                }
            }
            is DependencyFilter -> {
                ObjectFilter {buildType ->
                    val dependencyFilter = DependencyFilterBuilder.createFilter(filter.condition, buildType)
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")
                    buildType.ownDependencies.any {dependencyFilter.accepts(it.dependOn)}
                            || buildType.settings.ownArtifactDependencies.any {dependencyFilter.accepts(it.sourceBuildType)}
                }
            }

            else -> throw IllegalStateException("Unknow BCFilter")
        }
    }
}