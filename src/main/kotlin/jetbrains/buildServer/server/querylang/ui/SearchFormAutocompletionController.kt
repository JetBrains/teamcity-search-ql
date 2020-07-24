package jetbrains.buildServer.server.querylang.ui

import jetbrains.buildServer.controllers.BaseAutocompletionController
import jetbrains.buildServer.controllers.Completion
import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.auth.SecurityContext
import jetbrains.buildServer.web.openapi.WebControllerManager
import javax.servlet.http.HttpServletRequest


class SearchFormAutocompletionController(
    projectManager: ProjectManager,
    securityContext: SecurityContext,
    webControllerManager: WebControllerManager
) : BaseAutocompletionController(securityContext) {

    private val autoCompl: AutoCompletion

    init {
        webControllerManager.registerController("/adminQueryAutocompletion.html", this)

        autoCompl = AutoCompletion(
            projectManager
        )
    }

    override fun getCompletionData(request: HttpServletRequest): List<Completion?> {
        val term = request.getParameter("term")
        return autoCompl.complete(term).map {Completion(it.first, it.second, "", true)}
    }
}