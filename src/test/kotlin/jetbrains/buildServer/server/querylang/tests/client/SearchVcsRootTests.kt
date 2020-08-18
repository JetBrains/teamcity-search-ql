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
            TParam("param11", "qwerty"),
            TVcsRoot("vcs1", "git",
                TParam("param1", "abc"),
                TParam("param2", "%param11%")
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
        .addVcsCase(
            "find vcsRoot with val *bc",
            "v1"
        )
        .addVcsCase(
            "find vcsRoot with name vcs1",
            "v1"
        )
        .addVcsCase(
            "find vcsRoot with param[resolved] * = qwerty",
            "v1"
        )
        .addVcsCase(
            """find vcsRoot with param[resolved] * = "%param11%" """
        )
        .addVcsCase(
            """find vcsRoot with param * = "%param11%" """,
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
            "param1", "param2"
        )
        .addComplCase(
            "find vcsRoot with param param1=",
            "param1=abc", "param1=def"
        )
        .addComplCase(
            "find vcsRoot with id BaseProject_",
            "BaseProject_Vcs1", "BaseProject_Vcs2"
        )
        .addComplCase(
            "find vcsRoot with na",
            "name"
        )
        .addComplCase(
            "find vcsRoot with name vc",
            "vcs1", "vcs2"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()

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
}