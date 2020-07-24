package jetbrains.buildServer.server.querylang.ast

interface ConditionContainer<T : Filter> : Printable, Named {
    val condition: ConditionAST<T>

    override fun createStr(): String {
        return "${names[0]}(${condition.createStr()})"
    }
}

interface ProjectComplexFilter : ConditionContainer<ProjectFilter>

interface BuildConfComplexFilter : ConditionContainer<BuildConfFilter>

interface TemplateComplexFilter : ConditionContainer<TempFilter>

interface ParHolderComplexFilter : ConditionContainer<ParameterHolderFilter>

interface VcsRootComplexFilter : ConditionContainer<VcsRootFilter>