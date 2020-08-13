package jetbrains.buildServer.server.querylang.ast

import kotlin.reflect.full.companionObjectInstance

interface FilterModifier : Named {
    fun apply(filter: Filter<*>) : Boolean {
        val comp = this::class.companionObjectInstance as? FilterClasses ?: return false

        return comp.classes.any {a ->
            a.invoke(filter)
        }
    }

    data class FilterToAction<T : Filter<*>>(val filterClass: Class<T>, val action: (filter : T) -> Unit) {
        fun invoke(filter: Filter<*>): Boolean {
            if (filterClass.isInstance(filter)) {
                action.invoke(filterClass.cast(filter))
                return true
            } else {
                return false
            }
        }
    }
}

abstract class FilterClasses( val names: List<String>, vararg classes_: FilterModifier.FilterToAction<out Filter<*>>) {
    val classes = classes_.toList()
}

fun<T: Filter<*>> Class<T>.connect(action: (filter : T) -> Unit) = FilterModifier.FilterToAction(this, action)