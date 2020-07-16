package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.filter.FilterBuilder
import jetbrains.buildServer.server.querylang.objects.BuildConfOrTemp
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
    override fun makeRequest(query: MainQuery): QueryResult {
        //val a = projectManager.allVcsRoots[0]
        return when (query) {
            is FindProject -> findProjects(query.condition)
            is FindBuildConf -> findBuildConfs(query.condition)
            is FindTemplate -> findTemplates(query.condition)
            is FindVcsRoot -> findVcsRoots(query.condition)
            is FindBuildConfOrTemplate -> {
                val templates = findTemplates(query.condition).templates.map {it as BuildConfOrTemp}
                val buildConfs = findBuildConfs(query.condition).buildConfs.map {it as BuildConfOrTemp}
                ResultBuildConfOrTemp(templates.union(buildConfs).toList())
            }
        }
    }

    private fun findProjects(condition: ConditionAST<ProjectFilter>): ResultProject {
        val projectFilter = FilterBuilder.fromCondition<ProjectFilter, SProject>(condition, FilterBuilder::makeProjectFilter)
        return ResultProject(
                projectManager.projects
                        .filter {projectFilter.accepts(it)}
                        .map {Project(it)}
                        .toMutableList()
        )
    }

    private fun findBuildConfs(condition: ConditionAST<BuildConfFilter>): ResultBuildConfiguration {
        val buildConfFilter = FilterBuilder.fromCondition<BuildConfFilter, SBuildType>(condition, FilterBuilder::makeBCFilter)
        return ResultBuildConfiguration(
                projectManager
                        .allBuildTypes
                        .filter {buildConfFilter.accepts(it)}
                        .map {BuildConfiguration(it)}
                        .toMutableList()
        )
    }

    private fun findTemplates(condition: ConditionAST<TempFilter>): ResultBuildTemplate {
        val templateConfFilter = FilterBuilder.fromCondition<TempFilter, BuildTypeTemplate>(condition, FilterBuilder::makeTempFilter)
        return ResultBuildTemplate(
                projectManager
                        .allTemplates
                        .filter {templateConfFilter.accepts(it)}
                        .map { BuildTemplate(it) }
                        .toMutableList()
        )
    }

    private fun findVcsRoots(condition: ConditionAST<VcsRootFilter>): ResultVcsRoot {
        val vcsRootFilter = FilterBuilder.fromCondition<VcsRootFilter, SVcsRoot>(condition, FilterBuilder::makeVcsFilter)
        return ResultVcsRoot(
                projectManager
                        .allVcsRoots
                        .filter {vcsRootFilter.accepts(it)}
                        .map {VcsRoot(it)}
                        .toMutableList()
        )
    }
}