package jetbrains.buildServer.server.querylang.tests.parser

import jetbrains.buildServer.server.querylang.ast_old.*
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.wrapEq
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Test
class BuildConfSearchTests {
    private val parser = QueryParser
    
    fun testProjectFilterOnly() {
        val query = """
            find buildConfiguration in Project1
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(FilterConditionNode(
                ProjectFilter(FilterConditionNode(
                        IdFilter("Project1".wrapEq())
                ))
        )).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testProjectFilterWithOtherFilters() {
        val query = """
            find buildConfiguration in Project1 with (trigger ((type vcsTrigger) and (param par = "abc")))
        """.trimIndent()

        val parsed = parser.parse(query)

        val expected = FindBuildConf(AndConditionNode<BuildConfFilterType>(
                        FilterConditionNode(ProjectFilter(FilterConditionNode(
                                IdFilter("Project1".wrapEq())
                        ))),
                        FilterConditionNode(TriggerFilter(AndConditionNode<ParameterHolderFilterType>(
                                FilterConditionNode(TypeFilter("vcsTrigger".wrapEq())),
                                FilterConditionNode(ParameterFilter("par".wrapEq(), "abc".wrapEq()))
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
                AndConditionNode<BuildConfFilterType>(
                        FilterConditionNode(TriggerFilter(
                                AndConditionNode<ParameterHolderFilterType>(
                                        FilterConditionNode(TypeFilter("vcsTrigger".wrapEq())),
                                        FilterConditionNode(ParameterFilter("par".wrapEq(), "abc".wrapEq()))
                                ))
                        ),
                        FilterConditionNode(ProjectFilter(
                                FilterConditionNode(IdFilter("Project1".wrapEq()))
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
                                AndConditionNode<ParameterHolderFilterType>(
                                        FilterConditionNode(TypeFilter("vcsTrigger".wrapEq())),
                                        FilterConditionNode(ParameterFilter("par".wrapEq(), "abc".wrapEq()))
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
                        ProjectFilter(
                                FilterConditionNode(IdFilter("Project1".wrapEq()))
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
                                        TypeFilter("vcsTrigger".wrapEq())
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
                                        TypeFilter("vcsTrigger".wrapEq())
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
                                        ParameterFilter("path".wrapEq(), "abacaba".wrapEq())
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
                        ProjectFilter(
                            FilterConditionNode(
                                    AncestorFilter(
                                            FilterConditionNode(IdFilter("Project1".wrapEq()))
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
                                FilterConditionNode(ValueFilter("abc".wrapEq()))
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
                                        ParameterFilter("path".wrapEq(), "abc".wrapEq())
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
                                        ParameterFilter("path".wrapEq(), "abc".wrapEq())
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
                                AndConditionNode<ParameterHolderFilterType>(
                                        FilterConditionNode(
                                                ValueFilter("abc".wrapEq())
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
                                AndConditionNode<TemplateFilterType>(
                                        FilterConditionNode(IdFilter("5555".wrapEq())),
                                        FilterConditionNode(TriggerFilter(
                                                FilterConditionNode(
                                                        TypeFilter("vcsTrigger".wrapEq())
                                                )
                                        ))
                                )
                        )
                )
        ).wrap()

        assertEquals(expected, parsed)
    }

    
    fun testWrongTriggerFilter() {
        val query = """
            find project with id Project1 and trigger(type Type1 and (type Type2 or project (id Project1) ) )
        """.trimIndent()

        assertFailsWith<ParsingException> { parser.parse(query) }
    }

    fun testQuotesEscape() {
        val query = """
            find buildConfiguration with id "Base""Configuration"
        """.trimIndent()

        val parsed = parser.parse(query)
        val expected = FindBuildConf(FilterConditionNode(
                IdFilter("Base\"Configuration".wrapEq())
        )).wrap()

        assertEquals(expected, parsed)
    }
}