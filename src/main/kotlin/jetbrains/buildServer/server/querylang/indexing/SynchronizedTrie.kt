package jetbrains.buildServer.server.querylang.indexing

import java.util.*

class SynchronizedTrie<T> : AutoSynchronizedIndexer<T>() {
    private class Node<T>(var obj: T? = null, var terminalCnt: Int = 0) {
        val nodes: MutableMap<Char, Node<T>> = mutableMapOf()
        fun getNode(c: Char): Node<T>? {
            return nodes[c]
        }
        fun exists(c: Char): Boolean {
            return nodes.contains(c)
        }
        fun addEdge(c: Char, n: Node<T>) {
            nodes[c] = n
        }
        fun isTerminal(): Boolean {
            return terminalCnt > 0
        }
    }

    private val root = Node<T>()

    override fun addStringUnsafe(str: String, obj: T?) {
        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                val newNode = Node<T>()
                node.addEdge(c, newNode)
            }
            node = node.getNode(c)!!
        }
        node.terminalCnt += 1
        node.obj = obj
    }

    override fun existsUnsafe(str: String): Boolean {
        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                return false
            }
            node = node.getNode(c)!!
        }

        val res = node.isTerminal()

        return res
    }

    override fun completeUnsafe(str: String, limit: Int): List<String> {
        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                return listOf()
            }
            node = node.getNode(c)!!
        }

        val res = getStringFromSubtree(node, limit).map {str + it}

        return res
    }

    override fun clearUnsafe() {
        root.nodes.clear()
    }

    private fun getStringFromSubtree(fnode: Node<T>, limit: Int): List<String> {
        val queue: Queue<Pair<Node<T>, String>> = LinkedList()
        val res = mutableListOf<String>()
        queue.add(Pair(fnode, ""))
        while (!queue.isEmpty()) {
            val front = queue.poll()
            if (front.first.isTerminal()) {
                res.add(front.second)
                if (res.size >= limit) {
                    break
                }
            }
            front.first.nodes.forEach() {s, node ->
                queue.add(Pair(node, front.second + s))
            }
        }
        return res
    }
}