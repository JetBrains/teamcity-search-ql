package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.*
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.lang.Thread.sleep

@Test
class AutocompletionUpdateTests : BaseServerTestCase(){
    private lateinit var compl: CompletionManager
    private lateinit var eventListener: AutocompletionEventListener

    @BeforeClass
    override fun setUp() {
        super.setUp()
        compl = CompletionManager(myFixture.projectManager)

        eventListener = AutocompletionEventListener(TaskQueue(compl),myFixture.projectManager,  myFixture.eventDispatcher)
    }

    fun testAddBuildConfiguration() {
        val project = myFixture.project
        project.createBuildType("test1", "test1")

        println(compl.buildConfIdFinder.completeString("te", 10))
    }
}