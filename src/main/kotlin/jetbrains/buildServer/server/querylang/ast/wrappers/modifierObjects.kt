package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.server.querylang.ast.ObjectFilter

sealed class ElementValidator<T> {
    abstract fun validate(elements: Collection<T>, filter: ObjectFilter<T>): Boolean
}

class AllElementValidator<T> : ElementValidator<T>() {
    override fun validate(elements: Collection<T>, filter: ObjectFilter<T>) = elements.all { filter.accepts(it)}
}

class AnyElementValidator<T> : ElementValidator<T>() {
    override fun validate(elements: Collection<T>, filter: ObjectFilter<T>) = elements.any { filter.accepts(it) }
}