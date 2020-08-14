package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.users.SUser
import jetbrains.buildServer.util.EventDispatcher
import jetbrains.buildServer.vcs.SVcsRoot

class AutocompletionEventListener(
    val queue: TaskQueue,
    val projectManager: ProjectManager,
    eventDispatcher: EventDispatcher<BuildServerListener>
) : BuildServerAdapter() {
    init {
        eventDispatcher.addListener(this)
    }

    override fun serverShutdown() {
        queue.destroy()
    }

    override fun buildTypePersisted(buildType: SBuildType) {
        queue.addBuildType(buildType)
    }

    override fun buildTypeRegistered(buildType: SBuildType) {
        queue.addBuildType(buildType)
    }

    override fun projectPersisted(projectId: String) {
        projectManager.findProjectByExternalId(projectId)?.let { queue.addProject(it) }
    }

    override fun projectCreated(projectId: String, user: SUser?) {
        projectManager.findProjectById(projectId)?.let {queue.addProject(it)}
    }

    override fun projectRestored(projectId: String) {
        projectManager.findProjectById(projectId)?.let {queue.addProject(it)}
    }

    override fun projectDearchived(projectId: String) {
        projectManager.findProjectById(projectId)?.let {queue.addProject(it)}
    }

    override fun buildTypeTemplatePersisted(buildTemplate: BuildTypeTemplate) {
        queue.addTemplate(buildTemplate)
    }

    override fun buildTypeTemplateRestored(buildTemplate: BuildTypeTemplate) {
        queue.addTemplate(buildTemplate)
    }

    override fun vcsRootPersisted(vcsRoot: SVcsRoot) {
        queue.addVcsRoot(vcsRoot)
    }

    override fun vcsRootUpdated(oldVcsRoot: SVcsRoot, newVcsRoot: SVcsRoot) {
        queue.addVcsRoot(newVcsRoot)
    }
}