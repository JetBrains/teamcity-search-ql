package jetbrains.buildServer.server.querylang.ast


data class IdFilter(
    val strCondition: ConditionAST<StringFilter>
) :
    ProjectFilter,
    BcOrTempFilter,
    VcsRootFilter
{
    companion object : Names("id")
    override val names = IdFilter.names
    override fun createStr() = "id(" + strCondition.createStr() + ")"
}

data class SProjectFilter(
    override val condition: ConditionAST<ProjectFilter>
) :
    ProjectComplexFilter,
    BcOrTempFilter,
    VcsRootFilter
{
    companion object : Names("project")
    override val names = SProjectFilter.names
}

data class ParentFilter(
    override val condition: ConditionAST<ProjectFilter>
) :
    ProjectComplexFilter,
    BcOrTempFilter,
    ProjectFilter
{
    companion object : Names("parent")
    override val names = ParentFilter.names
}

data class TypeFilter(
    override val str: String
) :
    StringTerminalFilter,
    ParameterHolderFilter,
    VcsRootFilter
{
    companion object : Names("type")
    override val names = TypeFilter.names
}

data class TriggerFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) :
    ParHolderComplexFilter,
    BcOrTempFilter
{
    companion object : Names("trigger")
    override val names = TriggerFilter.names
}

data class StepFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) :
    ParHolderComplexFilter,
    BcOrTempFilter
{
    companion object : Names("step")
    override val names = StepFilter.names
}

data class FeatureFilter(
    override val condition: ConditionAST<ParameterHolderFilter>
) :
    ParHolderComplexFilter,
    BcOrTempFilter
{
    companion object : Names("feature")
    override val names = FeatureFilter.names
}

data class TempDepFilter(
    override val condition: ConditionAST<TempFilter>
) :
    TemplateComplexFilter,
    BuildConfFilter
{
    companion object : Names("template")
    override val names = TempDepFilter.names
}

data class ValueFilter(
    val strCondition: ConditionAST<StringFilter>
) :
    ParameterHolderFilter
{
    companion object : Names("val")
    override val names = ValueFilter.names
    override fun createStr() = "val " + strCondition.createStr()
}

data class EnabledFilter(
    val enabled: Boolean
) :
    TerminalFilter,
    ParameterHolderFilter
{
    companion object : Names("enabled")
    override val names = EnabledFilter.names
    override fun createStr() = "enabled"
}

data class ParameterFilter(val option: String, val valueCondition: ConditionAST<StringFilter>) : ParameterHolderFilter
{
    companion object : Names("param")
    override val names = ParameterFilter.names

    override fun createStr() = "param ${option}=(${valueCondition.createStr()})"
}

data class AncestorFilter(
    override val condition: ConditionAST<ProjectFilter>
) :
    ProjectComplexFilter,
    ProjectFilter
{
    companion object : Names("ancestor")
    override val names = AncestorFilter.names
}

data class AncestorOrSelfFilter(
    override val condition: ConditionAST<ProjectFilter>
) :
    ProjectComplexFilter,
    ProjectFilter
{
    companion object : Names("ancestorOrSelf")
    override val names = AncestorOrSelfFilter.names
}
