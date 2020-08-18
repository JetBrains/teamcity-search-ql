package jetbrains.buildServer.server.querylang.indexing

import java.util.*
import java.util.concurrent.locks.ReentrantReadWriteLock

class Trie<T> : AutocompletionIndexer<T> {
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
    private val lock = ReentrantReadWriteLock()

    override fun addString(str: String, obj: T?) {
        lock.writeLock().lock()

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

        lock.writeLock().unlock()
    }

    override fun exists(str: String): Boolean {
        lock.readLock().lock()

        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                return false
            }
            node = node.getNode(c)!!
        }

        val res = node.isTerminal()
        lock.readLock().unlock()

        return res
    }

    override fun complete(str: String, limit: Int): List<String> {
        lock.readLock().lock()
        var node = root
        str.forEach { c ->
            if (!node.exists(c)) {
                return listOf()
            }
            node = node.getNode(c)!!
        }

        val res = getStringFromSubtree(node, limit).map {str + it}
        lock.readLock().unlock()

        return res
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