package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.server.querylang.autocompl.Completer
import jetbrains.buildServer.server.querylang.autocompl.CompletionManager
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
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

        p5_bt1.addBuildTrigger("project", mapOf(Pair("param", "vcsRoot")))

        val complm = CompletionManager(myFixture.projectManager)
        val compl = Completer(complm)
        autoCompl = AutoCompletion(myFixture.projectManager, compl)
    }

    fun testProjectId() {
        val query = """
            find configuration with project id BaseProject_p1
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("BaseProject_p1", "BaseProject_p1_p4", "BaseProject_p1_p5", "BaseProject_p1_p5_p6")

        assertEquals(expected, vars)
    }

    fun testBuildConfId() {
        val query = """
            find configuration with project(id 5555) and (((id BaseProject_p1
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("BaseProject_p1_bt1", "BaseProject_p1_bt2", "BaseProject_p1_p5_bt1")

        assertEquals(expected, vars)
    }

    fun testVcsRootId() {
        val query = """
            find vcsRoot with id gi
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("gitId1", "gitId2")

        assertEquals(expected, vars)
    }

    fun testTemplateId() {
        val query = """
            find configuration with id 5555 or template (id 55555 or id BaseProject_p1
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("BaseProject_p1_p5_temp1")

        assertEquals(expected, vars)
    }

    fun testBuildConfOrTempId() {
        val query = """
            find configuration, template with (id 5555 and id 6666) or (((id BaseProject_p
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf(
            "BaseProject_p1_bt1",
            "BaseProject_p1_bt2",
            "BaseProject_p2_bt1",
            "BaseProject_p2_temp1",
            "BaseProject_p1_p5_bt1",
            "BaseProject_p1_p5_temp1"
        )

        assertEquals(expected, vars)
    }

    fun testTriggerParamName() {
        val query = """
            find configuration with (id 5555 or id 6666) and (id 7777 or ( ( trigger param pat
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("path", "patabc")

        assertEquals(expected, vars)
    }

    fun testTriggerParamValue() {
        val query = """
            find configuration with (id 5555 or id 6666) and (id 7777 or ( ( trigger param path = "ab
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("path=abc", "path=abd")

        assertEquals(expected, vars)
    }

    fun testTriggerEmptyParam() {
        val query = """
            find configuration with (id 5555 or id 6666) and (id 7777 or ( ( trigger param 
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("abc", "path", "param", "patabc")

        assertEquals(expected, vars)
    }

    fun testTriggerType() {
        val query = """
            find template with trigger type vcs
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("vcsTrigger")

        assertEquals(expected, vars)
    }

    fun testVcsRootType() {
        val query = """
            find vcsRoot with type gi
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("git")

        assertEquals(expected, vars)
    }

    fun testTriggerParamWithQuotes1() {
        val query = """
            find configuration with trigger param "path"=a
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("path=abc", "path=abd", "path=acd")

        assertEquals(expected, vars)
    }

    fun testEscapeKeywordParameterName() {
        val query = """
            find configuration with trigger param pa
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("path", "param", "patabc")

        assertEquals(expected, vars)
    }

    fun testVcsRootCheckoutRulesFilter() {
        val query = """
            find configuration with vcs (ru
        """.trimIndent()

        val vars = autoCompl.complete(query).map {it.show}
        val expected = listOf("rules")

        assertEquals(expected, vars)
    }
}