package jetbrains.buildServer.server.querylang.tests.client

import jetbrains.buildServer.artifacts.RevisionRules
import jetbrains.buildServer.server.querylang.parser.QueryParser
import jetbrains.buildServer.server.querylang.tests.BaseQueryLangTest
import org.testng.annotations.*
import java.lang.Thread.sleep
import kotlin.test.assertFailsWith

class FilterDependencyClientTests : BaseQueryLangTest() {

    @BeforeMethod
    override fun setUp() {
        super.setUp()

        TProject("BaseProject",
            TBuildConf("btest1").bind("b1"),

            TProject("Project2",
                TBuildConf("btest3").bind("b3")
            ),

            TBuildConf("btest2",
                TSDependency("b3")
            ).bind("b2"),

            TBuildConf("btest4",
                TADependency("b2", "qwerqwreqerq", false)
            ).bind("b4"),

            TTemplate("temp1",
                TSDependency("b4",
                    TOption("opt1", "bcd")
                )
            ).bind("t1"),

            TTemplate("temp2",
                TADependency("b4", "abacabadaba", false, RevisionRules.LAST_SUCCESSFUL_RULE)
            ).bind("t2"),

            TTemplate("temp3",
                TSDependency("b3",
                    TOption("opt1", "abc")
                )
            ).bind("t3"),

            TTemplate("temp4",
                TADependency("b4", "yuiouiyiioy", true)
            ).bind("t4"),

            TBuildConf("test5",
                TTempDependency("t1"),
                TTempDependency("t2"),
                TADependency("b3", "zxcvzxcvzc", true, RevisionRules.LAST_FINISHED_SAME_CHAIN_RULE),
                TSDependency("b3")
            ).bind("b5"),

            TBuildConf("test6",
                TADependency("b4", "irotiirtroi", false)
            ).bind("b6")
        ).create(true)
        
    }

    @DataProvider(name = "data")
    fun dataProvider() = TestDataProvider()
        .addBCCase(
            "find configuration with dependency (id *3 and snapshot)",
            "b2", "b5"
        )
        .addBCCase(
            "find configuration with dependency (dependency(id *3 and snapshot) and artifact)",
            "b4"
        )
        .addTempCase(
            "find template with dependency (id *4 and snapshot)",
            "t1"
        )
        .addTempCase(
            "find template with dependency (id *4 and artifact)",
            "t2", "t4"
        )
        .addBCCase(
            "find configuration with dependency (id *4 and (snapshot or artifact))",
            "b6"
        )
        .addBCCase(
            "find configuration with dependency[all] (id *4 and (snapshot or artifact))",
            "b5", "b6"
        )
        .addTempCase(
            "find template with dependency (snapshot option opt1=abc)",
            "t3"
        )
        .addBCCase(
            "find configuration with dependency[all] (snapshot option opt1=bcd)",
            "b5"
        )
        .addTempCase(
            "find template with dependency (artifact rules *bac*)",
            "t2"
        )
        .addBCCase(
            "find configuration with dependency (artifact (rules *tii*) and dependency (artifact rules *wer*))",
            "b6"
        )
        .addBCCase(
            "find configuration with dependency artifact(not clean)",
            "b6", "b4"
        )
        .addBCCase(
            "find configuration with dependency[all] artifact(not clean)",
            "b4", "b5", "b6"
        )
        .addBCCase(
            "find configuration with dependency artifact revRule *Chain*",
            "b5"
        )
        .addBCCase(
            "find configuration with dependency(artifact rules *xcv* and snapshot)",
            "b5"
        )
        .end()

    @DataProvider(name = "compl")
    fun complData() = TestDataProvider()
        .addComplCase(
            "find template with dependency snapshot option o",
            "opt1"
        )
        .addComplCase(
            "find template with dep",
            "dependency"
        )
        .addComplCase(
            "find template with dependency sn",
            "snapshot"
        )
        .addComplCase(
            "find template with dependency ar",
            "artifact"
        )
        .addComplCase(
            "find template with dependency snapshot o",
            "option"
        )
        .addComplCase(
            "find template with dependency artifact r",
            "rules", "revRule"
        )
        .addComplCase(
            "find template with dependency artifact ",
            "rules", "clean", "revRule"
        )
        .addComplCase(
            "find configuration with dependency artifact rules zxc",
            "zxcvzxcvzc"
        )
        .addComplCase(
            "find template with dependency artifact rules abac",
            "abacabadaba"
        )
        .addComplCase(
            "find template with dependency artifact c",
            "clean"
        )
        .addComplCase(
            "find configuration with dependency artifact revR",
            "revRule"
        )
        .addComplCase(
            "find configuration with dependency artifact",
            "artifact"
        )
        .addComplCase(
            "find template with dependency artifact revRule lastS",
            "lastSuccessful"
        )
        .addComplCase(
            "find configuration with dependency artifact revRule sameChainO",
            "sameChainOrLastFinished"
        )
        .end()

    @DataProvider(name = "failed")
    fun failedData() = TestFailedDataProvdier()
        .addParseCase("find configuration with dependency type vcs")
        .addParseCase("find project with dependency id Base")
        .addParseCase("find vcsRoot with dependency")
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
        sleep(50)
        checkVars(query, expected)
    }
}