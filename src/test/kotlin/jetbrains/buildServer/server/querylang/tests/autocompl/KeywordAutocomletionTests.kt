package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import org.testng.annotations.Test
import kotlin.test.assertEquals


@Test
internal class KeywordAutocomletionTests {
    val autoCompl = AutoCompletion()

    fun testFindAutoCompleteon() {
        val query = """
            find buil
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}

        assertEquals(1, vars.size)
        assertEquals("dConfiguration", vars[0])
    }

    
    fun testProjectAutoCompleteon() {
        val query = """
            find buildConfiguration with project ( ancestor id 5555 and anc
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}.sortedBy { it }

        assertEquals(2, vars.size)
        assertEquals("estor", vars[0])
        assertEquals("estorOrSelf", vars[1])
    }

    
    fun testBuildConfAutoCompleteon() {
        val query = """
            find buildConfiguration with id 5555 or id 66666 and temp
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}

        assertEquals(1, vars.size)
        assertEquals("late", vars[0])
    }

    
    fun testTemplateAutoCompleteon() {
        val query = """
            find buildConfiguration with id 5555 or (id 6666 and template (( id 5555 or (id 6666 and (i
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}

        assertEquals(1, vars.size)
        assertEquals("d", vars[0])
    }

    
    fun testTriggerAutoCompleteon() {
        val query = """
            find buildConfiguration with trigger (((((t
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}

        assertEquals(1, vars!!.size)
        assertEquals("ype", vars[0])
    }

    
    fun testVcsRootCompleteion() {
        val query = """
            find vcsRoot with project( ( id 55555) ) and (type 555 or id 6666 and ((t
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}

        assertEquals(1, vars!!.size)
        assertEquals("ype", vars[0])
    }

    
    fun testWrongNestedFilters() {
        val query = """
            find template with project (template (i
        """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(listOf(), vars)
    }

    
    fun testEmptyAutocompletionQuery() {
        val query = """
            find project with (id 5555 or id """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(listOf(), vars)
    }

    
    fun testWrongAutocompletionQuery() {
        val query = """
            find project with (id 5555 or i)""".trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(listOf(), vars)
    }
}