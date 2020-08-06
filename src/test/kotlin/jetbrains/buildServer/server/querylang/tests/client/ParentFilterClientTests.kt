package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class ParentFilterClientTests : BaseQueryLangTest() {
    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TVcsRoot("vcs1", "git").bind("v1"),
            TTemplate("temp2").bind("t2"),
            TProject("Project1",
                TBuildConf("BuildConf2").bind("b2")
            ).bind("p1"),
            TProject("Project2",
                TTemplate("temp1").bind("t1"),
                TVcsRoot("vcs2", "git").bind("v2"),
                TBuildConf("BuildConf3",
                    TTempDependency("t1")
                ).bind("b3")
            ).bind("p2"),
            TBuildConf("BuildConf1").bind("b1")
        ).create()

    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addProjectCase(
            "find project with parent id BaseProject",
            "p1", "p2"
        )
        .addBCCase(
            "find buildConfiguration with parent id BaseProject",
            "b1"
        )
        .addBCCase(
            "find buildConfiguration with parent id Project*",
            "b2", "b3"
        )
        .addTempCase(
            "find template with parent id *2",
            "t1"
        )
        .addBCCase(
            "find buildConfiguration with template parent id *2",
            "b3"
        )
        .addVcsCase(
            "find vcsRoot with parent id Project2",
            "v2"
        )
        .addVcsCase(
            "find vcsRoot with parent parent id BaseProject",
            "v2"
        )
        .addCase(
            "find buildConfiguration, template, project, vcsRoot with parent id BaseProject",
            "BuildConf1", "BaseProject_Vcs1", "temp2", "Project1", "Project2"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()
        .addParseCase("find buildConfiguration with trigger parent id BaseProject")
        .addParseCase("find project, parent with id BaseProject")
        .addParseCase("find project with parent BaseProject")
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