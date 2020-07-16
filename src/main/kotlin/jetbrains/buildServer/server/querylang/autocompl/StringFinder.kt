package jetbrains.buildServer.server.querylang.autocompl

interface StringFinder {
    fun completeString(prefix: String, limit: Int): List<String>
}