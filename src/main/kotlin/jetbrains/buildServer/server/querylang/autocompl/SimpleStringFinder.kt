package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.AutocompletionIndexer
import jetbrains.buildServer.server.querylang.indexing.CompressedTrie

class SimpleStringFinder(
    override val compl: CompletionManager,
    override val systemAdminOnly: Boolean,
    override var disabled: Boolean
) : SecuredStringFinder()
{

    val trie = CompressedTrie<Any>()
    override val nodesTotal
        get() = trie.nodesTotal
    override val symbolsTotal
        get() = trie.symbolsTotal

    override fun completeStringUnsafe(prefix: String, limit: Int): List<String> {
        val realPrefix = if (prefix.startsWith("\"")) prefix.drop(1) else prefix
        return trie.complete(realPrefix, limit).map {it.escape()}
    }

    fun addString(s: String) {
        if (disabled) {
            return
        }
        if (s.contains("\n")) {
            return
        }
        return trie.addString(s)
    }

    fun clear() {
        trie.clear()
    }
}