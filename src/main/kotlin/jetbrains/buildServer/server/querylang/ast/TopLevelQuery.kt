package jetbrains.buildServer.server.querylang.ast

sealed class TopLevelQuery : Named

data class FindProject(override val condition: ConditionAST<ProjectFilter>) : TopLevelQuery(), ProjectComplexFilter {
    override val names = listOf("project")
}

data class FindBuildConf(override val condition: ConditionAST<BuildConfFilter>) : TopLevelQuery(), BuildConfComplexFilter {
    override val names = listOf("buildConfiguration")
}

data class FindTemplate(override val condition: ConditionAST<TempFilter>) : TopLevelQuery(), TemplateComplexFilter {
    override val names = listOf("template")
}

data class FindVcsRoot(override val condition: ConditionAST<VcsRootFilter>) : TopLevelQuery(), VcsRootComplexFilter {
    override val names = listOf("vcsRoot")
}