package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.filter.FilterBuilder
import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project
import jetbrains.buildServer.server.querylang.objects.VcsRoot
import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.vcs.SVcsRoot
import java.lang.IllegalStateException

class InternalApiQueryHandler(
        val projectManager: ProjectManager
) : QueryHandler {
    override fun makeRequest(multQuery: FindMultipleTypes): QueryResult {
        return multQuery.findQueries.map { query ->
            when (query) {
                is FindProject -> findProjects(query.condition)
                is FindBuildConf -> findBuildConfs(query.condition)
                is FindTemplate -> findTemplates(query.condition)
                is FindVcsRoot -> findVcsRoots(query.condition)
            }
        }.fold(QueryResult()) { q1, q2 -> q1.join(q2)}
    }

    private fun findProjects(condition: ConditionAST<ProjectFilter>): QueryResult {
        val projectFilter = FilterBuilder.fromCondition<ProjectFilter, SProject>(condition, FilterBuilder::makeProjectFilter)
        return QueryResult(
                projectManager.projects
                        .filter {projectFilter.accepts(it)}
                        .map {Project(it)}
                        .toMutableList()
        )
    }

    private fun findBuildConfs(condition: ConditionAST<BuildConfFilter>): QueryResult {
        val buildConfFilter = FilterBuilder.fromCondition<BuildConfFilter, SBuildType>(condition, FilterBuilder::makeBCFilter)
        return QueryResult(
                projectManager
                        .allBuildTypes
                        .filter {buildConfFilter.accepts(it)}
                        .map {BuildConfiguration(it)}
                        .toMutableList()
        )
    }

    private fun findTemplates(condition: ConditionAST<TempFilter>): QueryResult {
        val templateConfFilter = FilterBuilder.fromCondition<TempFilter, BuildTypeTemplate>(condition, FilterBuilder::makeTempFilter)
        return QueryResult(
                projectManager
                        .allTemplates
                        .filter {templateConfFilter.accepts(it)}
                        .map { BuildTemplate(it) }
                        .toMutableList()
        )
    }

    private fun findVcsRoots(condition: ConditionAST<VcsRootFilter>): QueryResult {
        val vcsRootFilter = FilterBuilder.fromCondition<VcsRootFilter, SVcsRoot>(condition, FilterBuilder::makeVcsFilter)
        return QueryResult(
                projectManager
                        .allVcsRoots
                        .filter {vcsRootFilter.accepts(it)}
                        .map {VcsRoot(it)}
                        .toMutableList()
        )
    }
}