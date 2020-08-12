package jetbrains.buildServer.server.querylang.ast_old.wrappers

import jetbrains.buildServer.serverSide.SProject

class WProject(val project: SProject): ExternalIdContainer {
    override val externalId
        get() = project.externalId

    val parentProject: SProject?
        get() = project.parentProject

    val ownParams
        get() = project.ownParameters

    val params
        get() = project.parameters
}