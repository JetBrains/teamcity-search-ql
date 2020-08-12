package jetbrains.buildServer.server.querylang.ast_old

import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SPersistentEntity
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.vcs.SVcsRoot


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

    fun wrapFilter(ofilter: ObjectFilter<String>) = ofilter.use<SPersistentEntity> {obj ->
        ofilter.accepts(obj.externalId)
    }
}

data class ProjectFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectConditionContainer,
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
    ProjectConditionContainer,
    BuildConfFilterType,
    TemplateFilterType,
    ProjectFilterType,
    VcsRootFilterType
{
    companion object : Names("parent")
    override val names = Companion.names

    fun wrapFilterP(ofilter: ObjectFilter<SProject>) =
        ofilter.use<SProject> {ofilter.accepts(it.parentProject)}

    fun wrapFilterV(ofilter: ObjectFilter<SProject>) =
        ofilter.use<SVcsRoot> {ofilter.accepts(it.project)}

    fun wrapFilterB(ofilter: ObjectFilter<SProject>) =
        ofilter.use<SBuildType> {ofilter.accepts(it.project)}

    fun wrapFilterT(ofilter: ObjectFilter<SProject>) =
        ofilter.use<BuildTypeTemplate> {ofilter.accepts(it.project)}
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
    ParHolderConditionContainer,
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
    ParHolderConditionContainer,
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
    ParHolderConditionContainer,
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
    TemplateConditionContainer,
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
    override val nameCondition: ConditionAST<StringFilter>,
    override val valCondition: ConditionAST<StringFilter>
) : StringParameterTerminalFilter,
    ParameterHolderFilterType,
    BuildConfFilterType,
    TemplateFilterType,
    ProjectFilterType,
    VcsRootFilterType
{
    companion object : Names("param")
    override val names = Companion.names

    var includeInherited = false
}

data class AncestorFilter(
    override val condition: ConditionAST<ProjectFilterType>
) :
    ProjectConditionContainer,
    ProjectFilterType
{
    companion object : Names("ancestor")
    override val names = Companion.names
}

data class VcsRootFilter(
    override val condition: ConditionAST<VcsRootEntryFilter>
) : VcsRootEntryConditionContainer,
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
) : DependencyConditionContainer,
    BuildConfFilterType,
    TemplateFilterType
{
    companion object : Names("dependency")

    override val names = Companion.names

    var includeInhereted = false
}

data class ArtifactFilter(
    override val condition: ConditionAST<ArtifactDepFilterType>
) : ArtifactDepConditionContainer,
    DependencyFilterType
{
    companion object : Names("artifact")
    override val names = Companion.names
}

data class SnapshotFilter(
    override val condition: ConditionAST<SnapshotDepFilterType>
) : SnapshotDepConditionContainer,
    DependencyFilterType
{
    companion object : Names("snapshot")
    override val names = Companion.names
}

data class OptionFilter(
    override val nameCondition: ConditionAST<StringFilter>,
    override val valCondition: ConditionAST<StringFilter>,
    var includeInherited: Boolean = false
) : StringParameterTerminalFilter,
    BuildConfFilterType,
    TemplateFilterType,
    SnapshotDepFilterType
{
    companion object : Names("option")

    override val names = Companion.names
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
