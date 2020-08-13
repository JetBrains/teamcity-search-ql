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

internal fun KClass<out Named>.getName(): String? {
    val companion = this.companionObjectInstance as? Names ?: return null

    return companion.names.first()
}

internal fun KClass<out Named>.getNames(): List<String> {
    val companion = this.companionObjectInstance as? Names ?: return emptyList()

    return companion.names
}