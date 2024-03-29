package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.*

data class IdFilter(
    override val condition: ConditionAST<String>
) : SingleObjectConditionFilter<FIdContainer, String>()
{
    companion object : ObjectDescription(
        Names1("id"),
        Descriptions(
            TemplateDescription("_ external id")
        )
    )
    
    override val names = IdFilter.names

    override fun buildFrom(filter : RealObjectFilter<String>) = RealObjectFilter<FIdContainer> { obj ->
        filter.accepts(obj.id)
    }
}

data class ArchivedFilter(private val placeholder: String = "") : Filter<FArchivedContainer> {

    companion object : ObjectDescription(
        Names1("archived"),
        Descriptions(
            TemplateDescription("_ is archived")
        )
    )
    override val names = Companion.names

    override fun build():RealObjectFilter<FArchivedContainer> {
        return RealObjectFilter {obj ->
            obj.isArchived
        }
    }

    override fun createStr() = names.first()
}

data class BuildConfFilter(
    override val condition: ConditionAST<WBuildConf>
) : MultipleObjectsConditionFilter<FBuildConfContainer, WBuildConf>(),
    BuildConfConditionContainer
{
    companion object : ObjectDescription(
        Names1("configuration", "buildConfiguration"),
        Descriptions(
            SimpleDescription("configuration defined in project", "project")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<WBuildConf>):RealObjectFilter<FBuildConfContainer> {
        return RealObjectFilter {obj ->
            elementSelector().validate(obj.buildConfs, filter)
        }
    }
}

data class VcsRootFilter(
    override val condition: ConditionAST<WVcsRoot>
) : MultipleObjectsConditionFilter<FVcsRootContainer, WVcsRoot>(),
    VcsRootConditionContainer
{
    companion object : ObjectDescription(
        Names1("vcsRoot"),
        Descriptions(
            SimpleDescription("vcs root defined in project", "project")
        )
    )
    override val names = Companion.names

    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<WVcsRoot>):RealObjectFilter<FVcsRootContainer> {
        return RealObjectFilter {obj ->
            this.elementSelector().validate(obj.vcsRoots, filter)
        }
    }
}

data class ProjectFilter(
    override val condition: ConditionAST<WProject>
) : ConditionFilter<FProjectContainer, WProject>(),
    ProjectConditionContainer
{
    companion object : ObjectDescription(
        Names1("project"),
        Descriptions(
            SimpleDescription("this project or its ancestor", "project"),
            TemplateDescription("project that contains this _ or its ancestor")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<WProject>):RealObjectFilter<FProjectContainer> {
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

    override fun buildVisitorFrom(subVisitor: RealObjectFilter<WProject>): RealObjectFilter<FProjectContainer> {
        return RealObjectFilter { obj ->
            var project: WProject? = obj.project
            while (project != null) {
                subVisitor.accepts(project)
                project = project.parent
            }

            false
        }
    }
}


data class ParentFilter(
    override val condition: ConditionAST<WProject>
) : SingleObjectConditionFilter<FParentContainer, WProject>(),
    ProjectConditionContainer
{
    companion object : ObjectDescription(
        Names1("parent"),
        Descriptions(
            TemplateDescription("parent project of this _")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<WProject>):RealObjectFilter<FParentContainer> {
        return RealObjectFilter {obj ->
            obj.parent.let{ filter.accepts(it) }
        }
    }
}

data class TriggerFilter(
    override val condition: ConditionAST<WTrigger>
) : MultipleObjectsConditionFilter<FTriggerContainer, WTrigger>(),
    MWithInheritedContainer
{
    companion object : ObjectDescription(
        Names1("trigger"),
        Descriptions(
            TemplateDescription("build trigger defined in this _")
        )
    )
    override val names = Companion.names

    override var includeInherited = false
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter: RealObjectFilter<WTrigger>):RealObjectFilter<FTriggerContainer> {
        return RealObjectFilter {obj ->
            val settings = if (!this.includeInherited) obj.ownTriggers
            else obj.triggers

            elementSelector().validate(settings, filter)
        }
    }
}

data class StepFilter(
    override val condition: ConditionAST<WStep>
) : MultipleObjectsConditionFilter<FStepContainer, WStep>(),
    MWithInheritedContainer
{
    companion object : ObjectDescription(
        Names1("step"),
        Descriptions(
            TemplateDescription("build step defined in this _")
        )
    )
    override val names = Companion.names

    override var includeInherited = false
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<WStep>):RealObjectFilter<FStepContainer> {
        return RealObjectFilter {obj ->
            val settings = if (!this.includeInherited) obj.ownSteps
            else obj.steps

            elementSelector().validate(settings, filter)
        }
    }
}

data class FeatureFilter(
    override val condition: ConditionAST<WFeature>
) : MultipleObjectsConditionFilter<FFeatureContainer, WFeature>(),
    MWithInheritedContainer
{
    companion object : ObjectDescription(
        Names1("feature"),
        Descriptions(
            SimpleDescription("project feature", "project"),
            TemplateDescription("build feature defined in this _")
        )
    )
    override val names = Companion.names

    override var includeInherited = false
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<WFeature>):RealObjectFilter<FFeatureContainer> {
        return RealObjectFilter {obj ->
            val settings = if (this.includeInherited) obj.features
            else obj.ownFeatures

            elementSelector().validate(settings, filter)
        }
    }
}

data class TemplateFilter(
    override val condition: ConditionAST<WTemplate>
) : MultipleObjectsConditionFilter<FTemplateContainer, WTemplate>(),
    TemplateConditionContainer
{
    companion object : ObjectDescription(
        Names1("template"),
        Descriptions(
            SimpleDescription("template that was defined in this project", "project"),
            SimpleDescription("template attached to this build configuration", "configuration"),
            SimpleDescription("template attached to the build configuration that this configuration depends on", "dependency")
        )
    )
    override val names = Companion.names
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<WTemplate>):RealObjectFilter<FTemplateContainer> {
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
    companion object : ObjectDescription(
        Names1("val"),
        Descriptions(
            TemplateDescription("any string value of this _")
        )
    )
    override val names = Companion.names

    override var searchResolved = false

    override fun buildFrom(filter:RealObjectFilter<String>):RealObjectFilter<FValueContainer> {
        return RealObjectFilter {obj ->
            if (!searchResolved) {
                obj.values.any { filter.accepts(it.str) }
            } else {
                obj.values.any {filter.accepts(it.resolve())}
            }
        }
    }

    override fun buildVisitorFrom(subVisitor: RealObjectFilter<String>): RealObjectFilter<FValueContainer> {
        return RealObjectFilter { obj ->
            if (!searchResolved) {
                obj.values.forEach { subVisitor.accepts(it.str) }
            } else {
                obj.values.forEach { subVisitor.accepts(it.resolve())}
            }
            true
        }
    }
}

data class TypeFilter(
    override val condition: ConditionAST<String>
) : SingleObjectConditionFilter<FTypeContainer, String>()
{
    companion object : ObjectDescription(
        Names1("type"),
        Descriptions(
            TemplateDescription("_ type")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<String>):RealObjectFilter<FTypeContainer> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.type)
        }
    }
}

data class EnabledFilter(private val placeholder: String = "") : Filter<FEnabledContainer> {

    companion object : ObjectDescription(
        Names1("enabled"),
        Descriptions(
            TemplateDescription("this _ is enabled")
        )
    )
    override val names = Companion.names

    override fun build():RealObjectFilter<FEnabledContainer> {
        return RealObjectFilter {obj ->
            obj.isEnabled
        }
    }

    override fun createStr() = names.first()
}

data class ParameterFilter(
    override val condition: ConditionAST<WParam>
) : MultipleObjectsConditionFilter<FParamContainer, WParam>(),
    MWithInheritedContainer,
    MResolvedContainer
{
    companion object : ObjectDescription(
        Names1("param"),
        Descriptions(
            TemplateDescription(
                "parameter of this _"
            )
        )
    )
    override val names = Companion.names

    override var includeInherited = false
    override var searchResolved = false
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<WParam>):RealObjectFilter<FParamContainer> {
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
    ProjectConditionContainer
{
    companion object : ObjectDescription(
        Names1("ancestor"),
        Descriptions(
            SimpleDescription("ancestor of this project", "project")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter: RealObjectFilter<WProject>):RealObjectFilter<FAncestorContainer> {
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

    override fun buildVisitorFrom(subVisitor: RealObjectFilter<WProject>): RealObjectFilter<FAncestorContainer> {
        return RealObjectFilter fil@{obj ->
            var proj: WProject? = obj.firstAncestor
            while (proj != null) {
                subVisitor.accepts(proj)
                proj = proj.parent
            }
            false
        }
    }
}

data class VcsRootEntryFilter(
    override val condition: ConditionAST<WVcsRootEntry>
) : MultipleObjectsConditionFilter<FVcsRootEntryContainer, WVcsRootEntry>(),
    MWithInheritedContainer
{
    override var includeInherited: Boolean = false

    companion object : ObjectDescription(
        Names1("vcs"),
        Descriptions(
            TemplateDescription("vcs root attached to this _")
        )
    )
    override val names = Companion.names
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<WVcsRootEntry>):RealObjectFilter<FVcsRootEntryContainer> {
        return RealObjectFilter {obj ->
            val vcss = if (includeInherited) obj.vcsRootEntries
                       else obj.ownVcsRootEntries
            elementSelector().validate(vcss, filter)
        }
    }
}

data class RulesFilter(
    override val condition: ConditionAST<String>
) : MultipleObjectsConditionFilter<FRulesContainer, String>(),
    MResolvedContainer
{
    companion object : ObjectDescription(
        Names1("rules"),
        Descriptions(
            SimpleDescription("checkout rules of attached vcs root", "vcs"),
            SimpleDescription("artifact rules of this dependency", "artifact")
        )
    )

    override val names: List<String> = Companion.names

    override var searchResolved = false
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<String>):RealObjectFilter<FRulesContainer> {
        return RealObjectFilter {obj ->
            val rules = if (searchResolved) obj.rules.map {it.resolve()}
                        else obj.rules.map {it.str}

            elementSelector().validate(rules, filter)
        }
    }
}

data class DependencyFilter(
    override val condition: ConditionAST<SuperDependency>
) : MultipleObjectsConditionFilter<FDependencyContainer, SuperDependency>(),
    MWithInheritedContainer
{
    companion object : ObjectDescription(
        Names1("dependency"),
        Descriptions(
            SimpleDescription("all artifact dependencies and snapshot dependency on particular build configuration")
        )
    )

    override val names = Companion.names

    override var includeInherited = false
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<SuperDependency>):RealObjectFilter<FDependencyContainer> {
        return RealObjectFilter {obj ->
            val dependencies = if (includeInherited) obj.dependencies
                               else obj.ownDependencies
            elementSelector().validate(dependencies, filter)
        }
    }
}

data class ArtifactFilter(
    override val condition: ConditionAST<WArtifactDependency>
) : MultipleObjectsConditionFilter<SuperDependency, WArtifactDependency>()
{
    companion object : ObjectDescription(
        Names1("artifact"),
        Descriptions(
            SimpleDescription("artifact dependency")
        )
    )
    override val names = Companion.names

    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    override fun buildFrom(filter:RealObjectFilter<WArtifactDependency>):RealObjectFilter<SuperDependency> {
        return RealObjectFilter {obj ->
            elementSelector().validate(obj.artifactDependencies, filter)
        }
    }
}

data class SnapshotFilter(
    override val condition: ConditionAST<WSnapshotDependency>
) : SingleObjectConditionFilter<SuperDependency, WSnapshotDependency>()
{
    companion object : ObjectDescription(
        Names1("snapshot"),
        Descriptions(
            SimpleDescription("snapshot dependency")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<WSnapshotDependency>):RealObjectFilter<SuperDependency> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.snapshotDep)
        }
    }
}

data class CleanFilter(
    private val placeholder: String = ""
) : Filter<WArtifactDependency>
{
    companion object : ObjectDescription(
        Names1("clean"),
        Descriptions(
            SimpleDescription("clean destination paths flag")
        )
    )

    override val names = Companion.names

    override fun createStr(): String = names.first()

    override fun build():RealObjectFilter<WArtifactDependency> {
        return RealObjectFilter {obj ->
            obj.adep.isCleanDestinationFolder
        }
    }
}

data class RevRuleFilter(
    override val condition: ConditionAST<String>
) : SingleObjectConditionFilter<WArtifactDependency, String>()
{
    companion object : ObjectDescription(
        Names1("revRule"),
        Descriptions(
            SimpleDescription("where to get artifacts")
        )
    )

    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<String>):RealObjectFilter<WArtifactDependency> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.adep.revisionRule.name)
        }
    }
}

data class OptionFilter(
    override val condition: ConditionAST<WParam>
) : MultipleObjectsConditionFilter<FOptionContainer, WParam>(),
    MResolvedContainer
{
    override var searchResolved = false
    override var searchAll: ElementValidator<*> = AnyElementValidator<Any>()

    companion object : ObjectDescription(
        Names1("option"),
        Descriptions(
            TemplateDescription("option of this _")
        )
    )

    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<WParam>):RealObjectFilter<FOptionContainer> {
        return RealObjectFilter {obj ->
            val options = obj.options.map {
                if (searchResolved) it.resolve() else it.toParam()
            }

            elementSelector().validate(options, filter)
        }
    }
}

data class NameFilter(
    override val condition: ConditionAST<String>
) : SingleObjectConditionFilter<FNameContainer, String>() {

    companion object : ObjectDescription(
        Names1("name"),
        Descriptions(
            TemplateDescription("short name of this _")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter:RealObjectFilter<String>):RealObjectFilter<FNameContainer> {
        return RealObjectFilter {obj ->
            filter.accepts(obj.name)
        }
    }
}

data class SubProjectFilter(
    override val condition: ConditionAST<WProject>
) : MultipleObjectsConditionFilter<FSubProjectContainer, WProject>() {

    companion object : ObjectDescription(
        Names1("subProject"),
        Descriptions(
            SimpleDescription("subproject of this project", "project")
        )
    )
    override val names = Companion.names

    override fun buildFrom(filter: RealObjectFilter<WProject>): RealObjectFilter<FSubProjectContainer> {
        return RealObjectFilter { obj ->
            elementSelector().validate(obj.subProjects, filter)
        }
    }
}


