package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.server.querylang.myParameterManager
import jetbrains.buildServer.serverSide.Parameter
import jetbrains.buildServer.serverSide.parameters.types.ParameterTypeManager

class WParam(
    val name: String,
    value_: String
) {
    val value: String = if (name.startsWith("secure:", true)) {
        ""
    } else {
        value_
    }

    constructor(par: Parameter) : this(par.name,
        if (par.controlDescription != null &&
            myParameterManager.findParameterType(par)?.isSecureParameter(par.controlDescription!!) == true) {
            ""
        } else {
            par.value
        }
    )
}

class WResolvableParam(
    val name: String,
    value_: String,
    val resolver: ValueResolver
) {
    val value: String = if (name.startsWith("secure:", true)) {
        ""
    } else {
        value_
    }

    constructor(par: Parameter, resolver: ValueResolver) : this(
        par.name,
        if (par.controlDescription != null &&
            myParameterManager.findParameterType(par)?.isSecureParameter(par.controlDescription!!) == true) {
            ""
        } else {
            par.value
        },
        resolver
    )

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