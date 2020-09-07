package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.AllElementValidator
import jetbrains.buildServer.server.querylang.ast.wrappers.MAllContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.MWithInheritedContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.MResolvedContainer

data class WithInheritedFilterModifier(private val placeholder: String = "") : FilterModifier<MWithInheritedContainer> {
    companion object : ObjectDescription(
        Names1("withInherited"),
        Descriptions(
            SimpleDescription("include parameters inherited from projects", "configuration", "param"),
            SimpleDescription("include parameters inherited from projects", "template", "param"),
            SimpleDescription("include parameters inherited from projects", "projects", "param"),
            SimpleDescription("include dependencies inherited from build type templates", "dependency"),
            SimpleDescription("include vcs roots inherited from build type templates", "vcs"),
            TemplateDescription("include _s inherited from templates", listOf("param"))
        )
    )

    override val names = Companion.names

    override fun apply(filter: MWithInheritedContainer) {
        filter.includeInherited = true
    }
}

data class ResolvedFilterModifier(private val placeholder: String = "") : FilterModifier<MResolvedContainer> {
    companion object : ObjectDescription(
        Names1("resolved"),
        Descriptions(
            SimpleDescription(
                "resolve parameter references in strings"
            )
        )
    )

    override val names = Companion.names

    override fun apply(filter: MResolvedContainer) {
        filter.searchResolved = true
    }
}

data class AllFilterModifier(private val placeholder: String = "") : FilterModifier<MAllContainer> {
    companion object : ObjectDescription(
        Names1("all"),
        Descriptions(
            TemplateDescription("all _s should satisfy the following condition")
        )
    )

    override val names: List<String> = Companion.names

    override fun apply(filter: MAllContainer) {
        filter.searchAll = AllElementValidator<Any>()
    }
}