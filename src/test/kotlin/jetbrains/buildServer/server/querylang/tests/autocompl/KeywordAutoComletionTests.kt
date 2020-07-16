package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import org.testng.annotations.Test
import kotlin.test.assertEquals


@Test
internal class KeywordAutoComletionTests {
    val autoCompl = AutoCompletion()

    fun testFindAutoCompleteon() {
        val query = """
            find buil
        """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(2, vars!!.size)
        assertEquals("buildConf", vars[0])
        assertEquals("buildConfOrTemp", vars[1])
    }

    
    fun testProjectAutoCompleteon() {
        val query = """
            find buildConf with project ( ancestor id 5555 and anc
        """.trimIndent()

        val vars = autoCompl.complete(query)!!.sortedBy { it }

        assertEquals(2, vars.size)
        assertEquals("ancestor", vars[0])
        assertEquals("ancestorOrSelf", vars[1])
    }

    
    fun testBuildConfAutoCompleteon() {
        val query = """
            find buildConf with id 5555 or id 66666 and temp
        """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(1, vars!!.size)
        assertEquals("template", vars[0])
    }

    
    fun testTemplateAutoCompleteon() {
        val query = """
            find buildConf with id 5555 or (id 6666 and template (( id 5555 or (id 6666 and (i
        """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(1, vars!!.size)
        assertEquals("id", vars[0])
    }

    
    fun testTriggerAutoCompleteon() {
        val query = """
            find buildConf with trigger (((((t
        """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(1, vars!!.size)
        assertEquals("type", vars[0])
    }

    
    fun testVcsRootCompleteion() {
        val query = """
            find vcsRoot with project( ( id 55555) ) and (type 555 or id 6666 and ((t
        """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(1, vars!!.size)
        assertEquals("type", vars[0])
    }

    
    fun testWrongNestedFilters() {
        val query = """
            find template with project (template (i
        """.trimIndent()

        val vars = autoCompl.complete(query)

        assertEquals(null, vars)
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

        assertEquals(null, vars)
    }
}