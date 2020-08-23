package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.server.querylang.ast.ObjectFilter

interface ElementValidator<T> {
    val validator: (Iterable<T>, filter: ObjectFilter<T>) -> Boolean
        fun validate(elements: Iterable<T>, filter: ObjectFilter<T>): Boolean = validator(elements, filter)
}

open class CustomElementValidator<T>(
    override val validator: (Iterable<T>, filter: ObjectFilter<T>) -> Boolean
) : ElementValidator<T>

class AllElementValidator<T> : ElementValidator<T> {
    override val validator = {elems: Iterable<T>, filter: ObjectFilter<T> ->
        elems.iterator().hasNext() && elems.all { filter.accepts(it)}
    }
}

class AnyElementValidator<T> : ElementValidator<T> {
    override val validator = {elems: Iterable<T>, filter: ObjectFilter<T> ->
        elems.any { filter.accepts(it)}
    }
}

class AllElementsVisitor<T> : ElementValidator<T> {
    override val validator: (Iterable<T>, filter: ObjectFilter<T>) -> Boolean = {elems, filter ->
        elems.forEach { filter.accepts(it) }
        true
    }
}