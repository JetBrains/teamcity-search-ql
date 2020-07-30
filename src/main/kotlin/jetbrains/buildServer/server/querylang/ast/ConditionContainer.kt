package jetbrains.buildServer.server.querylang.ast

interface ConditionContainer<T : Filter> : Printable, Named {
    val condition: ConditionAST<T>

    override fun createStr(): String {
        return "${names[0]}(${condition.createStr()})"
    }
}

interface ProjectComplexFilter : ConditionContainer<ProjectFilterType>

interface BuildConfComplexFilter : ConditionContainer<BuildConfFilterType>

interface TemplateComplexFilter : ConditionContainer<TemplateFilterType>

interface ParHolderComplexFilter : ConditionContainer<ParameterHolderFilterType>

interface VcsRootComplexFilter : ConditionContainer<VcsRootFilterType>

interface VcsRootEntryComplexFilter : ConditionContainer<VcsRootEntryFilter>