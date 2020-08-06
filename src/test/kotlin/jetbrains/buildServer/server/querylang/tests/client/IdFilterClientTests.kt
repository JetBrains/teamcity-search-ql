package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class IdFilterClientTests : BaseQueryLangTest() {

    @BeforeMethod
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
        ).addTempCase(
            "find template with id *temp1",
            "te1"
        ).addVcsCase(
            "find vcsRoot with id *Vcs1 and project id Project1",
            "vcs1"
        ).addCase(
            "find project, template, vcsRoot, buildConfiguration with id *2*",
            "Project1_temp2", "Project1_Vcs2", "Project1_Project2", "Project1_Project2_test1"
        )
        .end()

    @DataProvider(name = "idFilterFailed")
    fun idFaildedData() = TestFailedDataProvdier()
        .addParseCase("find buildConf with id Base")
        .addParseCase("find buildConfiguration with trigger id Base")
        .addParseCase("find with id Base")
        .addParseCase("find buildConfiguration, template with template id *Project*")
        .addParseCase("find buildConfiguration with id **abacaba*")
        .addParseCase("find buildConfiguration with id \"abacaba\"abadaba\"")
        .end()


    @Test(dataProvider = "idFilterData")
    fun parametrizedIdTest(query: String, expected: List<String>) {
        val actual = getIds(query)

        assertEquals(expected.sorted(), actual)
    }

    @Test(dataProvider = "idFilterFailed")
    fun parametrizedFailedParsingTest(query: String, exc: Class<out Exception>) {
        assertFailsWith(exc.kotlin) {QueryParser.parse(query)}
    }
}