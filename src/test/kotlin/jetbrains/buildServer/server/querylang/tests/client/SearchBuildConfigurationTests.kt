package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class SearchBuildConfigurationTests : BaseQueryLangTest() {

    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TVcsRoot("vcs1", "git",
                TParam("path", "abc"),
                TOption("qwerty", "bcd")
            ),
            TBuildConf("test1",
                TOption("abc", "bcd"),
                TParam("path", "abccaba")
            ).bind("b1"),
            TBuildConf("test2",
                TParam("path", "abacaba")
            ).bind("b2")
        ).create()
    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addBCCase(
            "find buildConfiguration with id test2",
            "b2"
        )
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase(
            "find co",
            "configuration"
        )
        .addComplCase(
            "find buildConfigura"
        )
        .addComplCase(
            "find buildConfiguration with trigger ty",
            "type"
        )
        .addComplCase(
            "find configuration with option a",
            "abc"
        )
        .addComplCase(
            "find configuration with option abc=",
            "abc=bcd"
        )
        .addComplCase(
            "find configuration with param pa",
            "path"
        )
        .addComplCase(
            "find configuration with param path=aba",
            "path=abacaba"
        )
        .addComplCase(
            "find configuration with vcs type g",
            "git"
        )
        .addComplCase(
            "find configuration with vcs param pa",
            "path"
        )
        .addComplCase(
            "find configuration with vcs param path=a",
            "path=abc"
        )
        .addComplCase(
            "find configuration with vcs id BaseProject_",
            "BaseProject_Vcs1"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()

        .end()

    @DataProvider(name = "eval")
    fun evalData() = TestDataProvider()
        .addBCCase(
            "find buildConfiguration with id test1",
            "b1"
        )
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
        Thread.sleep(50)
        checkVars(query, expected)
    }

    @Test(dataProvider = "eval")
    fun evalTest(query: String, expected: List<String>) {
        Thread.sleep(50)
        checkEval(query, expected)
    }
}