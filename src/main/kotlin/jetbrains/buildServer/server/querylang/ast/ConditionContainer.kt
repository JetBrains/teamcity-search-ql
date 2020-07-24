package jetbrains.buildServer.server.querylang.ast

interface ConditionContainer<T : Filter> {
    val condition: ConditionAST<T>
}

interface ProjectComplexFilter : ConditionContainer<ProjectFilter>

interface BuildConfComplexFilter : ConditionContainer<BuildConfFilter>

interface TemplateComplexFilter : ConditionContainer<TempFilter>

interface ParHolderComplexFilter : ConditionContainer<ParameterHolderFilter>

interface VcsRootComplexFilter : ConditionContainer<VcsRootFilter>