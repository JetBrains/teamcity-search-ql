package jetbrains.buildServer.server.querylang.ast

import java.lang.IllegalStateException

sealed class ObjectFilter<in Obj>(val action: (Obj) -> Boolean) {
    open fun accepts(obj: Obj?): Boolean = obj?.let(action) ?: false

    fun <T: Obj>and(other: ObjectFilter<T>): ObjectFilter<T> {
        return if (this is NoneObjectFilter || other is NoneObjectFilter) {
            NoneObjectFilter()
        } else {
            RealObjectFilter {obj ->
                this.accepts(obj) && other.accepts(obj)
            }
        }
    }

    fun <T: Obj>or(other: ObjectFilter<T>): ObjectFilter<T> {
        if (this is NoneObjectFilter) {
            return other
        }
        if (other is NoneObjectFilter) {
            return this
        }
        return RealObjectFilter {obj ->
            this.accepts(obj) || other.accepts(obj)
        }
    }

    fun <T: Obj> not(): ObjectFilter<T> {
        if (this is NoneObjectFilter) {
            throw IllegalStateException()
        }
        return RealObjectFilter {obj ->
            !this.accepts(obj)
        }
    }
}

class RealObjectFilter<Object>(action: (Object) -> Boolean): ObjectFilter<Object>(action)

class NoneObjectFilter<Object> : ObjectFilter<Object>({false}) {
    override fun accepts(obj: Object?): Boolean {
        throw IllegalStateException()
    }
}