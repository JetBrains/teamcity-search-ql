package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class IdFilterClientTests : BaseQueryLangTest() {

    override fun setUp() {
        super.setUp()

        TProject("Project1",
            TTemplate("Project1_temp1").bind("te1"),
            TTemplate("Project1_temp2").bind("te2"),
            TVcsRoot("vcs1", "git").bind("vcs1"),
            TVcsRoot("vcs2", "git").bind("vcs2"),
            TProject(
                "Project1_Project2",
                TBuildConf("Project1_Project2_test1", TTempDependency("te1"))
            ),
            TProject(
                "Project1_Project3",
                TBuildConf(
                    "Project1_Project3_test1",
                    TTempDependency("te2"),
                    TVcsInst("vcs1")
                ).bind("p3b1")
            )
        ).create()
    }

    @DataProvider(name = "idFilterData")
    fun idDataProvider() = TestDataProvider()
        .addCase(
            "find project with parent id Project1",
            "Project1_Project2", "Project1_Project3"
        )
        .addCase(
            "find buildConfiguration with id *Project2*",
            "Project1_Project2_test1"
        )
        .addCase(
            "find buildConfiguration with template id *temp2",
            "Project1_Project3_test1"
        )
        .addCase(
            "find buildConfiguration with project ancestor id *Project3"
        )
        .addBCCase(
            "find buildConfiguration with parent id *Project3",
            "p3b1"
        )
        .end()


    @Test(dataProvider = "idFilterData")
    fun parametrizedIdTest(query: String, expected: List<String>) {
        val actual = getIds(query)

        assertEquals(expected, actual)
    }
}