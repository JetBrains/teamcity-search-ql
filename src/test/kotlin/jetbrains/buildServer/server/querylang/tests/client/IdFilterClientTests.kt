package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class IdFilterClientTests : BaseQueryLangTest() {

    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject("Project1",
            TTemplate("Project1_temp1").bind("1"),
            TProject(
                "Project1_Project2",
                TBuildConf("Project1_Project2_test1", TTempDependency("1"))
            ),
            TProject("Project1_Project3")
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
            "find buildConfiguration with template id Project1*",
            "Project1_Project2_test1"
        )
        .end()

    @Test(dataProvider = "idFilterData")
    fun parametrizedIdTest(query: String, expected: List<String>) {
        val actual = getIds(query)

        assertEquals(expected, actual)
    }
}