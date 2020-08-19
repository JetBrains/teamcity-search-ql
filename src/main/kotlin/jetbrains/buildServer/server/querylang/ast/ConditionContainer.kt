package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.FIdContainer

interface ObjectContainer<T> : Iterable<T> {
    fun unite(other: ObjectContainer<T>): ObjectContainer<T> {
        return if (other.size < size) {
            this.addAll(other.getObjects())
            this
        } else {
            other.unite(this)
        }
    }
    fun intersect(other: ObjectContainer<T>): ObjectContainer<T>
    fun getObjects(): Set<T>
    fun addAll(objs: Collection<T>)
    val size: Int
    fun toSimple(): SimpleObjectContainer<T> = SimpleObjectContainer(getObjects())

}

class SimpleObjectContainer<T>(objs: Collection<T>) : ObjectContainer<T> {
    inner class SimpleContainerIterator(val iter: MutableIterator<T>): Iterator<T> by iter

    private val internalSet: MutableSet<T> = objs.toMutableSet()

    override fun intersect(other: ObjectContainer<T>): ObjectContainer<T> {
        return SimpleObjectContainer(this.internalSet.intersect(other.getObjects()))
    }

    override fun iterator(): Iterator<T> {
        return SimpleContainerIterator(internalSet.iterator())
    }

    override fun addAll(objs: Collection<T>) {
        internalSet.addAll(objs)
    }

    override val size: Int
        get() = internalSet.size

    override fun getObjects(): Set<T> = internalSet
}

fun <T> Collection<T>.wrapInContainer() = SimpleObjectContainer(this)

class EvalResult<NestedObject> {
    val filter: ObjectFilter<NestedObject>
    val objects: ObjectContainer<NestedObject>

    constructor(filter_: ObjectFilter<NestedObject>, objects_: Collection<NestedObject>) {
        filter = filter_
        objects = objects_.wrapInContainer()
    }

    constructor(filter_: ObjectFilter<NestedObject>, objects_ : ObjectContainer<NestedObject>) {
        filter = filter_
        objects = objects_
    }

    operator fun component1() = filter
    operator fun component2() = objects
}

interface ConditionContainer<NestedObject> : Named {
    val condition: ConditionAST<NestedObject>

    fun eval(): EvalResult<NestedObject> {
        if (Thread.currentThread().isInterrupted) {
            throw InterruptedException()
        }
        return evalInner()
    }

    fun evalInner(): EvalResult<NestedObject>

    fun evalFilterInner(filter: Filter<NestedObject>): EvalResult<NestedObject>?  {
        return if (filter is ObjectEvaluator) {
            filter.eval()
        } else {
            EvalResult(filter.build(), listOf())
        }
    }

    fun evalFilter(filter: Filter<NestedObject>): EvalResult<NestedObject> {
        return evalFilterInner(filter) ?: EvalResult(filter.build(), listOf())
    }

    fun ConditionAST<NestedObject>.eval(): EvalResult<NestedObject> {
        return when (this) {
            is OrConditionNode -> {
                val lres = this.left.eval()
                val rres = this.right.eval()

                EvalResult(
                    lres.filter.or(rres.filter),
                    lres.objects.union(rres.objects).toList()
                )
            }

            is AndConditionNode -> {
                val lres = this.left.eval()
                val rres = this.right.eval()

                val objects: MutableList<NestedObject> = lres.objects.intersect(rres.objects).toMutableList()
                if (lres.filter !is NoneObjectFilter) {
                    objects.addAll(rres.objects.filter {lres.filter.accepts(it)})
                }
                if (rres.filter !is NoneObjectFilter) {
                    objects.addAll(lres.objects.filter { rres.filter.accepts(it) })
                }

                EvalResult(
                    lres.filter.and(rres.filter),
                    objects.toSet().toList()
                )
            }

            is NotConditionNode -> {
                val res = this.cond.build()

                EvalResult(res.not(), emptyList())
            }

            is FilterConditionNode -> {
                evalFilter(this.filter)
            }

            is NoneConditionAST -> {
                EvalResult(RealObjectFilter {false}, emptyList())
            }
        }
    }

    fun evalCondition() = condition.eval()
}