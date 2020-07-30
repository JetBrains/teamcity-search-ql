package jetbrains.buildServer.server.querylang.tests

import jetbrains.buildServer.server.querylang.autocompl.AutoCompletion
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import kotlin.system.measureTimeMillis

@Test
class StressTest : BaseServerTestCase() {

    @BeforeClass
    override fun setUp() {
        super.setUp()
        val projectCnt = 500
        val buildConfCnt = 2
        val time = measureTimeMillis {
            for (i in 1..projectCnt) {
                val pr = myProject.createProject("Project$i", "Project$i")
                for (j in 1..buildConfCnt) {
                    val bc = pr.createBuildType("${j}BuildConf$j")
                    bc.addBuildTrigger(
                        "vcsTrigger",
                        mapOf(Pair("$i$j.pathasdfsadfasdfas", "asdfasd$i.asdf$j.fasdfasfdad"))
                    )
                    bc.addBuildTrigger(
                        "schedulingTrigger",
                        mapOf(Pair("$i$j.pathasdfsadfasdasdfasdffas", "asdfasd$i.asdf$j.fasdfasfasdfdad"))
                    )
                    bc.addBuildTrigger(
                        "trigger",
                        mapOf(Pair("$i$j.paasdfsdoksadfasdfas", "asdfasd$i.asdf$j.fasdfasasdffdad"))
                    )
                }
            }
        }
        println(time)
    }

    fun testIndexTime() {
        val time = measureTimeMillis {
            val compl = AutoCompletion(myFixture.projectManager)
        }
        println(time)
    }
}