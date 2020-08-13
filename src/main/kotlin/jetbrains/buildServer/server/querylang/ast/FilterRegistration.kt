package jetbrains.buildServer.server.querylang.ast

import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

object FilterRegistration {
    init {
        registerTerminalFilter(EqualsStringFilter::class)
        registerTerminalFilter(PrefixStringFilter::class)
        registerTerminalFilter(SuffixStringFilter::class)
        registerTerminalFilter(SubstringFilter::class)
        registerTerminalFilter(EnabledFilter::class)
        registerTerminalFilter(CleanFilter::class)

        registerConditionFilter(IdFilter::class)
        registerConditionFilter(BuildConfFilter::class)
        registerConditionFilter(VcsRootFilter::class)
        registerConditionFilter(ProjectFilter::class)
        registerConditionFilter(ParentFilter::class)
        registerConditionFilter(TriggerFilter::class)
        registerConditionFilter(StepFilter::class)
        registerConditionFilter(FeatureFilter::class)
        registerConditionFilter(TemplateFilter::class)
        registerConditionFilter(ParameterFilter::class)
        registerConditionFilter(AncestorFilter::class)
        registerConditionFilter(VcsRootEntryFilter::class)
        registerConditionFilter(RulesFilter::class)
        registerConditionFilter(DependencyFilter::class)
        registerConditionFilter(ArtifactFilter::class)
        registerConditionFilter(SnapshotFilter::class)
        registerConditionFilter(RevRuleFilter::class)
        registerConditionFilter(OptionFilter::class)
    }
    private val filterGraph: MutableMap< KClass<out Filter<*>> , MutableSet<KClass<out Filter<*>>> > = mutableMapOf()

    data class ConditionFilterTypes<Obj : Any, NestedObj : Any>(val filterClass: KClass<Obj>, val subFilterClass: KClass<NestedObj>)
    private val conditionFilters: MutableMap< KClass<out ConditionFilter<*, *>>, ConditionFilterTypes<*, *>> = mutableMapOf()

    private val terminalFilters: MutableMap< KClass<out Filter<*>>, KClass<*> > = mutableMapOf()

    private inline fun <reified Obj : Any,reified NestedObj : Any> registerConditionFilter(filter: KClass<out ConditionFilter<Obj, NestedObj>>) {
        conditionFilters[filter] = ConditionFilterTypes(Obj::class, NestedObj::class)

        conditionFilters.forEach {(filterClass, objTypes) ->
            if (Obj::class.isSuperclassOf(objTypes.subFilterClass)) {
                filterGraph.getOrPut(filterClass, { mutableSetOf()}).add(filter)
            }
            if (objTypes.filterClass.isSuperclassOf(NestedObj::class)) {
                filterGraph.getOrPut(filter, { mutableSetOf()}).add(filterClass)
            }
        }

        terminalFilters.forEach { (filterClass, objClass) ->
            if (objClass.isSuperclassOf(NestedObj::class)) {
                filterGraph.getOrPut(filter, { mutableSetOf() }).add(filterClass)
            }
        }
    }

    private inline fun <reified Obj> registerTerminalFilter(filter: KClass<out Filter<Obj>>) {
        terminalFilters[filter] = Obj::class

        conditionFilters.forEach {(filterClass, objTypes) ->
            if (Obj::class.isSuperclassOf(objTypes.subFilterClass)) {
                filterGraph.getOrPut(filterClass, { mutableSetOf()}).add(filter)
            }
        }
    }
}