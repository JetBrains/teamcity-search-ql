package jetbrains.buildServer.server.querylang.ast

import org.reflections.Reflections
import kotlin.reflect.full.companionObjectInstance

object FilterTypeRegistration {

    private val reflection = Reflections("jetbrains.buildServer.server.querylang.ast")
    private val conditionFilterList : MutableList< Connector<*> > = mutableListOf()

    private val keywords = getNames(reflection.getSubTypesOf(Named::class.java).toList())

    inline fun <reified T : Filter> connectFilterType(
        conditionContainerClass: Class<out ConditionContainer<T, *>>
    )
    {
        connectFilterTypeInner(conditionContainerClass, T::class.java)
    }

    fun <T : Filter> connectFilterTypeInner(
        conditionContainerClass: Class<out ConditionContainer<T, *>>,
        filterTypeClass: Class<T>)
    {
        conditionFilterList.add(Connector<T>(conditionContainerClass, filterTypeClass))
    }

    fun getConditionContainerFilterPairs() = conditionFilterList.toList()

    fun isKeyWord(str: String) = str in keywords

    private fun getNames(classes: List<Class<out Named>>): List<String> {
        val res = mutableListOf<String>()
        classes.forEach { clazz ->
            val names = clazz.kotlin.companionObjectInstance as? Names
            if (names != null) {
                res.addAll(names.names)
            }
        }
        return res
    }

    class Connector<T : Filter>(val conditionc: Class<out ConditionContainer<T, *>>,val filterc: Class<T>)
}