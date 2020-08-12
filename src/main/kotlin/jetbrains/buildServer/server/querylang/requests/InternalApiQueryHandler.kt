package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast_old.*
import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project
import jetbrains.buildServer.server.querylang.objects.VcsRoot
import jetbrains.buildServer.serverSide.ProjectManager

class InternalApiQueryHandler(
        val projectManager: ProjectManager
) : QueryHandler {
    override fun makeRequest(mainQuery: MainQuery): QueryResult {
        return when(mainQuery) {
            is FindMultipleTypes -> {
                mainQuery.findQueries.map { query ->
                    when (query) {
                        is FindProject -> findProjects(query)
                        is FindBuildConf -> findBuildConfs(query)
                        is FindTemplate -> findTemplates(query)
                        is FindVcsRoot -> findVcsRoots(query)
                    }
                }.fold(QueryResult()) { q1, q2 -> q1.join(q2) }
            }
            is MultipleMainQuery -> {
                QueryResult()
            }
        }
    }

    private fun findProjects(query: FindProject): QueryResult {
        val projectFilter = query.build()
        return QueryResult(
                projectManager.projects
                        .filter {projectFilter.accepts(it)}
                        .map {Project(it)}
                        .toMutableList()
        )
    }

    private fun findBuildConfs(query: FindBuildConf): QueryResult {
        val (filter, result) = query.eval()
        val res = if (filter is NoneObjectFilter) result
                  else projectManager.allBuildTypes.filter {bt -> bt !in result && filter.accepts(bt)}
        return QueryResult(
                res.map {BuildConfiguration(it)}.toMutableList()
        )
    }

    private fun findTemplates(query: FindTemplate): QueryResult {
        val templateConfFilter = query.build()
        return QueryResult(
                projectManager
                        .allTemplates
                        .filter {templateConfFilter.accepts(it)}
                        .map { BuildTemplate(it) }
                        .toMutableList()
        )
    }

    private fun findVcsRoots(query: FindVcsRoot): QueryResult {
        val vcsRootFilter = query.build()
        return QueryResult(
                projectManager
                        .allVcsRoots
                        .filter {vcsRootFilter.accepts(it)}
                        .map {VcsRoot(it)}
                        .toMutableList()
        )
    }
}