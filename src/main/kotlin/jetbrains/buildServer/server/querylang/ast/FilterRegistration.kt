package jetbrains.buildServer.server.querylang.ast

import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

object FilterRegistration {
    val anyConditionContainer = object : ConditionContainer<Any>() {
        override val condition: ConditionAST<Any>
            get() = NoneConditionAST()

        override val names: List<String>
            get() = listOf()

        override fun evalInner(): EvalResult<Any> {
            return EvalResult(NoneObjectFilter(), emptyList())
        }
    }

    private val filterGraph: MutableMap< KClass<out ConditionContainer<*>> , MutableSet<KClass<out Filter<*>>> > = mutableMapOf()
    private val revFilterGraph: MutableMap < KClass<out Filter<*>>, MutableSet<KClass<out ConditionContainer<*>>> > = mutableMapOf()

    private val conditionContainers: MutableMap< KClass<out ConditionContainer<*>>, KClass<*>> = mutableMapOf()

    private val filters: MutableMap< KClass<out Filter<*>>, KClass<*> > = mutableMapOf()

    init {
        registerConditionContainer(ProjectTopLevelQuery::class)
        registerConditionContainer(BuildConfTopLevelQuery::class)
        registerConditionContainer(TemplateTopLevelQuery::class)
        registerConditionContainer(VcsRootTopLevelQuery::class)

        registerFilter(EqualsStringFilter::class)
        registerFilter(PrefixStringFilter::class)
        registerFilter(SuffixStringFilter::class)
        registerFilter(SubstringFilter::class)
        registerFilter(EnabledFilter::class)
        registerFilter(CleanFilter::class)
        registerFilter(StringParamFilter::class)
        registerFilter(AnyStringFilter::class)

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
        registerConditionFilter(ValueFilter::class)
        registerConditionFilter(AncestorFilter::class)
        registerConditionFilter(VcsRootEntryFilter::class)
        registerConditionFilter(RulesFilter::class)
        registerConditionFilter(DependencyFilter::class)
        registerConditionFilter(ArtifactFilter::class)
        registerConditionFilter(SnapshotFilter::class)
        registerConditionFilter(RevRuleFilter::class)
        registerConditionFilter(OptionFilter::class)
        registerConditionFilter(TypeFilter::class)
        registerConditionFilter(NameFilter::class)
    }

    fun getFilterGraph() = filterGraph.toMap()

    fun getFilters() = filters.keys.toList()

    fun getConditionContainers() = conditionContainers.keys.toList()

    fun printaAllRelations() {
        filterGraph.forEach {(fc, fsubc) ->
            println("${fc.simpleName}(${fc.getName()})")
            println(fsubc.joinToString(separator = ", ") {"${it.simpleName}(${it.getName()})"})
            println()
        }
    }

    fun canBeSubfilter(filter: KClass<out ConditionContainer<*>>, subf: KClass<out Filter<*>>): Boolean {
        if (filter == anyConditionContainer::class) {
            return true
        }
        return filterGraph[filter]?.contains(subf) ?: false
    }

    fun getPossibleConditionContainers(filterClass: KClass<out Filter<*>>): Set<KClass<out ConditionContainer<*>>> {
        return revFilterGraph[filterClass]?.toSet() ?: emptySet()
    }

    private inline fun <reified Obj : Any,reified NestedObj : Any> registerConditionFilter(filter: KClass<out ConditionFilter<Obj, NestedObj>>) {
        registerFilter(filter)
        registerConditionContainer(filter)
    }

    private inline fun <reified Obj> registerFilter(filter: KClass<out Filter<Obj>>) {
        filters[filter] = Obj::class

        conditionContainers.forEach {(filterClass, objTypes) ->
            if (Obj::class.isSuperclassOf(objTypes)) {
                addEdge(filterClass, filter)
            }
        }
    }

    private inline fun <reified NestedObj> registerConditionContainer(conditionContainer: KClass<out ConditionContainer<NestedObj>>) {
        conditionContainers[conditionContainer] = NestedObj::class

        filters.forEach {(filterClass, objType) ->
            if (objType.isSuperclassOf(NestedObj::class)) {
                addEdge(conditionContainer, filterClass)
            }
        }
    }

    private fun addEdge(conditionContainer: KClass<out ConditionContainer<*>>, filter: KClass<out Filter<*>>) {
        filterGraph.getOrPut(conditionContainer, { mutableSetOf()}).add(filter)
        revFilterGraph.getOrPut(filter, { mutableSetOf()}).add(conditionContainer)
    }
}

fun <NestedObj> Filter<*>.checkAndCast(filter: KClass<out ConditionContainer<NestedObj>>): Filter<NestedObj>? {
    val res = this as? Filter<NestedObj>
    if (!FilterRegistration.canBeSubfilter(filter, this::class)) {
        return null
    }
    return res
}