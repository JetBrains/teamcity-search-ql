package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.*
import jetbrains.buildServer.server.querylang.myPrivateRecipesManager
import jetbrains.buildServer.server.querylang.myProjectManager
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.requests.QueryResult
import jetbrains.buildServer.server.querylang.ui.objects.*

private fun checkInterruptionStatus() {
    if (Thread.currentThread().isInterrupted) {
        throw InterruptedException()
    }
}

sealed class MainQuery

data class FullQuery(val queries: List<TopLevelQuery<*>>): MainQuery(), Printable {
    fun eval(): QueryResult {
        val res = queries.flatMap { query ->
            when (query) {
                is ProjectTopLevelQuery -> query.eval().objects.map { ProjectResult(it) }
                is BuildConfTopLevelQuery -> query.eval().objects.map { BuildConfigurationResult(it)}
                is TemplateTopLevelQuery -> query.eval().objects.map { TemplateResult(it) }
                is VcsRootTopLevelQuery -> query.eval().objects.map { VcsRootResult(it) }
                is PrivateRecipeTopLevelQuery -> query.eval().objects.map { PrivateRecipeResult(it) }
            }
        }
        return QueryResult(res.toMutableList())
    }

    override fun createStr(): String {
        return if (queries.isEmpty()) "Error: empty query"
        else {
            val conditionStr = queries.first().condition.createStr()
            "find ${queries.joinToString(separator = ",") { it.names.first() }} with $conditionStr"
        }
    }

    fun getPossibleStrings(): List<String> {
        val collector = StringCollector()
        queries.forEach { it.getPossibleStrings(collector) }
        return collector.toList()
    }
}

data class PartialQuery(val fullQueries: List<FullQuery>): MainQuery()

sealed class TopLevelQuery<T> : ConditionContainer<T>, Named, ConditionSplitter<T> {
    fun splitCondition() = condition.splitCondition()

    fun getPossibleStrings(collector: StringCollector): List<String> {
        val collectorFilter = QueryParser.validateQuery(condition, true) ?: return emptyList()
        collectorFilter.setCollector(collector)
        val (remCondition, visitor) = condition.splitCondition()
        val vars = evalFrom(remCondition).objects
        vars.forEach {visitor.accepts(it)}
        return collector.toList()
    }

    override fun evalInner(): EvalResult<T> = evalFrom(condition)

    abstract fun evalFrom(condition: ConditionAST<T>): EvalResult<T>
}

data class ProjectTopLevelQuery(override val condition: ConditionAST<WProject>): TopLevelQuery<WProject>(), ProjectConditionContainer {
    companion object : ObjectDescription(
        Names1(*(ProjectFilter.names.toTypedArray())),
        Descriptions(
            FixedContextDescription("search projects")
        )
    )

    override val names = Companion.names

    override fun evalFrom(ncondition: ConditionAST<WProject>): EvalResult<WProject> {
        val res = ncondition.eval()

        return if (res.filter !is NoneObjectFilter)
            EvalResult(NoneObjectFilter(),
                myProjectManager.projects.filter {
                    checkInterruptionStatus()
                    res.filter.accepts(it.wrap())
                }.mapNotNull { it.wrap() } + res.objects
            )
            else
                EvalResult(NoneObjectFilter(),
                    res.objects
                )
    }
}

data class BuildConfTopLevelQuery(
    override val condition: ConditionAST<WBuildConf>
) : TopLevelQuery<WBuildConf>(), BuildConfConditionContainer {
    companion object : ObjectDescription(
        Names1(*(BuildConfFilter.names.toTypedArray())),
        Descriptions(
            FixedContextDescription("search build configurations")
        )
    )

    override val names = Companion.names

    override fun evalFrom(ncondition: ConditionAST<WBuildConf>): EvalResult<WBuildConf> {
        val res = ncondition.eval()

        return if (res.filter !is NoneObjectFilter)
                EvalResult(NoneObjectFilter(),
                    myProjectManager.allBuildTypes.filter {
                        checkInterruptionStatus()
                        res.filter.accepts(it.wrap())
                    }.mapNotNull { it.wrap() } + res.objects
                )
            else
                EvalResult(NoneObjectFilter(),res.objects)
    }
}

data class TemplateTopLevelQuery(
    override val condition: ConditionAST<WTemplate>
) : TopLevelQuery<WTemplate>(),
    TemplateConditionContainer
{
    companion object : ObjectDescription(
        Names1(*(TemplateFilter.names.toTypedArray())),
        Descriptions(
            FixedContextDescription("search build configuration templates")
        )
    )

    override val names = Companion.names

    override fun evalFrom(condition: ConditionAST<WTemplate>): EvalResult<WTemplate> {
        val res = condition.eval()

        return if (res.filter !is NoneObjectFilter)
                EvalResult(NoneObjectFilter(),
                    myProjectManager.allTemplates.filter {
                        checkInterruptionStatus()
                        res.filter.accepts(it.wrap())
                    }.mapNotNull { it.wrap() } + res.objects
                )
            else
                EvalResult(NoneObjectFilter(), res.objects)
    }
}

data class VcsRootTopLevelQuery(
    override val condition: ConditionAST<WVcsRoot>
) : TopLevelQuery<WVcsRoot>(),
    VcsRootConditionContainer
{
    companion object : ObjectDescription(
        Names1(*(VcsRootFilter.names.toTypedArray())),
        Descriptions(
            FixedContextDescription("search vcs roots")
        )
    )

    override val names = Companion.names

    override fun evalFrom(condition: ConditionAST<WVcsRoot>): EvalResult<WVcsRoot> {
        val res = condition.eval()

        return if (res.filter !is NoneObjectFilter)
            EvalResult(NoneObjectFilter(),
                myProjectManager.allVcsRoots.filter {
                    checkInterruptionStatus()
                    res.filter.accepts(it.wrap(it.project.valueResolver))
                }.mapNotNull {it.wrap(it.project.valueResolver) } + res.objects
            )
            else
                EvalResult(NoneObjectFilter(),res.objects)
    }
}

data class PrivateRecipeTopLevelQuery(
    override val condition: ConditionAST<WPrivateRecipe>
) : TopLevelQuery<WPrivateRecipe>(),
    PrivateRecipeConditionContainer
{
    companion object : ObjectDescription(
        Names1("privateRecipe"),
        Descriptions(
            FixedContextDescription("search private recipes")
        )
    )

    override val names = Companion.names

    override fun evalFrom(condition: ConditionAST<WPrivateRecipe>): EvalResult<WPrivateRecipe> {
        val res = condition.eval()

        return if (res.filter !is NoneObjectFilter)
            EvalResult(NoneObjectFilter(),
                myPrivateRecipesManager.recipeSpecs.filter { spec ->
                    checkInterruptionStatus()
                    spec.configLocation.project?.valueResolver?.let { vr -> res.filter.accepts(spec.wrap(vr)) } ?: false
                }.mapNotNull { it.wrap(it.configLocation.project!!.valueResolver) } + res.objects
            )
        else
            EvalResult(NoneObjectFilter(),res.objects)
    }
}