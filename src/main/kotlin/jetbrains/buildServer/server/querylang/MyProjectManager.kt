package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.serverSide.auth.AccessDeniedException
import jetbrains.buildServer.serverSide.auth.AuthorityHolder
import jetbrains.buildServer.serverSide.auth.SecurityContext
import jetbrains.buildServer.serverSide.parameters.types.ParameterTypeManager

class MyProjectManager(private val projectManager: ProjectManager): ProjectManager by projectManager {

    override fun findProjectByExternalId(p0: String?): SProject? {
        return try {
            projectManager.findProjectByExternalId(p0)
        } catch(e: AccessDeniedException) {
            null
        }
    }

    override fun findBuildTypeByExternalId(p0: String?): SBuildType? {
        return try {
            projectManager.findBuildTypeByExternalId(p0)
        } catch(e: AccessDeniedException) {
            null
        }
    }

    override fun findBuildTypeTemplateByExternalId(p0: String?): BuildTypeTemplate? {
        return try {
            projectManager.findBuildTypeTemplateByExternalId(p0)
        } catch(e: AccessDeniedException) {
            null
        }
    }

    override fun findVcsRootByExternalId(p0: String): SVcsRoot? {
        return try {
            projectManager.findVcsRootByExternalId(p0)
        } catch(e: AccessDeniedException) {
            null
        }
    }
}

lateinit var myProjectManager: MyProjectManager
lateinit var myParameterManager: ParameterTypeManager
lateinit var mySecurityContext: SecurityContext

class MyProjectManagerInit(
    val projectManager: ProjectManager,
    parameterManager: ParameterTypeManager,
    securityContext: SecurityContext
) {
    init {
        myProjectManager = MyProjectManager(projectManager)
        myParameterManager = parameterManager
        mySecurityContext = securityContext
    }
}

