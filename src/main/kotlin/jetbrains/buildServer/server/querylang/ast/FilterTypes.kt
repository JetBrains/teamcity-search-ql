package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.*
import jetbrains.buildServer.server.querylang.myProjectManager
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.vcs.SVcsRoot


interface ParameterHolderFilterType : Filter

interface ParHolderConditionContainer : ConditionContainer<ParameterHolderFilterType, ParametersDescriptor> {
    override fun buildFilter(filter: ParameterHolderFilterType, context: Any?): ObjectFilter<ParametersDescriptor> {
        return when (filter) {
            is TypeFilter -> {
                val strFilter = filter.build()
                ObjectFilter { parHolder ->
                    strFilter.accepts(parHolder.type)
                }
            }
            is ParameterFilter -> {
                val (nameCondition, valCondition) = filter.buildP()
                ObjectFilter { parHolder ->
                    parHolder.parameters.any {(key, value) ->
                        nameCondition.accepts(key) && valCondition.accepts(value)
                    }
                }
            }
            is ValueFilter -> {
                val conditionVal = filter.build()
                ObjectFilter { parHolder ->
                    parHolder.parameters.values.any {conditionVal.accepts(it)}
                }
            }
            is EnabledFilter -> {
                val buildType = context as? BuildTypeSettings
                    ?: throw java.lang.IllegalStateException("Context for ParameterHolder should be SBuildType")
                ObjectFilter { parHolder ->
                    buildType.isEnabled(parHolder.id)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown ParHolderFilter")
        }
    }
}

interface ProjectFilterType: Filter

interface ProjectConditionContainer : ConditionContainer<ProjectFilterType, SProject> {
    override fun buildFilter(filter: ProjectFilterType, context: Any?): ObjectFilter<SProject> {
        return when (filter) {
            is IdFilter -> {
                val condition = filter.build()
                ObjectFilter { project ->
                    condition.accepts(project.externalId)
                }
            }
            is AncestorFilter -> {
                val conditionFilter = filter.build()
                ObjectFilter { project ->
                    hasSuitableAncestor(project.parentProject, conditionFilter)
                }
            }
            is ParentFilter -> {
                val conditionFilter = filter.build()
                ObjectFilter { project ->
                    conditionFilter.accepts(project.parentProject)
                }
            }
            is ProjectFilter -> {
                val conditionFilter = filter.build()
                ObjectFilter { project ->
                    this.hasSuitableAncestor(project, conditionFilter)
                }
            }
            is FeatureFilter -> {
                val condFilter = filter.build()
                ObjectFilter { project ->
                    val features = if (filter.includeInherited) project.availableFeatures
                    else project.ownFeatures

                    features.any { feat ->
                        condFilter.accepts(feat)
                    }
                }
            }

            is ParameterFilter -> {
                val (nameFilter, valFilter) = filter.buildP()

                ObjectFilter { project ->
                    val params = if (filter.includeInherited) project.parameters
                    else project.ownParameters
                    params.any {(name, value) ->
                        nameFilter.accepts(name) && valFilter.accepts(value)
                    }
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow ProjectFilterType")
        }
    }

    private fun hasSuitableAncestor(project: SProject?, filter: ObjectFilter<SProject>): Boolean {
        var curProject: SProject? = project
        while (curProject != null) {
            if (filter.accepts(curProject)) {
                return true
            }
            curProject = curProject.parentProject
        }
        return false
    }
}

interface VcsRootFilterType : Filter, VcsRootEntryFilter

interface VcsRootConditionContainer : ConditionContainer<VcsRootFilterType, SVcsRoot> {
    override fun buildFilter(filter: VcsRootFilterType, context: Any?): ObjectFilter<SVcsRoot> {
        return when(filter) {
            is IdFilter -> {
                val condition = filter.build()
                ObjectFilter { vcs ->
                    condition.accepts(vcs.externalId)
                }
            }
            is ProjectFilter -> {
                val projectFilter = ProjectFilter(FilterConditionNode(filter)).build()
                ObjectFilter { vcs ->
                    projectFilter.accepts(vcs.project)
                }
            }
            is ParentFilter -> {
                val projectFilter = filter.build()
                ObjectFilter { vcs ->
                    projectFilter.accepts(vcs.project)
                }
            }
            is TypeFilter -> {
                val strFilter = filter.build()
                ObjectFilter { vcs ->
                    strFilter.accepts(vcs.vcsName)
                }
            }
            is ParameterFilter -> {
                val (nameFilter, valFilter) = filter.buildP()

                ObjectFilter { vcs ->
                    vcs.properties.any {(name, value) ->
                        nameFilter.accepts(name) && valFilter.accepts(value)
                    }
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown VcsRootFilterType")
        }
    }
}

interface TemplateFilterType : Filter

interface TemplateConditionContainer : ConditionContainer<TemplateFilterType, BuildTypeTemplate> {
    override fun buildFilter(filter: TemplateFilterType, context: Any?): ObjectFilter<BuildTypeTemplate> {
        return when(filter) {
            is ProjectFilter -> {
                val projectFilter = ProjectFilter(FilterConditionNode(filter)).build()
                ObjectFilter { buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is IdFilter -> {
                val condition = filter.build()
                ObjectFilter { buildType ->
                    condition.accepts(buildType.externalId)
                }
            }
            is TriggerFilter -> {
                ObjectFilter { buildType ->
                    val condition = filter.build(buildType)
                    buildType.buildTriggersCollection.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter { buildType ->
                    val condition = filter.build(buildType)
                    buildType.buildRunners.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter { buildType ->
                    val condition = filter.build(buildType)
                    buildType.buildFeatures.any {feature ->
                        condition.accepts(feature)
                    }
                }
            }
            is ParentFilter -> {
                val projectFilter = filter.build()
                ObjectFilter { buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is VcsRootFilter -> {
                val vcsFilter = filter.build()
                ObjectFilter { buildType ->
                    buildType.vcsRootEntries.any {vcsFilter.accepts(it.toMyVcsRootEntry())}
                }
            }
            is ParameterFilter -> {
                val (nameFilter, valFilter) = filter.buildP()
                ObjectFilter { buildType ->
                    val params = if (filter.includeInherited) buildType.parameters
                    else buildType.ownParameters
                    params.any<String, String> {(key, value) ->
                        nameFilter.accepts(key) && valFilter.accepts(value)
                    }
                }
            }
            is DependencyFilter -> {
                ObjectFilter { buildType ->
                    val dependencyFilter = filter.build(buildType)
                    buildType.dependencies.any {
                        dependencyFilter.accepts(MySnapshotDependency(it))}
                            || buildType.artifactDependencies.any {dependencyFilter.accepts(MyArtifactDependency(it))
                    }
                }
            }
            is OptionFilter -> {
                val (nameFilter, valFilter) = filter.buildP()
                ObjectFilter { temp ->
                    val options = if (filter.includeInherited) temp.options
                    else temp.ownOptions
                    options.any {opt ->
                        nameFilter.accepts(opt.key) && valFilter.accepts(temp.getOption(opt).toString())
                    }
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow TemplateFilterType")
        }
    }
}

interface BuildConfFilterType : Filter, DependencyFilterType

interface BuildConfConditionContainer : ConditionContainer<BuildConfFilterType, SBuildType> {
    override fun buildFilter(filter: BuildConfFilterType, context: Any?): ObjectFilter<SBuildType> {
        return when (filter) {
            is ProjectFilter -> {
                val projectFilter = ProjectFilter(FilterConditionNode(filter)).build()
                ObjectFilter { buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is IdFilter -> {
                val condition = filter.build()
                ObjectFilter { buildType ->
                    condition.accepts(buildType.externalId)
                }
            }
            is TriggerFilter -> {
                ObjectFilter { buildType ->
                    buildType as? BuildTypeEx ?: throw java.lang.IllegalStateException("Should be BuildTypeEx")
                    val condition = filter.build(buildType)
                    val settings = if (!filter.includeInherited) buildType.settings.ownBuildTriggers
                    else buildType.buildTriggersCollection

                    settings.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter { buildType ->
                    val condition = filter.build(buildType)

                    buildType as? BuildTypeEx ?: throw java.lang.IllegalStateException("Should be BuildTypeEx")

                    val settings = if (!filter.includeInherited) buildType.settings.ownBuildRunners
                    else buildType.buildRunners

                    settings.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter { buildType ->
                    val condition = filter.build(buildType)

                    buildType as? BuildTypeEx ?: throw java.lang.IllegalStateException("Should be BuildTypeEx")

                    val settings = if (!filter.includeInherited) buildType.settings.ownBuildFeatures
                    else buildType.buildFeatures

                    settings.any {feature ->
                        condition.accepts(feature)
                    }
                }
            }

            is ParentFilter -> {
                val projectFilter = filter.build()

                ObjectFilter { buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is TempDepFilter -> {
                val tempFilter = filter.build()

                ObjectFilter { buildType ->
                    buildType.templates.any {tempFilter.accepts(it)}
                }
            }
            is VcsRootFilter -> {
                val vcsFilter = filter.build()

                ObjectFilter { buildType ->
                    buildType.vcsRootInstanceEntries.any {vcsFilter.accepts(it.toMyVcsRootEntry())}
                }
            }
            is ParameterFilter -> {
                val (nameFilter, valFilter) = filter.buildP()
                ObjectFilter { buildType ->
                    val params = if (filter.includeInherited) buildType.parameters
                    else buildType.ownParameters
                    params.any<String, String> {(key, value) ->
                        nameFilter.accepts(key) && valFilter.accepts(value)
                    }
                }
            }
            is DependencyFilter -> {
                ObjectFilter { buildType ->
                    val dependencyFilter = filter.build()
                    buildType as? BuildTypeEx ?: throw java.lang.IllegalStateException("Should be BuildTypeEx")

                    val artifactDeps = if (filter.includeInhereted) buildType.artifactDependencies
                    else buildType.settings.ownArtifactDependencies

                    val snapshotDeps = if (filter.includeInhereted) buildType.dependencies
                    else buildType.ownDependencies

                    snapshotDeps.any {dependencyFilter.accepts(MySnapshotDependency(it))}
                            || artifactDeps.any {dependencyFilter.accepts(MyArtifactDependency(it))}
                }
            }

            is OptionFilter -> {
                val (nameFilter, valFilter) = filter.buildP()
                ObjectFilter { bt ->
                    val options = if (filter.includeInherited) bt.options
                    else bt.ownOptions
                    options.any {opt ->
                        nameFilter.accepts(opt.key) && valFilter.accepts(bt.getOption(opt).toString())
                    }
                }
            }

            else -> throw java.lang.IllegalStateException("Unknow BCFilter")
        }
    }

    override fun eval(): EvalResult<SBuildType> {
        return eval(condition)
    }

    override fun evalFilter(filter: BuildConfFilterType): EvalResult<SBuildType> {
        return when(filter) {
            is IdFilter -> {
                val vars = retrieveEquals(filter.strCondition) ?: return EvalResult(filter.buildRev(), emptyList())
                val buildTypes = vars.mapNotNull { myProjectManager.findBuildTypeByExternalId(it)}
                return EvalResult(NoneObjectFilter(), buildTypes)
            }
            else -> EvalResult(filter.buildRev(), emptyList())
        }
    }
}

interface VcsRootEntryFilter : Filter

interface VcsRootEntryConditionContainer : ConditionContainer<VcsRootEntryFilter, MyVcsRootEntry> {
    override fun buildFilter(filter: VcsRootEntryFilter, context: Any?): ObjectFilter<MyVcsRootEntry> {
        return when(filter) {
            is VcsRootFilterType -> {
                val vcsFilter = FindVcsRoot(FilterConditionNode(filter)).build()
                ObjectFilter { entry ->
                    vcsFilter.accepts(entry.vcsRoot)
                }
            }
            is RulesFilter -> {
                val stringFilter = filter.build()
                ObjectFilter { entry ->
                    stringFilter.accepts(entry.checkoutRules)
                }
            }
            else -> throw IllegalStateException("Unknown VcsRootInstanceFilter")
        }
    }
}


interface DependencyFilterType : Filter

interface DependencyConditionContainer : ConditionContainer<DependencyFilterType, MyDependency> {
    override fun buildFilter(filter: DependencyFilterType, context: Any?): ObjectFilter<MyDependency> {
        return when (filter) {
            is BuildConfFilterType -> {
                val bcFilter = FindBuildConf(FilterConditionNode(filter)).build()
                ObjectFilter { obj ->
                    bcFilter.accepts(obj.dependOn)
                }
            }
            is ArtifactFilter -> {
                val confFilter = filter.build()
                ObjectFilter { obj ->
                    (obj is MyArtifactDependency) && confFilter.accepts(obj)
                }
            }
            is SnapshotFilter -> {
                val condFilter = filter.build()
                ObjectFilter { obj ->
                    (obj is MySnapshotDependency) && condFilter.accepts(obj)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown dependency filter")
        }
    }
}

interface SnapshotDepFilterType : Filter

interface SnapshotDepConditionContainer : ConditionContainer<SnapshotDepFilterType ,MySnapshotDependency> {
    override fun buildFilter(filter: SnapshotDepFilterType, context: Any?): ObjectFilter<MySnapshotDependency> {
        return when(filter) {
            is OptionFilter -> {
                val (nameFilter, valFilter) = filter.buildP()
                ObjectFilter { obj ->
                    obj.dep.options.any { opt ->
                        nameFilter.accepts(opt.key) && valFilter.accepts(obj.dep.getOption(opt).toString())
                    }
                }
            }
            else -> throw IllegalStateException("Unknown SnapshotDepFilterType")
        }
    }
}

interface ArtifactDepFilterType : Filter

interface ArtifactDepConditionContainer : ConditionContainer<ArtifactDepFilterType, MyArtifactDependency> {
    override fun buildFilter(filter: ArtifactDepFilterType, context: Any?): ObjectFilter<MyArtifactDependency> {
        return when(filter) {
            is RulesFilter -> {
                val conditionFilter = filter.build()
                ObjectFilter { obj ->
                    conditionFilter.accepts(obj.dep.sourcePaths)
                }
            }
            is CleanFilter -> {
                ObjectFilter { obj ->
                    obj.dep.isCleanDestinationFolder
                }
            }
            is RevRuleFilter -> {
                val conditionFilter = filter.build()
                ObjectFilter { obj ->
                    conditionFilter.accepts(obj.dep.revisionRule.name)
                }
            }
            else -> throw IllegalStateException("Unknown filter '${filter::class.java}' of ArtifactDependencyFilterType")
        }
    }
}