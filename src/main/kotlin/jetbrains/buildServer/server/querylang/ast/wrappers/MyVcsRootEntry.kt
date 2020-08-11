package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.vcs.VcsRootEntry
import jetbrains.buildServer.vcs.VcsRootInstanceEntry

data class MyVcsRootEntry(val vcsRoot: SVcsRoot, val checkoutRules: String)

fun VcsRootEntry.toMyVcsRootEntry() = MyVcsRootEntry(
    this.vcsRoot as? SVcsRoot ?: throw IllegalStateException("Can't cast VcsRoot to SVcsRoot"),
    this.checkoutRules.asString
)

fun VcsRootInstanceEntry.toMyVcsRootEntry() = MyVcsRootEntry(
    this.vcsRoot.parent, this.checkoutRules.asString
)