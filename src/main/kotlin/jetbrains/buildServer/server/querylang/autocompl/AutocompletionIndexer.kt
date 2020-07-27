package jetbrains.buildServer.server.querylang.autocompl

interface AutocompletionIndexer<T> {
    fun addString(str: String, obj: T? = null)

    fun getCnt(str: String): Int

    fun exists(str: String): Boolean

    fun complete(str: String, limit: Int): List<String>
}