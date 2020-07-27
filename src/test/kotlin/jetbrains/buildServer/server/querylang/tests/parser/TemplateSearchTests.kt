package jetbrains.buildServer.server.querylang.tests.parser

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.parser.QueryParser
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Test
internal class TemplateSearchTests {
    val parser = QueryParser()
    
    fun testTemplateSearchWithBCFilters() {
        val query = """
            find template with id Test1 and trigger type vcsTrigger
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindTemplate(
                AndConditionNode<TempFilter>(
                        FilterConditionNode(IdFilter("Test1")),
                        FilterConditionNode(TriggerFilter(
                                FilterConditionNode(
                                        TypeFilter("vcsTrigger")
                                )
                        ))
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testTemplateSearchWithProjectFilter() {
        val query = """
            find template in Project1 with id Test1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindTemplate(
                AndConditionNode<TempFilter>(
                        FilterConditionNode(SProjectFilter(
                                FilterConditionNode(
                                        IdFilter("Project1")
                                )
                        )),
                        FilterConditionNode(IdFilter("Test1"))
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testWithWrongFilter() {
        val query = """
            find template with template (id 55555)
        """.trimIndent()

        assertFailsWith<ParsingException> { parser.parse(query) }
    }
}