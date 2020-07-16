package jetbrains.buildServer.server.querylang.ast

sealed class MainQuery

data class FindProject(val condition: ConditionAST<ProjectFilter>) : MainQuery()

data class FindBuildConf(val condition: ConditionAST<BuildConfFilter>) : MainQuery()

data class FindTemplate(val condition: ConditionAST<TempFilter>) : MainQuery()

data class FindBuildConfOrTemplate(val condition: ConditionAST<BcOrTempFilter>) : MainQuery()

data class FindVcsRoot(val condition: ConditionAST<VcsRootFilter>) : MainQuery()