package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.indexing.CompressedTrie
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.serverSide.auth.SecurityContext
import jetbrains.buildServer.util.EventDispatcher
import jetbrains.buildServer.util.ThreadUtil
import jetbrains.buildServer.util.executors.ExecutorsFactory
import jetbrains.buildServer.vcs.SVcsRoot
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.reflect.KClass

class CompletionManager(
    private val projectManager: ProjectManager,
    val securityContext: SecurityContext,
    val serverDispatcher: EventDispatcher<ServerListener>
): ServerListener {
    private val DISABLE_AUTOCOMPLETION_NAME = "teamcity.internal.searchQL.autocompletion.disable"

    private val VALUE_LENGTH_PARAM_NAME = "teamcity.internal.searchQL.autocompletion.value.lengthLimit"
    private val VALUE_LENGTH_DEFAULT = 200

    private val VALUE_CNT_PARAM_NAME = "teamcity.internal.searchQL.autocompletion.value.maxCnt"
    private val VALUE_CNT_DEFAULT = 30

    private val UPDATE_PARAMETER_INTERVAL_SECONDS: Long = 60

    var disableAll = false
    var disabledValues = false
    var disableIds = false

    var valueLengthLimit = VALUE_LENGTH_DEFAULT
    var valueCntLimit = VALUE_CNT_DEFAULT

    private val executor =
        Executors.newSingleThreadScheduledExecutor()
    private val lock = ReentrantReadWriteLock()


    private val map: MutableMap<String, SecuredStringFinder> = mutableMapOf()
    private lateinit var projectIdFinder: SimpleStringFinder
    private lateinit var projectParamFinder: ParameterValueFinder
    private lateinit var projectNameFinder: SimpleStringFinder

    private lateinit var buildConfIdFinder: SimpleStringFinder
    private lateinit var buildConfOptionFinder: ParameterValueFinder
    private lateinit var buildConfParamFinder: ParameterValueFinder
    private lateinit var buildConfNameFinder: SimpleStringFinder

    private lateinit var templateIdFinder: SimpleStringFinder
    private lateinit var templateOptionFinder: ParameterValueFinder
    private lateinit var templateParamFinder: ParameterValueFinder
    private lateinit var templateNameFinder: SimpleStringFinder

    private lateinit var vcsRootIdFinder: SimpleStringFinder
    private lateinit var vcsRootTypeFinder: SimpleStringFinder
    private lateinit var vcsParamFinder: ParameterValueFinder
    private lateinit var vcsRootNameFinder: SimpleStringFinder

    private lateinit var triggerParamValueFinder: ParameterValueFinder
    private lateinit var triggerTypeFinder: SimpleStringFinder

    private lateinit var stepParamValueFinder: ParameterValueFinder
    private lateinit var stepTypeFinder: SimpleStringFinder

    private lateinit var featureParamValueFinder: ParameterValueFinder
    private lateinit var featureTypeFinder: SimpleStringFinder

    private lateinit var snapshotOptionFinder: ParameterValueFinder

    private lateinit var artifactRulesFinder: SimpleStringFinder
    private lateinit var artifactRevRuleFinder: SimpleStringFinder

    init {
        serverDispatcher.addListener(this)

        updateParams()
        createNewIndexers()
        registerFinders()

        executor.scheduleAtFixedRate(
            {
                if (updateParams()) {
                    createNewIndexers()
                    registerFinders()
                    if (!disableAll) {
                        indexAll()
                    }
                }
            },
            UPDATE_PARAMETER_INTERVAL_SECONDS,
            UPDATE_PARAMETER_INTERVAL_SECONDS,
            TimeUnit.SECONDS
        )
    }

    private fun createNewIndexers() {
        lock.writeLock().lock()
            map.clear()
            projectIdFinder = getSimpleFinder(true, disableIds)
            projectParamFinder = getParamFinder(true, disableAll)
            projectNameFinder = getSimpleFinder(true, disableIds)

            buildConfIdFinder = getSimpleFinder(true, disableIds)
            buildConfOptionFinder = getParamFinder(false, disableAll)
            buildConfParamFinder = getParamFinder(true, disableAll)
            buildConfNameFinder = getSimpleFinder(true, disableIds)

            templateIdFinder = getSimpleFinder(true, disableIds)
            templateOptionFinder = getParamFinder(false, disableAll)
            templateParamFinder = getParamFinder(true, disableAll)
            templateNameFinder = getSimpleFinder(true, disableIds)

            vcsRootIdFinder = getSimpleFinder(true, disableIds)
            vcsRootTypeFinder = getSimpleFinder(false, disableAll)
            vcsParamFinder = getParamFinder(true, disableAll)
            vcsRootNameFinder = getSimpleFinder(true, disableIds)

            triggerParamValueFinder = getParamFinder(false, disableAll)
            triggerTypeFinder = getSimpleFinder(false, disableAll)

            stepParamValueFinder = getParamFinder(false, disableAll)
            stepTypeFinder = getSimpleFinder(false, disableAll)

            featureParamValueFinder = getParamFinder(false, disableAll)
            featureTypeFinder = getSimpleFinder(false, disableAll)

            snapshotOptionFinder = getParamFinder(false, disableAll)

            artifactRulesFinder = getSimpleFinder(false, disableAll)
            artifactRevRuleFinder = getSimpleFinder(false, disableAll)
        lock.writeLock().unlock()
    }

    private fun registerFinders() {
        fun registerFinder(sf: SecuredStringFinder, vararg nameContext: KClass<out Named>) {
            val vars = nameContext.map { it.getNames()!! }

            addToMapWithPrefix(sf, "", vars)
        }

        lock.writeLock().lock()
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
        lock.writeLock().unlock()
    }

    private fun updateParams(): Boolean {
        var isUpdated = false

        lock.writeLock().lock()
            val disable = TeamCityProperties.getProperty(DISABLE_AUTOCOMPLETION_NAME).split(",").map {it.trim()}
            disable.contains("all").let {
                if (it != disableAll) isUpdated = true
                disableAll = it
            }

            (disable.contains("value") || disableAll).let {
                if (it != disabledValues) isUpdated = true
                disabledValues = it
            }

            (disable.contains("id") || disableAll).let {
                if (it != disableIds) isUpdated = true
                disableIds = it
            }

            TeamCityProperties.getInteger(VALUE_LENGTH_PARAM_NAME, VALUE_LENGTH_DEFAULT).let {
                if (it != valueLengthLimit) isUpdated = true
                valueLengthLimit = it
            }

            TeamCityProperties.getInteger(VALUE_CNT_PARAM_NAME, VALUE_CNT_DEFAULT).let {
                if (it != valueCntLimit) isUpdated = true
                valueCntLimit = it
            }
        lock.writeLock().unlock()

        return isUpdated
    }

    val nodesTotal: Long
        get() = map.values.fold(0L) {acc, sf -> acc + sf.nodesTotal}

    val symbolsTotal: Long
        get() = map.values.fold(0L) {acc, sf -> acc + sf.symbolsTotal}


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
        lock.readLock().lock()
        val res = map[filterType]?.completeString(s, limit) ?: listOf()
        lock.readLock().unlock()
        return res
    }

    fun updateProject(project: SProject) {
        lock.readLock().lock()
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
        lock.readLock().unlock()
    }

    fun updateBuildType(bt: SBuildType) {
        lock.readLock().lock()
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
        lock.readLock().unlock()
    }

    fun updateTemplate(temp: BuildTypeTemplate) {
        lock.readLock().lock()
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
        lock.readLock().unlock()
    }

    fun updateVcsRoot(vcs: SVcsRoot) {
        lock.readLock().lock()
        vcsRootIdFinder.addString(vcs.externalId)
        vcsRootTypeFinder.addString(vcs.vcsName)
        vcsRootNameFinder.addString(vcs.name)

        vcs.properties.forEach {(name, value) ->
            vcsParamFinder.addParam(name, value)
        }
        lock.readLock().unlock()
    }

    fun getSimpleFinder(isSystemAdminOnly: Boolean, disabled: Boolean): SimpleStringFinder {
        return SimpleStringFinder(this, isSystemAdminOnly, disabled)
    }

    fun getParamFinder(
        isSystemAdminOnly: Boolean,
        disabled: Boolean,
        isValueSystemAdminOnly: Boolean = true
    ): ParameterValueFinder {
        return ParameterValueFinder(this,
            isSystemAdminOnly,
            isValueSystemAdminOnly,
            disabled,
            disabledValues,
            valueLengthLimit,
            valueCntLimit
        )
    }

    override fun serverShutdown() {
        ThreadUtil.shutdownGracefully(executor, "QueryLangCompletionManager")
    }

    override fun serverStartup() {}
}