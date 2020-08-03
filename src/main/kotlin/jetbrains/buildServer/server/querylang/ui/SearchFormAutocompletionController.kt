package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.controllers.BaseAutocompletionController
import jetbrains.buildServer.controllers.Completion
import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.auth.SecurityContext
import jetbrains.buildServer.web.openapi.WebControllerManager
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
        return autoCompl.complete(term).map {Completion(it.result, it.show, "", true)}
    }
}