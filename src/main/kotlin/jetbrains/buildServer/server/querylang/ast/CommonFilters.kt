package jetbrains.buildServer.server.querylang.ast


data class IdFilter(
    override val strCondition: ConditionAST<StringFilter>
) : StringTerminalFilter,
    ProjectFilterType,
    BuildConfFilterType,
    TemplateFilterType,
    VcsRootFilterType
{
    companion object : Names("id")
    override val names = IdFilter.names
}

data class ProjectFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectComplexFilter,
    ProjectFilterType,
    BuildConfFilterType,
    TemplateFilterType,
    VcsRootFilterType
{
    companion object : Names("project")
    override val names = Companion.names
}

data class ParentFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectComplexFilter,
    BuildConfFilterType,
    TemplateFilterType,
    ProjectFilterType,
    VcsRootFilterType
{
    companion object : Names("parent")
    override val names = Companion.names
}

data class TypeFilter(
    override val strCondition: ConditionAST<StringFilter>
) :
    StringTerminalFilter,
    ParameterHolderFilterType,
    VcsRootFilterType
{
    companion object : Names("type")
    override val names = Companion.names
}

data class TriggerFilter(
    override val condition: ConditionAST<ParameterHolderFilterType>
) :
    ParHolderComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("trigger")
    override val names = Companion.names

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
    override val names = Companion.names

    var includeInherited = false
}

data class FeatureFilter(
    override val condition: ConditionAST<ParameterHolderFilterType>
) :
    ParHolderComplexFilter,
    BuildConfFilterType,
    TemplateFilterType,
    ProjectFilterType
{
    companion object : Names("feature")
    override val names = Companion.names

    var includeInherited = false
}

data class TempDepFilter(
    override val condition: ConditionAST<TemplateFilterType>
) :
    TemplateComplexFilter,
    BuildConfFilterType
{
    companion object : Names("template")
    override val names = Companion.names
}

data class ValueFilter(
    override val strCondition: ConditionAST<StringFilter>
) : StringTerminalFilter,
    ParameterHolderFilterType
{
    companion object : Names("val")
    override val names = Companion.names
}

data class EnabledFilter(
    val enabled: Boolean
) :
    TerminalFilter,
    ParameterHolderFilterType
{
    companion object : Names("enabled")
    override val names = Companion.names
    override fun createStr() = "enabled"
}

data class ParameterFilter(
    val nameCondition: ConditionAST<StringFilter>,
    val valueCondition: ConditionAST<StringFilter>
) : ParameterHolderFilterType, BuildConfFilterType, TemplateFilterType
{
    companion object : Names("param")
    override val names = Companion.names

    override fun createStr() = "param (${nameCondition.createStr()})=(${valueCondition.createStr()})"

    var includeInherited = false
}

data class AncestorFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectComplexFilter,
    ProjectFilterType
{
    companion object : Names("ancestor")
    override val names = Companion.names
}

data class VcsRootFilter(
    override val condition: ConditionAST<VcsRootEntryFilter>
) : VcsRootEntryComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("vcsRoot")
    override val names = Companion.names
}

data class RulesFilter(
    override val strCondition: ConditionAST<StringFilter>
) : StringTerminalFilter,
    VcsRootEntryFilter,
    ArtifactDepFilterType
{
    companion object : Names("rules")

    override val names: List<String> = Companion.names
}

data class DependencyFilter(
    override val condition: ConditionAST<DependencyFilterType>
) : DependencyComplexFilter,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("dependency")

    override val names = Companion.names

    var includeInhereted = false
}

data class ArtifactFilter(
    override val condition: ConditionAST<ArtifactDepFilterType>
) : ArtifactDepComplexFilter,
    DependencyFilterType
{
    companion object : Names("artifact")
    override val names = Companion.names
}

data class SnapshotFilter(
    override val condition: ConditionAST<SnapshotDepFilterType>
) : SnapshotDepComplexFilter,
    DependencyFilterType
{
    companion object : Names("snapshot")
    override val names = Companion.names
}

data class OptionFilter(
    val nameCondition: ConditionAST<StringFilter>,
    val valueCondition: ConditionAST<StringFilter>,
    var includeInherited: Boolean = false
) : BuildConfFilterType,
    TemplateFilterType,
    SnapshotDepFilterType
{
    companion object : Names("option")

    override val names = Companion.names

    override fun createStr() = "option (${nameCondition.createStr()})=(${valueCondition.createStr()})"
}

data class CleanFilter(
    private val placeholder: String = ""
) : EmptyTerminalFilter,
    ArtifactDepFilterType
{
    companion object : Names("clean")

    override val names = Companion.names
}

data class RevRuleFilter(
    override val strCondition: ConditionAST<StringFilter>
) : StringTerminalFilter,
    ArtifactDepFilterType
{
    companion object : Names("revRule")

    override val names = Companion.names
}
