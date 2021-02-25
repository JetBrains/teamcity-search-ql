package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.server.querylang.ast.wrappers.WBuildConf
import jetbrains.buildServer.server.querylang.ast.wrappers.WProject
import jetbrains.buildServer.server.querylang.ast.wrappers.WTemplate
import jetbrains.buildServer.server.querylang.ast.wrappers.WVcsRoot
import jetbrains.buildServer.server.querylang.requests.*
import jetbrains.buildServer.server.querylang.ui.objects.*
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.web.openapi.PluginDescriptor
import jetbrains.buildServer.web.util.WebUtil

class SearchAdminBean(
    val searchAdminForm: SearchAdminForm,
    val projectManager: ProjectManager,
    val pluginDescriptor: PluginDescriptor
){
    class ResultLine(
        val objUrl: String,
        showObj_: String,
        val parentProjectUrl: String?,
        showParent_: String?
    ) {
        val showObj = WebUtil.escapeXml(showObj_)
        val showParent = showParent_?.let {WebUtil.escapeXml(it)}
    }

    private lateinit var result: QueryResult
    var resultsTotal: Int = 0
    var resultsDisplayed: Int = 0
    private var wrongQueryMessage: String? = null

    val resultProjects = mutableListOf<ResultLine>()
    val resultBuildConfigurations = mutableListOf<ResultLine>()
    val resultTemplates = mutableListOf<ResultLine>()
    val resultVcsRoots = mutableListOf<ResultLine>()

    private val PROJECT_URL_PREFIX = "editProject.html?projectId="
    private val BUILD_CONF_URL_PREFIX = "editBuild.html?id=buildType:"
    private val BUILD_TEMPLATE_URL_PREFIX = "editBuild.html?id=template:"
    private val VCS_ROOT_URL_PREFIX = "editVcsRoot.html?vcsRootId="

    fun getQuery(): String? {
        return searchAdminForm.query
    }

    fun buildResultList(result_: QueryResult?) {
        if (result_ == null) {
            return
        }
        result = result_
        setResultsCnt(result.objects.size, result.objectsTotal)
        for (elem in result.objects) {
            when (elem) {
                is ProjectResult -> addProject(elem)
                is BuildConfigurationResult -> addBuildConf(elem)
                is TemplateResult -> addTemplate(elem)
                is VcsRootResult -> addVcsRoot(elem)
            }
        }
    }

    fun isNothingFound(): Boolean {
        return resultProjects.isEmpty() &&
                resultBuildConfigurations.isEmpty() &&
                resultTemplates.isEmpty() &&
                resultVcsRoots.isEmpty()
    }

    fun isWrongQuery() = wrongQueryMessage != null

    fun setWrongQueryMessage(message: String) {
        wrongQueryMessage = message
    }

    fun getWrongQueryMessage() = wrongQueryMessage

    fun hasProjects() = resultProjects.isNotEmpty()
    fun hasBuildConfs() = resultBuildConfigurations.isNotEmpty()
    fun hasTemplates() = resultTemplates.isNotEmpty()
    fun hasVcsRoots() = resultVcsRoots.isNotEmpty()

    fun notAllResultsLoaded() = resultsDisplayed != resultsTotal

    private fun setResultsCnt(resultsDisplayed_: Int, resultsTotal_: Int) {
        resultsTotal = resultsTotal_
        resultsDisplayed = resultsDisplayed_
    }

    private fun addProject(resObj: TeamCityObjectResult<WProject>) {
        resultProjects.add(getResLine(resObj, PROJECT_URL_PREFIX))
    }

    private fun addBuildConf(resObj: TeamCityObjectResult<WBuildConf>) {
        resultBuildConfigurations.add(getResLine(resObj, BUILD_CONF_URL_PREFIX))
    }

    private fun addTemplate(resObj: TeamCityObjectResult<WTemplate>) {
        resultTemplates.add(getResLine(resObj, BUILD_TEMPLATE_URL_PREFIX))
    }

    private fun addVcsRoot(resObj: TeamCityObjectResult<WVcsRoot>) {
        resultVcsRoots.add(getResLine(resObj, VCS_ROOT_URL_PREFIX, "&action=editVcsRoot"))
    }

    private fun getResLine(resObj: TeamCityObjectResult<*>, prefix: String, suffix: String = ""): ResultLine {

        val res = ResultLine(
            prefix + resObj.externalId + suffix,
            resObj.name,
            resObj.project?.id?.let {PROJECT_URL_PREFIX + it},
            resObj.project?.sproject?.extendedFullName
        )
        return res
    }
}