package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.filter.VcsRootEntryFilterBuilder.toMyVcsRootEntry
import jetbrains.buildServer.serverSide.BuildTypeTemplate

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
                    buildType.dependencies.any {
                        dependencyFilter.accepts(DependencyFilterBuilder.MySnapshotDependency(it))}
                            || buildType.artifactDependencies.any {dependencyFilter.accepts(DependencyFilterBuilder.MyArtifactDependency(it))
                    }
                }
            }
            is OptionFilter -> {
                val nameFilter = StringFilterBuilder.createFilter(filter.nameCondition)
                val valFilter = StringFilterBuilder.createFilter(filter.valueCondition)
                ObjectFilter {temp ->
                    val options = if (filter.includeInherited) temp.options
                    else temp.ownOptions
                    options.any {opt ->
                        nameFilter.accepts(opt.key) && valFilter.accepts(temp.getOption(opt).toString())
                    }
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow TemplateFilterType")
        }
    }
}