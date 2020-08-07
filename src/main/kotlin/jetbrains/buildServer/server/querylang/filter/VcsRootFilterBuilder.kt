package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.vcs.VcsRootInstanceEx

object VcsRootFilterBuilder : FilterBuilder<VcsRootFilterType, SVcsRoot> {
    override fun createFilter(filter: VcsRootFilterType, context: Any?): ObjectFilter<SVcsRoot> {
        return when(filter) {
            is IdFilter -> {
                val condition = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {vcs ->
                    condition.accepts(vcs.externalId)
                }
            }
            is ProjectFilter -> {
                val projectFilter = ProjectFilterBuilder.createFilter(ProjectFilter(filter.condition))
                ObjectFilter {vcs ->
                    projectFilter.accepts(vcs.project)
                }
            }
            is ParentFilter -> {
                val projectFilter = ProjectFilterBuilder.createFilter(filter.condition)
                ObjectFilter {vcs ->
                    projectFilter.accepts(vcs.project)
                }
            }
            is TypeFilter -> {
                val strFilter = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {vcs ->
                    strFilter.accepts(vcs.vcsName)
                }
            }
            is ParameterFilter -> {
                val nameFilter = StringFilterBuilder.createFilter(filter.nameCondition)
                val valFilter = StringFilterBuilder.createFilter(filter.valueCondition)

                ObjectFilter {vcs ->
                    vcs.properties.any {(name, value) ->
                        nameFilter.accepts(name) && valFilter.accepts(value)
                    }
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown VcsRootFilterType")
        }
    }
}