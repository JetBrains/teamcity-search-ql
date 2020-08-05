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
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    val settings = if (!filter.includeInherited) buildType.settings.ownBuildTriggers
                                   else buildType.buildTriggersCollection
                    settings.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter {buildType ->
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")
                    val settings = if (!filter.includeInherited) buildType.settings.ownBuildRunners
                                   else buildType.buildRunners
                    settings.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter {buildType ->
                    val condition = ParHolderFilterBuilder.createFilter(filter.condition, buildType)
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")

                    val settings = if (!filter.includeInherited) buildType.settings.ownBuildFeatures
                                   else buildType.buildFeatures
                    settings.any {feature ->
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
                val valFilter = StringFilterBuilder.createFilter(filter.valueCondition)
                val nameFilter = StringFilterBuilder.createFilter(filter.nameCondition)
                ObjectFilter {buildType ->
                    val params = if (filter.includeInherited) buildType.parameters
                                   else buildType.ownParameters
                    params.any<String, String> {(key, value) ->
                        nameFilter.accepts(key) && valFilter.accepts(value)
                    }
                }
            }
            is DependencyFilter -> {
                ObjectFilter {buildType ->
                    val dependencyFilter = DependencyFilterBuilder.createFilter(filter.condition, buildType)
                    buildType as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")

                    val artifactDeps = if (filter.includeInhereted) buildType.artifactDependencies
                                       else buildType.settings.ownArtifactDependencies

                    val snapshotDeps = if (filter.includeInhereted) buildType.dependencies
                                       else buildType.ownDependencies

                    snapshotDeps.any {dependencyFilter.accepts(it.dependOn)}
                            || artifactDeps.any {dependencyFilter.accepts(it.sourceBuildType)}
                }
            }

            else -> throw IllegalStateException("Unknow BCFilter")
        }
    }
}