package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.serverSide.ServerListener
import jetbrains.buildServer.util.ThreadUtil
import jetbrains.buildServer.vcs.SVcsRoot
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.collections.LinkedHashSet

class TaskQueue(
    private val compl: CompletionManager,
    private val updatePeriod: Long = 300,
    private val initialDelay: Long = 30,
    private val tu: TimeUnit = TimeUnit.SECONDS
) {

    private val queue: LinkedHashSet<ObjectUpdateTask> = LinkedHashSet()
    private val scheduledExecutor = Executors.newSingleThreadScheduledExecutor()

    init {
        scheduledExecutor.scheduleAtFixedRate(
            { update() },
            initialDelay,
            updatePeriod,
            tu
        )
    }


    fun destroy() {
        ThreadUtil.shutdownGracefully(scheduledExecutor, "Query Language executor")
    }

    constructor(compl: CompletionManager): this(compl, 300, 30, TimeUnit.SECONDS)

    fun addBuildType(bt: SBuildType) {
        addObject(BuildTypeUpdateTask(bt))
    }
    fun addProject(project: SProject) {
        addObject(ProjectUpdateTask(project))
    }
    fun addVcsRoot(vcsRoot: SVcsRoot) {
        addObject(VcsRootUpdateTask(vcsRoot))
    }
    fun addTemplate(template: BuildTypeTemplate) {
        addObject(TemplateUpdateTask(template))
    }

    private fun addObject(task: ObjectUpdateTask) {
        synchronized(this) {
            queue.add(task)
        }
    }

    private fun update() {
        lateinit var tasks: List<ObjectUpdateTask>
        synchronized(this) {
            tasks = queue.toList()
            queue.clear()
        }
        update(tasks)
    }

    private fun update(tasks: List<ObjectUpdateTask>) {
        tasks.forEach {task ->
            when (task) {
                is ProjectUpdateTask -> {compl.updateProject(task.project)}
                is BuildTypeUpdateTask -> {compl.updateBuildType(task.buildType)}
                is TemplateUpdateTask -> {compl.updateTemplate(task.template)}
                is VcsRootUpdateTask -> {compl.updateVcsRoot(task.vcsRoot)}
            }
        }
    }

    internal interface ObjectUpdateTask

    data class ProjectUpdateTask(val project: SProject) : ObjectUpdateTask

    data class BuildTypeUpdateTask(val buildType: SBuildType) : ObjectUpdateTask

    data class TemplateUpdateTask(val template: BuildTypeTemplate) : ObjectUpdateTask

    data class VcsRootUpdateTask(val vcsRoot: SVcsRoot) : ObjectUpdateTask
}