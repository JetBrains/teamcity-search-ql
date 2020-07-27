package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.vcs.SVcsRoot
import kotlin.reflect.KFunction2

object FilterBuilder {

    fun makeProjectFilter(
            filter: ProjectFilter,
            context: Any? = null
    ): ObjectFilter<SProject> {
        fun hasSuitableAncestor(project: SProject?, filter: ObjectFilter<SProject>): Boolean {
            var curProject: SProject? = project
            while (curProject != null) {
                if (filter.accepts(curProject)) {
                    return true
                }
                curProject = curProject.parentProject
            }
            return false
        }
        return when (filter) {
            is IdFilter -> {
                ObjectFilter {project ->
                    project.externalId == filter.str
                }
            }
            is AncestorFilter -> {
                val conditionFilter = fromCondition<ProjectFilter, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter { project ->
                    hasSuitableAncestor(project.parentProject, conditionFilter)
                }
            }
            is AncestorOrSelfFilter -> {
                val conditionFilter = fromCondition<ProjectFilter, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {project ->
                    hasSuitableAncestor(project, conditionFilter)
                }
            }
            is ParentFilter -> {
                val conditionFilter = fromCondition<ProjectFilter, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {project ->
                    conditionFilter.accepts(project.parentProject)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow ProjectFilter")
        }
    }

    fun makeBCFilter(
            filter: BuildConfFilter,
            context: Any? = null
    ): ObjectFilter<SBuildType> {
        return when (filter) {
            is SProjectFilter -> {
                val projectFilter = makeProjectFilter(AncestorOrSelfFilter(filter.condition))
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is IdFilter -> {
                ObjectFilter {buildType ->
                    filter.str == buildType.externalId
                }
            }
            is TriggerFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilter, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildTriggersCollection.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilter, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildRunners.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilter, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildFeatures.any {feature ->
                        condition.accepts(feature)
                    }
                }
            }
            is ParentFilter -> {
                val projectFilter = fromCondition<ProjectFilter, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is TempDepFilter -> {
                val tempFilter = fromCondition<TempFilter, BuildTypeTemplate>(filter.condition, this::makeTempFilter)
                ObjectFilter {buildType ->
                    buildType.templates.any {tempFilter.accepts(it)}
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow BCFilter")
        }
    }

    fun makeTempFilter(
            filter: TempFilter,
            context: Any? = null
    ) : ObjectFilter<BuildTypeTemplate> {
        return when(filter) {
            is SProjectFilter -> {
                val projectFilter = makeProjectFilter(AncestorOrSelfFilter(filter.condition))
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is IdFilter -> {
                ObjectFilter {buildType ->
                    filter.str == buildType.externalId
                }
            }
            is TriggerFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilter, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildTriggersCollection.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilter, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildRunners.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilter, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildFeatures.any {feature ->
                        condition.accepts(feature)
                    }
                }
            }
            is ParentFilter -> {
                val projectFilter = fromCondition<ProjectFilter, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow TempFilter")
        }
    }

    fun makeParHolderFilter(
            filter: ParameterHolderFilter,
            context: Any?
    ): ObjectFilter<ParametersDescriptor> {
        return when (filter) {
            is TypeFilter -> {
                ObjectFilter {parHolder ->
                    parHolder.type == filter.str
                }
            }
            is ParameterFilter -> {
                ObjectFilter {parHolder ->
                    parHolder.parameters.containsKey(filter.option)
                            && parHolder.parameters[filter.option] == filter.value
                }
            }
            is ValueFilter -> {
                ObjectFilter {parHolder ->
                    parHolder.parameters.containsValue(filter.str)
                }
            }
            is EnabledFilter -> {
                val buildType = context as? BuildTypeSettings
                        ?: throw java.lang.IllegalStateException("Context for ParameterHolder should be SBuildType")
                ObjectFilter {parHolder ->
                    buildType.isEnabled(parHolder.id)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown ParHolderFilter")
        }
    }

    fun makeVcsFilter(
            filter: VcsRootFilter,
            context: Any? = null
    ): ObjectFilter<SVcsRoot> {
        return when(filter) {
            is IdFilter -> {
                ObjectFilter {vcs ->
                    vcs.externalId == filter.str
                }
            }
            is SProjectFilter -> {
                val projectFilter = makeProjectFilter(AncestorOrSelfFilter(filter.condition))
                ObjectFilter {vcs ->
                    projectFilter.accepts(vcs.project)
                }
            }
            is TypeFilter -> {
                ObjectFilter {vcs ->
                    vcs.vcsName == filter.str
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown VcsRootFilter")
        }
    }

    fun <T : Filter, S> fromCondition(
            condition: ConditionAST<T>,
            makeObjectFilter: KFunction2<T, Any?, ObjectFilter<S>>,
            context: Any? = null
    ): ObjectFilter<S> {
        return when (condition) {
            is OrConditionNode -> {
                val filter1 = fromCondition<T, S>(condition.left, makeObjectFilter, context)
                val filter2 = fromCondition<T, S>(condition.right, makeObjectFilter, context)
                ObjectFilter {obj ->
                    filter1.accepts(obj) || filter2.accepts(obj)
                }
            }
            is AndConditionNode -> {
                val filter1 = fromCondition<T, S>(condition.left, makeObjectFilter, context)
                val filter2 = fromCondition<T, S>(condition.right, makeObjectFilter, context)
                ObjectFilter {obj ->
                    filter1.accepts(obj) && filter2.accepts(obj)
                }
            }
            is NotConditionNode -> {
                val filter = fromCondition<T, S>(condition.cond, makeObjectFilter, context)
                ObjectFilter {obj ->
                    !filter.accepts(obj)
                }
            }
            is FilterConditionNode -> {
                makeObjectFilter.call(condition.filter, context)
            }
        }
    }
}