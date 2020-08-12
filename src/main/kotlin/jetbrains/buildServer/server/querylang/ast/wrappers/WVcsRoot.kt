package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.vcs.VcsRootEntry
import jetbrains.buildServer.vcs.VcsRootInstanceEntry

fun SVcsRoot.wrap() = WSimpleVcsRoot(this)

abstract class WVcsRoot() : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FParamContainer
{
    abstract val svcsRoot: SVcsRoot

    override val id: String
        get() = svcsRoot.externalId

    override val project: WProject
        get() = svcsRoot.project.wrap()

    override val parent: WProject?
        get() = svcsRoot.project.wrap()

    override val ownParams: Map<String, String>
        get() = svcsRoot.properties

    override val params: Map<String, String>
        get() = ownParams
}

class WSimpleVcsRoot(override val svcsRoot: SVcsRoot) : WVcsRoot()

abstract class WVcsRootEntry : WVcsRoot() {
    abstract val rules: String
    abstract override val svcsRoot: SVcsRoot
}

fun VcsRootEntry.wrap() = MyVcsRootEntry(this)

class MyVcsRootEntry(val svcsEntry: VcsRootEntry): WVcsRootEntry() {
    val internalVcsRoot: SVcsRoot by lazy {
        svcsEntry.vcsRoot as? SVcsRoot ?: throw IllegalStateException("VcsRootEntry.vcsRoot should be SVcsRoot")
    }

    override val rules: String
        get() = svcsEntry.checkoutRules.asString

    override val svcsRoot: SVcsRoot
        get() = internalVcsRoot
}

fun VcsRootInstanceEntry.wrap() = MyVcsRootInstanceEntry(this)

class MyVcsRootInstanceEntry(val svcsInstanceEntry: VcsRootInstanceEntry): WVcsRootEntry() {
    override val rules: String
        get() = svcsInstanceEntry.checkoutRules.asString

    override val svcsRoot: SVcsRoot
        get() = svcsInstanceEntry.vcsRoot.parent
}