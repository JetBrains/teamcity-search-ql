package jetbrains.buildServer.server.querylang.tests.parser

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.parser.QueryParser
import org.testng.annotations.Test
import kotlin.test.assertEquals

@Test
class BuildConfOrTemplateSearchTests {
    val parser = QueryParser()

    
    fun testFindByIdAndProject() {
        val query = """
            find buildConfOrTemp in Project1 with id Test1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConfOrTemplate(
                AndConditionNode<BcOrTempFilter>(
                        FilterConditionNode(SProjectFilter(
                                FilterConditionNode(
                                        IdFilter("Project1")
                                )
                        )),
                        FilterConditionNode(IdFilter("Test1"))
                )
        )

        assertEquals(expected, parsed)
    }

    
    fun testFindByIdAndTrigger() {
        val query = """
            find buildConfOrTemp with id Test1 and trigger type vcsTrigger
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConfOrTemplate(
                AndConditionNode<BcOrTempFilter>(
                        FilterConditionNode(IdFilter("Test1")),
                        FilterConditionNode(TriggerFilter(
                                FilterConditionNode(
                                        TypeFilter("vcsTrigger")
                                )
                        ))
                )
        )

        assertEquals(expected, parsed)
    }
}