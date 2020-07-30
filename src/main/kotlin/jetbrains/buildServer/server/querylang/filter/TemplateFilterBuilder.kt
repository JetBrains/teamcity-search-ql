package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.filter.VcsRootEntryFilterBuilder.toMyVcsRootEntry
import jetbrains.buildServer.serverSide.BuildTypeTemplate

object TemplateFilterBuilder : FilterBuilder<TemplateFilterType, BuildTypeTemplate> {
    override fun createFilter(filter: TemplateFilterType, context: Any?): ObjectFilter<BuildTypeTemplate> {
        return when(filter) {
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
            else -> throw java.lang.IllegalStateException("Unknow TemplateFilterType")
        }
    }
}