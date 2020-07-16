package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.CompletionManager
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase

import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

@Test
class CompletionManagerTriggerParamTests : BaseServerTestCase() {

    private lateinit var compl: CompletionManager

    @BeforeClass
    override fun setUp() {
        super.setUp()
        val project1 = myFixture.createProject("Base1111", "Base1111")
        val bc1 = project1.createBuildType("bt1", "bt1")
        val temp1 = project1.createBuildType("temp1", "temp1")

        bc1.addBuildTrigger("vcsTrigger", mapOf(Pair("path", "abc"), Pair("abc", "bcd"), Pair("pathabc", "abc")))
        temp1.addBuildTrigger("vcsTrigger", mapOf(Pair("path", "abd"), Pair("abc", "bcd")))

        compl = CompletionManager(myFixture.projectManager)
    }

    
    fun testParamNameCompletion() {
        val vars = compl.completeString("pat", "trigger_param", 10)
        val expected = listOf("h", "habc")

        assertEquals(expected, vars)
    }

    
    fun testValueCompletion() {
        val vars = compl.completeString("path =  \"a", "trigger_param",10).toSet()
        val expected = setOf("bc", "bd")

        assertEquals(expected, vars)
    }

    
    fun testValueCompletion2() {
        val vars = compl.completeString("abc =  \"", "trigger_param", 10)
        val expected = listOf("bcd")

        assertEquals(expected, vars)
    }

    
    fun testWrongInput() {
        val vars = compl.completeString("path = \"a ", "trigger_param", 10)

        assertEquals(emptyList<String>(), vars)
    }
}