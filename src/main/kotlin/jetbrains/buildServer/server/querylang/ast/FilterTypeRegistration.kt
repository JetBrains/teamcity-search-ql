package jetbrains.buildServer.server.querylang.ast

object FilterTypeRegistration {

    private val conditionFilterList : MutableList< Connector<*> > = mutableListOf()



    inline fun <reified T : Filter> connectFilterType(
        conditionContainerClass: Class<out ConditionContainer<T>>
    )
    {
        connectFilterTypeInner(conditionContainerClass, T::class.java)
    }

    fun <T : Filter> connectFilterTypeInner(
        conditionContainerClass: Class<out ConditionContainer<T>>,
        filterTypeClass: Class<T>)
    {
        conditionFilterList.add(Connector<T>(conditionContainerClass, filterTypeClass))
    }

    fun getConditionContainerFilterPairs() = conditionFilterList.toList()

    class Connector<T : Filter>(val conditionc: Class<out ConditionContainer<T>>,val filterc: Class<T>)
}