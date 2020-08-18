package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.server.querylang.ast.ConditionContainer

interface MWithInheritedContainer {
    var includeInherited: Boolean
}

interface MResolvedContainer {
    var searchResolved: Boolean
}

interface MAllContainer {
    var searchAll: Boolean
    fun <T> ConditionContainer<T>.elementSelector(): ElementValidator<T> {
        return if (searchAll) {
            AllElementValidator()
        } else {
            AnyElementValidator()
        }
    }
}