package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.ProjectManager

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
    init {
        map["project_id"] = projectIdFinder
        map["parent_id"] = projectIdFinder
        map["ancestor_id"] = projectIdFinder
        map["ancestor_id"] = projectIdFinder
        map["ancestorOrSelf_id"] = projectIdFinder
        map["trigger_param"] = triggerParamValueFinder
        map["step_param"] = stepParamValueFinder
        map["feature_param"] = featureParamValueFinder
        map["buildConf_id"] = buildConfIdFinder
        map["template_id"] = templateIdFinder
        map["vcsRoot_id"] = vcsRootIdFinder
        map["trigger_type"] = triggerTypeFinder
        map["step_type"] = stepTypeFinder
        map["feature_type"] = featureTypeFinder

        indexAll()
    }

    fun completeString(s: String, filterType: String, limit: Int): List<String> {
        return map[filterType]?.completeString(s, limit) ?: listOf()
    }

    fun indexAll() {
        projectManager.projects.forEach {project ->
            projectIdFinder.addString(project.externalId)
            project.buildTypes.forEach { bt ->
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

            project.buildTypeTemplates.forEach { temp ->
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
        }

        projectManager.allVcsRoots.forEach { vcs ->
            vcsRootIdFinder.addString(vcs.externalId)
        }
    }
}