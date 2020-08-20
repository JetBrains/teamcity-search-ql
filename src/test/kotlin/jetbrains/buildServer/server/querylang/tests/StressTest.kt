package jetbrains.buildServer.server.querylang.tests

import jetbrains.buildServer.serverSide.BuildTypeEx
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.lang.Thread.sleep
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class StressTest : BaseQueryLangTest() {

    val projectCnt = 500
    val children = 3       //the number of project children, affects depth
    val buildConfCnt = 10  //per project
    val templateCnt = 3
    val settinsCnt = 3
    val dependenciesOneBCCnt = 10

    val runtime = Runtime.getRuntime()
    var usedMemoryBefore: Long = 0

    @BeforeClass
    override fun setUp() {
        super.setUp()
        val project = TProject("BaseProject")
        val base = genProjectTree(project, projectCnt, children)

        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory()

        base.create(true)

        createDependencies()
    }

    @AfterClass
    override fun tearDown() {
        super.tearDown()
        sleep(1000)
        val usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory()
        println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / (1024 * 1024) + " mb")
    }

    @DataProvider(name = "time")
    fun measureTimeData() = SingleDataProvider()
            .addCase(
                    "find project with project id BaseProject"
            )
            .addCase(
                    "find configuration with project id BaseProject"
            )
            .addCase(
                    "find configuration with project id BaseProject and trigger type vcsTrigger"
            )
            .addCase(
                    "find configuration with trigger type vcsTrigger"
            )
            .addCase(
                    "find configuration with dependency (trigger type schedulingTrigger and artifact)"
            )
            .addCase(
                    "find configuration with dependency dependency trigger type vcsTrigger"
            )
            .end()

    @Test(dataProvider = "time")
    fun parametrizedTimeTest(query: String) {
        var objCnt: Int = 0
        val time = measureTimeMillis {
            objCnt = client.process(query).objects.size
        }
        println("\"$query\" -- finished in ${time} milliseconds\n found $objCnt")

    }



    private fun genProjectTree(project: TProject, size: Int, cnt: Int): TProject {
        val newSize = size - 1
        val projects = if (newSize <= cnt) {
            createNProjects(project, newSize)
        } else {
            createNProjects(project, cnt).mapIndexed { i, pr ->
                if (i == cnt - 1) {
                    genProjectTree(pr, newSize / cnt + newSize % cnt, cnt)
                } else {
                    genProjectTree(pr, newSize / cnt, cnt)
                }
            }
        }.map { addNBuildConfs(it, buildConfCnt) }.map {addNTemplates(it, buildConfCnt)}

        return project.addAndCopy(*projects.toTypedArray())
    }

    private fun createNProjects(p: TProject, n: Int): List<TProject> {
        val projects = (1..n).map { TProject(p.id + "_" + getRandAlphString(15)) }
        return projects
    }

    private fun getRandAlphString(length: Int): String {
        val chars = ('0'..'9') + ('A'..'Z') + ('a'..'z')
        return (0..length).map {
            Random.nextInt(0, chars.size).let {chars[it]}
        }.joinToString("")
    }

    private fun getRandString(strings: List<String>): String {
        return Random.nextInt(0, strings.size).let {strings[it]}
    }

    private fun getRandString(vararg strings: String): String {
        return Random.nextInt(0, strings.size).let {strings[it]}
    }

    private fun addRandomSettings(b: TBuildConf, k: Int): TBuildConf {

        val triggers = (1..k).map {TTrigger(getRandString(listOf("vcsTrigger", "schedulingTrigger", "otherTrigger", "timeTrigger")))}
        val steps = (1..k).map {TStep(getRandString("abacabaStep", "stepQwerty", "stepIEOWIE", "stepIOoiwieiow"))}
        val features = (1..k).map {TFeature(getRandString("feature11", "abadsdsFeature", "fslkFeature", "featureaieiw"))}
        val params = (1..k).map {TParam(getRandAlphString(20), getRandAlphString(30)) }
        val options = (1..k).map {TParam(getRandAlphString(20), getRandAlphString(30)) }

        val objects = mutableListOf<TestObject>()
        objects.addAll(triggers)
        objects.addAll(steps)
        objects.addAll(features)
        objects.addAll(params)
        objects.addAll(options)

        return b.addAndCopy(*objects.toTypedArray())
    }

    private fun addRandomSettings(t: TTemplate, k: Int): TTemplate {

        val triggers = (1..k).map {TTrigger(getRandString(listOf("vcsTrigger", "schedulingTrigger", "otherTrigger", "timeTrigger")))}
        val steps = (1..k).map {TStep(getRandString("abacabaStep", "stepQwerty", "stepIEOWIE", "stepIOoiwieiow"))}
        val features = (1..k).map {TFeature(getRandString("feature11", "abadsdsFeature", "fslkFeature", "featureaieiw"))}
        val params = (1..k).map {TParam(getRandAlphString(20), getRandAlphString(30)) }
        val options = (1..k).map {TParam(getRandAlphString(20), getRandAlphString(30)) }

        val objects = mutableListOf<TestObject>()
        objects.addAll(triggers)
        objects.addAll(steps)
        objects.addAll(features)
        objects.addAll(params)
        objects.addAll(options)

        return t.addAndCopy(*objects.toTypedArray())
    }

    private fun addNBuildConfs(p: TProject, n: Int): TProject {
        val buildConfs = createNBuildConfs(p, n).map {
            addRandomSettings(it, settinsCnt)
        }
        return p.addAndCopy(*buildConfs.toTypedArray())
    }

    private fun createNBuildConfs(p: TProject, n: Int): List<TBuildConf> {
        return (1..n).map { TBuildConf(p.id + "_" + getRandAlphString(15)) }
    }

    private fun addNTemplates(p: TProject, n: Int): TProject {
        val buildConfs = createNTemplates(p, n).map {
            addRandomSettings(it, settinsCnt)
        }
        return p.addAndCopy(*buildConfs.toTypedArray())
    }

    private fun createNTemplates(p: TProject, n: Int): List<TTemplate> {
        return (1..n).map { TTemplate(p.id + "_" + getRandAlphString(15)) }
    }

    fun <T> List<T>.getRandom(maxIndex: Int): T {
        return Random.nextInt(maxIndex).let {this[it]}
    }

    private fun createDependencies() {
        val bcs = projectManager.allBuildTypes.shuffled().map {it as BuildTypeEx }
        (2 * dependenciesOneBCCnt until bcs.size).forEach {i ->
            (1..(dependenciesOneBCCnt - 1)).forEach {
                TADependency(bcs.getRandom(i), getRandAlphString(20), true).create(bcs[i])
            }
            TSDependency(bcs.getRandom(i)).create(bcs[i])
        }
    }
}