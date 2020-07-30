package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.vcs.SVcsRoot

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
                val projectFilter = ProjectFilterBuilder.createFilter(AncestorOrSelfFilter(filter.condition))
                ObjectFilter {vcs ->
                    projectFilter.accepts(vcs.project)
                }
            }
            is TypeFilter -> {
                ObjectFilter {vcs ->
                    vcs.vcsName == filter.str
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown VcsRootFilterType")
        }
    }
}