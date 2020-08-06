package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.vcs.SVcsRoot
import kotlin.reflect.KClass

class CompletionManager(val projectManager: ProjectManager) {
    val map: MutableMap<String, StringFinder> = mutableMapOf()
    val projectIdFinder = SimpleStringFinder()
    val buildConfIdFinder = SimpleStringFinder()
    val templateIdFinder = SimpleStringFinder()
    val vcsRootIdFinder = SimpleStringFinder()
    val triggerParamValueFinder = ParameterValueFinder()
    val stepParamValueFinder = ParameterValueFinder()
    val featureParamValueFinder = ParameterValueFinder()
    val triggerTypeFinder = SimpleStringFinder()
    val stepTypeFinder = SimpleStringFinder()
    val featureTypeFinder = SimpleStringFinder()
    val vcsRootTypeFinder = SimpleStringFinder()
    val snapshotOptionFinder = ParameterValueFinder()

    init {
        registerFinder(projectIdFinder, ProjectFilter::class, IdFilter::class)
        registerFinder(projectIdFinder, ParentFilter::class, IdFilter::class)
        registerFinder(projectIdFinder, AncestorFilter::class, IdFilter::class)
        registerFinder(triggerParamValueFinder, TriggerFilter::class, ParameterFilter::class)
        registerFinder(stepParamValueFinder, StepFilter::class, ParameterFilter::class)
        registerFinder(featureParamValueFinder, FeatureFilter::class, ParameterFilter::class)
        registerFinder(buildConfIdFinder, FindBuildConf::class, IdFilter::class)
        registerFinder(templateIdFinder, FindTemplate::class, IdFilter::class)
        registerFinder(vcsRootIdFinder, FindVcsRoot::class, IdFilter::class)
        registerFinder(triggerTypeFinder, TriggerFilter::class, TypeFilter::class)
        registerFinder(stepTypeFinder, StepFilter::class, TypeFilter::class)
        registerFinder(featureTypeFinder, FeatureFilter::class, TypeFilter::class)
        registerFinder(vcsRootTypeFinder, FindVcsRoot::class, TypeFilter::class)
        registerFinder(snapshotOptionFinder, SnapshotFilter::class, OptionFilter::class)

        indexAll()
    }

    private fun registerFinder(sf: StringFinder, vararg nameContext: KClass<out Named>) {
        val vars = nameContext.map { Named.getNames(it) }

        addToMapWithPrefix(sf, "", vars)
    }

    private fun addToMapWithPrefix(sf: StringFinder, prefix: String, vars: List<List<String>>) {
        if (vars.isEmpty()) {
            map[prefix] = sf
            return
        }

        vars.first().forEach { str ->
            val newprefix = if (prefix.isEmpty()) str else prefix + "_" + str

            addToMapWithPrefix(sf, newprefix, vars.drop(1))
        }
    }

    private fun indexAll() {
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
    }

    fun updateBuildType(bt: SBuildType) {
        buildConfIdFinder.addString(bt.externalId)
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
    }

    fun updateTemplate(temp: BuildTypeTemplate) {
        templateIdFinder.addString(temp.externalId)
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
    }

    fun updateVcsRoot(vcs: SVcsRoot) {
        vcsRootIdFinder.addString(vcs.externalId)
        vcsRootTypeFinder.addString(vcs.vcsName)
    }
}