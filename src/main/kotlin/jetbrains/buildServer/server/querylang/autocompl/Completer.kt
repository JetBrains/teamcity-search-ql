package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.ProjectManager
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.IllegalStateException
import java.util.*
import kotlin.streams.toList

class Completer(val projectManager: ProjectManager? = null) {
    private val graph = mutableMapOf<String, List<String>>()
    init {
        readFilterGraph()
    }

    fun suggest(objectTypes: List<String>?, trace: List<String>, word: String, limit: Int): List<String> {
        if (objectTypes == null) {
            return graph["root"]!!.filter {it.startsWith(word)}.map {it.drop(word.length)}
        }

        if (objectTypes.any {!graph.contains(it)}) throw IllegalStateException("Unkwnow type name")

        if (trace.isEmpty()) {
            if (objectTypes.isEmpty()) {
                throw IllegalStateException("objectTypes shouldn't be empty")
            }
            return objectTypes.fold(graph[objectTypes.first()]!!.toSet()) {acc, s ->
                acc.intersect(graph[s]!!)
            }.toList().filter {it.startsWith(word)}.map {it.drop(word.length)}
        }

        //some of the types doesn't contain first filter
        if (!objectTypes.all {graph[it]!!.contains(trace[0])}) {
            return listOf()
        }

        //unite all variants
        return objectTypes.flatMap { objType ->
            getVariants(objType, trace, word, limit)
        }.toSet().toList().take(limit).sortedWith(compareBy({ it.length }, {it}))
    }

    fun suggestBasedOnOther(otherFilters: List<String>, word: String): List<String> {
        val vars = graph.values.filter { value ->
            otherFilters.all {it in value}
        }.flatMap { it.filter {it.startsWith(word)} }.toSet().toList()

        return vars.map {it.drop(word.length)}
    }

    fun suggestForPartial(trace: List<String>, word: String): List<String> {
        if (trace.isEmpty()) {
            return listOf()
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
            return graph[node]!!.filter {it.startsWith(word)}.map {it.drop(word.length)}
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
            edges.forEach { if (!graph.contains(it)) graph[it] = listOf() }
            graph[name] = edges
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
            graph[node]?.filter { it.startsWith(word) }?.map { it.drop(word.length) }
                ?: throw IllegalStateException("Unknow filter name ${node}")
        }
    }
}