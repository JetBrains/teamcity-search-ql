package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.controllers.FormUtil
import jetbrains.buildServer.controllers.admin.AdminOverviewBean
import jetbrains.buildServer.controllers.admin.AdminPage
import jetbrains.buildServer.controllers.admin.ProjectAdminForm
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.requests.ConsoleResultPrinter
import jetbrains.buildServer.server.querylang.requests.RequestClient
import jetbrains.buildServer.server.querylang.requests.InternalApiQueryHandler

import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.web.openapi.Groupable
import jetbrains.buildServer.web.openapi.PagePlaces
import jetbrains.buildServer.web.openapi.PluginDescriptor
import jetbrains.buildServer.web.util.CameFromSupport
import java.lang.Exception
import javax.servlet.http.HttpServletRequest

class SearchAdminPage(
    private val pluginDescriptor: PluginDescriptor,
    pagePlaces: PagePlaces,
    projectManager_: ProjectManager
) : AdminPage(
        pagePlaces,
        "search",
        pluginDescriptor.getPluginResourcesPath("search.jsp"),
        "Search"
    )
{

    private val projectManager: ProjectManager = projectManager_
    private val requestClient: RequestClient
    val parser = QueryParser()
    init {
        requestClient = RequestClient(InternalApiQueryHandler(projectManager))
        register()
    }

    override fun fillModel(model: MutableMap<String, Any>, request: HttpServletRequest) {
        val form = FormUtil.getOrCreateForm(
            request,
            SearchAdminForm::class.java
        ) { SearchAdminForm() }!!
        FormUtil.bindFromRequest(request, form)

        val bean = SearchAdminBean(form, projectManager)
        try {
            val result = bean.getQuery()?.let { requestClient.process(parser.parse(it)) }
            bean.buildResultList(result)
        } catch (e: ParsingException) {
            bean.setWrongQueryMessage("Wrong query: ${e.message}")
        } catch (e: Exception) {
            bean.setWrongQueryMessage("Java exception: ${e.message}")
        }
        model["searchForm"] = bean
        CameFromSupport.setupCameFromUrl(model, request)
    }

    override fun getGroup(): String {
        return Groupable.PROJECT_RELATED_GROUP
    }

}