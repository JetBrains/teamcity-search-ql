package jetbrains.buildServer.server.querylang.indexing

import java.util.*
import java.util.concurrent.locks.ReentrantReadWriteLock

class CompressedTrie<T> : AutocompletionIndexer<T> {

    var nodesTotal: Long = 0
    var symbolsTotal: Long = 0
    var stringsTotal: Long = 0

    inner class Node<T>(var str: String, var obj: T? = null, var isTerminal: Boolean = false) {
        init {
            nodesTotal += 1
            symbolsTotal += str.length
        }
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
    }

    private val root = Node<T>("")
    val lock = ReentrantReadWriteLock()

    override fun addString(str: String, obj: T?) {
        lock.writeLock().lock()

        var node = root
        var i = 0
        while (i < str.length) {
            val c = str[i]
            var nextNode = node.getNode(c)
            if (nextNode == null) {
                nextNode = Node(
                    str.substring(i)
                )
                node.addEdge(c, nextNode)
                i = str.length
                node = nextNode
                break
            }

            val prefix = findLargestPrefix(str, i, nextNode.str)

            if (nextNode.str.length <= str.length - i && prefix.length == nextNode.str.length) {
                i += prefix.length
                node = nextNode
            } else {
                val newNode1 =
                    Node<T>(prefix)

                node.addEdge(c, newNode1)
                nextNode.str = nextNode.str.drop(prefix.length)
                newNode1.addEdge(nextNode.str.first(), nextNode)
                i += prefix.length
                node = newNode1
            }
        }

        if (!node.isTerminal) {
            stringsTotal += 1
        }
        node.isTerminal = true
        node.obj = obj

        lock.writeLock().unlock()
    }

    override fun complete(str: String, limit: Int): List<String> {
        lock.readLock().lock()

        val (node, strRest) = goDown(str) ?: return emptyList()

        val firstNode = if (strRest.isEmpty()) node
                        else node.getNode(strRest.first())!!

        val prefix = if (strRest.isEmpty()) ""
                     else firstNode.str.drop(strRest.length)
        val res = getAllBfs(firstNode, limit).map {prefix + it}

        lock.readLock().unlock()

        return res.map {str + it}
    }

    override fun exists(str: String): Boolean {
        lock.readLock().lock()

        val (node, strRest) = goDown(str) ?: return false
        val res = node.isTerminal && strRest.isEmpty()

        lock.readLock().unlock()

        return res
    }

    fun clear() {
        root.nodes.clear()
    }

    private fun findLargestPrefix(str1: String, beg1: Int,  str2: String): String {
        var i1 = beg1
        var i2 = 0
        var res = ""
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                res += str1[i1]
            }
            else {
                break
            }
            i1 += 1
            i2 += 1
        }
        return res
    }

    private fun goDown(str: String): Pair<Node<T>, String>? {
        var node = root
        var i = 0
        while (i < str.length) {
            val c = str[i]
            if (!node.exists(c)) {
                return null
            }
            val nextNode = node.getNode(c)!!

            val prefix = findLargestPrefix(str, i, nextNode.str)
            if (prefix.length != nextNode.str.length) {
                if (prefix.length == str.length - i) {
                    break
                }
                return null
            }
            i += prefix.length
            node = nextNode
        }
        return Pair(node, str.substring(i))
    }

    private fun getAllBfs(startNode: Node<T>, limit: Int): List<String> {
        val queue = LinkedList<Triple<Node<T>, String, Int>>()
        queue.add(Triple(startNode, "", 0))
        val res = mutableListOf<String>()

        while (res.size < limit && !queue.isEmpty()) {
            val (node, str, prefixLength) = queue.poll()
            if (node.str.length == prefixLength) {
                node.nodes.forEach { _, nextNode ->
                    queue.add(Triple(nextNode, str + nextNode.str, 1))
                }
                if (node.isTerminal) {
                    res.add(str)
                }
            }
            else {
                queue.add(Triple(node, str, prefixLength + 1))
            }
        }
        return res
    }
}