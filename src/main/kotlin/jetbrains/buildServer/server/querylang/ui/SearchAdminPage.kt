package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.controllers.FormUtil
import jetbrains.buildServer.controllers.admin.AdminPage
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.requests.RequestClient
import jetbrains.buildServer.server.querylang.requests.InternalApiQueryHandler
import jetbrains.buildServer.server.querylang.requests.QueryResult

import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.ServerListener
import jetbrains.buildServer.serverSide.TeamCityProperties
import jetbrains.buildServer.util.EventDispatcher
import jetbrains.buildServer.util.ThreadUtil
import jetbrains.buildServer.web.openapi.Groupable
import jetbrains.buildServer.web.openapi.PagePlaces
import jetbrains.buildServer.web.openapi.PluginDescriptor
import jetbrains.buildServer.web.util.CameFromSupport
import java.lang.Exception
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import javax.servlet.http.HttpServletRequest

class SearchAdminPage(
    private val pluginDescriptor: PluginDescriptor,
    pagePlaces: PagePlaces,
    projectManager_: ProjectManager,
    serverDispatcher: EventDispatcher<ServerListener>
) : AdminPage(
        pagePlaces,
        "search",
        pluginDescriptor.getPluginResourcesPath("search.jsp"),
        "Search"
    ),
    ServerListener
{

    private val TIMELIMIT_PARAM_NAME = "query.lang.timelimit.millis"
    private val DEFAULT_TIMELIMIT: Long = 2000
    private val executor = Executors.newSingleThreadExecutor()
    private val projectManager: ProjectManager = projectManager_
    private val requestClient: RequestClient
    init {
        requestClient = RequestClient(InternalApiQueryHandler(projectManager))
        serverDispatcher.addListener(this)
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
            val result = bean.getQuery()?.let {
                val queryTimelimit = TeamCityProperties.getIntervalMilliseconds(TIMELIMIT_PARAM_NAME, DEFAULT_TIMELIMIT)
                val fut = executor.submit<QueryResult> { requestClient.process(it) }
                fut.get(queryTimelimit, TimeUnit.MILLISECONDS)
            }
            bean.buildResultList(result)
        } catch (e: TimeoutException) {
            bean.setWrongQueryMessage("Timeout")
        } catch (e: ExecutionException) {
            val innere = e.cause
            if (innere is ParsingException) {
                bean.setWrongQueryMessage("Wrong query: ${innere.message}")
            } else {
                bean.setWrongQueryMessage("Java exception: ${"Java exception: ${innere?.message}"}")
            }
        }
        catch (e: Exception) {
            bean.setWrongQueryMessage("Java exception: ${e.message}")
        }
        model["searchForm"] = bean
        CameFromSupport.setupCameFromUrl(model, request)
    }

    override fun getGroup(): String {
        return Groupable.PROJECT_RELATED_GROUP
    }

    override fun serverShutdown() {
        ThreadUtil.shutdownGracefully(executor, "Search admin page executor")
    }

    override fun serverStartup() {}

}