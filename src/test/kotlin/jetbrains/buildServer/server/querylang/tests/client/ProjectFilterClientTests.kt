package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.myParameterManager
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class ProjectFilterClientTests: BaseQueryLangTest() {
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
                TParam("qwerty", "fhd%root-path%abacaba"),
                TBuildConf("Project1_Project2_test1", TTempDependency("te1")).bind("p2b1"),
                TBuildConf("Project1_Project2_test2").bind("p2b2")
            ),
            TProject(
                "Project1_Project3",
                TVcsRoot("vcs31", "git").bind("vcs3"),
                TTemplate("Project1_Project3_temp1").bind("te3"),
                TBuildConf(
                    "Project1_Project3_test1",
                    TTempDependency("te2"),
                    TVcsInst("vcs1")
                ).bind("p3b1")
            ).modify { it.setArchived(true, null); it }
        ).create()
    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addBCCase(
            "find buildConfiguration in Project1_Project2",
            "p2b1", "p2b2"
        )
        .addBCCase(
            "find buildConfiguration in Project1_Project2 with id *test1",
            "p2b1"
        )
        .addTempCase(
            "find template with project id Project1 and id *temp1",
        "te1", "te3"
        )
        .addVcsCase(
            "find vcsRoot with project id Project1 and id *1",
            "vcs1", "vcs3"
        )
        .addCase(
            "find project, template, buildConfiguration, vcsRoot with project id *Project3",
            "Project1_Project3_temp1", "Project1_Project3_test1", "Project1_Project3_Vcs31", "Project1_Project3"
        )
        .addBCCase(
            "find buildConfiguration with id *_test* and project archived",
            "p3b1"
        )
        .addBCCase(
            "find buildConfiguration with id *_test* and project (not archived)",
            "p2b1", "p2b2", "p3b1" // because p3b1 has ancestor which is not archived
        )
        .end()

    @DataProvider(name = "failed")
    fun faileddData() = TestFailedDataProvdier()
        .addParseCase("find template with projectid Base")
        .addParseCase("find buildConfiguration with trigger project id Base")
        .end()


    @Test(dataProvider = "data")
    fun parametrizedTest(query: String, expected: List<String>) {
        val actual = getIds(query)

        assertEquals(expected.sorted(), actual)
    }

    @Test(dataProvider = "failed")
    fun parametrizedFailedParsingTest(query: String, exc: Class<out Exception>) {
        assertFailsWith(exc.kotlin) { QueryParser.parse(query)}
    }
}