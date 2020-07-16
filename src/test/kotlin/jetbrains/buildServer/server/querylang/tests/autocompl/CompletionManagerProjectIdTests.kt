package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.CompletionManager
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

@Test
internal class CompletionManagerProjectIdTests : BaseServerTestCase() {

    private lateinit var compl: CompletionManager

    @BeforeClass
    override fun setUp() {
        super.setUp()

        val base = myFixture.createProject("Base", "Base")
        val project1 = myFixture.createProject("Base_Project1", "Base_Project1", base)
        val project2 = myFixture.createProject("Base_Project2", "Base_Project2", base)
        val project3 = myFixture.createProject("Base_Project2_Project3", "Base_Project2_Project3", project2)
        val project4 = myFixture.createProject("Base_Project2_Project4", "Base_Project2_Project4", project2)
        val project5 = myFixture.createProject("Base_Project2_Project5", "Base_Project2_Project5", project2)
        val project6 = myFixture.createProject("Base_Project2_Project3_Project6", "Base_Project2_Project3_Project6", project3)
        val project7 = myFixture.createProject("Base_Project2_Project4_Project7", "Base_Project2_Project4_Project7", project4)

        compl = CompletionManager(myFixture.projectManager)
    }

    @Test
    fun test1() {
        val vars = compl.completeString("Base_Project2_", "project_id", 4)
        val expected = listOf(
                "Project3",
                "Project4",
                "Project5",
                "Project3_Project6"
        )

        assertEquals(expected, vars)
    }
}