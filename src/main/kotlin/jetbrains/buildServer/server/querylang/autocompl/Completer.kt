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

    fun suggest(trace: List<String>, word: String, limit: Int): List<String> {
        var node = "root"
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
        if (graph[node]?.size == 0 && projectManager != null && trace.size > 1) {
            return CompletionManager(projectManager)
                    .completeString(
                            word,
                            "${trace[trace.lastIndex - 1]}_${trace.last()}",
                            limit
                    )
        }
        return graph[node]?.filter {it.startsWith(word)}?.map {it.drop(word.length)}
            ?: throw IllegalStateException("Unknow filter name ${node}")
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
}