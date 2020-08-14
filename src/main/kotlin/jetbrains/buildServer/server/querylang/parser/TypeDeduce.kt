package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import kotlin.reflect.KClass
import kotlin.reflect.full.*

class TypeDeduce {
    fun deduceQueryType(condition: ConditionAST<*>, level: Int): List<FullQuery> {

        return getMainQueries(condition, level)
    }

    private fun getAllFilters(condition: ConditionAST<*>): List<Filter<*>> {
        return when (condition) {
            is AndConditionNode -> getAllFilters(condition.left) + getAllFilters(condition.right)
            is OrConditionNode  -> getAllFilters(condition.left) + getAllFilters(condition.right)
            is NotConditionNode -> getAllFilters(condition.cond)
            is FilterConditionNode -> listOf(condition.filter)
            is NoneConditionAST -> listOf()
        }
    }

    private inline fun <reified T> createInstance(clazz: KClass<out ConditionContainer<*>>, condition: ConditionAST<*>): T? {
        return try {
            clazz.primaryConstructor!!.call(condition) as? T
        } catch (e: Exception) {
            null
        }
    }

    private fun getMainQueries(
        condition: ConditionAST<*>,
        level: Int
    ): List<FullQuery> {
        val filters = getAllFilters(condition)

        val res = mutableListOf<FullQuery>()
        val new = mutableListOf<TopLevelQuery<*>>()

        val possibleConditionContainers = filters
            .map { FilterRegistration.getPossibleConditionContainers(it::class) }
            .reduce {acc, elem -> acc.intersect(elem)}

        possibleConditionContainers.forEach { clazz ->
            when {
                clazz.isSubclassOf(TopLevelQuery::class) ->
                    createInstance<TopLevelQuery<*>>(clazz, condition)?.let { new.add(it) }

                clazz.isSubclassOf(Filter::class) && level != 0 ->
                    createInstance<Filter<*>>(clazz, condition)?.let {
                        res.addAll(deduceQueryType(it.toConditiion(), level - 1))
                    }
            }
        }

        if (new.isNotEmpty()) {
            res.add(FullQuery(new))
        }
        return res.reversed()
    }

}