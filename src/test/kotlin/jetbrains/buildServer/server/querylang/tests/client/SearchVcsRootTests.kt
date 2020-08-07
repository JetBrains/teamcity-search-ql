package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class SearchVcsRootTests : BaseQueryLangTest() {

    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject(
            "BaseProject",
            TVcsRoot("vcs1", "git",
                TParam("param1", "abc")
            ).bind("v1"),

            TVcsRoot("vcs2", "git",
                TParam("param1", "def")
            ).bind("v2")

        ).create()

    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addVcsCase(
            "find vcsRoot with param param1=abc",
            "v1"
        )
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase(
            "find vcs",
            "vcsRoot"
        )
        .addComplCase(
            "find vcsRoot with para",
            "param"
        )
        .addComplCase(
            "find vcsRoot with param pa",
            "param1"
        )
        .addComplCase(
            "find vcsRoot with param param1=",
            "param1=abc", "param1=def"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()

        .end()


    @Test(dataProvider = "data")
    fun parametrizedTest(query: String, expected: List<String>) {
        val actual = getIds(query)

        BaseServerTestCase.assertEquals(expected.sorted(), actual)
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
}