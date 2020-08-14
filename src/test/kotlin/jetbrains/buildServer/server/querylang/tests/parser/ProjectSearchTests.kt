package jetbrains.buildServer.server.querylang.tests.parser

/*

import jetbrains.buildServer.server.querylang.ast_old.*
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.wrapEq
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Test
internal class ProjectSearchTests {
    private val parser = QueryParser
    
    fun testOnlyOneFilter() {
        val query = """
            find project with ancestor id Project1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindProject(
                        FilterConditionNode(
                                AncestorFilter(
                                        FilterConditionNode(IdFilter("Project1".wrapEq()))
                                )
                        )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testParentFilter() {
        val query = """
            find project with parent id Project1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindProject(
                FilterConditionNode(
                        ParentFilter(
                                FilterConditionNode(IdFilter("Project1".wrapEq()))
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testWrongFilter() {
        val query = """
            find project with id Project1 and type Type1
        """.trimIndent()

        assertFailsWith<ParsingException> { parser.parse(query) }
    }
}

 */