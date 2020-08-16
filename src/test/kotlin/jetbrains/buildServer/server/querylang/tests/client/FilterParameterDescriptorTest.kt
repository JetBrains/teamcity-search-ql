package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class FilterParameterDescriptorTest : BaseQueryLangTest() {
    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TTemplate("temp1",
                TTrigger("vcsTrigger"),
                TStep("step1"),
                TFeature("feature1")
            ).bind("t1"),

            TBuildConf("test1",
                TTrigger("vcsTrigger"),
                TStep("step1"),
                TFeature("feature1")
            ).bind("b1"),

            TBuildConf("test2",
                TTrigger("schTrigger"),
                TStep("step2"),
                TFeature("feature2"),
                TTempDependency("t1")
            ).bind("b2"),

            TBuildConf("test3",
                TTrigger("trigger", Pair("path", "abc")),
                TStep("step", Pair("abc", "def")),
                TFeature("feature", Pair("asd", "fgh")),
                TFeature("feature2", Pair("abc", "")),
                TStep("step22", Pair("abc-bcd", "qwe-rty"))
            ).bind("b3")
        ).create()
    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addBCCase(
            "find buildConfiguration with trigger type vcsTrigger",
            "b1"
        )
        .addBCCase(
            "find buildConfiguration with step type step1",
            "b1"
        )
        .addBCCase(
            "find buildConfiguration with feature type feature1",
            "b1"
        )
        .addBCCase(
            "find buildConfiguration with trigger[all] type vcsTrigger",
            "b1", "b2"
        )
        .addBCCase(
            "find buildConfiguration with step[all] type step1",
            "b1", "b2"
        )
        .addBCCase(
            "find buildConfiguration with feature[all] type feature1",
            "b1", "b2"
        )
        .addBCCase(
            "find buildConfiguration with trigger param path=abc and step param abc=def and feature param asd=fgh",
            "b3"
        )
        .addTempCase(
            "find template with trigger type vcsTrigger and step type step1 and feature type feature1",
            "t1"
        )
        .addBCCase(
            "find configuration with feature param asd=*",
            "b3"
         )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()
        .addParseCase("find buildConfiguration with trigger[all vcsTrigger")
        .addParseCase("find project with trigger type vcsTrigger")
        .addParseCase("find buildConfiguration with trigger par abc=bcd")
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase("find configuration with feature param abc=",
            "abc=\"\""
        )
        .addComplCase(
            "find configuration with step param abc-",
            "abc-bcd"
        )
        .addComplCase(
            "find configuration with step param abc-bcd=qwe-",
            "abc-bcd=qwe-rty"
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
}