package jetbrains.buildServer.server.querylang.ast

sealed class MainQuery

data class FindProject(override val condition: ConditionAST<ProjectFilter>) : MainQuery(), ProjectComplexFilter

data class FindBuildConf(override val condition: ConditionAST<BuildConfFilter>) : MainQuery(), BuildConfComplexFilter

data class FindTemplate(override val condition: ConditionAST<TempFilter>) : MainQuery(), TemplateComplexFilter

data class FindVcsRoot(override val condition: ConditionAST<VcsRootFilter>) : MainQuery(), VcsRootComplexFilter

data class FindMultipleTypes(val findQueries: List<MainQuery>) : MainQuery()