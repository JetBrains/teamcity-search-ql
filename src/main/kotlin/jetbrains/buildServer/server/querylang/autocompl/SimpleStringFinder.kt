package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.ProjectManager

class SimpleStringFinder : StringFinder {
    private val trie: Trie<Any> = Trie<Any>()
    override fun completeString(prefix: String, limit: Int): List<String> {
        return trie.completeString(prefix, limit)
    }

    fun addString(s: String) {
        return trie.addString(s)
    }

    fun deleteString(s: String) {
        return trie.deleteString(s)
    }
}