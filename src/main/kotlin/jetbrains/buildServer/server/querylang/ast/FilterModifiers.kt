package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.MWithInheritedContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.MResolvedContainer

data class WithInheritedFilterModifier(private val placeholder: String = "") : FilterModifier<MWithInheritedContainer> {
    companion object : Names("withInherited")

    override val names = Companion.names

    override fun apply(filter: MWithInheritedContainer) {
        filter.includeInherited = true
    }
}

data class ResolvedFilterModifier(private val placeholder: String = "") : FilterModifier<MResolvedContainer> {
    companion object : Names("resolved")

    override val names = Companion.names

    override fun apply(filter: MResolvedContainer) {
        filter.searchResolved = true
    }
}