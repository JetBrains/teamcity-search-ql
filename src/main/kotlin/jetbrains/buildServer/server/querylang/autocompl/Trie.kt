package jetbrains.buildServer.server.querylang.autocompl

import java.util.*

class Trie<T> : AutocompletionIndexer<T> {
    class Node<T>(var obj: T? = null, var terminalCnt: Int = 0) {
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

    val root = Node<T>()

    override fun addString(str: String, obj: T?) {
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

    override fun exists(str: String): Boolean {
        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                return false
            }
            node = node.getNode(c)!!
        }
        return node.isTerminal()
    }

    override fun getCnt(str: String): Int {
        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                return 0
            }
            node = node.getNode(c)!!
        }
        return node.terminalCnt
    }

    override fun complete(str: String, limit: Int): List<String> {
        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                return listOf()
            }
            node = node.getNode(c)!!
        }
        return getStringFromSubtree(node, limit)
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