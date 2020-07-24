package jetbrains.buildServer.server.querylang.ast


data class IdFilter(val id: String) : ProjectFilter, BcOrTempFilter, ParameterHolderFilter, VcsRootFilter

data class SProjectFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, BcOrTempFilter, VcsRootFilter

data class ParentFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, BcOrTempFilter, ProjectFilter

data class TypeFilter(val type: String) : ParameterHolderFilter, VcsRootFilter

data class TriggerFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) : ParHolderComplexFilter, BcOrTempFilter

data class StepFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) : ParHolderComplexFilter, BcOrTempFilter

data class FeatureFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) : ParHolderComplexFilter, BcOrTempFilter

data class TempDepFilter(
    override val condition: ConditionAST<TempFilter>
) : TemplateComplexFilter, BuildConfFilter

data class ParValueFilter(val value: String) : ParameterHolderFilter

data class EnabledFilter(val enabled: Boolean) : ParameterHolderFilter

data class ParameterFilter(val option: String, val value: String) : ParameterHolderFilter

data class AncestorFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, ProjectFilter

data class AncestorOrSelfFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, ProjectFilter
