package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.CompletionManager
import jetbrains.buildServer.serverSide.ServerListener
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import jetbrains.buildServer.util.EventDispatcher
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

@Test
class CompletionManagerStepParamTests : BaseServerTestCase() {

    private lateinit var compl: CompletionManager
    @BeforeClass
    override fun setUp() {
        super.setUp()
        val project1 = myFixture.createProject("Base1111", "Base1111")
        val bc1 = project1.createBuildType("bt1", "bt1")
        val temp1 = project1.createBuildType("temp1", "temp1")

        bc1.addBuildRunner("vcsTrigger", "a", mapOf(Pair("path", "abc"), Pair("abc", "bcd"), Pair("pathabc", "abc")))
        temp1.addBuildRunner("vcsTrigger", "a", mapOf(Pair("path", "abd"), Pair("abc", "bcd")))

        compl = CompletionManager(myFixture.projectManager, myFixture.securityContext, myFixture.eventDispatcher as EventDispatcher<ServerListener>)

        compl.indexAll()
    }

    fun testParamNameCompletion() {
        val vars = compl.completeString("pat", "step_param", 10).map {it.str}
        val expected = listOf("path", "pathabc")

        assertEquals(expected, vars)
    }

    fun testValueCompletion() {
        val vars = compl.completeString("path =  \"a", "step_param", 10).map {it.str}.toSet()
        val expected = setOf("path=abc", "path=abd")

        assertEquals(expected, vars)
    }

    
    fun testValueCompletion2() {
        val vars = compl.completeString("abc =  \"", "step_param", 10).map {it.str}
        val expected = listOf("abc=bcd")

        assertEquals(expected, vars)
    }

    
    fun testWrongInput() {
        val vars = compl.completeString("path = \"a ", "step_param", 10)

        assertEquals(emptyList<String>(), vars)
    }
}