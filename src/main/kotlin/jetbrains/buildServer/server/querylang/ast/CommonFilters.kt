package jetbrains.buildServer.server.querylang.ast

data class IdFilter(val id: String) : ProjectFilter, BcOrTempFilter, ParameterHolderFilter, VcsRootFilter

data class SProjectFilter(val condition: ConditionAST<ProjectFilter>) : BcOrTempFilter, VcsRootFilter

data class ParentFilter(val condition: ConditionAST<ProjectFilter>) : BcOrTempFilter, ProjectFilter

data class TypeFilter(val type: String) : ParameterHolderFilter, VcsRootFilter

data class TriggerFilter(val condition: ConditionAST<ParameterHolderFilter>) : BcOrTempFilter

data class StepFilter(val condition: ConditionAST<ParameterHolderFilter>) : BcOrTempFilter

data class FeatureFilter(val condition: ConditionAST<ParameterHolderFilter>) : BcOrTempFilter

data class TempDepFilter(val condition: ConditionAST<TempFilter>) : BuildConfFilter

data class ParValueFilter(val value: String) : ParameterHolderFilter

data class EnabledFilter(val enabled: Boolean) : ParameterHolderFilter

data class ParameterFilter(val option: String, val value: String) : ParameterHolderFilter

data class AncestorFilter(val condition: ConditionAST<ProjectFilter>) : ProjectFilter

data class AncestorOrSelfFilter(val condition: ConditionAST<ProjectFilter>) : ProjectFilter
