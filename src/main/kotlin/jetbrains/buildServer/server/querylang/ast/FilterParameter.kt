package jetbrains.buildServer.server.querylang.ast

interface FilterParameter

abstract class ParameterClasses(vararg classesList : Class<out Filter>) {
    val classes : List<Class<out Filter>> = classesList.toList()
}

data class AllTriggerParameter(private val placehoder: String = "") : FilterParameter {
    companion object : ParameterClasses(
        TriggerFilter::class.java
    )
}