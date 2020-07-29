package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.ast.FilterTypeRegistration
import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.parser.TypeDeduce
import org.testng.annotations.Test
import kotlin.test.assertEquals

@Test
class PartialQueryTests {
    val compl = AutoCompletion()

    //initialization is necessary
    private val queryParser = QueryParser

    fun completeIdQuery() {
        val query = "id BaseProject"

        val res = compl.complete(query).map {it.result}
        val expected = listOf(
            "find project with ancestor(id(BaseProject))",
            "find project,buildConfiguration,template with parent(id(BaseProject))",
            "find project with ancestorOrSelf(id(BaseProject))",
            "find buildConfiguration,template,vcsRoot with project(id(BaseProject))",
            "find buildConfiguration with template(id(BaseProject))",
            "find project,buildConfiguration,template,vcsRoot with id(BaseProject)"
        )

        assertEquals(expected, res)
    }

    fun completeTypeQuery() {
        val query = "type vcsTrigger"

        val res = compl.complete(query).map {it.result}
        val expected = listOf(
            "find buildConfiguration,template with feature(type vcsTrigger)",
            "find buildConfiguration,template with step(type vcsTrigger)",
            "find buildConfiguration,template with trigger(type vcsTrigger)",
            "find vcsRoot with type vcsTrigger"
        )

        assertEquals(expected, res)
    }

    fun completeParamQuery() {
        val query = "param path = (Base* and *Project)"

        val res = compl.complete(query).map {it.result}
        val expected = listOf(
            "find buildConfiguration,template with feature(param path=(Base* and *Project))",
            "find buildConfiguration,template with step(param path=(Base* and *Project))",
            "find buildConfiguration,template with trigger(param path=(Base* and *Project))"
        )

        assertEquals(expected, res)
    }
}