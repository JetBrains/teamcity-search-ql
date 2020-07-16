package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.requests.*
import jetbrains.buildServer.serverSide.ProjectManager
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

@Test
class ClientTests: BaseServerTestCase() {
    private lateinit var pManager: ProjectManager
    private lateinit var client: RequestClient
    private val parser = QueryParser()

    @BeforeClass
    override fun setUp() {
        super.setUp()
        pManager = myFixture.projectManager
        myFixture.registerVcsSupport("jetbrains.git")
        client = RequestClient(InternalApiQueryHandler(pManager), EmptyResultPrinter)

        val baseProject = myFixture.createProject("BaseProject", "BaseProject")
        val project1 = myFixture.createProject("Project1", "Project1", baseProject)
        val project2 = myFixture.createProject("Project2", "Project2", baseProject)
        val project3 = myFixture.createProject("Project3", "Project3", project1)
        val project4 = myFixture.createProject("Project4", "Project4", project3)
        val project5 = myFixture.createProject("Project5", "Project5", project4)

        val p1bt1 = project1.createBuildType("Project1_test1", "Project1_test1")
        p1bt1.addBuildTrigger("vcsTrigger", mapOf(Pair("opt1", "val1")))
        p1bt1.addBuildTrigger("schedulingTrigger", mapOf(Pair("opt2", "val2")))

        val p1bt2 = project1.createBuildType("Project1_test2", "Project1_test2")
        p1bt2.addBuildTrigger("vcsTrigger", mapOf(Pair("opt1", "val2")))

        val p2bt1 = project2.createBuildType("Project2_test1", "Project2_test1")
        p2bt1.addBuildTrigger("schedulingTrigger", mapOf(Pair("opt2", "val2")))

        val p3bt1 = project3.createBuildType("Project3_test1", "Project3_test1")
        p3bt1.addBuildTrigger("vcsTrigger", mapOf(Pair("opt1", "val1")))
        p3bt1.addBuildTrigger("schedulingTrigger", mapOf(Pair("opt3", "val3")))

        val p3bt2 = project3.createBuildType("Project3_test2", "Project3_test2")
        p3bt2.addBuildTrigger("schedulingTrigger", mapOf())
        p3bt2.addBuildRunner("runner1", "runnerType1", mapOf(Pair("path", "abc")))
        p3bt2.addBuildFeature("featureType2", mapOf(Pair("path", "qwe")))
        val disRun1 = p3bt2.addBuildRunner("runner3", "runnerType2", mapOf())
        p3bt2.setEnabled(disRun1.id, false)

        val p3vcs1 = project3.createVcsRoot("jetbrains.git", "Project3_vcs1", "Project3_vcs1")

        val p4bt1 = project4.createBuildType("Project4_test1", "Project4_test1")
        p4bt1.addBuildRunner("runner2", "runnerType2", mapOf(Pair("path", "abc")))
        p4bt1.addBuildFeature("featureType1", mapOf(Pair("path", "qwe")))

        val p4temp1 = project4.createBuildTypeTemplate("Project4_temp1", "Project4_temp1")
        p4temp1.addBuildRunner("temp_runner1", "temp_runner1", mapOf(Pair("home", "cde")))

        val p5bt1 = project5.createBuildType("Project5_test1", "Project5_test1")
        p5bt1.addTemplate(p4temp1, true)

        val p5vcs1 = project5.createVcsRoot("jetbrains.git", "Project5_vcs1", "Project5_vcs1")
    }

    fun testSearchBuildConfigurationWithVcsTrigger() {
        val query = """
                     find buildConf with
                         project ancestor id BaseProject
                         and trigger (type vcsTrigger and param opt1 = "val1")
                     """.trimIndent()

        val res = client.process(parser.parse(query))

        when (res) {
            is ResultBuildConfiguration -> {
                res.buildConfs.sortBy { it.description }
                assertEquals(res.buildConfs.size, 2)
                assertEquals(res.buildConfs[0].description, "Project1_test1")
                assertEquals(res.buildConfs[1].description, "Project3_test1")
            }
            else -> {
                fail("Result should be ResultBuildConfiguration")
            }
        }
        println(res)
    }

    fun testSearchBuildConfigurationWithVcsAndSchedulingTrigger() {
        val query = """
                     find buildConf with
                         project ancestor id BaseProject
                         and trigger (type vcsTrigger and param opt1 = "val1")
                         and trigger type schedulingTrigger
                     """.trimIndent()

        val res = client.process(parser.parse(query))

        when (res) {
            is ResultBuildConfiguration -> {
                res.buildConfs.sortBy { it.description }
                assertEquals(res.buildConfs.size, 2)
                assertEquals(res.buildConfs[0].description, "Project1_test1")
                assertEquals(res.buildConfs[1].description, "Project3_test1")
            }
            else -> {
                fail("Result should be ResultBuildConfiguration")
            }
        }
        println(res)
    }

    fun testSearchBuildConfigurationWithVcsOrSchedulingTrigger() {
        val query = """
                     find buildConf with
                         project ancestor id BaseProject
                         and trigger(type vcsTrigger and param opt1 = "val1" or  type schedulingTrigger and param opt2 = "val2")
                     """.trimIndent()

        val res = client.process(parser.parse(query))

        when (res) {
            is ResultBuildConfiguration -> {
                val confs = res.buildConfs.sortedBy { it.description }
                assertEquals(confs.size, 3)
                assertEquals(confs[0].description, "Project1_test1")
                assertEquals(confs[1].description, "Project2_test1")
                assertEquals(confs[2].description, "Project3_test1")
            }
            else -> {
                fail("Result should be ResultBuildConfiguration")
            }
        }
        println(res)
    }

    fun testSearchProjectByExternalIdInSubprojects() {
        val query = """
                     find project with
                         ancestor id Project1
                         and id Project3
                     """.trimIndent()

        val res = client.process(parser.parse(query))

        when (res) {
            is ResultProject -> {
                assertEquals(res.projects.size, 1)
                assertEquals(res.projects[0].description, "Project3")
            }
            else -> {
                fail("Result should be ResultProject")
            }
        }
        println(res)
    }

    fun testLogicalExpression() {
        val query = """
            find buildConf with
                trigger(val "val2" or type schedulingTrigger)
                and not (trigger val "val3" or parent id Project1)
        """.trimIndent()

        val res = client.process(parser.parse(query))

        when (res) {
            is ResultBuildConfiguration -> {
                res.buildConfs.sortBy { it.description }
                assertEquals(res.buildConfs.size, 2)
                assertEquals(res.buildConfs[0].description, "Project2_test1")
                assertEquals(res.buildConfs[1].description, "Project3_test2")
            }
            else -> {
                fail("Result should be ResultBuildConfiguration")
            }
        }
    }

    fun testBCWithProjectAncestorFilter1() {
        val query = """
            find buildConf with project (ancestor id Project3)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildConfiguration

        assertEquals(2, res.buildConfs.size)
        assertEquals(res.buildConfs[0].description, "Project4_test1")
        assertEquals(res.buildConfs[1].description, "Project5_test1")
    }

    fun testBCWithProjectFilter() {
        val query = """
            find buildConf with project (id Project3)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildConfiguration

        res.buildConfs.sortBy {it.description}
        assertEquals(4, res.buildConfs.size)
        assertEquals(res.buildConfs[0].description, "Project3_test1")
        assertEquals(res.buildConfs[1].description, "Project3_test2")
        assertEquals(res.buildConfs[2].description, "Project4_test1")
        assertEquals(res.buildConfs[3].description, "Project5_test1")
    }

    fun testProjectWithAncestorOrSelfFIlter() {
        val query = """
            find project with ancestorOrSelf (id Project3)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultProject

        res.projects.sortBy { it.description }
        assertEquals(3, res.projects.size)
        assertEquals(res.projects[0].description, "Project3")
        assertEquals(res.projects[1].description, "Project4")
        assertEquals(res.projects[2].description, "Project5")
    }

    fun testProjectParentFilter() {
        val query = """
            find project with parent id BaseProject
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultProject

        res.projects.sortBy { it.description }
        assertEquals(res.projects.size, 2)
        assertEquals(res.projects[0].description, "Project1")
        assertEquals(res.projects[1].description, "Project2")
    }

    fun testBuildConfigurationStepFilter() {
        val query = """
            find buildConf with step (param path = "abc" and type runnerType2)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildConfiguration

        res.buildConfs.sortBy { it.description }
        assertEquals(res.buildConfs.size, 1)
        assertEquals(res.buildConfs[0].description, "Project4_test1")
    }

    fun testBuildConfigurationFeatureFilter() {
        val query = """
            find buildConf with feature (param path = "qwe" and type featureType2)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildConfiguration

        res.buildConfs.sortBy { it.description }
        assertEquals(res.buildConfs.size, 1)
        assertEquals(res.buildConfs[0].description, "Project3_test2")
    }

    fun testBuildConfigurationStepEnabledFilter() {
        val query = """
            find buildConf with step(type runnerType2 and not enabled)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildConfiguration

        assertEquals(res.buildConfs.size, 1)
        assertEquals(res.buildConfs[0].description, "Project3_test2")
    }

    fun testTemplateStepFilter() {
        val query = """
            find template with step( (type temp_runner1 or type runnerType2) and enabled)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildTemplate

        assertEquals(1, res.templates.size)
        assertEquals("Project4_temp1", res.templates[0].description)
    }

    fun testBuildConfOrTempStepFilter() {
        val query = """
            find buildConfOrTemp with step( (type temp_runner1 or type runnerType2) and enabled)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildConfOrTemp

        val obj = res.buildObjects.sortedBy { it.description }
        assertEquals(3, res.buildObjects.size)
        assertEquals("Project4_temp1", obj[0].description)
        assertEquals("Project4_test1", obj[1].description)
        assertEquals("Project5_test1", obj[2].description)
    }

    fun testBuildConfDependencyOnTemp() {
        val query = """
            find buildConf with template step (type temp_runner1)
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultBuildConfiguration

        assertEquals(1, res.buildConfs.size)
        assertEquals("Project5_test1", res.buildConfs[0].description)
    }

    fun testVcsRootWithProjectAndTypeFilter() {
        val query = """
            find vcsRoot in Project4 with type jetbrains.git or id Project3_vcs1
        """.trimIndent()

        val res = client.process(parser.parse(query)) as ResultVcsRoot

        assertEquals(1, res.vcsRoots.size)
        assertEquals("Project5_vcs1", res.vcsRoots[0].description)
    }
}