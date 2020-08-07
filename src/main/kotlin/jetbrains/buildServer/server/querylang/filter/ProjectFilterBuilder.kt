package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.SProject

object ProjectFilterBuilder : FilterBuilder<ProjectFilterType, SProject> {
    override fun createFilter(filter: ProjectFilterType, context: Any?) : ObjectFilter<SProject> {
        return when (filter) {
            is IdFilter -> {
                val condition = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {project ->
                    condition.accepts(project.externalId)
                }
            }
            is AncestorFilter -> {
                val conditionFilter = ProjectFilterBuilder.createFilter(filter.condition)
                ObjectFilter { project ->
                    hasSuitableAncestor(project.parentProject, conditionFilter)
                }
            }
            is ParentFilter -> {
                val conditionFilter = ProjectFilterBuilder.createFilter(filter.condition)
                ObjectFilter {project ->
                    conditionFilter.accepts(project.parentProject)
                }
            }
            is ProjectFilter -> {
                val conditionFilter = ProjectFilterBuilder.createFilter(filter.condition)
                ObjectFilter {project ->
                    hasSuitableAncestor(project, conditionFilter)
                }
            }
            is FeatureFilter -> {
                val condFilter = ParHolderFilterBuilder.createFilter(filter.condition)
                ObjectFilter {project ->
                    val features = if (filter.includeInherited) project.availableFeatures
                                   else project.ownFeatures

                    features.any { feat ->
                        condFilter.accepts(feat)
                    }
                }
            }

            is ParameterFilter -> {
                val nameFilter = StringFilterBuilder.createFilter(filter.nameCondition)
                val valFilter = StringFilterBuilder.createFilter(filter.valueCondition)

                ObjectFilter {project ->
                    val params = if (filter.includeInherited) project.parameters
                                 else project.ownParameters
                    params.any {(name, value) ->
                        nameFilter.accepts(name) && valFilter.accepts(value)
                    }
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow ProjectFilterType")
        }
    }

    private fun hasSuitableAncestor(project: SProject?, filter: ObjectFilter<SProject>): Boolean {
        var curProject: SProject? = project
        while (curProject != null) {
            if (filter.accepts(curProject)) {
                return true
            }
            curProject = curProject.parentProject
        }
        return false
    }
}