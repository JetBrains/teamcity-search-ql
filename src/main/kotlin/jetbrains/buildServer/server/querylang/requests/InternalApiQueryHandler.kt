package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.filter.*
import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project
import jetbrains.buildServer.server.querylang.objects.VcsRoot
import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.vcs.SVcsRoot

class InternalApiQueryHandler(
        val projectManager: ProjectManager
) : QueryHandler {
    override fun makeRequest(mainQuery: MainQuery): QueryResult {
        return when(mainQuery) {
            is FindMultipleTypes -> {
                mainQuery.findQueries.map { query ->
                    when (query) {
                        is FindProject -> findProjects(query.condition)
                        is FindBuildConf -> findBuildConfs(query.condition)
                        is FindTemplate -> findTemplates(query.condition)
                        is FindVcsRoot -> findVcsRoots(query.condition)
                    }
                }.fold(QueryResult()) { q1, q2 -> q1.join(q2) }
            }
            is MultipleMainQuery -> {
                QueryResult()
            }
        }
    }

    private fun findProjects(condition: ConditionAST<ProjectFilterType>): QueryResult {
        val projectFilter = ProjectFilterBuilder.createFilter(condition)
        return QueryResult(
                projectManager.projects
                        .filter {projectFilter.accepts(it)}
                        .map {Project(it)}
                        .toMutableList()
        )
    }

    private fun findBuildConfs(condition: ConditionAST<BuildConfFilterType>): QueryResult {
        val buildConfFilter = BuildConfFilterBuilder.createFilter(condition)
        return QueryResult(
                projectManager
                        .allBuildTypes
                        .filter {buildConfFilter.accepts(it)}
                        .map {BuildConfiguration(it)}
                        .toMutableList()
        )
    }

    private fun findTemplates(condition: ConditionAST<TemplateFilterType>): QueryResult {
        val templateConfFilter = TemplateFilterBuilder.createFilter(condition)
        return QueryResult(
                projectManager
                        .allTemplates
                        .filter {templateConfFilter.accepts(it)}
                        .map { BuildTemplate(it) }
                        .toMutableList()
        )
    }

    private fun findVcsRoots(condition: ConditionAST<VcsRootFilterType>): QueryResult {
        val vcsRootFilter = VcsRootFilterBuilder.createFilter(condition)
        return QueryResult(
                projectManager
                        .allVcsRoots
                        .filter {vcsRootFilter.accepts(it)}
                        .map {VcsRoot(it)}
                        .toMutableList()
        )
    }
}