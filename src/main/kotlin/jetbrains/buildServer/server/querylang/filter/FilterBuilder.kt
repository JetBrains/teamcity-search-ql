package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.vcs.VcsRootEntry
import jetbrains.buildServer.vcs.VcsRootInstanceEntry
import kotlin.reflect.KFunction2

object FilterBuilder {

    fun makeProjectFilter(
        filter: ProjectFilterType,
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
                val condition = fromCondition(filter.strCondition, this::makeStringFilter)
                ObjectFilter {project ->
                    condition.accepts(project.externalId)
                }
            }
            is AncestorFilter -> {
                val conditionFilter = fromCondition<ProjectFilterType, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter { project ->
                    hasSuitableAncestor(project.parentProject, conditionFilter)
                }
            }
            is AncestorOrSelfFilter -> {
                val conditionFilter = fromCondition<ProjectFilterType, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {project ->
                    hasSuitableAncestor(project, conditionFilter)
                }
            }
            is ParentFilter -> {
                val conditionFilter = fromCondition<ProjectFilterType, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {project ->
                    conditionFilter.accepts(project.parentProject)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow ProjectFilterType")
        }
    }

    fun makeBCFilter(
        filter: BuildConfFilterType,
        context: Any? = null
    ): ObjectFilter<SBuildType> {
        return when (filter) {
            is ProjectFilter -> {
                val projectFilter = makeProjectFilter(AncestorOrSelfFilter(filter.condition))
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is IdFilter -> {
                val condition = fromCondition(filter.strCondition, this::makeStringFilter)
                ObjectFilter {buildType ->
                    condition.accepts(buildType.externalId)
                }
            }
            is TriggerFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilterType, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildTriggersCollection.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilterType, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildRunners.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilterType, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildFeatures.any {feature ->
                        condition.accepts(feature)
                    }
                }
            }
            is ParentFilter -> {
                val projectFilter = fromCondition<ProjectFilterType, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is TempDepFilter -> {
                val tempFilter = fromCondition<TemplateFilterType, BuildTypeTemplate>(filter.condition, this::makeTempFilter)
                ObjectFilter {buildType ->
                    buildType.templates.any {tempFilter.accepts(it)}
                }
            }
            is VcsRootFilter -> {
                val vcsFilter = fromCondition(filter.condition, this::makeVcsRootEntryFilter)
                ObjectFilter {buildType ->
                    buildType.vcsRootInstanceEntries.any {vcsFilter.accepts(it.toMyVcsRootEntry())}
                }
            }

            else -> throw java.lang.IllegalStateException("Unknow BCFilter")
        }
    }

    fun makeTempFilter(
        filter: TemplateFilterType,
        context: Any? = null
    ) : ObjectFilter<BuildTypeTemplate> {
        return when(filter) {
            is ProjectFilter -> {
                val projectFilter = makeProjectFilter(AncestorOrSelfFilter(filter.condition))
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is IdFilter -> {
                val condition = fromCondition(filter.strCondition, this::makeStringFilter)
                ObjectFilter {buildType ->
                    condition.accepts(buildType.externalId)
                }
            }
            is TriggerFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilterType, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildTriggersCollection.any {trig ->
                        condition.accepts(trig)
                    }
                }
            }
            is StepFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilterType, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildRunners.any {step ->
                        condition.accepts(step)
                    }
                }
            }
            is FeatureFilter -> {
                ObjectFilter {buildType ->
                    val condition = fromCondition<ParameterHolderFilterType, ParametersDescriptor>(filter.condition, this::makeParHolderFilter, buildType)
                    buildType.buildFeatures.any {feature ->
                        condition.accepts(feature)
                    }
                }
            }
            is ParentFilter -> {
                val projectFilter = fromCondition<ProjectFilterType, SProject>(filter.condition, this::makeProjectFilter)
                ObjectFilter {buildType ->
                    projectFilter.accepts(buildType.project)
                }
            }
            is VcsRootFilter -> {
                val vcsFilter = fromCondition(filter.condition, this::makeVcsRootEntryFilter)
                ObjectFilter {buildType ->
                    buildType.vcsRootEntries.any {vcsFilter.accepts(it.toMyVcsRootEntry())}
                }
            }
            else -> throw java.lang.IllegalStateException("Unknow TemplateFilterType")
        }
    }

    fun makeParHolderFilter(
        filter: ParameterHolderFilterType,
        context: Any?
    ): ObjectFilter<ParametersDescriptor> {
        return when (filter) {
            is TypeFilter -> {
                ObjectFilter {parHolder ->
                    parHolder.type == filter.str
                }
            }
            is ParameterFilter -> {
                val conditionVal = fromCondition(filter.valueCondition, this::makeStringFilter)
                ObjectFilter {parHolder ->
                    parHolder.parameters.containsKey(filter.option)
                            && conditionVal.accepts(parHolder.parameters[filter.option])
                }
            }
            is ValueFilter -> {
                val conditionVal = fromCondition(filter.strCondition, this::makeStringFilter)
                ObjectFilter {parHolder ->
                    parHolder.parameters.values.any {conditionVal.accepts(it)}
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
        filter: VcsRootFilterType,
        context: Any? = null
    ): ObjectFilter<SVcsRoot> {
        return when(filter) {
            is IdFilter -> {
                val condition = fromCondition(filter.strCondition, this::makeStringFilter)
                ObjectFilter {vcs ->
                    condition.accepts(vcs.externalId)
                }
            }
            is ProjectFilter -> {
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
            else -> throw java.lang.IllegalStateException("Unknown VcsRootFilterType")
        }
    }

    fun makeVcsRootEntryFilter(
        filter: VcsRootEntryFilter,
        context: Any? = null
    ): ObjectFilter<MyVcsRootEntry> {
        return when(filter) {
            is VcsRootFilterType -> {
                val vcsFilter = makeVcsFilter(filter, context)
                ObjectFilter {entry ->
                    vcsFilter.accepts(entry.vcsRoot)
                }
            }
            is CheckoutRulesFilter -> {
                val stringFilter = fromCondition(filter.condition, this::makeStringFilter)
                ObjectFilter {entry ->
                    stringFilter.accepts(entry.checkoutRules)
                }
            }
            else -> throw IllegalStateException("Unknown VcsRootInstanceFilter")
        }
    }

    fun makeStringFilter(
        filter: StringFilter,
        context: Any? = null
    ): ObjectFilter<String> {
        return when(filter) {
            is EqualsStringFilter -> {
                ObjectFilter{str ->
                    str == filter.str
                }
            }
            is PrefixStringFilter -> {
                ObjectFilter {str ->
                    str.startsWith(filter.str)
                }
            }
            is SuffixStringFilter -> {
                ObjectFilter {str ->
                    str.endsWith(filter.str)
                }
            }
            is SubstringFilter -> {
                ObjectFilter {str ->
                    str.contains(filter.str)
                }
            }
            else -> throw IllegalStateException("Unknown StringFilter")
        }
    }

    fun <T : Filter, S> fromCondition(
            condition: ConditionAST<T>,
            makeObjectFilter: KFunction2<T, Any?, ObjectFilter<S>>,
            context: Any? = null
    ): ObjectFilter<S> {
        return when (condition) {
            is OrConditionNode -> {
                val filter1 = fromCondition(condition.left, makeObjectFilter, context)
                val filter2 = fromCondition(condition.right, makeObjectFilter, context)
                ObjectFilter {obj ->
                    filter1.accepts(obj) || filter2.accepts(obj)
                }
            }
            is AndConditionNode -> {
                val filter1 = fromCondition(condition.left, makeObjectFilter, context)
                val filter2 = fromCondition(condition.right, makeObjectFilter, context)
                ObjectFilter {obj ->
                    filter1.accepts(obj) && filter2.accepts(obj)
                }
            }
            is NotConditionNode -> {
                val filter = fromCondition(condition.cond, makeObjectFilter, context)
                ObjectFilter {obj ->
                    !filter.accepts(obj)
                }
            }
            is FilterConditionNode -> {
                println(condition.filter is StringFilter)
                makeObjectFilter.call(condition.filter, context)
            }
        }
    }

    data class MyVcsRootEntry(val vcsRoot: SVcsRoot, val checkoutRules: String)

    fun VcsRootEntry.toMyVcsRootEntry() = MyVcsRootEntry(
        this.vcsRoot as? SVcsRoot ?: throw IllegalStateException("Can't cast VcsRoot to SVcsRoot"),
        this.checkoutRules.asString
    )

    fun VcsRootInstanceEntry.toMyVcsRootEntry() = MyVcsRootEntry(
        this.vcsRoot.parent, this.checkoutRules.asString
    )
}