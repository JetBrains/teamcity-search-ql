package jetbrains.buildServer.server.querylang.tests.parser

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.parser.QueryParser
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Test
class BuildConfSearchTests {
    private val parser = QueryParser()

    private fun TopLevelQuery.wrap(): MainQuery {
        return FindMultipleTypes(listOf(this))
    }
    
    fun testProjectFilterOnly() {
        val query = """
            find buildConfiguration in Project1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(FilterConditionNode(
                SProjectFilter(FilterConditionNode(
                        IdFilter("Project1")
                ))
        )).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testProjectFilterWithOtherFilters() {
        val query = """
            find buildConfiguration in Project1 with (trigger ((type vcsTrigger) and (param par = "abc")))
        """.trimIndent()

        val parsed = parser.parse(query)

        val expected = FindBuildConf(AndConditionNode<BuildConfFilter>(
                        FilterConditionNode(SProjectFilter(FilterConditionNode(
                                IdFilter("Project1")
                        ))),
                        FilterConditionNode(TriggerFilter(AndConditionNode<ParameterHolderFilter>(
                                FilterConditionNode(TypeFilter("vcsTrigger")),
                                FilterConditionNode(ParameterFilter("par", "abc"))
                        )))
        )).wrap()
        assertEquals(expected, parsed)
    }

    
    fun testLongProjectFilter() {
        val query = """
            find buildConfiguration 
                 with trigger(type vcsTrigger and param par="abc") 
                 and project(id Project1)
        """.trimIndent()

        val parsed = parser.parse(query)

        val expected = FindBuildConf(
                AndConditionNode<BuildConfFilter>(
                        FilterConditionNode(TriggerFilter(
                                AndConditionNode<ParameterHolderFilter>(
                                        FilterConditionNode(TypeFilter("vcsTrigger")),
                                        FilterConditionNode(ParameterFilter("par", "abc"))
                                ))
                        ),
                        FilterConditionNode(SProjectFilter(
                                FilterConditionNode(IdFilter("Project1"))
                        ))
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testOnlyOneFilter() {
        val query = """
            find buildConfiguration with trigger(type vcsTrigger and param par = "abc")
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        TriggerFilter(
                                AndConditionNode<ParameterHolderFilter>(
                                        FilterConditionNode(TypeFilter("vcsTrigger")),
                                        FilterConditionNode(ParameterFilter("par", "abc"))
                                )
                        )
                )
        ).wrap()

        assertEquals(parsed, expected)

    }

    
    fun testProjectFilterWithOneSubfilter() {
        val query = """
            find buildConfiguration with project id Project1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        SProjectFilter(
                                FilterConditionNode(IdFilter("Project1"))
                        )
                )
        ).wrap()

        assertEquals(parsed, expected)
    }

    
    fun testTriggerFilterWithOneSubfilter() {
        val query = """
            find buildConfiguration with trigger type vcsTrigger
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        TriggerFilter(
                                FilterConditionNode(
                                        TypeFilter("vcsTrigger")
                                )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testShortenedTriggerTypeFilter() {
        val query = """
            find buildConfiguration with trigger type vcsTrigger
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        TriggerFilter(
                                FilterConditionNode(
                                        TypeFilter("vcsTrigger")
                                )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testShortenedTriggerParameterFilter() {
        val query = """
            find buildConfiguration with trigger param path="abacaba"
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        TriggerFilter(
                                FilterConditionNode(
                                        ParameterFilter("path", "abacaba")
                                )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testAncestorFilter() {
        val query = """
            find buildConfiguration with project ancestor id Project1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        SProjectFilter(
                            FilterConditionNode(
                                    AncestorFilter(
                                            FilterConditionNode(IdFilter("Project1"))
                                    )
                            )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testTriggerValueFilter() {
        val query = """
            find buildConfiguration with trigger val "abc"
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        TriggerFilter(
                                FilterConditionNode(ValueFilter("abc"))
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testBuildStepFilter() {
        val query = """
            find buildConfiguration with step param path = "abc"
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        StepFilter(
                                FilterConditionNode(
                                        ParameterFilter("path", "abc")
                                )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testBuildFeature() {
        val query = """
            find buildConfiguration with feature param path = "abc"
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        FeatureFilter(
                                FilterConditionNode(
                                        ParameterFilter("path", "abc")
                                )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testBuildStepEnabled() {
        val query = """
            find buildConfiguration with step(val "abc" and enabled)
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        StepFilter(
                                AndConditionNode<ParameterHolderFilter>(
                                        FilterConditionNode(
                                                ValueFilter("abc")
                                        ),
                                        FilterConditionNode(
                                                EnabledFilter(true)
                                        )
                                )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testTemplateDependence() {
        val query = """
            find buildConfiguration with template(id 5555 and trigger type vcsTrigger)
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(
                FilterConditionNode(
                        TempDepFilter(
                                AndConditionNode<TempFilter>(
                                        FilterConditionNode(IdFilter("5555)")),
                                        FilterConditionNode(TriggerFilter(
                                                FilterConditionNode(
                                                        TypeFilter("vcsTrigger")
                                                )
                                        ))
                                )
                        )
                )
        ).wrap()
    }

    
    fun testWrongTriggerFilter() {
        val query = """
            find project with id Project1 and trigger(type Type1 and (type Type2 or project (id Project1) ) )
        """.trimIndent()

        assertFailsWith<ParsingException> { parser.parse(query) }
    }
}