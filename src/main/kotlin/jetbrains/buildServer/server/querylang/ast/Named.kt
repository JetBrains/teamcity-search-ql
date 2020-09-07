package jetbrains.buildServer.server.querylang.ast

import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

interface Named {
    val names: List<String>

    fun hasNames() = names.isEmpty()
}

class Descriptions(private vararg val descriptions: Description) {
    fun getDescription(context: List<String>): String? {
        for (descr in descriptions) {
            descr.getDescription(context)?.let {return it}
        }
        return null
    }

    fun add(other: Descriptions): Descriptions {
        return Descriptions(
            *((descriptions.toSet() + other.descriptions.toSet()).toTypedArray())
        )
    }
}

interface Description {
    fun getDescription(context: List<String>): String?
}

data class TemplateDescription(val description: String, val forbiddenWords: List<String> = emptyList()): Description {
    private val parts: MutableList<String> = mutableListOf()
    init {
        var lastPart = ""
        description.forEach {
            if (it != '_') {
                lastPart += it
            }
            else {
                parts.add(lastPart)
                lastPart = ""
            }
        }
        parts.add(lastPart)
    }

    override fun getDescription(context: List<String>): String? {
        if (context.last() in forbiddenWords) {
            return null
        }
        if (context.size + 1 < parts.size) {
            return null
        }
        val words = context.takeLast(parts.size - 1)

        var i = 0
        var res = ""
        while (i < words.size) {
            res += parts[i] + words[i]
            i += 1
        }
        res += parts.last()
        return res
    }
}

class SimpleDescription(val description: String, vararg val fixedContext: String): Description {
    override fun getDescription(context: List<String>): String? {
        if (context.takeLast(fixedContext.size) != fixedContext.toList()) {
            return null
        }
        return description
    }

    override fun equals(other: Any?): Boolean {
        if (other is SimpleDescription && description == other.description) return true
        return false
    }

    override fun hashCode(): Int {
        return description.hashCode()
    }
}

class FixedContextDescription(val description: String, vararg val fixedContext: Array<out String>): Description {
    override fun getDescription(context: List<String>): String? {
        if (context != fixedContext.toList()) {
            return null
        }
        return description
    }
}

class Names1(vararg _names: String) {
    val names: List<String> = _names.toList()
}

abstract class ObjectDescription(
    names_: Names1,
    val descriptions: Descriptions? = null
) {
    val names = names_.names
}

fun KClass<out Named>.getDescriptions(): Descriptions? {
    val companion = this.companionObjectInstance as? ObjectDescription

    return companion?.descriptions
}

fun KClass<out Named>.getName(): String? {
    val companion = this.companionObjectInstance as? ObjectDescription

    return companion?.names?.first()
}

fun KClass<out Named>.getNames(): List<String>? {
    val companion = this.companionObjectInstance as? ObjectDescription

    return companion?.names
}