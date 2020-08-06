package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class FilterDependencyClientTests : BaseQueryLangTest() {
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TBuildConf("btest1").bind("b1"),

            TProject("Project2",
                TBuildConf("btest3").bind("b3")
            ),

            TBuildConf("btest2",
                TSDependency("b3")
            ).bind("b2"),

            TBuildConf("btest4",
                TADependency("b2")
            ).bind("b4"),

            TTemplate("temp1",
                TSDependency("b4",
                    TOption("opt1", "bcd")
                )
            ).bind("t1"),

            TTemplate("temp2",
                TADependency("b4")
            ).bind("t2"),

            TTemplate("temp3",
                TSDependency("b3",
                    TOption("opt1", "abc")
                )
            ).bind("t3"),

            TBuildConf("test5",
                TTempDependency("t1"),
                TADependency("b3")
            ).bind("b5"),

            TBuildConf("test6",
                TADependency("b4")
            ).bind("b6")
        ).create()
        
    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addBCCase(
            "find buildConfiguration with dependency (id *3 and snapshot)",
            "b2"
        )
        .addBCCase(
            "find buildConfiguration with dependency (dependency(id *3 and snapshot) and artifact)",
            "b4"
        )
        .addTempCase(
            "find template with dependency (id *4 and snapshot)",
            "t1"
        )
        .addTempCase(
            "find template with dependency (id *4 and artifact)",
            "t2"
        )
        .addBCCase(
            "find buildConfiguration with dependency (id *4 and (snapshot or artifact))",
            "b6"
        )
        .addBCCase(
            "find buildConfiguration with dependency[all] (id *4 and (snapshot or artifact))",
            "b5", "b6"
        )
        .addTempCase(
            "find template with dependency (snapshot option opt1=abc)",
            "t3"
        )
        .addBCCase(
            "find buildConfiguration with dependency[all] (snapshot option opt1=bcd)",
            "b5"
        )
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase(
            "find buildConfiguration with dep",
            "dependency"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()
        .addParseCase("find buildConfiguration with dependency type vcs")
        .addParseCase("find project with dependency id Base")
        .addParseCase("find vcsRoot with dependency")
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

    @Test(dataProvider = "compl")
    fun parametrizedCompletionTests(query: String, expected: List<String>) {
        checkVars(query, expected)
    }
}