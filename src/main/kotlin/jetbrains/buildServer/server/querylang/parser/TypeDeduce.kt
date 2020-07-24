package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import org.reflections.Reflections
import kotlin.reflect.KClass
import kotlin.reflect.full.*

class TypeDeduce {
    val reflections = Reflections("jetbrains.buildServer.server.querylang.ast")

    fun deduceQueryType(condition: ConditionAST<Filter>, level: Int): List<TopLevelQuery> {
        val filters = getAllFilters(condition)

        val res = mutableListOf<TopLevelQuery>()


        res.addAll(getMainQueries(filters, condition, level, ProjectComplexFilter::class))
        res.addAll(getMainQueries(filters, condition, level, BuildConfComplexFilter::class))
        res.addAll(getMainQueries(filters, condition, level, TemplateComplexFilter::class))
        res.addAll(getMainQueries(filters, condition, level, VcsRootComplexFilter::class))
        res.addAll(getMainQueries(filters, condition, level, ParHolderComplexFilter::class))
        return res
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

    private inline fun <reified T : Filter> getMainQueries(
        filters: List<Filter>,
        condition: ConditionAST<Filter>,
        level: Int,
        kclass: KClass<out ConditionContainer<T>>
    ): List<TopLevelQuery> {
        val res = mutableListOf<TopLevelQuery>()
        if (filters.all {it is T}) {
            val filterClasses = getSubclasses(kclass.java)
            filterClasses.forEach { clazz ->
                when {
                    clazz.kotlin.isSubclassOf(TopLevelQuery::class) ->
                        createInstance<TopLevelQuery>(clazz, condition)?.let { res.add(it) }

                    clazz.kotlin.isSubclassOf(Filter::class) && level != 0 ->
                        createInstance<Filter>(clazz, condition)?.let {
                            res.addAll(deduceQueryType(FilterConditionNode(it), level - 1))
                        }
                }
            }
        }
        return res
    }

}