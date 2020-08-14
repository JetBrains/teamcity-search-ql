package jetbrains.buildServer.server.querylang.ast

import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

interface Named {
    val names: List<String>

    fun hasNames() = names.isEmpty()
}

abstract class Names(vararg _names: String) {
    val names: List<String> = _names.toList()
}

fun KClass<out Named>.getName(): String? {
    val companion = this.companionObjectInstance as? Names

    return companion?.names?.first()
}

fun KClass<out Named>.getNames(): List<String>? {
    val companion = this.companionObjectInstance as? Names

    return companion?.names
}