package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.indexing.StringInfo
import org.reflections.Reflections
import java.lang.IllegalStateException
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.isSubclassOf

class Completer(val completionManager: CompletionManager? = null) {
    data class CompletionVars(val variants: Set<String>) {
        fun first(): String = variants.first()
        fun contains(str: String) = variants.contains(str)
    }

    private fun List<CompletionVars>.toStringList() : List<String> = this.map {it.first()}
    private fun List<CompletionVars>.toFullStringList() : List<String> = this.flatMap {it.variants}

    private val graph = mutableMapOf<String, MutableList<CompletionVars>>()
    private val possibleModifiers = mutableMapOf<String, MutableSet<String>>()
    private val reflections = Reflections("jetbrains.buildServer.server.querylang.ast")

    init {
        loadFilterGraph()
        loadPossibleModifiers()
    }

    fun suggest(
        input: String,
        objectTypes: List<String>?,
        trace: List<String>,
        word: String,
        completeModifier: Boolean,
        limit: Int
    ): List<CompletionResult> {
        //complete object type name
        if (objectTypes == null) {
            return graph["root"]!!.map {it.first()}
                .filterBegins(word)
                .map {StringInfo(it, it.getShortDescription(listOf(emptyList())))}
                .autocomplSort()
                .toCompletionResult(input)
        }

        objectTypes.forEach {
            if (!graph.contains(it)) throw IllegalStateException("Unkwnow type name $it")
        }

        val fullTrace = objectTypes.map {
            listOf(it) + trace
        }

        //complete first level filter name (e.g `find project with par`)
        if (trace.isEmpty()) {
            if (objectTypes.isEmpty()) {
                throw IllegalStateException("objectTypes shouldn't be empty")
            }
            return objectTypes.map {
                graph[it]!!.map {it.first()}.toSet()
            }.reduce{acc, s ->
                acc.intersect(s)
            }.toList()
                .filterBegins(word)
                .autocomplSort()
                .toCompletionResult(input, true, fullTrace)
        }

        //some of the types doesn't contain first filter
        if (!objectTypes.all {graph[it]!!.any {it.contains(trace.first())}}) {
            return listOf()
        }

        //unite all variants
        return objectTypes.flatMap { objType ->
            getVariants(objType, trace, word, limit, completeModifier, fullTrace)
        }.toSet()
            .toList()
            .take(limit)
            .autocomplSort()
            .toCompletionResult(input)
    }

    fun suggestBasedOnOther(input: String, otherFilters: List<String>, word: String): List<CompletionResult> {
        val vars = graph.values.map{it.toStringList()}.filter { value ->
            otherFilters.all {it in value}
        }.flatMap { it.filterBegins(word) }.toSet().toList()

        return vars.toCompletionResult(input)
    }

    fun suggestForPartial(input: String, trace: List<String>, word: String): List<CompletionResult> {
        if (trace.isEmpty()) {
            return emptyList()
        }
        var node = trace[0]

        graph[node] ?: return emptyList()

        trace.drop(1).forEach { filterName ->
            if (filterName !in graph[node]!!.toFullStringList()) {
                return emptyList()
            }
            node = filterName
        }

        if (graph.contains(node)) {
            return graph[node]!!.toStringList().filterBegins(word).toCompletionResult(input)
        }
        return emptyList()
    }

    private fun getVariants(
        startNode: String,
        trace: List<String>,
        word: String,
        limit: Int,
        completeModifier: Boolean,
        fullTrace: List<List<String>>
    ): List<StringInfo<String>> {
        var node = startNode
        for (filterName in trace) {
            if (graph[node] == null) {
                throw IllegalStateException("Unknow filter name ${filterName}")
            }

            if (!graph[node]!!.toFullStringList().contains(filterName)) {
                return emptyList()
            } else {
                node = filterName
            }
        }

        if (completeModifier) {
            return possibleModifiers[node]
                ?.filterBegins(word)
                ?.map {
                    StringInfo(it, it.getShortDescription(fullTrace))
                }
                ?: throw IllegalStateException("Unknow filter name ${node}")
        }

        return if (graph[node]?.size == 0 && completionManager != null) {
            val last2Filters = if (trace.size > 1) "${trace[trace.lastIndex - 1]}_${trace.last()}"
                               else "${startNode}_${trace.last()}"
            val res = completionManager.completeString(
                word,
                last2Filters,
                limit
            )

            return res
        } else {
            graph[node]
                ?.toStringList()
                ?.filterBegins(word)
                ?.map {StringInfo(it, it.getShortDescription(fullTrace))}
                ?: throw IllegalStateException("Unknow filter name ${node}")
        }
    }

    private fun loadFilterGraph() {
        val topLevelClasses = reflections.getSubTypesOf(TopLevelQuery::class.java)

        graph["root"] = topLevelClasses.mapNotNull {
            it.kotlin.getNames()?.let {CompletionVars(it.toSet())}
        }.toMutableList()

        FilterRegistration.getFilters().forEach {filterClass ->
            filterClass.getNames()?.let {names ->
                names.forEach {graph[it] = mutableListOf<CompletionVars>()}
            }
        }

        FilterRegistration.getConditionContainers().forEach {ccontainer ->
            ccontainer.getNames()?.let {names ->
                names.forEach {graph[it] = mutableListOf()}
            }
        }

        val filterGraph = FilterRegistration.getFilterGraph()
        filterGraph.forEach {(container, filterSet) -> container.getNames()?.let {names ->
            names.forEach { name ->
                graph.getOrPut(name, { mutableListOf() })
                    .addAll(filterSet.mapNotNull { it.getNames()?.let{CompletionVars(it.toSet())} })
            }
        } }
    }

    private fun loadPossibleModifiers() {
        val modifiers = FilterRegistration.getModifiers()
        modifiers.forEach {modClass ->
            val companionObj = modClass.companionObjectInstance as? ObjectDescription
                ?: throw IllegalStateException("All modifiers should have companion object")

            val names = companionObj.names
            FilterRegistration.getPossibleFilters(modClass).forEach {filterClass ->
                getNames(filterClass).forEach {
                    if (!possibleModifiers.contains(it)) {
                        possibleModifiers[it] = mutableSetOf()
                    }
                    possibleModifiers[it]!!.addAll(names)
                }
            }
        }
    }

    private fun getNames(clazz: KClass<out Named>): List<String> {
        val names = clazz.companionObjectInstance as? ObjectDescription ?: throw IllegalStateException("There is no ObjectDescription companion object")
        return names.names
    }

    private fun List<StringInfo<String>>.toCompletionResult(
        input: String
    ): List<CompletionResult> {
        return this.map {
            CompletionResult(input + it.str, it.str, it.meta)
        }
    }

    @JvmName("toCompletionResultListString")
    private fun List<String>.toCompletionResult(
        input: String,
        searchForMeta: Boolean = false,
        context: List<List<String>> = listOf()
    ): List<CompletionResult> {
        return this.map {
            CompletionResult(
                input + it,
                it,
                if (searchForMeta) it.getShortDescription(context) else null
            )
        }
    }

    private fun Collection<String>.filterBegins(word: String): List<String> {
        return this.filter {it.startsWith(word)}
    }

    private fun List<StringInfo<String>>.autocomplSort(): List<StringInfo<String>> {
        return this.sortedWith(compareBy ({ it.str.length }, {it.str}))
    }

    @JvmName("autocomplSortString")
    private fun List<String>.autocomplSort(): List<String> {
        return this.sortedWith(compareBy ({ it.length }, {it}))
    }

    private fun String.dropw(word: String): String {
        return this.drop(word.length)
    }

    private fun String.fromInput() = if (this.startsWith("\"")) this.drop(1) else this

    private fun String.getShortDescription(context: List<List<String>>): String? {
        return context.mapNotNull {
            FilterRegistration.getShortDescription(this, it)
        }.toSet().joinToString(separator = " OR ")
    }
}