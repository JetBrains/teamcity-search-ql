package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.AutocompletionIndexer
import jetbrains.buildServer.server.querylang.indexing.CompressedTrie

class SimpleStringFinder(val trie: AutocompletionIndexer<Any> = CompressedTrie()) : StringFinder {
    override fun completeString(prefix: String, limit: Int): List<String> {
        val realPrefix = if (prefix.startsWith("\"")) prefix.drop(1) else prefix
        return trie.complete(realPrefix, limit).map {(prefix + it).escape()}
    }

    fun addString(s: String) {
        return trie.addString(s)
    }
}