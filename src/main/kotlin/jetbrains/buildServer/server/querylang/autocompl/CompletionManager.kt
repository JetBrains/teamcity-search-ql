package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.indexing.CompressedTrie
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.serverSide.auth.SecurityContext
import jetbrains.buildServer.vcs.SVcsRoot
import kotlin.reflect.KClass

class CompletionManager(
    private val projectManager: ProjectManager,
    val securityContext: SecurityContext
) {
    private val DISABLE_VALUE_PARAM_NAME = "query.lang.disable.value.autocompletion"
    private val DISABLE_IDS_PARAM_NAME = "query.lang.disable.ids.autocompletion"
    private val DISABLE_AUTOCOMPLETION_NAME = "query.lang.disable.autocompletion"

    val disableAll = TeamCityProperties.getBoolean(DISABLE_AUTOCOMPLETION_NAME)
    val disabledValues = TeamCityProperties.getBoolean(DISABLE_VALUE_PARAM_NAME) || disableAll
    val disableIds = TeamCityProperties.getBoolean(DISABLE_IDS_PARAM_NAME) || disableAll


    private val map: MutableMap<String, SecuredStringFinder> = mutableMapOf()
    private val projectIdFinder = getSimpleFinder(true, disableIds)
    private val projectParamFinder = getParamFinder(true, disableAll)
    private val projectNameFinder = getSimpleFinder(true, disableIds)

    private val buildConfIdFinder = getSimpleFinder(true, disableIds)
    private val buildConfOptionFinder = getParamFinder(false, disableAll)
    private val buildConfParamFinder = getParamFinder(true, disableAll)
    private val buildConfNameFinder = getSimpleFinder(true, disableIds)

    private val templateIdFinder = getSimpleFinder(true, disableIds)
    private val templateOptionFinder = getParamFinder(false, disableAll)
    private val templateParamFinder = getParamFinder(true, disableAll)
    private val templateNameFinder = getSimpleFinder(true, disableIds)

    private val vcsRootIdFinder = getSimpleFinder(true, disableIds)
    private val vcsRootTypeFinder = getSimpleFinder(false, disableAll)
    private val vcsParamFinder = getParamFinder(true, disableAll)
    private val vcsRootNameFinder = getSimpleFinder(true, disableIds)

    private val triggerParamValueFinder = getParamFinder(false, disableAll)
    private val triggerTypeFinder = getSimpleFinder(false, disableAll)

    private val stepParamValueFinder = getParamFinder(false, disableAll)
    private val stepTypeFinder = getSimpleFinder(false, disableAll)

    private val featureParamValueFinder = getParamFinder(false, disableAll)
    private val featureTypeFinder = getSimpleFinder(false, disableAll)

    private val snapshotOptionFinder = getParamFinder(false, disableAll)

    private val artifactRulesFinder = getSimpleFinder(false, disableAll)
    private val artifactRevRuleFinder = getSimpleFinder(false, disableAll)

    init {
        registerFinder(projectIdFinder, ProjectFilter::class, IdFilter::class)
        registerFinder(projectIdFinder, ParentFilter::class, IdFilter::class)
        registerFinder(projectIdFinder, AncestorFilter::class, IdFilter::class)
        registerFinder(triggerParamValueFinder, TriggerFilter::class, ParameterFilter::class)
        registerFinder(stepParamValueFinder, StepFilter::class, ParameterFilter::class)
        registerFinder(featureParamValueFinder, FeatureFilter::class, ParameterFilter::class)
        registerFinder(buildConfIdFinder, BuildConfTopLevelQuery::class, IdFilter::class)
        registerFinder(templateIdFinder, TemplateTopLevelQuery::class, IdFilter::class)
        registerFinder(vcsRootIdFinder, VcsRootTopLevelQuery::class, IdFilter::class)
        registerFinder(triggerTypeFinder, TriggerFilter::class, TypeFilter::class)
        registerFinder(stepTypeFinder, StepFilter::class, TypeFilter::class)
        registerFinder(featureTypeFinder, FeatureFilter::class, TypeFilter::class)
        registerFinder(vcsRootTypeFinder, VcsRootTopLevelQuery::class, TypeFilter::class)
        registerFinder(snapshotOptionFinder, SnapshotFilter::class, OptionFilter::class)
        registerFinder(artifactRulesFinder, ArtifactFilter::class, RulesFilter::class)
        registerFinder(artifactRevRuleFinder, ArtifactFilter::class, RevRuleFilter::class)
        registerFinder(projectParamFinder, ProjectTopLevelQuery::class, ParameterFilter::class)
        registerFinder(vcsParamFinder, VcsRootTopLevelQuery::class, ParameterFilter::class)
        registerFinder(buildConfOptionFinder, BuildConfTopLevelQuery::class, OptionFilter::class)
        registerFinder(templateOptionFinder, TemplateTopLevelQuery::class, OptionFilter::class)
        registerFinder(buildConfParamFinder, BuildConfTopLevelQuery::class, ParameterFilter::class)
        registerFinder(templateParamFinder, TemplateFilter::class, ParameterFilter::class)
        registerFinder(buildConfIdFinder, DependencyFilter::class, IdFilter::class)
        registerFinder(buildConfParamFinder, DependencyFilter::class, ParameterFilter::class)
        registerFinder(buildConfOptionFinder, DependencyFilter::class, OptionFilter::class)
        registerFinder(vcsRootIdFinder, VcsRootEntryFilter::class, IdFilter::class)
        registerFinder(vcsRootTypeFinder, VcsRootEntryFilter::class, TypeFilter::class)
        registerFinder(vcsParamFinder, VcsRootEntryFilter::class, ParameterFilter::class)
        registerFinder(projectNameFinder, ProjectTopLevelQuery::class, NameFilter::class)
        registerFinder(buildConfNameFinder, BuildConfTopLevelQuery::class, NameFilter::class)
        registerFinder(templateNameFinder, TemplateTopLevelQuery::class, NameFilter::class)
        registerFinder(vcsRootNameFinder, VcsRootTopLevelQuery::class, NameFilter::class)
    }

    val nodesTotal: Long
        get() = map.values.fold(0L) {acc, sf -> acc + sf.nodesTotal}

    val symbolsTotal: Long
        get() = map.values.fold(0L) {acc, sf -> acc + sf.symbolsTotal}

    private fun registerFinder(sf: SecuredStringFinder, vararg nameContext: KClass<out Named>) {
        val vars = nameContext.map { it.getNames()!! }

        addToMapWithPrefix(sf, "", vars)
    }

    private fun addToMapWithPrefix(sf: SecuredStringFinder, prefix: String, vars: List<List<String>>) {
        if (vars.isEmpty()) {
            map[prefix] = sf
            return
        }

        vars.first().forEach { str ->
            val newprefix = if (prefix.isEmpty()) str else prefix + "_" + str

            addToMapWithPrefix(sf, newprefix, vars.drop(1))
        }
    }

    fun indexAll() {
        projectManager.projects.forEach { updateProject(it) }
        projectManager.allBuildTypes.forEach { updateBuildType(it) }
        projectManager.allTemplates.forEach { updateTemplate(it) }
        projectManager.allVcsRoots.forEach { updateVcsRoot(it) }
    }

    fun completeString(s: String, filterType: String, limit: Int): List<String> {
        return map[filterType]?.completeString(s, limit) ?: listOf()
    }

    fun updateProject(project: SProject) {
        projectIdFinder.addString(project.externalId)
        projectNameFinder.addString(project.name)

        project.ownFeatures.forEach {feat ->
            featureTypeFinder.addString(feat.type)
            feat.parameters.forEach { (name, value) ->
                featureParamValueFinder.addParam(name, value)
            }
        }

        project.ownParameters.forEach {(name, value) ->
            projectParamFinder.addParam(name, value)
        }
    }

    fun updateBuildType(bt: SBuildType) {
        buildConfIdFinder.addString(bt.externalId)
        buildConfNameFinder.addString(bt.name)
        bt.buildTriggersCollection.forEach { trig ->
            triggerTypeFinder.addString(trig.type)
            trig.parameters.forEach {name, value ->
                triggerParamValueFinder.addParam(name, value)
            }
        }
        bt.buildRunners.forEach {step ->
            stepTypeFinder.addString(step.type)
            step.parameters.forEach {name, value ->
                stepParamValueFinder.addParam(name, value)
            }
        }
        bt.buildFeatures.forEach { feat ->
            featureTypeFinder.addString(feat.type)
            feat.parameters.forEach {name, value ->
                featureParamValueFinder.addParam(name, value)
            }
        }

        bt.dependencies.forEach { dep ->
            dep.ownOptions.forEach {opt ->
                snapshotOptionFinder.addParam(opt.key, dep.getOption(opt).toString())
            }
        }

        bt.artifactDependencies.forEach {art ->
            artifactRulesFinder.addString(art.sourcePaths)
            artifactRevRuleFinder.addString(art.revisionRule.name)
        }

        bt.options.forEach {opt ->
            buildConfOptionFinder.addParam(opt.key, bt.getOption(opt).toString())
        }

        bt.ownParameters.forEach {(a, b) -> buildConfParamFinder.addParam(a, b)}
    }

    fun updateTemplate(temp: BuildTypeTemplate) {
        templateIdFinder.addString(temp.externalId)
        templateNameFinder.addString(temp.name)
        temp.buildTriggersCollection.forEach { trig ->
            triggerTypeFinder.addString(trig.type)
            trig.parameters.forEach {name, value ->
                triggerParamValueFinder.addParam(name, value)
            }
        }
        temp.buildRunners.forEach {step ->
            stepTypeFinder.addString(step.type)
            step.parameters.forEach {name, value ->
                stepParamValueFinder.addParam(name, value)
            }
        }
        temp.buildFeatures.forEach { feat ->
            featureTypeFinder.addString(feat.type)
            feat.parameters.forEach {name, value ->
                featureParamValueFinder.addParam(name, value)
            }
        }

        temp.dependencies.forEach { dep ->
            dep.ownOptions.forEach {opt ->
                snapshotOptionFinder.addParam(opt.key, dep.getOption(opt).toString())
            }
        }

        temp.artifactDependencies.forEach { art ->
            artifactRulesFinder.addString(art.sourcePaths)
            artifactRevRuleFinder.addString(art.revisionRule.name)
        }

        temp.options.forEach {opt ->
            templateOptionFinder.addParam(opt.key, temp.getOption(opt).toString())
        }

        temp.ownParameters.forEach {(a, b) -> templateParamFinder.addParam(a, b)}
    }

    fun updateVcsRoot(vcs: SVcsRoot) {
        vcsRootIdFinder.addString(vcs.externalId)
        vcsRootTypeFinder.addString(vcs.vcsName)
        vcsRootNameFinder.addString(vcs.name)

        vcs.properties.forEach {(name, value) ->
            vcsParamFinder.addParam(name, value)
        }
    }

    fun getSimpleFinder(isSystemAdminOnly: Boolean, disabled: Boolean): SimpleStringFinder {
        return SimpleStringFinder(this, isSystemAdminOnly, disabled)
    }

    fun getParamFinder(
        isSystemAdminOnly: Boolean,
        disabled: Boolean,
        isValueSystemAdminOnly: Boolean = true
    ): ParameterValueFinder {
        return ParameterValueFinder(this, isSystemAdminOnly, isValueSystemAdminOnly, disabled, disabledValues)
    }
}