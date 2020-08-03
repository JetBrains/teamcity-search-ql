package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.vcs.SVcsRoot

class CompletionManager(val projectManager: ProjectManager) {
    val map: MutableMap<String, StringFinder> = mutableMapOf()
    val projectIdFinder = SimpleStringFinder()
    val buildConfIdFinder = SimpleStringFinder()
    val templateIdFinder = SimpleStringFinder()
    val buildConfOrTempIdFinder = CombinedStringFinder(buildConfIdFinder, templateIdFinder)
    val vcsRootIdFinder = SimpleStringFinder()
    val triggerParamValueFinder = ParameterValueFinder()
    val stepParamValueFinder = ParameterValueFinder()
    val featureParamValueFinder = ParameterValueFinder()
    val triggerTypeFinder = SimpleStringFinder()
    val stepTypeFinder = SimpleStringFinder()
    val featureTypeFinder = SimpleStringFinder()
    val vcsRootTypeFinder = SimpleStringFinder()
    init {
        map["project_id"] = projectIdFinder
        map["parent_id"] = projectIdFinder
        map["ancestor_id"] = projectIdFinder
        map["ancestor_id"] = projectIdFinder
        map["ancestorOrSelf_id"] = projectIdFinder
        map["trigger_param"] = triggerParamValueFinder
        map["step_param"] = stepParamValueFinder
        map["feature_param"] = featureParamValueFinder
        map["buildConfiguration_id"] = buildConfIdFinder
        map["template_id"] = templateIdFinder
        map["vcsRoot_id"] = vcsRootIdFinder
        map["trigger_type"] = triggerTypeFinder
        map["step_type"] = stepTypeFinder
        map["feature_type"] = featureTypeFinder
        map["buildConfOrTemp_id"] = buildConfOrTempIdFinder
        map["vcsRoot_type"] = vcsRootTypeFinder

        indexAll()
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
    }

    fun updateVcsRoot(vcs: SVcsRoot) {
        vcsRootIdFinder.addString(vcs.externalId)
        vcsRootTypeFinder.addString(vcs.vcsName)
    }
}