package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

@Test
class AutocompletionTests : BaseServerTestCase() {
    private lateinit var autoCompl: AutoCompletion

    @BeforeClass
    override fun setUp() {
        super.setUp()

        val baseProject = myFixture.createProject("BaseProject", "BaseProject")
        val project1 = myFixture.createProject("BaseProject_p1", "BaseProject_p1", baseProject)
        val project2 = myFixture.createProject("BaseProject_p2", "BaseProject_p2", baseProject)
        val project3 = myFixture.createProject("BaseProject_p3", "BaseProject_p3", baseProject)
        val project4 = myFixture.createProject("BaseProject_p1_p4", "BaseProject_p1_p4", project1)
        val project5 = myFixture.createProject("BaseProject_p1_p5", "BaseProject_p1_p5", project1)
        val project6 = myFixture.createProject("BaseProject_p1_p5_p6", "BaseProject_p1_p5_p6", project5)

        val p1_bt1 = project1.createBuildType("BaseProject_p1_bt1", "BaseProject_p1_bt1")
        val p1_bt2 = project1.createBuildType("BaseProject_p1_bt2", "BaseProject_p1_bt2")
        val p5_bt1 = project5.createBuildType("BaseProject_p1_p5_bt1", "BaseProject_p1_p5_bt1")
        val p5_bt2 = project2.createBuildType("BaseProject_p2_bt1", "BaseProject_p2_bt1")

        val p5_temp1 = project5.createBuildTypeTemplate("BaseProject_p1_p5_temp1", "BaseProject_p1_p5_temp1")
        val p2_temp1 = project2.createBuildTypeTemplate("BaseProject_p2_temp1", "BaseProject_p2_temp1")

        myFixture.registerVcsSupport("git")
        myFixture.registerVcsSupport("svn")
        val vcsRoot1 = project1.createVcsRoot("git", "gitId1", "gitId1")
        val vcsRoot2 = project3.createVcsRoot("git", "gitId2", "gitId2")
        val vcsRoot3 = project3.createVcsRoot("svn", "svnId3", "svnId3")

        p1_bt1.addBuildTrigger("vcsTrigger", mapOf(Pair("path", "abc")))
        p5_temp1.addBuildTrigger("vcsTrigger", mapOf(Pair("path", "abd")))
        p5_bt1.addBuildTrigger("schedulingTrigger", mapOf(Pair("patabc", "abc"), Pair("abc", "bcd"), Pair("path", "acd")))

        autoCompl = AutoCompletion(myFixture.projectManager)
    }

    fun testProjectId() {
        val query = """
            find buildConf with project id BaseProject_p1
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("", "_p4", "_p5", "_p5_p6")

        assertEquals(expected, vars)
    }

    fun testBuildConfId() {
        val query = """
            find buildConf with project(id 5555) and (((id BaseProject_p1
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("_bt1", "_bt2", "_p5_bt1")

        assertEquals(expected, vars)
    }

    fun testVcsRootId() {
        val query = """
            find vcsRoot with id gi
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("tId1", "tId2")

        assertEquals(expected, vars)
    }

    fun testTemplateId() {
        val query = """
            find buildConf with id 5555 or template (id 55555 or id BaseProject_p1
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("_p5_temp1")

        assertEquals(expected, vars)
    }

    fun testBuildConfOrTempId() {
        val query = """
            find buildConfOrTemp with (id 5555 and id 6666) or (((id BaseProject_p
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("1_bt1", "1_bt2", "2_bt1", "2_temp1", "1_p5_bt1", "1_p5_temp1")

        assertEquals(expected, vars)
    }

    fun testTriggerParamName() {
        val query = """
            find buildConf with (id 5555 or id 6666) and (id 7777 or ( ( trigger param pat
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("h", "abc")

        assertEquals(expected, vars)
    }

    fun testTriggerParamValue() {
        val query = """
            find buildConf with (id 5555 or id 6666) and (id 7777 or ( ( trigger param path = "ab
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("c", "d")

        assertEquals(expected, vars)
    }

    fun testTriggerEmptyParam() {
        val query = """
            find buildConf with (id 5555 or id 6666) and (id 7777 or ( ( trigger param 
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("abc", "path", "patabc")

        assertEquals(expected, vars)
    }

    fun testTriggerType() {
        val query = """
            find template with trigger type vcs
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("Trigger")

        assertEquals(expected, vars)
    }

    fun testVcsRootType() {
        val query = """
            find vcsRoot with type gi
        """.trimIndent()

        val vars = autoCompl.complete(query)
        val expected = listOf("t")

        assertEquals(expected, vars)
    }
}