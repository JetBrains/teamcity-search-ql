package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.controllers.FormUtil
import jetbrains.buildServer.controllers.admin.AdminPage
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.requests.RequestClient
import jetbrains.buildServer.server.querylang.requests.InternalApiQueryHandler
import jetbrains.buildServer.server.querylang.requests.QueryResult

import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.SecurityContextEx
import jetbrains.buildServer.serverSide.ServerListener
import jetbrains.buildServer.serverSide.TeamCityProperties
import jetbrains.buildServer.serverSide.executors.ExecutorServices
import jetbrains.buildServer.util.EventDispatcher
import jetbrains.buildServer.util.ThreadUtil
import jetbrains.buildServer.web.openapi.Groupable
import jetbrains.buildServer.web.openapi.PagePlaces
import jetbrains.buildServer.web.openapi.PluginDescriptor
import jetbrains.buildServer.web.util.CameFromSupport
import org.springframework.security.core.context.SecurityContextHolder
import java.lang.Exception
import java.util.concurrent.*
import javax.servlet.http.HttpServletRequest

class SearchAdminPage(
    private val pluginDescriptor: PluginDescriptor,
    pagePlaces: PagePlaces,
    projectManager_: ProjectManager,
    private val executorServices: ExecutorServices,
    private val securityContext: SecurityContextEx
) : AdminPage(
        pagePlaces,
        "search",
        pluginDescriptor.getPluginResourcesPath("search.jsp"),
        "Search"
    )
{

    private val TIMELIMIT_PARAM_NAME = "query.lang.timelimit.millis"
    private val DEFAULT_TIMELIMIT: Long = 2000

    private val projectManager: ProjectManager = projectManager_
    private val requestClient: RequestClient
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
        val executor = executorServices.normalExecutorService


        var task: Future<QueryResult>? = null
        try {
            val result = bean.getQuery()?.let {
                val queryTimelimit = TeamCityProperties.getIntervalMilliseconds(TIMELIMIT_PARAM_NAME, DEFAULT_TIMELIMIT)
                val authHolder = securityContext.authorityHolder
                task = executor.submit<QueryResult> {
                    val oldAuthorityHolder = securityContext.authorityHolder
                    securityContext.authorityHolder = authHolder
                    val res = requestClient.process(it)
                    securityContext.authorityHolder = oldAuthorityHolder
                    return@submit res
                }
                task!!.get(queryTimelimit, TimeUnit.MILLISECONDS)
            }
            bean.buildResultList(result)
        } catch (e: TimeoutException) {
            bean.setWrongQueryMessage("Timeout")
        } catch (e: ExecutionException) {
            val innere = e.cause
            if (innere is ParsingException) {
                bean.setWrongQueryMessage("Wrong query: ${innere.message}")
            } else {
                bean.setWrongQueryMessage("Java ${e.javaClass.name} exception: ${innere?.message}")
            }
        }
        catch (e: Exception) {
            bean.setWrongQueryMessage("Java exception: ${e.message}")
        }
        finally {
            try {
                task?.cancel(true)
            }
            catch (e: InterruptedException) {}
            catch (e: Exception) {}
        }


        model["searchForm"] = bean
        CameFromSupport.setupCameFromUrl(model, request)
    }

    override fun getGroup(): String {
        return Groupable.PROJECT_RELATED_GROUP
    }

}