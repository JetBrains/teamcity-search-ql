package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.*
import jetbrains.buildServer.server.querylang.myProjectManager
import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project
import jetbrains.buildServer.server.querylang.objects.VcsRoot
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.requests.QueryResult

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
                is ProjectTopLevelQuery -> query.eval().objects.map { Project(it.sproject) }
                is BuildConfTopLevelQuery -> query.eval().objects.map { BuildConfiguration(it.sbuildConf)}
                is TemplateTopLevelQuery -> query.eval().objects.map { BuildTemplate(it.stemplate) }
                is VcsRootTopLevelQuery -> query.eval().objects.map { VcsRoot(it.svcsRoot) }
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

    fun getPossibleStrings() = queries.flatMap { it.getPossibleStrings() }
}

data class PartialQuery(val fullQueries: List<FullQuery>): MainQuery()

sealed class TopLevelQuery<T> : ConditionContainer<T>, Named, ConditionSplitter<T> {
    fun splitCondition() = condition.splitCondition()

    fun getPossibleStrings(): List<String> {
        val collector = StringCollector()
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
    companion object : Names(*(ProjectFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun evalFrom(ncondition: ConditionAST<WProject>): EvalResult<WProject> {
        val res = ncondition.eval()

        return if (res.filter !is NoneObjectFilter)
            EvalResult(NoneObjectFilter(),
                myProjectManager.projects.filter {
                    checkInterruptionStatus()
                    res.filter.accepts(it.wrap())
                }.map { it.wrap() } + res.objects
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
    companion object : Names(*(BuildConfFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun evalFrom(ncondition: ConditionAST<WBuildConf>): EvalResult<WBuildConf> {
        val res = ncondition.eval()

        return if (res.filter !is NoneObjectFilter)
                EvalResult(NoneObjectFilter(),
                    myProjectManager.allBuildTypes.filter {
                        checkInterruptionStatus()
                        res.filter.accepts(it.wrap())
                    }.map { it.wrap() } + res.objects
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
    companion object : Names(*(TemplateFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun evalFrom(condition: ConditionAST<WTemplate>): EvalResult<WTemplate> {
        val res = condition.eval()

        return if (res.filter !is NoneObjectFilter)
                EvalResult(NoneObjectFilter(),
                    myProjectManager.allTemplates.filter {
                        checkInterruptionStatus()
                        res.filter.accepts(it.wrap())
                    }.map { it.wrap() } + res.objects
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
    companion object : Names(*(VcsRootFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun evalFrom(condition: ConditionAST<WVcsRoot>): EvalResult<WVcsRoot> {
        val res = condition.eval()

        return if (res.filter !is NoneObjectFilter)
            EvalResult(NoneObjectFilter(),
                myProjectManager.allVcsRoots.filter {
                    checkInterruptionStatus()
                    res.filter.accepts(it.wrap(it.project.valueResolver))
                }.map {it.wrap(it.project.valueResolver) } + res.objects
            )
            else
                EvalResult(NoneObjectFilter(),res.objects)
    }
}