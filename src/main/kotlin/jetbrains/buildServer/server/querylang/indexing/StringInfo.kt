package jetbrains.buildServer.server.querylang.indexing

data class StringInfo<T>(
    val str: String,
    val meta: T?
)