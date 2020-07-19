package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.server.querylang.ast.FindProject
import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project
import jetbrains.buildServer.server.querylang.objects.VcsRoot
import jetbrains.buildServer.server.querylang.requests.*
import jetbrains.buildServer.serverSide.ProjectManager

class SearchAdminBean(val searchAdminForm: SearchAdminForm, val projectManager: ProjectManager){
    private lateinit var result: QueryResult<*>
    val resultProjects = mutableListOf<Pair<String, String>>()
    val resultBuildConfigurations = mutableListOf<Pair<String, String>>()
    val resultTemplates = mutableListOf<Pair<String, String>>()
    val resultVcsRoots = mutableListOf<Pair<String, String>>()

    private val PROJECT_URL_PREFIX = "/bs/project.html?projectId="
    private val BUILD_CONF_URL_PREFIX = "/bs/viewType.html?buildTypeId="
    private val BUILD_TEMPLATE_URL_PREFIX = "/bs/admin/editBuild.html?id=template:"
    private val VCS_ROOT_URL_PREFIX = "/bs/admin/editVcsRoot.html?vcsRootId="

    fun getQuery(): String? {
        return searchAdminForm.query
    }

    fun buildResultList(result_: QueryResult<*>?) {
        if (result_ == null) {
            return
        }
        result = result_
        for (elem in result.objects) {
            when (elem) {
                is Project -> addProject(elem.externalId)
                is BuildConfiguration -> addBuildConf(elem.externalId)
                is BuildTemplate -> addTemplate(elem.externalId)
                is VcsRoot -> addVcsRoot(elem.externalId)
            }
        }
    }

    fun isNothingFound(): Boolean {
        return resultProjects.isEmpty() &&
                resultBuildConfigurations.isEmpty() &&
                resultTemplates.isEmpty() &&
                resultVcsRoots.isEmpty()
    }

    fun hasProjects() = resultProjects.isNotEmpty()
    fun hasBuildConfs() = resultBuildConfigurations.isNotEmpty()
    fun hasTemplates() = resultTemplates.isNotEmpty()
    fun hasVcsRoots() = resultVcsRoots.isNotEmpty()

    private fun addProject(id: String) {
        resultProjects.add(Pair(PROJECT_URL_PREFIX + id, id))
    }

    private fun addBuildConf(id: String) {
        resultBuildConfigurations.add(Pair(BUILD_CONF_URL_PREFIX + id, id))
    }

    private fun addTemplate(id: String) {
        resultTemplates.add(Pair(BUILD_TEMPLATE_URL_PREFIX + id, id))
    }

    private fun addVcsRoot(id: String) {
        resultVcsRoots.add(Pair(VCS_ROOT_URL_PREFIX + id, id))
    }
}