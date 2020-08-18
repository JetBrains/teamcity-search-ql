package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver

class WParam(
    val name: String,
    val value: String
)

class WResolvableParam(
    val name: String,
    val value: String,
    val resolver: ValueResolver
) {
    fun resolve(): WParam {
        return WParam(name, resolver.resolve(value).result)
    }

    fun toParam(): WParam = WParam(name, value)

    fun toValue() = ResolvableString(value, resolver)
}

class ResolvableString(
    val str: String,
    val resolver: ValueResolver
) {
    fun resolve(): String {
        return resolver.resolve(str).result
    }
}