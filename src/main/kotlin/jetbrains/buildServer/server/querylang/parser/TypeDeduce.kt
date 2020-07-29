package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import org.reflections.Reflections
import kotlin.reflect.KClass
import kotlin.reflect.full.*

class TypeDeduce {
    val reflections = Reflections("jetbrains.buildServer.server.querylang.ast")

    fun deduceQueryType(condition: ConditionAST<Filter>, level: Int): List<FindMultipleTypes> {

        return getMainQueries(condition, level)
    }

    private fun getAllFilters(condition: ConditionAST<Filter>): List<Filter> {
        return when (condition) {
            is AndConditionNode -> getAllFilters(condition.left) + getAllFilters(condition.right)
            is OrConditionNode  -> getAllFilters(condition.left) + getAllFilters(condition.right)
            is NotConditionNode -> getAllFilters(condition.cond)
            is FilterConditionNode -> listOf(condition.filter)
        }
    }

    private fun <T> getSubclasses(clazz: Class<T>): List<Class<out T>> {
        return reflections.getSubTypesOf(clazz).toList()
    }

    private inline fun <reified T> createInstance(clazz: Class<out ConditionContainer<*>>, condition: ConditionAST<Filter>): T? {
        return try {
            clazz.kotlin.primaryConstructor!!.call(condition) as? T
        } catch (e: Exception) {
            null
        }
    }

    private fun getMainQueries(
        condition: ConditionAST<Filter>,
        level: Int
    ): List<FindMultipleTypes> {
        val filters = getAllFilters(condition)

        val res = mutableListOf<FindMultipleTypes>()
        val new = mutableListOf<TopLevelQuery<*>>()

        fun rec(conditionClass: KClass<out ConditionContainer<out Filter>>, filterClass: KClass<out Filter>) {

            if (filters.all { filterClass.isInstance(it) }) {
                val filterClasses = getSubclasses(conditionClass.java)
                filterClasses.forEach { clazz ->
                    when {
                        clazz.kotlin.isSubclassOf(TopLevelQuery::class) ->
                            createInstance<TopLevelQuery<*>>(clazz, condition)?.let { new.add(it) }

                        clazz.kotlin.isSubclassOf(Filter::class) && level != 0 ->
                            createInstance<Filter>(clazz, condition)?.let {
                                res.addAll(deduceQueryType(FilterConditionNode(it), level - 1))
                            }
                    }
                }
            }
        }

        FilterTypeRegistration.getConditionContainerFilterPairs().forEach { r ->
            rec(r.conditionc.kotlin, r.filterc.kotlin)
        }

        if (new.isNotEmpty()) {
            res.add(FindMultipleTypes(new))
        }
        return res
    }

}