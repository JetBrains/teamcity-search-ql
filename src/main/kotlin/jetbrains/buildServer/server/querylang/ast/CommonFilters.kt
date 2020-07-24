package jetbrains.buildServer.server.querylang.ast


data class IdFilter(val id: String) : ProjectFilter, BcOrTempFilter, ParameterHolderFilter, VcsRootFilter {
    override val names = listOf("id")
}

data class SProjectFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, BcOrTempFilter, VcsRootFilter {
    override val names = listOf("project")
}

data class ParentFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, BcOrTempFilter, ProjectFilter {
    override val names = listOf("parent")
}

data class TypeFilter(val type: String) : ParameterHolderFilter, VcsRootFilter {
    override val names = listOf("type")
}

data class TriggerFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) : ParHolderComplexFilter, BcOrTempFilter {
    override val names = listOf("trigger")
}

data class StepFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) : ParHolderComplexFilter, BcOrTempFilter {
    override val names = listOf("step")
}

data class FeatureFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) : ParHolderComplexFilter, BcOrTempFilter {
    override val names = listOf("feature")
}

data class TempDepFilter(
    override val condition: ConditionAST<TempFilter>
) : TemplateComplexFilter, BuildConfFilter {
    override val names = listOf("template")
}

data class ParValueFilter(val value: String) : ParameterHolderFilter {
    override val names = listOf("val")
}

data class EnabledFilter(val enabled: Boolean) : ParameterHolderFilter {
    override val names = listOf("enabled")
}

data class ParameterFilter(val option: String, val value: String) : ParameterHolderFilter {
    override val names = listOf("param")
}

data class AncestorFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, ProjectFilter {
    override val names = listOf("ancestor")
}

data class AncestorOrSelfFilter(
    override val condition: ConditionAST<ProjectFilter>
) : ProjectComplexFilter, ProjectFilter {
    override val names = listOf("ancestorOrSelf")
}
