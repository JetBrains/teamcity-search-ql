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
) : ConditionFilter<FVcsRootContainer, AbstractWVcsRoot>(),
    MAllContainer
{
    companion object : Names("vcsRoot")
    override val names = Companion.names

    override var searchAll = false

    override fun buildFrom(filter: ObjectFilter<AbstractWVcsRoot>, context: Any?): ObjectFilter<FVcsRootContainer> {
        return RealObjectFilter {obj ->
            this.elementSelector().validate(obj.vcsRoots, filter)
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
) : ConditionFilter<FTriggerContainer, WTrigger>(),
    MWithInheritedContainer,
    MAllContainer
{
    companion object : Names("trigger")
    override val names = Companion.names

    override var includeInherited = false
    override var searchAll = false

    override fun build(context: Any?): ObjectFilter<FTriggerContainer> {
        return RealObjectFilter {obj ->
            val settings = if (!this.includeInherited) obj.ownTriggers
            else obj.triggers

            val objectFilterWithContext = condition.build(obj)

            elementSelector().validate(settings, objectFilterWithContext)
        }
    }

    override fun buildFrom(filter: ObjectFilter<WTrigger>, context: Any?): ObjectFilter<FTriggerContainer> {
        throw IllegalStateException("Can't call buildFrom from StepFilter")
    }
}

data class StepFilter(
    override val condition: ConditionAST<WStep>
) : ConditionFilter<FStepContainer, WStep>(),
    MWithInheritedContainer,
    MAllContainer
{
    companion object : Names("step")
    override val names = Companion.names

    override var includeInherited = false
    override var searchAll = false

    override fun build(context: Any?): ObjectFilter<FStepContainer> {
        return RealObjectFilter {obj ->
            val settings = if (!this.includeInherited) obj.ownSteps
            else obj.steps

            val objectFilterWithContext = condition.build(obj)

            elementSelector().validate(settings, objectFilterWithContext)
        }
    }

    override fun buildFrom(filter: ObjectFilter<WStep>, context: Any?): ObjectFilter<FStepContainer> {
        throw IllegalStateException("Can't call buildFrom from StepFilter")
    }
}

data class FeatureFilter(
    override val condition: ConditionAST<WFeature>
) : ConditionFilter<FFeatureContainer, WFeature>(),
    MWithInheritedContainer,
    MAllContainer
{
    companion object : Names("feature")
    override val names = Companion.names

    override var includeInherited = false
    override var searchAll = false

    override fun build(context: Any?): ObjectFilter<FFeatureContainer> {
        return RealObjectFilter {obj ->
            val settings = if (this.includeInherited) obj.features
            else obj.ownFeatures

            val objectFilterWithContext = condition.build(obj)

            elementSelector().validate(settings, objectFilterWithContext)
        }
    }

    override fun buildFrom(filter: ObjectFilter<WFeature>, context: Any?): ObjectFilter<FFeatureContainer> {
        throw IllegalStateException("Can't call buildFrom from FeatureFilter")
    }
}

data class TemplateFilter(
    override val condition: ConditionAST<WTemplate>
) : ConditionFilter<FTemplateContainer, WTemplate>(),
    MAllContainer
{
    companion object : Names("template")
    override val names = Companion.names
    override var searchAll = false

    override fun buildFrom(filter: ObjectFilter<WTemplate>, context: Any?): ObjectFilter<FTemplateContainer> {
        return RealObjectFilter {obj ->
            elementSelector().validate(obj.templates, filter)
        }
    }
}

data class ValueFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<FValueContainer, String>(),
    MResolvedContainer
{
    companion object : Names("val")
    override val names = Companion.names

    override var searchResolved = false

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?): ObjectFilter<FValueContainer> {
        return RealObjectFilter {obj ->
            if (!searchResolved) {
                obj.values.any { filter.accepts(it.str) }
            } else {
                obj.values.any {filter.accepts(it.resolve())}
            }
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
) : ConditionFilter<FParamContainer, WParam>(),
    MWithInheritedContainer,
    MResolvedContainer,
    MAllContainer
{
    companion object : Names("param")
    override val names = Companion.names

    override var includeInherited = false
    override var searchResolved = false
    override var searchAll = false

    override fun buildFrom(filter: ObjectFilter<WParam>, context: Any?): ObjectFilter<FParamContainer> {
        return RealObjectFilter {obj ->
            val params = (if (includeInherited) obj.params else obj.ownParams).map {
                if (!searchResolved) {
                    it.toParam()
                } else {
                    it.resolve()
                }
            }

            elementSelector().validate(params, filter)
        }
    }
}

data class AncestorFilter(
    override val condition: ConditionAST<WProject>
) : ConditionFilter<FAncestorContainer, WProject>(),
    MAllContainer
{
    companion object : Names("ancestor")
    override val names = Companion.names
    override var searchAll = false

    override fun buildFrom(filter: ObjectFilter<WProject>, context: Any?): ObjectFilter<FAncestorContainer> {
        return when (elementSelector()) {
            is AnyElementValidator -> RealObjectFilter fil@{obj ->
                var proj: WProject? = obj.firstAncestor
                while (proj != null) {
                    if (filter.accepts(proj)) {
                        return@fil true
                    }
                    proj = proj.parent
                }
                false
            }
            is AllElementValidator -> RealObjectFilter fil1@{obj ->
                var proj: WProject? = obj.firstAncestor
                while (proj != null) {
                    if (!filter.accepts(proj)) {
                        return@fil1 false
                    }
                    proj = proj!!.parent
                }
                true
            }
        }
    }
}

data class VcsRootEntryFilter(
    override val condition: ConditionAST<WVcsRootEntry>
) : ConditionFilter<FVcsRootEntryContainer, WVcsRootEntry>(),
    MWithInheritedContainer,
    MAllContainer
{
    override var includeInherited: Boolean = false

    companion object : Names("vcs")
    override val names = Companion.names
    override var searchAll = false

    override fun buildFrom(filter: ObjectFilter<WVcsRootEntry>, context: Any?): ObjectFilter<FVcsRootEntryContainer> {
        return RealObjectFilter {obj ->
            val vcss = if (includeInherited) obj.vcsRootEntries
                       else obj.ownVcsRootEntries
            elementSelector().validate(vcss, filter)
        }
    }
}

data class RulesFilter(
    override val condition: ConditionAST<String>
) : ConditionFilter<FRulesContainer, String>(),
    MResolvedContainer
{
    companion object : Names("rules")

    override val names: List<String> = Companion.names

    override var searchResolved = false

    override fun buildFrom(filter: ObjectFilter<String>, context: Any?): ObjectFilter<FRulesContainer> {
        return RealObjectFilter {obj ->
            if (searchResolved) filter.accepts(obj.rules.resolve())
            else filter.accepts(obj.rules.str)
        }
    }
}

data class DependencyFilter(
    override val condition: ConditionAST<SuperDependency>
) : ConditionFilter<FDependencyContainer, SuperDependency>(),
    MWithInheritedContainer,
    MAllContainer
{
    companion object : Names("dependency")

    override val names = Companion.names

    override var includeInherited = false
    override var searchAll = false

    override fun buildFrom(filter: ObjectFilter<SuperDependency>, context: Any?): ObjectFilter<FDependencyContainer> {
        return RealObjectFilter {obj ->
            val dependencies = if (includeInherited) obj.dependencies
                               else obj.ownDependencies
            elementSelector().validate(dependencies, filter)
        }
    }
}

data class ArtifactFilter(
    override val condition: ConditionAST<WArtifactDependency>
) : ConditionFilter<SuperDependency, WArtifactDependency>(),
    MAllContainer
{
    companion object : Names("artifact")
    override val names = Companion.names

    override var searchAll = false

    override fun buildFrom(filter: ObjectFilter<WArtifactDependency>, context: Any?): ObjectFilter<SuperDependency> {
        return RealObjectFilter {obj ->
            elementSelector().validate(obj.artifactDependencies, filter)
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
) : ConditionFilter<FOptionContainer, WParam>(),
    MWithInheritedContainer,
    MResolvedContainer,
    MAllContainer
{
    override var includeInherited: Boolean = false
    override var searchResolved = false
    override var searchAll = false

    companion object : Names("option")

    override val names = Companion.names

    override fun buildFrom(filter: ObjectFilter<WParam>, context: Any?): ObjectFilter<FOptionContainer> {
        return RealObjectFilter {obj ->
            val options = (if (includeInherited) obj.options else obj.ownOptions).map {
                if (searchResolved) it.resolve() else it.toParam()
            }

            elementSelector().validate(options, filter)
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


