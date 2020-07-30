package jetbrains.buildServer.server.querylang.ast

sealed class TopLevelQuery<T : Filter> : Named, ConditionContainer<T> {
    fun wrap(): MainQuery {
        return FindMultipleTypes(listOf(this))
    }

    abstract override val condition: ConditionAST<T>
}

data class FindProject(override val condition: ConditionAST<ProjectFilterType>) : TopLevelQuery<ProjectFilterType>(), ProjectComplexFilter {
    companion object : Names("project")
    override val names = FindProject.names
}

data class FindBuildConf(override val condition: ConditionAST<BuildConfFilterType>) : TopLevelQuery<BuildConfFilterType>(), BuildConfComplexFilter {
    companion object : Names("buildConfiguration", "configuration")
    override val names = FindBuildConf.names
}

data class FindTemplate(override val condition: ConditionAST<TemplateFilterType>) : TopLevelQuery<TemplateFilterType>(), TemplateComplexFilter {
    companion object : Names("template")
    override val names = FindTemplate.names
}

data class FindVcsRoot(override val condition: ConditionAST<VcsRootFilterType>) : TopLevelQuery<VcsRootFilterType>(), VcsRootComplexFilter {
    companion object : Names("vcsRoot")
    override val names = FindVcsRoot.names
}