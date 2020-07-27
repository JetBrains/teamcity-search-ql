package jetbrains.buildServer.server.querylang.ast

interface Named {
    val names: List<String>
}

open class Names(vararg namesVars: String) {
    val names: List<String> = namesVars.toList()
}