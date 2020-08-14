package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.*
import jetbrains.buildServer.server.querylang.myProjectManager
import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project
import jetbrains.buildServer.server.querylang.objects.VcsRoot
import jetbrains.buildServer.server.querylang.requests.QueryResult

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
        else "find ${queries.joinToString(separator = ",") { it.names.first() }} with ${queries.first().condition.createStr()}"
    }
}

data class PartialQuery(val fullQueries: List<FullQuery>): MainQuery()

sealed class TopLevelQuery<T> : Named, ConditionContainer<T>

data class ProjectTopLevelQuery(override val condition: ConditionAST<WProject>): ConditionContainer<WProject>, TopLevelQuery<WProject>() {
    companion object : Names(*(ProjectFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun eval(): EvalResult<WProject> {
        val res = condition.eval()

        return EvalResult(NoneObjectFilter(),
            if (res.filter !is NoneObjectFilter)
                myProjectManager.projects.filter {res.filter.accepts(it.wrap())}.map {it.wrap()}
            else
                res.objects
        )
    }
}

data class BuildConfTopLevelQuery(override val condition: ConditionAST<WBuildConf>) : ConditionContainer<WBuildConf>, TopLevelQuery<WBuildConf>() {
    companion object : Names(*(BuildConfFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun eval(): EvalResult<WBuildConf> {
        val res = condition.eval()

        return EvalResult(NoneObjectFilter(),
            if (res.filter !is NoneObjectFilter)
                myProjectManager.allBuildTypes.filter {res.filter.accepts(it.wrap())}.map {it.wrap()}
            else
                res.objects
        )
    }
}

data class TemplateTopLevelQuery(override val condition: ConditionAST<WTemplate>) : ConditionContainer<WTemplate>, TopLevelQuery<WTemplate>() {
    companion object : Names(*(TemplateFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun eval(): EvalResult<WTemplate> {
        val res = condition.eval()

        return EvalResult(NoneObjectFilter(),
            if (res.filter !is NoneObjectFilter)
                myProjectManager.allTemplates.filter {res.filter.accepts(it.wrap())}.map {it.wrap()}
            else
                res.objects
        )
    }
}

data class VcsRootTopLevelQuery(override val condition: ConditionAST<WVcsRoot>) : ConditionContainer<WVcsRoot>, TopLevelQuery<WVcsRoot>() {
    companion object : Names(*(VcsRootFilter.names.toTypedArray()))

    override val names = Companion.names

    override fun eval(): EvalResult<WVcsRoot> {
        val res = condition.eval()

        return EvalResult(NoneObjectFilter(),
            if (res.filter !is NoneObjectFilter)
                myProjectManager.allVcsRoots.filter {res.filter.accepts(it.wrap())}.map {it.wrap()}
            else
                res.objects
        )
    }
}