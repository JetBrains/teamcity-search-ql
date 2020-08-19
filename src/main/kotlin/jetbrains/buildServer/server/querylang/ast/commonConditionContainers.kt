package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.FBuildConfContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.WBuildConf
import jetbrains.buildServer.server.querylang.ast.wrappers.WProject
import jetbrains.buildServer.server.querylang.ast.wrappers.wrap
import jetbrains.buildServer.server.querylang.myProjectManager
import jetbrains.buildServer.serverSide.impl.ProjectEx

interface BuildConfConditionContainer : ConditionContainer<WBuildConf> {
    override fun evalFilterInner(filter: Filter<WBuildConf>): EvalResult<WBuildConf>? {
        when (filter) {
            is IdFilter -> {
                val (remFilter, ids) = filter.transformedEval()
                if (remFilter is NoneObjectFilter) {
                    val buildConfs = ids.mapNotNull { myProjectManager.findBuildTypeByExternalId(it)?.wrap()}
                    return EvalResult(NoneObjectFilter(), buildConfs)
                }
            }
            is ParentFilter -> {
                val (remFilter, projects) = filter.transformedEval()
                val objs = projects.flatMap { project -> project.projectEx.ownBuildTypes }.mapNotNull {it?.wrap()}
                return EvalResult(remFilter, objs)
            }
        }
        return null
    }
}

interface ProjectConditionContainer : ConditionContainer<WProject> {
    override fun evalFilterInner(filter: Filter<WProject>): EvalResult<WProject>? {
        when(filter) {
            is IdFilter -> {
                val (restFilter, ids) = filter.transformedEval()
                if (restFilter is NoneObjectFilter) {
                    val projects = ids.mapNotNull { myProjectManager.findProjectByExternalId(it)?.wrap() }
                    return EvalResult(NoneObjectFilter(), projects)
                }
            }
            is ParentFilter -> {
                val (remFilter, projects) = filter.transformedEval()
                val objs = projects.flatMap { project -> project.projectEx.ownProjects }.mapNotNull { it?.wrap() }
                return EvalResult(remFilter, objs)
            }
        }
        return null
    }
}