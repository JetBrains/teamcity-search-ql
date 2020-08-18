package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.AutocompletionIndexer
import jetbrains.buildServer.server.querylang.indexing.CompressedTrie

class SimpleStringFinder(
    override val compl: CompletionManager,
    override val systemAdminOnly: Boolean = true
) : SecuredStringFinder()
{
    val trie: AutocompletionIndexer<Any> = CompressedTrie()

    override fun completeStringUnsafe(prefix: String, limit: Int): List<String> {
        val realPrefix = if (prefix.startsWith("\"")) prefix.drop(1) else prefix
        return trie.complete(realPrefix, limit).map {it.escape()}
    }

    fun addString(s: String) {
        return trie.addString(s)
    }
}