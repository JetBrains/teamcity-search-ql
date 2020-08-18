package jetbrains.buildServer.server.querylang.ast.wrappers

interface MWithInheritedContainer {
    var includeInherited: Boolean
}

interface MResolvedContainer {
    var searchResolved: Boolean
}

interface MAllContainer<T> {
    var elementSelector: ElementValidator<T>
}