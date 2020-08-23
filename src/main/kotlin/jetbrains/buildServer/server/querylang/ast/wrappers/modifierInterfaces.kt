package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.server.querylang.ast.ConditionContainer

interface MWithInheritedContainer {
    var includeInherited: Boolean
}

interface MResolvedContainer {
    var searchResolved: Boolean
}

interface MAllContainer {
    var searchAll: ElementValidator<*>

    fun <T> ConditionContainer<T>.elementSelector(): ElementValidator<T> {
        return searchAll as ElementValidator<T>
    }
}