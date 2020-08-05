package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class FilterTypeTests : BaseQueryLangTest() {
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TVcsRoot("vcs1", "gitVcs").bind("v1"),
            TTemplate("temp1",
                TTrigger("vcsTrigger"),
                TStep("stepType1"),
                TFeature("featType1")
            ).bind("t1"),
            TBuildConf("test1",
                TTrigger("vcsTrigger"),
                TStep("stepType1"),
                TFeature("featType1")
            ).bind("b1"),
            TBuildConf("test2",
                TTrigger("schTrigger"),
                TTrigger("tri\"g"),
                TStep("stepType2"),
                TFeature("featType2")
            ).bind("b2")
        ).create()

    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addVcsCase(
            "find vcsRoot with type gitVcs",
            "v1"
        )
        .addBCCase(
            "find buildConfiguration with trigger type vcsTrigger",
            "b1"
        )
        .addBCCase(
            "find buildConfiguration with step type stepType2",
            "b2"
        )
        .addBCCase(
            "find buildConfiguration with feature type featType2",
            "b2"
        )
        .addTempCase(
            "find template with feature type featType1 and step type stepType1 and trigger type vcs*",
            "t1"
        )
        .addBCCase(
            "find buildConfiguration with trigger type \"tri\"\"g\"",
            "b2"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()
        .addParseCase("find buildConfiguration with type vcsTrigger")
        .addParseCase("find project with id type vcs")
        .addParseCase("find project with type ")
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