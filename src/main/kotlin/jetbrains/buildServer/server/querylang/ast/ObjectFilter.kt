package jetbrains.buildServer.server.querylang.ast

import java.lang.IllegalStateException

sealed class ObjectFilter<in Obj>(val action: (Obj) -> Boolean) {
    open fun accepts(obj: Obj?): Boolean = obj?.let(action) ?: false

    open fun <T: Obj>and(other: ObjectFilter<T>): ObjectFilter<T> {
        return if (this is NoneObjectFilter || other is NoneObjectFilter) {
            NoneObjectFilter()
        } else {
            RealObjectFilter {obj ->
                this.accepts(obj) && other.accepts(obj)
            }
        }
    }

    open fun <T: Obj>or(other: ObjectFilter<T>): ObjectFilter<T> {
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

    open fun <T: Obj> not(): ObjectFilter<T> {
        if (this is NoneObjectFilter) {
            throw IllegalStateException()
        }
        return RealObjectFilter {obj ->
            !this.accepts(obj)
        }
    }
}

class RealObjectFilter<in Object>(action: (Object) -> Boolean): ObjectFilter<Object>(action) {
    fun <T: Object> andR(other: RealObjectFilter<T>): RealObjectFilter<T> {
        return RealObjectFilter {obj ->
            this.accepts(obj) && other.accepts(obj)
        }
    }

    fun <T: Object> orR(other: RealObjectFilter<T>): RealObjectFilter<T> {
        return RealObjectFilter {obj ->
            this.accepts(obj) || other.accepts(obj)
        }
    }

    open fun <T: Object> notR(): RealObjectFilter<T> {
        return RealObjectFilter {obj ->
            !this.accepts(obj)
        }
    }
}

class NoneObjectFilter<Object> : ObjectFilter<Object>({false}) {
    override fun accepts(obj: Object?): Boolean {
        throw IllegalStateException()
    }
}