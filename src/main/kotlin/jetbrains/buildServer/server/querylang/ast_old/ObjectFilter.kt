package jetbrains.buildServer.server.querylang.ast_old

import java.lang.IllegalStateException

open class ObjectFilter<in T>(val condition: (obj: T) -> Boolean) {
    open fun accepts(obj: T?): Boolean = obj?.let {condition(it)} ?: false

    fun <L : Any> use(action: (L) -> Boolean): ObjectFilter<L> {
        if (this is NoneObjectFilter) {
            return NoneObjectFilter()
        } else {
            return ObjectFilter(action)
        }
    }

    fun <L: T> and(other: ObjectFilter<L>): ObjectFilter<L> {
        if (this is NoneObjectFilter || other is NoneObjectFilter) {
            return NoneObjectFilter()
        }

        return ObjectFilter { obj ->
            this.condition(obj) && other.condition(obj)
        }
    }

    fun <L: T>or(other: ObjectFilter<L>): ObjectFilter<L> {
        if (this is NoneObjectFilter) {
            return other
        }
        if (other is NoneObjectFilter) {
            return this
        }

        return ObjectFilter { obj ->
            this.condition(obj) || other.condition(obj)
        }
    }

    fun not(): ObjectFilter<T> {
        return ObjectFilter { obj ->
            !this.condition(obj)
        }
    }

}

class NoneObjectFilter<T> : ObjectFilter<T>({false}) {
    override fun accepts(obj: T?): Boolean {
        throw IllegalStateException("Can't call accepts method for NoneObjectFilter")
    }
}