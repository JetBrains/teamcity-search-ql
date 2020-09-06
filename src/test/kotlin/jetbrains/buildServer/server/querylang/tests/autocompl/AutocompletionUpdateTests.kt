package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.*
import jetbrains.buildServer.serverSide.ServerListener
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import jetbrains.buildServer.util.EventDispatcher
import jetbrains.buildServer.util.WaitFor
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

@Test
class AutocompletionUpdateTests : BaseServerTestCase(){
    private lateinit var compl: CompletionManager
    private lateinit var eventListener: AutocompletionEventListener
    private val updatePeriod: Long = 100

    @BeforeMethod
    override fun setUp() {
        super.setUp()
        compl = CompletionManager(myFixture.projectManager, myFixture.securityContext, myFixture.eventDispatcher as EventDispatcher<ServerListener>)
        val taskQueue = TaskQueue(compl, updatePeriod, 0, TimeUnit.MILLISECONDS)

        eventListener = AutocompletionEventListener(taskQueue ,myFixture.projectManager,  myFixture.eventDispatcher)
        eventListener.serverStartup()
    }

    fun testAddBuildConfiguration() {
        val project = myFixture.project
        project.createBuildType("test1", "test1")

        sleep(2 * updatePeriod)

        val vars = compl.completeString("te", "configuration_id", 10).map {it.str}
        val expected = listOf("test1")

        assertEquals(expected, vars)
    }

    fun testAddTemplate() {
        val temp = myFixture.project.createBuildTypeTemplate("temp1", "temp1")
        persist(temp)

        sleep(2 * updatePeriod)

        val vars = compl.completeString("te", "template_id", 10).map {it.str}
        val expected = listOf("temp1")

        assertEquals(expected, vars)
    }

    fun testAddBuildTrigger() {
        myFixture.buildType.addBuildTrigger("vcsTrigger", mapOf(Pair("path", "abc")))
        persist(myFixture.buildType)

        sleep(2 * updatePeriod)
        val vars = compl.completeString("vc", "trigger_type", 10).map {it.str}
        val expected = listOf("vcsTrigger")

        assertEquals(expected, vars)
    }

    fun testAddProject() {
        myFixture.createProject("Project1", "Project1")

        sleep(updatePeriod * 2)
        val vars = compl.completeString("Pr", "project_id", 10).map {it.str}
        val expected = listOf("Project1")

        assertEquals(expected, vars)
    }

    fun testAddVcsRoot() {
        myFixture.registerVcsSupport("git")
        val vcs = myFixture.project.createVcsRoot("git", "abacaba", "name")
        persist(vcs)

        sleep(2 * updatePeriod)
        val vars = compl.completeString("aba", "vcsRoot_id", 10).map {it.str}
        val expected = listOf("abacaba")

        assertEquals(expected, vars)
    }
}