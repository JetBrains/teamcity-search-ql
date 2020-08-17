package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.*
import jetbrains.buildServer.server.querylang.myProjectManager
import java.lang.IllegalStateException

data class IdFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<FIdContainer, String>()
{
    companion object : Names("id")
    override val names = IdFilter.names

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?) = RealObjectFilter<FIdContainer> { obj ->
        filter.accepts(obj.id)
    }
}

data class BuildConfFilter(
    override val condition: ConditionAST<WBuildConf>
) : ConditionFilter<FBuildConfContainer, WBuildConf>()
{
    companion object : Names("configuration", "buildConfiguration")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WBuildConf>, context: Any?): ObjectFilter<FBuildConfContainer> {
        return RealObjectFilter {obj ->
            obj.buildConfs.any {filter.accepts(it)}
        }
    }
}

data class VcsRootFilter(
    override val condition: ConditionAST<AbstractWVcsRoot>
) : ConditionFilter<FVcsRootContainer, AbstractWVcsRoot>()
{
    companion object : Names("vcsRoot")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<AbstractWVcsRoot>, context: Any?): ObjectFilter<FVcsRootContainer> {
        return RealObjectFilter {obj ->
            obj.vcsRoots.any {filter.accepts(it)}
        }
    }
}

data class ProjectFilter(
    override val condition: ConditionAST<WProject>
) : ConditionFilter<FProjectContainer, WProject>()
{
    companion object : Names("project")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WProject>, context: Any?): ObjectFilter<FProjectContainer> {
        return RealObjectFilter fil@{obj ->
            var project: WProject? = obj.project

            while (project != null) {
                if (filter.accepts(project)) {
                    return@fil true
                }
                project = project.parent
            }

            false
        }
    }

    override fun evalFilter(filter: Filter<WProject>): EvalResult<WProject> {
        return when(filter) {
            is IdFilter -> {
                val (restFilter, ids) = filter.eval()
                return if (restFilter is NoneObjectFilter) {
                    val projects = ids.mapNotNull { myProjectManager.findProjectByExternalId(it)?.wrap() }
                    EvalResult(NoneObjectFilter(), projects)
                }
                else {
                    super.evalFilter(filter)
                }
            }
            else -> super.evalFilter(filter)
        }
    }
}


data class ParentFilter(
    override val condition: ConditionAST<WProject>
) : ConditionFilter<FParentContainer, WProject>()
{
    companion object : Names("parent")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WProject>, context: Any?): ObjectFilter<FParentContainer> {
        return RealObjectFilter {obj ->
            obj.parent.let{ filter.accepts(it) }
        }
    }
}

data class TriggerFilter(
    override val condition: ConditionAST<WTrigger>
) : ConditionFilter<FTriggerContainer, WTrigger>()
{
    companion object : Names("trigger")
    override val names = Companion.names

    var includeInherited = false

    override fun build(context: Any?): ObjectFilter<FTriggerContainer> {
        return RealObjectFilter {obj ->
            val settings = if (!this.includeInherited) obj.ownTriggers
            else obj.triggers

            val objectFilterWithContext = condition.build(obj)
            settings.any {trig ->
                objectFilterWithContext.accepts(trig)
            }
        }
    }

    override fun buildFrom(filter: ObjectFilter<WTrigger>, context: Any?): ObjectFilter<FTriggerContainer> {
        throw IllegalStateException("Can't call buildFrom from StepFilter")
    }
}

data class StepFilter(
    override val condition: ConditionAST<WStep>
) : ConditionFilter<FStepContainer, WStep>()
{
    companion object : Names("step")
    override val names = Companion.names

    var includeInherited = false

    override fun build(context: Any?): ObjectFilter<FStepContainer> {
        return RealObjectFilter {obj ->
            val settings = if (!this.includeInherited) obj.ownSteps
            else obj.steps

            val objectFilterWithContext = condition.build(obj)

            settings.any {step ->
                objectFilterWithContext.accepts(step)
            }
        }
    }

    override fun buildFrom(filter: ObjectFilter<WStep>, context: Any?): ObjectFilter<FStepContainer> {
        throw IllegalStateException("Can't call buildFrom from StepFilter")
    }
}

data class FeatureFilter(
    override val condition: ConditionAST<WFeature>
) : ConditionFilter<FFeatureContainer, WFeature>()
{
    companion object : Names("feature")
    override val names = Companion.names

    var includeInherited = false

    override fun build(context: Any?): ObjectFilter<FFeatureContainer> {
        return RealObjectFilter {obj ->
            val settings = if (this.includeInherited) obj.features
            else obj.ownFeatures

            val objectFilterWithContext = condition.build(obj)

            settings.any {step ->
                objectFilterWithContext.accepts(step)
            }
        }
    }

    override fun buildFrom(filter: ObjectFilter<WFeature>, context: Any?): ObjectFilter<FFeatureContainer> {
        throw IllegalStateException("Can't call buildFrom from FeatureFilter")
    }
}

data class TemplateFilter(
    override val condition: ConditionAST<WTemplate>
) : ConditionFilter<FTemplateContainer, WTemplate>()
{
    companion object : Names("template")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WTemplate>, context: Any?): ObjectFilter<FTemplateContainer> {
        return RealObjectFilter {obj ->
            obj.templates.any {filter.accepts(it)}
        }
    }
}

data class ValueFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<FValueContainer, String>()
{
    companion object : Names("val")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?): ObjectFilter<FValueContainer> {
        return RealObjectFilter {obj ->
            obj.values.any {filter.accepts(it)}
        }
    }
}

data class TypeFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<FTypeContainer, String>()
{
    companion object : Names("type")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?): ObjectFilter<FTypeContainer> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.type)
        }
    }
}

data class EnabledFilter(private val placeholder: String = "") : Filter<FEnabledContainer> {

    companion object : Names("enabled")
    override val names = Companion.names

    override fun build(context: Any?): ObjectFilter<FEnabledContainer> {
        val enabledContext = context as? EnabledChecker ?: throw IllegalStateException("Context should be EnabledChecker")
        return RealObjectFilter {obj ->
            enabledContext.isEnabled(obj)
        }
    }

    override fun createStr() = names.first()
}

data class ParameterFilter(
    override val condition: ConditionAST<WParam>
) : ConditionFilter<FParamContainer, WParam>()
{
    companion object : Names("param")
    override val names = Companion.names

    var includeInherited = false

    override fun buildFrom(filter: ObjectFilter<WParam>, context: Any?): ObjectFilter<FParamContainer> {
        return RealObjectFilter {obj ->
            val params = if (includeInherited) obj.params
                         else obj.ownParams

            params.any {(a, b) -> filter.accepts(WParam(a, b))}
        }
    }
}

data class AncestorFilter(
    override val condition: ConditionAST<WProject>
) : ConditionFilter<FAncestorContainer, WProject>()
{
    companion object : Names("ancestor")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WProject>, context: Any?): ObjectFilter<FAncestorContainer> {
        return RealObjectFilter fil@{obj ->
            var proj: WProject? = obj.firstAncestor
            while (proj != null) {
                if (filter.accepts(proj)) {
                    return@fil true
                }
                proj = proj.parent
            }
            false
        }
    }
}

data class VcsRootEntryFilter(
    override val condition: ConditionAST<WVcsRootEntry>
) : ConditionFilter<FVcsRootEntryContainer, WVcsRootEntry>()
{
    var includeInherited: Boolean = false
    companion object : Names("vcs")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WVcsRootEntry>, context: Any?): ObjectFilter<FVcsRootEntryContainer> {
        return RealObjectFilter {obj ->
            val vcss = if (includeInherited) obj.vcsRootEntries
                       else obj.ownVcsRootEntries
            vcss.any {filter.accepts(it)}
        }
    }
}

data class RulesFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<FRulesContainer, String>()
{
    companion object : Names("rules")

    override val names: List<String> = Companion.names

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?): ObjectFilter<FRulesContainer> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.rules)
        }
    }
}

data class DependencyFilter(
    override val condition: ConditionAST<SuperDependency>
) : ConditionFilter<FDependencyContainer, SuperDependency>()
{
    companion object : Names("dependency")

    override val names = Companion.names

    var includeInhereted = false

    override fun buildFrom(filter: ObjectFilter<SuperDependency>, context: Any?): ObjectFilter<FDependencyContainer> {
        return RealObjectFilter {obj ->
            val dependencies = if (includeInhereted) obj.dependencies
                               else obj.ownDependencies
            dependencies.any {filter.accepts(it)}
        }
    }
}

data class ArtifactFilter(
    override val condition: ConditionAST<WArtifactDependency>
) : ConditionFilter<SuperDependency, WArtifactDependency>()
{
    companion object : Names("artifact")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WArtifactDependency>, context: Any?): ObjectFilter<SuperDependency> {
        return RealObjectFilter {obj ->
            obj.artifactDependencies.any {filter.accepts(it)}
        }
    }
}

data class SnapshotFilter(
    override val condition: ConditionAST<WSnapshotDependency>
) : ConditionFilter<SuperDependency, WSnapshotDependency>()
{
    companion object : Names("snapshot")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WSnapshotDependency>, context: Any?): ObjectFilter<SuperDependency> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.snapshotDep)
        }
    }
}

data class CleanFilter(
    private val placeholder: String = ""
) : Filter<WArtifactDependency>
{
    companion object : Names("clean")

    override val names = Companion.names

    override fun createStr(): String = names.first()

    override fun build(context: Any?): ObjectFilter<WArtifactDependency> {
        return RealObjectFilter {obj ->
            obj.adep.isCleanDestinationFolder
        }
    }
}

data class RevRuleFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<WArtifactDependency, String>()
{
    companion object : Names("revRule")

    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?): ObjectFilter<WArtifactDependency> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.adep.revisionRule.name)
        }
    }
}

data class OptionFilter(
    override val condition: ConditionAST<WParam>
) : ConditionFilter<FOptionContainer, WParam>()
{
    var includeInherited: Boolean = false

    companion object : Names("option")

    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WParam>, context: Any?): ObjectFilter<FOptionContainer> {
        return RealObjectFilter {obj ->
            val options = if (includeInherited) obj.options
                          else obj.ownOptions
            options.any {opt -> filter.accepts(WParam(opt.key, obj.getOption(opt).toString()))}
        }
    }
}

data class NameFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<FNameContainer, String>() {

    companion object : Names("name")
    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?): ObjectFilter<FNameContainer> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.name)
        }
    }
}


