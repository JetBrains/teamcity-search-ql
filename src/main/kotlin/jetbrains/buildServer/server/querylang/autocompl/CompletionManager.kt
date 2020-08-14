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
    val artifactRulesFinder = SimpleStringFinder()
    val artifactRevRuleFinder = SimpleStringFinder()
    val projectParamFinder = ParameterValueFinder()
    val vcsParamFinder = ParameterValueFinder()
    val templateOptionFinder = ParameterValueFinder()
    val buildConfOptionFinder = ParameterValueFinder()

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

        indexAll()
    }

    private fun registerFinder(sf: StringFinder, vararg nameContext: KClass<out Named>) {
        val vars = nameContext.map { it.getNames()!! }

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

        bt.ownOptions.forEach {opt ->
            buildConfOptionFinder.addParam(opt.key, bt.getOption(opt).toString())
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

        temp.artifactDependencies.forEach { art ->
            artifactRulesFinder.addString(art.sourcePaths)
            artifactRevRuleFinder.addString(art.revisionRule.name)
        }

        temp.options.forEach {opt ->
            templateOptionFinder.addParam(opt.key, temp.getOption(opt).toString())
        }
    }

    fun updateVcsRoot(vcs: SVcsRoot) {
        vcsRootIdFinder.addString(vcs.externalId)
        vcsRootTypeFinder.addString(vcs.vcsName)

        vcs.properties.forEach {(name, value) ->
            vcsParamFinder.addParam(name, value)
        }
    }
}