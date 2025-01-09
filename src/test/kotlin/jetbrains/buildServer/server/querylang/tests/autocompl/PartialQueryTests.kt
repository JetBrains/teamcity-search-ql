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

    fun completeTypeQuery() {
        val query = "type vcsTrigger"

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            "find vcsRoot with type vcsTrigger",
            "find configuration,template with vcs type vcsTrigger",
            "find project,configuration,template with feature type vcsTrigger",
            "find configuration,template,privateRecipe with step type vcsTrigger",
            "find configuration,template with trigger type vcsTrigger",
            "find project with vcsRoot type vcsTrigger"
        )

        assertEquals(expected, res)
    }

    fun testDoubleQuotes() {
        val query = """param "path&1" = ("Base^"* and *"ProjectResult*" )"""

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            """find project,configuration,template,vcsRoot,privateRecipe with param "path&1"=("Base^"* and *"ProjectResult*")"""
        )

        assertEquals(expected.first(), res.first())
    }

    fun testDoubleQuotesId() {
        val query = """id "Base^ProjectResult" """

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            """find project,configuration,template,vcsRoot,privateRecipe with id "Base^ProjectResult""""
        )

        assertEquals(expected.first(), res.first())
    }

    fun testEscapedDoubleQuotesTest() {
        val query = """id "Base""ProjectResult" """

        val res = compl.complete(query).map { it.result }
        val expected = listOf(
            """find project,configuration,template,vcsRoot,privateRecipe with id "Base""ProjectResult""""
        )

        assertEquals(expected.first(), res.first())
    }
}