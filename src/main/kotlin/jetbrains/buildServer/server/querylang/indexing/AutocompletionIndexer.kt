package jetbrains.buildServer.server.querylang.indexing

interface AutocompletionIndexer<T> {
    fun addString(str: String, obj: T? = null)

    fun exists(str: String): Boolean

    fun complete(str: String, limit: Int): List<String>
}