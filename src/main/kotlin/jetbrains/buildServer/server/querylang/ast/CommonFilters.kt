package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.toIdentOrString


data class IdFilter(
    val strCondition: ConditionAST<StringFilter>
) :
    ProjectFilterType,
    BuildConfFilterType,
    TemplateFilterType,
    VcsRootFilterType
{
    companion object : Names("id")
    override val names = IdFilter.names
    override fun createStr() = "id(" + strCondition.createStr() + ")"
}

data class ProjectFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectComplexFilter,
    BuildConfFilterType,
    TemplateFilterType,
    VcsRootFilterType
{
    companion object : Names("project")
    override val names = ProjectFilter.names
}

data class ParentFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectComplexFilter,
    BuildConfFilterType,
    TemplateFilterType,
    ProjectFilterType
{
    companion object : Names("parent")
    override val names = ParentFilter.names
}

data class TypeFilter(
    override val str: String
) :
    StringTerminalFilter,
    ParameterHolderFilterType,
    VcsRootFilterType
{
    companion object : Names("type")
    override val names = TypeFilter.names
}

data class TriggerFilter(
    override val condition: ConditionAST<ParameterHolderFilterType>
) :
    ParHolderComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("trigger")
    override val names = TriggerFilter.names

    var includeInherited = false
}

data class StepFilter(
    override val condition: ConditionAST<ParameterHolderFilterType>
) :
    ParHolderComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("step")
    override val names = StepFilter.names

    var includeInherited = false
}

data class FeatureFilter(
    override val condition: ConditionAST<ParameterHolderFilterType>
) :
    ParHolderComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("feature")
    override val names = FeatureFilter.names

    var includeInherited = false
}

data class TempDepFilter(
    override val condition: ConditionAST<TemplateFilterType>
) :
    TemplateComplexFilter,
    BuildConfFilterType
{
    companion object : Names("template")
    override val names = TempDepFilter.names
}

data class ValueFilter(
    val strCondition: ConditionAST<StringFilter>
) :
    ParameterHolderFilterType
{
    companion object : Names("val")
    override val names = ValueFilter.names
    override fun createStr() = "val " + strCondition.createStr()
}

data class EnabledFilter(
    val enabled: Boolean
) :
    TerminalFilter,
    ParameterHolderFilterType
{
    companion object : Names("enabled")
    override val names = EnabledFilter.names
    override fun createStr() = "enabled"
}

data class ParameterFilter(
    val option: String,
    val valueCondition: ConditionAST<StringFilter>
) : ParameterHolderFilterType, BuildConfFilterType, TemplateFilterType
{
    companion object : Names("param")
    override val names = ParameterFilter.names

    override fun createStr() = "param ${option.toIdentOrString()}=(${valueCondition.createStr()})"

    var includeInherited = false
}

data class AncestorFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectComplexFilter,
    ProjectFilterType
{
    companion object : Names("ancestor")
    override val names = AncestorFilter.names
}

data class AncestorOrSelfFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectComplexFilter,
    ProjectFilterType
{
    companion object : Names("ancestorOrSelf")
    override val names = AncestorOrSelfFilter.names
}

data class VcsRootFilter(
    override val condition: ConditionAST<VcsRootEntryFilter>
) : VcsRootEntryComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("vcsRoot")
    override val names = VcsRootFilter.names
}

data class CheckoutRulesFilter(
    val condition: ConditionAST<StringFilter>
) : VcsRootEntryFilter {
    companion object : Names("rules")

    override val names: List<String> = CheckoutRulesFilter.names

    override fun createStr() = "rules(" + condition.createStr() + ")"
}

data class DependencyFilter(
    override val condition: ConditionAST<DependencyFilterType>
) : DependencyComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("dependency")

    override val names = CheckoutRulesFilter.names

    var includeInhereted = false
}

data class ArtifactFilter(
    private val placeholder: String = ""
) : EmptyTerminalFilter, DependencyFilterType {
    companion object : Names("artifact")
    override val names = Companion.names
}

data class SnapshotFilter(
    private val placeholder: String = ""
) : EmptyTerminalFilter, DependencyFilterType {
    companion object : Names("snapshot")
    override val names = Companion.names
}