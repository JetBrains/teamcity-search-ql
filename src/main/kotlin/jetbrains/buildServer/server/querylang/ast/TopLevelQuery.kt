package jetbrains.buildServer.server.querylang.ast

sealed class TopLevelQuery<T : Filter> : Named, ConditionContainer<T> {
    fun wrap(): MainQuery {
        return FindMultipleTypes(listOf(this))
    }

    abstract override val condition: ConditionAST<T>
}

data class FindProject(override val condition: ConditionAST<ProjectFilter>) : TopLevelQuery<ProjectFilter>(), ProjectComplexFilter {
    override val names = listOf("project")
}

data class FindBuildConf(override val condition: ConditionAST<BuildConfFilter>) : TopLevelQuery<BuildConfFilter>(), BuildConfComplexFilter {
    override val names = listOf("buildConfiguration")
}

data class FindTemplate(override val condition: ConditionAST<TempFilter>) : TopLevelQuery<TempFilter>(), TemplateComplexFilter {
    override val names = listOf("template")
}

data class FindVcsRoot(override val condition: ConditionAST<VcsRootFilter>) : TopLevelQuery<VcsRootFilter>(), VcsRootComplexFilter {
    override val names = listOf("vcsRoot")
}