package jetbrains.buildServer.server.querylang.ast

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


interface ObjectContainer<T> : Iterable<T> {
    fun unite(other: ObjectContainer<T>): ObjectContainer<T> {
        return if (other.size <= size) {
            this.addAll(other.getObjects())
            this
        } else {
            other.unite(this)
        }
    }

    fun intersect(other: ObjectContainer<T>): ObjectContainer<T>

    fun intersectAndDiff(other: ObjectContainer<T>): Triple<ObjectContainer<T>, ObjectContainer<T>, ObjectContainer<T>>

    fun contains(obj: T): Boolean

    fun remove(obj: T): Boolean

    fun getObjects(): Set<T>
    fun addAll(objs: Collection<T>)
    fun add(obj: T)
    val size: Int
    fun toSimple(): SimpleObjectContainer<T> = SimpleObjectContainer(getObjects())

}

class SimpleObjectContainer<T>(objs: Collection<T>) : ObjectContainer<T> {
    inner class SimpleContainerIterator(val iter: MutableIterator<T>): Iterator<T> by iter

    private val internalSet: MutableSet<T> = objs.toMutableSet()

    override fun intersect(other: ObjectContainer<T>): ObjectContainer<T> {
        return SimpleObjectContainer(this.internalSet.intersect(other.getObjects()))
    }

    override fun intersectAndDiff(other: ObjectContainer<T>): Triple<ObjectContainer<T>, ObjectContainer<T>, ObjectContainer<T>> {
        if (other.size < size) {
            val (a, b, c) = other.intersectAndDiff(this)
            return Triple(a, c, b)
        }

        val inter = SimpleObjectContainer<T>(emptyList())

        internalSet.forEach { elem -> if (other.remove(elem)) {this.remove(elem); inter.add(elem)} }
        return Triple(inter, this, other)
    }

    override fun contains(obj: T): Boolean {
        return internalSet.contains(obj)
    }

    override fun iterator(): Iterator<T> {
        return SimpleContainerIterator(internalSet.iterator())
    }

    override fun remove(obj: T): Boolean {
        return internalSet.remove(obj)
    }

    override fun add(obj: T) {
        internalSet.add(obj)
    }

    override fun addAll(objs: Collection<T>) {
        internalSet.addAll(objs)
    }

    override val size: Int
        get() = internalSet.size

    override fun getObjects(): Set<T> = internalSet
}

fun <T> Collection<T>.wrapInContainer() = SimpleObjectContainer(this)