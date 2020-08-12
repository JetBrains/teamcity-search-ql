package jetbrains.buildServer.server.querylang.ast_old

import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

interface Named {
    val names: List<String>

    companion object {
        fun getNames(cl: KClass<out Named>): List<String> {
            val namesC = cl.companionObjectInstance as? Names
            return namesC?.names ?: emptyList()
        }
    }
}

open class Names(vararg namesVars: String) {
    val names: List<String> = namesVars.toList()
}