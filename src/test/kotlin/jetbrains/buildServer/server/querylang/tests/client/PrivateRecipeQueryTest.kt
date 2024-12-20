package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class PrivateRecipeQueryTest : BaseQueryLangTest() {

    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject(
            "BaseProject"

        ).create()

    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addCase("find privateRecipe with id intellij*")
        .addCase("find privateRecipe with step type ABC")
        .addCase("find privateRecipe with name Runner")
        .addCase("find privateRecipe with param path=abc")
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase(
            "find pr",
            "privateRecipe"
        )
        .addComplCase(
            "find privateRecipe with n",
            "name"
        )
        .addComplCase(
            "find privateRecipe with i",
            "id"
        )
        .addComplCase(
            "find privateRecipe with ",
            "id",
            "name",
            "param",
            "parent",
            "project",
            "step"
            )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()

        .end()

    @DataProvider(name = "eval")
    fun evalData() = TestDataProvider()

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

    @Test(dataProvider = "eval")
    fun evalTest(query: String, expected: List<String>) {
        waitForIndexing()
        checkEval(query, expected)
    }
}