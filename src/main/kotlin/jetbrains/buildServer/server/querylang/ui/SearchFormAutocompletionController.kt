package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.controllers.BaseAutocompletionController
import jetbrains.buildServer.controllers.Completion
import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.auth.SecurityContext
import jetbrains.buildServer.web.openapi.WebControllerManager
import jetbrains.buildServer.web.util.WebUtil
import javax.servlet.http.HttpServletRequest


class SearchFormAutocompletionController(
    securityContext: SecurityContext,
    webControllerManager: WebControllerManager,
    private val autoCompl: AutoCompletion
) : BaseAutocompletionController(securityContext) {

    init {
        webControllerManager.registerController("/adminQueryAutocompletion.html", this)
    }

    override fun getCompletionData(request: HttpServletRequest): List<Completion?> {
        val term = request.getParameter("term")
        val res = try {
            autoCompl.complete(term).map {
                Completion(
                        it.result,
                        if (it.show == "?" && it.meta == "Context based completion") {
                            "<b>?</b>"
                        } else {
                            WebUtil.escapeXml(it.show)
                        },
                        it.meta ?: "",
                        true
                )
            }
        } catch (e: Exception) {
            //TODO("Add logging")
            emptyList<Completion>()
        }
        return res
    }
}