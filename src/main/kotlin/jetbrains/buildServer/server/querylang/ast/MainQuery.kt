package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.*
import jetbrains.buildServer.server.querylang.myProjectManager
import jetbrains.buildServer.server.querylang.objects.BuildConfiguration
import jetbrains.buildServer.server.querylang.objects.BuildTemplate
import jetbrains.buildServer.server.querylang.objects.Project
import jetbrains.buildServer.server.querylang.objects.VcsRoot
import jetbrains.buildServer.server.querylang.requests.QueryResult

class MainQuery(val queries: List<TopLevelQuery>) {
    fun eval(): QueryResult {
        val res = queries.flatMap { query ->
            when (query) {
                is ProjectTopLevelQuery -> query.eval().objects.map { Project(it.sproject) }
                is BuildConfTopLevelQuery -> query.eval().objects.map { BuildConfiguration(it.sbuildConf)}
                is TemplateTopLevelQuery -> query.eval().objects.map { BuildTemplate(it.stemplate) }
                is VcsRootTopLevelQuery -> query.eval().objects.map { VcsRoot(it.svcsRoot) }
            }
        }
        return QueryResult(res)
    }
}

sealed class TopLevelQuery

class ProjectTopLevelQuery(override val condition: ConditionAST<WProject>): ConditionContainer<WProject>, TopLevelQuery() {
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

class BuildConfTopLevelQuery(override val condition: ConditionAST<WBuildConf>) : ConditionContainer<WBuildConf>, TopLevelQuery() {
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

class TemplateTopLevelQuery(override val condition: ConditionAST<WTemplate>) : ConditionContainer<WTemplate>, TopLevelQuery() {
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

class VcsRootTopLevelQuery(override val condition: ConditionAST<WVcsRoot>) : ConditionContainer<WVcsRoot>, TopLevelQuery() {
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