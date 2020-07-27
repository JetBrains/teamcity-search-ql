package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.ProjectManager

class SimpleStringFinder(val trie: AutocompletionIndexer<Any> = CompressedTrie()) : StringFinder {
    override fun completeString(prefix: String, limit: Int): List<String> {
        return trie.complete(prefix, limit)
    }

    fun addString(s: String) {
        return trie.addString(s)
    }
}