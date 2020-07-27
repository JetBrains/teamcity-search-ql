package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.ProjectManager
import org.reflections.Reflections
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.IllegalStateException
import java.util.*
import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.isSubclassOf
import kotlin.streams.toList

class Completer(val projectManager: ProjectManager? = null) {
    private val graph = mutableMapOf<String, MutableList<String>>()
    private val reflections = Reflections("jetbrains.buildServer.server.querylang.ast")
    init {
        loadFilterGraph()
    }

    fun suggest(
        input: String,
        objectTypes: List<String>?,
        trace: List<String>,
        word: String,
        limit: Int
    ): List<CompletionResult> {


        //complete object type name
        if (objectTypes == null) {
            return graph["root"]!!
                .filterBegins(word)
                .autocomplSort()
                .toCompletionResult(input, word)
        }

        if (objectTypes.any {!graph.contains(it)}) throw IllegalStateException("Unkwnow type name")


        //complete first level filter name (e.g `find project with par`)
        if (trace.isEmpty()) {
            if (objectTypes.isEmpty()) {
                throw IllegalStateException("objectTypes shouldn't be empty")
            }
            return objectTypes.fold(graph[objectTypes.first()]!!.toSet()) {acc, s ->
                acc.intersect(graph[s]!!)
            }.toList().filterBegins(word).toCompletionResult(input, word)
        }

        //some of the types doesn't contain first filter
        if (!objectTypes.all {graph[it]!!.contains(trace[0])}) {
            return listOf()
        }

        //unite all variants
        return objectTypes.flatMap { objType ->
            getVariants(objType, trace, word, limit)
        }.toSet()
            .toList()
            .take(limit)
            .autocomplSort()
            .toCompletionResult(input, word, true)
    }

    fun suggestBasedOnOther(input: String, otherFilters: List<String>, word: String): List<CompletionResult> {
        val vars = graph.values.filter { value ->
            otherFilters.all {it in value}
        }.flatMap { it.filterBegins(word) }.toSet().toList()

        return vars.toCompletionResult(input, word)
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
            return graph[node]!!.filterBegins(word).toCompletionResult(input, word)
        }
        return emptyList()
    }

    private fun readFilterGraph() {
        val classLoader: ClassLoader = this.javaClass.classLoader
        val inputStream = BufferedReader(
            InputStreamReader(classLoader.getResourceAsStream("filters.txt"))
        )

        val lines = inputStream.lines().toList()
        val lineRegex = """\w+\s*->\s*\[(\s*\w+\s*,)*\s*\w+\s*]""".toRegex()

        lines.forEachIndexed { i, s ->
            if (!lineRegex.matches(s)) {
                throw InputMismatchException("Parsing error in line $i")
            }

            val names = """\w+""".toRegex().findAll(s)
            val name = names.first().value
            val edges = names.drop(1).toList().map {it.value}
            edges.forEach { if (!graph.contains(it)) graph[it] = mutableListOf() }
            graph[name] = edges.toMutableList()
        }
    }

    private fun getVariants(startNode: String, trace: List<String>, word: String, limit: Int): List<String> {
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
        return if (graph[node]?.size == 0 && projectManager != null) {
            val last2Filters = if (trace.size > 1) "${trace[trace.lastIndex - 1]}_${trace.last()}"
                               else "${startNode}_${trace.last()}"
            CompletionManager(projectManager)
                .completeString(
                    word,
                    last2Filters,
                    limit
                )
        } else {
            graph[node]?.filterBegins(word)?.map { it.drop(word.length) }
                ?: throw IllegalStateException("Unknow filter name ${node}")
        }
    }

    private fun List<String>.toCompletionResult(
        input: String,
        word: String,
        addOnly: Boolean = false
    ): List<CompletionResult> {
        return this.map {
            if (addOnly) CompletionResult(input + it, word + it)
            else CompletionResult(input + it.dropw(word), it)
        }
    }

    private fun loadFilterGraph() {
        val topLevelClasses = reflections.getSubTypesOf(TopLevelQuery::class.java)
        val filters = reflections.getSubTypesOf(Filter::class.java).filter {!it.isInterface}

        graph["root"] = topLevelClasses.flatMap {getNames(it)}.toMutableList()
        filters.forEach { filterClass ->
            getNames(filterClass).forEach {filterName ->
                graph[filterName] = mutableListOf()
            }
        }

        createEdges(ProjectComplexFilter::class.java, filters)
        createEdges(BuildConfComplexFilter::class.java, filters)
        createEdges(TemplateComplexFilter::class.java, filters)
        createEdges(VcsRootComplexFilter::class.java, filters)
    }

    private inline fun <reified T : Filter> createEdges(mainClass: Class<out ConditionContainer<T>>, filters: List<Class<out Filter>>) {
        val classes = reflections.getSubTypesOf(mainClass)
        classes.forEach { clazz ->
            val filterNames = getNames(clazz)
            filterNames.forEach { filterName ->
                if (!graph.contains(filterName)) {
                    graph[filterName] = mutableListOf()
                }
            }
            filters.filter { it.kotlin.isSubclassOf(T::class) }.forEach { filter ->
                val subFilterNames = getNames(filter)
                filterNames.forEach { filterName ->
                    graph[filterName]!!.addAll(subFilterNames)
                }
            }
        }
    }

    private fun getNames(clazz: Class<out Named>): List<String> {
        val names = clazz.kotlin.companionObjectInstance as? Names ?: throw IllegalStateException("There is not Names companion object")
        return names.names
    }

    private fun List<String>.filterBegins(word: String): List<String> {
        return this.filter {it.startsWith(word)}
    }

    private fun List<String>.autocomplSort(): List<String> {
        return this.sortedWith(compareBy({ it.length }, {it}))
    }

    private fun String.dropw(word: String): String {
        return this.drop(word.length)
    }
}