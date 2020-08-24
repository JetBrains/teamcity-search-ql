package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.CompressedTrie

class StringStorage {
    private val trie = CompressedTrie<Any>()

    fun addString(str: String) {
        if (str.contains("\n")) {
            return
        }
        trie.addString(str)
    }

    fun getAllStrings(): List<String> {
        return trie.getAllStrings()
    }
}