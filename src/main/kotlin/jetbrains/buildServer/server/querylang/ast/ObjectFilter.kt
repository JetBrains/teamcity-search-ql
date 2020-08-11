package jetbrains.buildServer.server.querylang.ast

open class ObjectFilter<T>(val condition: (obj: T) -> Boolean) {
    fun accepts(obj: T?): Boolean = obj?.let {condition(it)} ?: false

    fun and(other: ObjectFilter<T>): ObjectFilter<T> {
        if (this is NoneObjectFilter || other is NoneObjectFilter) {
            return NoneObjectFilter()
        }

        return ObjectFilter { obj ->
            this.condition(obj) && other.condition(obj)
        }
    }

    fun or(other: ObjectFilter<T>): ObjectFilter<T> {
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

class NoneObjectFilter<T> : ObjectFilter<T>({false})