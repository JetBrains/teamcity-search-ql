package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.CheckoutRulesFilter
import jetbrains.buildServer.server.querylang.ast.VcsRootEntryFilter
import jetbrains.buildServer.server.querylang.ast.VcsRootFilterType
import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.vcs.VcsRootEntry
import jetbrains.buildServer.vcs.VcsRootInstanceEntry

object VcsRootEntryFilterBuilder : FilterBuilder<VcsRootEntryFilter, VcsRootEntryFilterBuilder.MyVcsRootEntry> {
    override fun createFilter(filter: VcsRootEntryFilter, context: Any?): ObjectFilter<MyVcsRootEntry> {
        return when(filter) {
            is VcsRootFilterType -> {
                val vcsFilter = VcsRootFilterBuilder.createFilter(filter, context)
                ObjectFilter {entry ->
                    vcsFilter.accepts(entry.vcsRoot)
                }
            }
            is CheckoutRulesFilter -> {
                val stringFilter = StringFilterBuilder.createFilter(filter.condition)
                ObjectFilter {entry ->
                    stringFilter.accepts(entry.checkoutRules)
                }
            }
            else -> throw IllegalStateException("Unknown VcsRootInstanceFilter")
        }
    }

    data class MyVcsRootEntry(val vcsRoot: SVcsRoot, val checkoutRules: String)

    fun VcsRootEntry.toMyVcsRootEntry() = MyVcsRootEntry(
        this.vcsRoot as? SVcsRoot ?: throw IllegalStateException("Can't cast VcsRoot to SVcsRoot"),
        this.checkoutRules.asString
    )

    fun VcsRootInstanceEntry.toMyVcsRootEntry() = MyVcsRootEntry(
        this.vcsRoot.parent, this.checkoutRules.asString
    )
}