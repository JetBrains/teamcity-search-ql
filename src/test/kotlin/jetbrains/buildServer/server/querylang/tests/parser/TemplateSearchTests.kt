package jetbrains.buildServer.server.querylang.tests.parser

import jetbrains.buildServer.server.querylang.ast_old.*
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.wrapEq
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Test
internal class TemplateSearchTests {
    val parser = QueryParser
    
    fun testTemplateSearchWithBCFilters() {
        val query = """
            find template with id Test1 and trigger type vcsTrigger
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindTemplate(
                AndConditionNode<TemplateFilterType>(
                        FilterConditionNode(IdFilter("Test1".wrapEq())),
                        FilterConditionNode(TriggerFilter(
                                FilterConditionNode(
                                        TypeFilter("vcsTrigger".wrapEq())
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
                AndConditionNode<TemplateFilterType>(
                        FilterConditionNode(ProjectFilter(
                                FilterConditionNode(
                                        IdFilter("Project1".wrapEq())
                                )
                        )),
                        FilterConditionNode(IdFilter("Test1".wrapEq()))
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