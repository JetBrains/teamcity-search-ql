package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.server.querylang.autocompl.Completer
import jetbrains.buildServer.server.querylang.parser.QueryParser
import org.testng.annotations.Test
import kotlin.test.assertEquals

@Test
class PartialQueryTests {
    val compl = AutoCompletion(null, Completer(null))

    //initialization is necessary
    private val queryParser = QueryParser

    fun completeIdQuery() {
        val query = "id BaseProject"

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            "find project with ancestor(id BaseProject)",
            "find project,configuration,template,vcsRoot with parent(id BaseProject)",
            "find project,configuration,template,vcsRoot with project(id BaseProject)",
            "find configuration with template(id BaseProject)",
            "find configuration,template with vcsRoot(id BaseProject)",
            "find configuration,template with dependency(id BaseProject)",
            "find project,configuration,template,vcsRoot with id BaseProject"
        )

        assertEquals(expected, res)
    }

    fun completeTypeQuery() {
        val query = "type vcsTrigger"

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            "find project,configuration,template with feature(type vcsTrigger)",
            "find configuration,template with step(type vcsTrigger)",
            "find configuration,template with trigger(type vcsTrigger)",
            "find configuration,template with vcsRoot(type vcsTrigger)",
            "find vcsRoot with type vcsTrigger"
        )

        assertEquals(expected, res)
    }

    fun testDoubleQuotes() {
        val query = """param "path&1" = ("Base^"* and *"Project*" )"""

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            """find project with ancestor(param ("path&1")=("Base^"* and *"Project*"))"""
        )

        assertEquals(expected.first(), res.first())
    }

    fun testDoubleQuotesId() {
        val query = """id "Base^Project" """

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            """find project with ancestor(id "Base^Project")"""
        )

        assertEquals(expected.first(), res.first())
    }

    fun testEscapedDoubleQuotesTest() {
        val query = """id "Base""Project" """

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            """find project with ancestor(id "Base""Project")"""
        )

        assertEquals(expected.first(), res.first())
    }

    fun testEscapeKeywordTest() {
        val query = """id "project" """
        val res = compl.complete(query).map {it.result}
        val expected = listOf(
            """find project with ancestor(id "project")"""
        )

        assertEquals(expected.first(), res.first())
    }
}