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

            TProject("Project1",
                TProjectFeature("qwerty", Pair("abc", "bcd")),
                TParam("param1", "abc"),
                TProject("Project2",
                    TParam("param2", "def")
                ).bind("p2")
            ).bind("p1"),

            TProject("Project3",
                TProjectFeature("pfeat2")
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
            "find project with feature[all] type pfeat1",
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
            "find project with param[all] param1=abc",
            "p1", "p2"
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
            "param1", "param2"
        )
        .addComplCase(
            "find project with param param1=a",
            "param1=abc"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()

        .end()

    @DataProvider(name = "eval")
    fun evalData() = TestDataProvider()
        .addNoneEvalCase(
            "find project with id BaseProject",
            "BaseProject"
        )
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
        Thread.sleep(50)
        checkVars(query, expected)
    }

    @Test(dataProvider = "eval")
    fun evalTest(query: String, expected: List<String>) {
        Thread.sleep(50)
        checkEval(query, expected)
    }
}