package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import jetbrains.buildServer.util.StringOption
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class FilterOptionClientTests : BaseQueryLangTest() {
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TTemplate("temp1",
                TOption("path", "abc")
            ).bind("t1"),

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
            "b1"
        )
        .addBCCase(
            "find buildConfiguration with option[all] path=abc",
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
}