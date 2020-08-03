package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.*
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
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
        compl = CompletionManager(myFixture.projectManager)
        val taskQueue = TaskQueue(compl, updatePeriod, 0, TimeUnit.MILLISECONDS)

        eventListener = AutocompletionEventListener(taskQueue ,myFixture.projectManager,  myFixture.eventDispatcher)
    }

    fun testAddBuildConfiguration() {
        val project = myFixture.project
        project.createBuildType("test1", "test1")

        sleep(2 * updatePeriod)

        val vars = compl.buildConfIdFinder.completeString("te", 10)
        val expected = listOf("test1")

        assertEquals(expected, vars)
    }

    fun testAddTemplate() {
        val temp = myFixture.project.createBuildTypeTemplate("temp1", "temp1")
        persist(temp)

        sleep(2 * updatePeriod)

        val vars = compl.templateIdFinder.completeString("te", 10)
        val expected = listOf("temp1")

        assertEquals(expected, vars)
    }

    fun testAddBuildTrigger() {
        myFixture.buildType.addBuildTrigger("vcsTrigger", mapOf(Pair("path", "abc")))
        persist(myFixture.buildType)

        sleep(2 * updatePeriod)
        val vars = compl.triggerTypeFinder.completeString("vc", 10)
        val expected = listOf("vcsTrigger")

        assertEquals(expected, vars)
    }

    fun testAddProject() {
        myFixture.createProject("Project1", "Project1")

        sleep(updatePeriod * 2)
        val vars = compl.projectIdFinder.completeString("Pr", 10)
        val expected = listOf("Project1")

        assertEquals(expected, vars)
    }

    fun testAddVcsRoot() {
        myFixture.registerVcsSupport("git")
        val vcs = myFixture.project.createVcsRoot("git", "abacaba", "name")
        persist(vcs)

        sleep(2 * updatePeriod)
        val vars = compl.vcsRootIdFinder.completeString("aba", 10)
        val expected = listOf("abacaba")

        assertEquals(expected, vars)
    }
}