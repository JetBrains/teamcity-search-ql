package jetbrains.buildServer.server.querylang.indexing

import java.util.*
import java.util.concurrent.atomic.AtomicLong

class SynchronizedCompressedTrie<T> : AutoSynchronizedIndexer<T>() {

    val nodesTotal = AtomicLong(0)
    val symbolsTotal= AtomicLong(0)
    val stringsTotal = AtomicLong(0)

    inner class Node<T>(var str: String, var obj: T? = null, var isTerminal: Boolean = false) {
        init {
            nodesTotal.incrementAndGet()
            symbolsTotal.addAndGet(str.length.toLong())
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

    override fun addStringUnsafe(str: String, obj: T?) {
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
            stringsTotal.incrementAndGet()
        }
        node.isTerminal = true
        node.obj = obj
    }

    override fun completeUnsafe(str: String, limit: Int): List<Pair<String, T?>> {
        val (node, strRest) = goDown(str) ?: return emptyList()

        val firstNode = if (strRest.isEmpty()) node
                        else node.getNode(strRest.first())!!

        val prefix = if (strRest.isEmpty()) ""
                     else firstNode.str.drop(strRest.length)
        return getAllBfs(firstNode, limit)
            .map {Pair(str + prefix + it.first, it.second)}
    }

    override fun existsUnsafe(str: String): Boolean {
        val (node, strRest) = goDown(str) ?: return false
        return node.isTerminal && strRest.isEmpty()
    }

    fun getAllStrings(): List<Pair<String, T?>> {
        lock.writeLock().lock()
        val res = getAllBfs(root, Int.MAX_VALUE)
        lock.writeLock().unlock()
        return res
    }

    override fun clearUnsafe() {
        root.nodes.clear()

        stringsTotal.set(0)
        nodesTotal.set(1)
        symbolsTotal.set(0)
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

    private fun getAllBfs(startNode: Node<T>, limit: Int): List<Pair<String, T?>> {
        val queue = LinkedList<Triple<Node<T>, String, Int>>()
        queue.add(Triple(startNode, "", 0))
        val res = mutableListOf<Pair<String, T?>>()

        while (res.size < limit && !queue.isEmpty()) {
            val (node, str, prefixLength) = queue.poll()
            if (node.str.length == prefixLength) {
                node.nodes.forEach { _, nextNode ->
                    queue.add(Triple(nextNode, str + nextNode.str, 1))
                }
                if (node.isTerminal) {
                    res.add(Pair(str, node.obj))
                }
            }
            else {
                queue.add(Triple(node, str, prefixLength + 1))
            }
        }
        return res
    }
}