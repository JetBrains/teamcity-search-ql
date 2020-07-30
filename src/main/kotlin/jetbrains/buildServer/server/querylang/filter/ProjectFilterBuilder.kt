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
            is AncestorOrSelfFilter -> {
                val conditionFilter = ProjectFilterBuilder.createFilter(filter.condition)
                ObjectFilter {project ->
                    hasSuitableAncestor(project, conditionFilter)
                }
            }
            is ParentFilter -> {
                val conditionFilter = ProjectFilterBuilder.createFilter(filter.condition)
                ObjectFilter {project ->
                    conditionFilter.accepts(project.parentProject)
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