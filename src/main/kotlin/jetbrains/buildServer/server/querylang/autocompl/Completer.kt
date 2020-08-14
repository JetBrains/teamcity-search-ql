package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.ast.*
import org.reflections.Reflections
import java.lang.IllegalStateException
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.isSubclassOf

class Completer(val completionManager: CompletionManager? = null) {
    private val graph = mutableMapOf<String, MutableSet<String>>()
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
            return graph["root"]!!
                .filterBegins(word)
                .autocomplSort()
                .toCompletionResult(input)
        }

        if (objectTypes.any {!graph.contains(it)}) throw IllegalStateException("Unkwnow type name")


        //complete first level filter name (e.g `find project with par`)
        if (trace.isEmpty()) {
            if (objectTypes.isEmpty()) {
                throw IllegalStateException("objectTypes shouldn't be empty")
            }
            return objectTypes.fold(graph[objectTypes.first()]!!.toSet()) {acc, s ->
                acc.intersect(graph[s]!!)
            }.toList().filterBegins(word).toCompletionResult(input)
        }

        //some of the types doesn't contain first filter
        if (!objectTypes.all {graph[it]!!.contains(trace[0])}) {
            return listOf()
        }

        //unite all variants
        return objectTypes.flatMap { objType ->
            getVariants(objType, trace, word, limit, completeModifier)
        }.toSet()
            .toList()
            .take(limit)
            .autocomplSort()
            .toCompletionResult(input)
    }

    fun suggestBasedOnOther(input: String, otherFilters: List<String>, word: String): List<CompletionResult> {
        val vars = graph.values.filter { value ->
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
            if (filterName !in graph[node]!!) {
                return emptyList()
            }
            node = filterName
        }

        if (graph.contains(node)) {
            return graph[node]!!.filterBegins(word).toCompletionResult(input)
        }
        return emptyList()
    }

    private fun getVariants(
        startNode: String,
        trace: List<String>,
        word: String,
        limit: Int,
        completeModifier: Boolean
    ): List<String> {
        var node = startNode
        for (filterName in trace) {
            if (graph[node] == null) {
                throw IllegalStateException("Unknow filter name ${filterName}")
            }

            if (!graph[node]!!.contains(filterName)) {
                return emptyList()
            } else {
                node = filterName
            }
        }

        if (completeModifier) {
            return possibleModifiers[node]?.filterBegins(word) ?:
                throw IllegalStateException("Unknow filter name ${node}")
        }

        return if (graph[node]?.size == 0 && completionManager != null) {
            val last2Filters = if (trace.size > 1) "${trace[trace.lastIndex - 1]}_${trace.last()}"
                               else "${startNode}_${trace.last()}"
            completionManager.completeString(
                word,
                last2Filters,
                limit
            )
        } else {
            graph[node]?.filterBegins(word)
                ?: throw IllegalStateException("Unknow filter name ${node}")
        }
    }

    private fun loadFilterGraph() {
        val topLevelClasses = reflections.getSubTypesOf(TopLevelQuery::class.java)

        graph["root"] = topLevelClasses.mapNotNull {it.kotlin.getName()}.toMutableSet()

        FilterRegistration.getFilters().forEach { it.getName()?.let {graph[it] = mutableSetOf()} }

        FilterRegistration.getConditionContainers().forEach { it.getName()?.let {graph[it] = mutableSetOf()} }

        val filterGraph = FilterRegistration.getFilterGraph()
        filterGraph.forEach {(container, filterSet) -> container.getName()?.let {name ->
            graph.getOrPut(name, { mutableSetOf() }).addAll(filterSet.mapNotNull { it.getName() })
        } }
    }

    private fun loadPossibleModifiers() {
        val modifiers = reflections.getSubTypesOf(FilterModifier::class.java)

        modifiers.forEach {modClass ->
            val companionObj = modClass.kotlin.companionObjectInstance as? FilterClasses
                ?: throw IllegalStateException("All modifiers should have companion object")

            val names = companionObj.names
            companionObj.classes.map {it.filterClass}.forEach {filterClass ->
                getNames(filterClass).forEach {
                    if (!possibleModifiers.contains(it)) {
                        possibleModifiers[it] = mutableSetOf()
                    }
                    possibleModifiers[it]!!.addAll(names)
                }
            }
        }
    }

    private fun getNames(clazz: Class<out Named>): List<String> {
        val names = clazz.kotlin.companionObjectInstance as? Names ?: throw IllegalStateException("There is not Names companion object")
        return names.names
    }

    private fun List<String>.toCompletionResult(
        input: String
    ): List<CompletionResult> {
        return this.map {
            CompletionResult(input + it, it)
        }
    }

    private fun Collection<String>.filterBegins(word: String): List<String> {
        return this.filter {it.startsWith(word)}
    }

    private fun List<String>.autocomplSort(): List<String> {
        return this.sortedWith(compareBy({ it.length }, {it}))
    }

    private fun String.dropw(word: String): String {
        return this.drop(word.length)
    }

    private fun String.fromInput() = if (this.startsWith("\"")) this.drop(1) else this
}