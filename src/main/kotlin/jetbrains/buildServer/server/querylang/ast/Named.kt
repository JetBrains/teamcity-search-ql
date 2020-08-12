package jetbrains.buildServer.server.querylang.ast

interface Named {
    val names: List<String>

    fun hasNames() = names.isEmpty()
}

abstract class Names(vararg _names: String) {
    val names: List<String> = _names.toList()
}