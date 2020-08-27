package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import jetbrains.buildServer.util.StringOption
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class FilterOptionClientTests : BaseQueryLangTest() {
    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TTemplate("temp1",
                TOption("path", "abc")
            ).bind("t1"),

            TTemplate("temp2",
                TOption("cleanBuild", "true")
            ).bind("t2"),

            TBuildConf("test1",
                TOption("path", "abc")
            ).bind("b1"),

            TBuildConf("test2",
                TOption("abc", "bcd"),
                TTempDependency("t1")
            ).bind("b2")
        ).create()
    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addBCCase(
            "find buildConfiguration with option (*at*)=(*bc)",
            "b1", "b2"
        )
        .addBCCase(
            "find buildConfiguration with option path=abc",
            "b1", "b2"
        )
        .addBCCase(
            "find buildConfiguration with template option path=abc",
            "b2"
        )
        .addTempCase(
            "find template with option path=abc",
            "t1"
        )
        .addTempCase(
            "find template with option cleanBuild=false",
            "t1"
        )
        .addTempCase(
            "find template with option cleanBuild=true",
            "t2"
        )
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase(
            "find template with option cleanB",
            "cleanBuild"
        )
        .addComplCase(
            "find template with op",
            "option"
        )
        .addComplCase(
            "find template with option cleanBuild=",
            "cleanBuild=false", "cleanBuild=true"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()
        .addParseCase("find project with option abc=path")
        .addParseCase("find buildConfiguration with trigger option path=abc")
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
        waitForIndexing()
        checkVars(query, expected)
    }
}