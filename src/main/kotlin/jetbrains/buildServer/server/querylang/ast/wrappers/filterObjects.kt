package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.util.Option
import jetbrains.buildServer.util.OptionSupport
import kotlin.reflect.full.isSubclassOf

class DefaultOptions(val optSupport: OptionSupport) {
    private val possibleOptions: MutableSet<Option<*>> = mutableSetOf()

    init {
        optSupport.javaClass.fields.forEach { field ->
            val fieldClass = field.type.kotlin
            if (fieldClass.isSubclassOf(Option::class)) {
                val opt = field.get(optSupport) as Option<*>
                possibleOptions.add(opt)
            }
        }
    }

    fun getOptions(): List<Pair<String, String>> = possibleOptions.union(optSupport.options).map {
        Pair(it.key, optSupport.getOption(it).toString())
    }
}