package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFailsWith

class SearchProjectTests : BaseQueryLangTest() {

    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TProjectFeature("pfeat1", Pair("path", "abc")),
            TParam("refpath1", "abacaba%root-path%dababa"),

            TProject("Project1",
                TTemplate("Template1"),
                TProjectFeature("qwerty", Pair("abc", "bcd")),
                TParam("param1", "abc"),
                TParam("refpath2", "abacaba%full-path%dababa"),
                TProject("Project2",
                    TParam("param2", "def"),
                    TParam("param3", "%param1%")
                ).bind("p2")
            ).bind("p1"),

            TProject("Project3",
                TProjectFeature("pfeat2"),
                TBuildConf("BuildConf1")
            ).bind("p3")

        ).bind("p0")
            .create(myFixture.projectManager.rootProject, true)

    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addProjectCase(
            "find project with feature type pfeat1",
            "p0"
        )
        .addProjectCase(
            "find project with feature[withInherited] type pfeat1",
            "p0", "p1", "p2", "p3"
        )
        .addProjectCase(
            "find project with feature param abc=bcd",
            "p1"
        )
        .addProjectCase(
            "find project with param param1=abc",
            "p1"
        )
        .addProjectCase(
            "find project with param[withInherited] param1=abc",
            "p1", "p2"
        )
        .addProjectCase(
            """find project with val *"%full-path%"* """,
            "p1"
        )
        .addProjectCase(
            """find project with val *"path%"* """,
            "p0", "p1"
        )
        .addProjectCase(
            "find project with name BaseProject",
            "p0"
        )
        .addProjectCase(
            "find project with param[resolved] * = abc",
            "p1", "p2"
        )
        .addProjectCase(
            "find project with param * = abc",
            "p1"
        )
        .addProjectCase(
            "find project with id BaseProject or id Project1 or name asdfasdfasdfa",
            "p0", "p1"
        )
        .addProjectCase(
            "find project with configuration id BuildConf1",
            "p3"
        )
        .addProjectCase(
            "find project with template id Template1",
            "p1"
        )
        .addProjectCase(
            "find project with subProject param param2=def",
            "p1"
        )
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase(
            "find proje",
            "project"
        )
        .addComplCase(
            "find project",
            "project"
        )
        .addComplCase(
            "find project with fe",
            "feature"
        )
        .addComplCase(
            "find project with feature ty",
            "type"
        )
        .addComplCase(
            "find project with feature type pf",
            "pfeat1", "pfeat2"
        )
        .addComplCase(
            "find project with feature param pa",
            "path"
        )
        .addComplCase(
            "find project with feature param path=",
            "path=abc"
        )
        .addComplCase(
            "find project with para",
            "param"
        )
        .addComplCase(
            "find project with param par",
            "param1", "param2", "param3"
        )
        .addComplCase(
            "find project with param param1=a",
            "param1=abc"
        )
        .addComplCase(
            "find project with nam",
            "name"
        )
        .addComplCase(
            "find project with name BasePr",
            "BaseProject"
        )
        .addComplCase(
            "find project with confi",
            "configuration"
        )
        .addComplCase(
            "find project with temp",
            "template"
        )
        .addComplCase(
            "find project with su",
            "subProject"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()

        .end()

    @DataProvider(name = "eval")
    fun evalData() = TestDataProvider()
        .addNoneEvalCase(
            "find project with (id (BaseProject or Project2) or id Project3) and (not param param2=def)",
            "BaseProject", "Project3"
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