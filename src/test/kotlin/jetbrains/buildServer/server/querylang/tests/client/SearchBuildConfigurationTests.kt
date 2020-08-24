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
            TTemplate("temp1").bind("t1"),
            TBuildConf("test1",
                TOption("abc", "bcd"),
                TParam("path", "abccaba"),
                TOption("op1", "%path%"),
                TTempDependency("t1")
            ).bind("b1"),
            TBuildConf("test2",
                TParam("path", "abacaba"),
                TTrigger("vcs", Pair("asdcacd", "kjkkkk")),
                TStep("steptype11", Pair("asdfwqe", "dffd")),
                TFeature("feature11", Pair("qweqfhsdf", "xzxc")),
                TTrigger("sch", Pair("resolvedParam1", "root/user/%path%"))
            ).bind("b2"),
            TBuildConf("buildConfiguration1").bind("b3"),

            TProject("Project1",
                TBuildConf("BC1",
                    TTrigger("vcsTrigger")
                ),
                TBuildConf("BC2",
                    TTrigger("schTrigger")
                )
            ).bind("p1")
        ).create()
    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addBCCase(
            "find buildConfiguration with id test2",
            "b2"
        )
        .addBCCase(
            "find buildConfiguration with val abccaba",
            "b1"
        )
        .addBCCase(
            "find configuration with val kjkkkk and val dffd and val xzxc",
            "b2"
        )
        .addBCCase(
            "find configuration with val bcd",
            "b1"
        )
        .addBCCase("find configuration with name test1",
        "b1"
        )
        .addBCCase(
            """find configuration with trigger param[resolved] * = *"/abacaba" """,
            "b2"
        )
        .addBCCase(
            """find configuration with trigger param * = *"%path%" """,
            "b2"
        )
        .addBCCase(
            "find configuration with option[resolved] * = abccaba",
            "b1"
        )
        .addBCCase(
            "find configuration with option * = \"%path%\" ",
            "b1"
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
        .addComplCase(
            "find configuration with na",
            "name"
        )
        .addComplCase(
            "find configuration with name buil",
            "buildConfiguration1"
        )
        .addComplCase(
            "find configuration with trigger[all, wi",
            "withInherited"
        )
        .addComplCase(
            "find configuration with parent id Project1 and id ?",
            "BC1", "BC2"
        )
        .addComplCase(
            "find configuration with id test2 and trigger type ?",
            "vcs", "sch"
        )
        .addComplCase(
            "find configuration with id test2 and param ?",
            "path"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()

        .end()

    @DataProvider(name = "eval")
    fun evalData() = TestDataProvider()
        .addNoneEvalCase(
            "find buildConfiguration with id test1",
            "test1"
        )
        .addNoneEvalCase(
            "find configuration with parent id Project1 and trigger type vcsTrigger",
            "BC1"
        )
        .addNoneEvalCase(
            "find configuration with template parent id BaseProject",
            "test1"
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
        waitForIndexing()
        checkVars(query, expected)
    }

    @Test(dataProvider = "eval")
    fun evalTest(query: String, expected: List<String>) {
        waitForIndexing()
        checkEval(query, expected)
    }
}