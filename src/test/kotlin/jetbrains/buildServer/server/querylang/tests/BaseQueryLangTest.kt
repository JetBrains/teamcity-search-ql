package jetbrains.buildServer.server.querylang.tests

import jetbrains.buildServer.artifacts.RevisionRules
import jetbrains.buildServer.buildTriggers.BuildTriggerDescriptor
import jetbrains.buildServer.server.querylang.parser.ParsingException
import jetbrains.buildServer.server.querylang.requests.InternalApiQueryHandler
import jetbrains.buildServer.server.querylang.requests.RequestClient
import jetbrains.buildServer.server.querylang.tests.client.EmptyResultPrinter
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.serverSide.dependency.DependencySettings
import jetbrains.buildServer.serverSide.impl.BaseServerTestCase
import jetbrains.buildServer.serverSide.impl.ProjectEx
import jetbrains.buildServer.util.Option
import jetbrains.buildServer.util.OptionSupport
import jetbrains.buildServer.util.StringOption
import jetbrains.buildServer.vcs.SVcsRoot
import org.testng.annotations.BeforeMethod

abstract class BaseQueryLangTest : BaseServerTestCase() {
    protected lateinit var client: RequestClient
    protected lateinit var projectManager: ProjectManager

    @BeforeMethod
    override fun setUp() {
        super.setUp()
        projectManager = myFixture.projectManager
        client = RequestClient(InternalApiQueryHandler(projectManager),
            EmptyResultPrinter
        )
    }

    fun getIds(query: String) : List<String> {
        return client.process(query).objects.map {it.externalId}.sorted()
    }

    private val projects = mutableMapOf<String, ProjectEx>()
    private val buildConfs = mutableMapOf<String, BuildTypeEx>()
    private val templates = mutableMapOf<String, BuildTypeTemplateEx>()
    private val steps = mutableMapOf<String, BuildRunnerDescriptor>()
    private val features = mutableMapOf<String, SBuildFeatureDescriptor>()
    private val triggers = mutableMapOf<String, BuildTriggerDescriptor>()
    private val vcsRoots = mutableMapOf<String, SVcsRoot>()

    protected fun project(key: String): ProjectEx {
        return projects[key]!!
    }

    protected fun bc(key: String): BuildTypeEx {
        return buildConfs[key]!!
    }

    protected fun temp(key: String): BuildTypeTemplateEx {
        return templates[key]!!
    }

    protected fun step(key: String): BuildRunnerDescriptor {
        return steps[key]!!
    }

    protected fun feature(key: String): SBuildFeatureDescriptor {
        return features[key]!!
    }

    protected fun trigger(key: String): BuildTriggerDescriptor {
        return triggers[key]!!
    }

    protected fun vcs(key: String): SVcsRoot {
        return vcsRoots[key]!!
    }

    interface TestObject

    abstract class TestStorableObject<T, L> : TestObject {

        private var key: String = ""

        protected abstract fun createInner(context: L): T
        protected abstract val storage: MutableMap<String, T>?

        fun bind(key_: String): TestStorableObject<T, L> {
            key = key_
            return this
        }

        fun create(context: L): T {
            val obj = createInner(context)
            if (key != "" && storage != null) {
                storage!![key] = obj
            }
            return obj
        }
    }

    abstract class TestReferenceObject<T, L> : TestObject {

        abstract fun createInner(context: T, obj: L)

        abstract val storage: MutableMap<String, L>

        var ref: String? = null

        var obj: L? = null

        fun create(context: T) {
            if (ref != null) {
                obj = storage[ref!!]!!
            }
            createInner(context, obj!!)
        }
    }

    inner class TProject(val id: String, vararg val objects: TestObject) :
        TestStorableObject<ProjectEx, ProjectEx>()
    {

        override val storage = projects

        override fun createInner(parent: ProjectEx): ProjectEx {
            val project = myFixture.createProject(id, id, parent)

            objects.forEach {obj ->
                when (obj) {
                    is TProject -> {
                        obj.create(project)
                    }
                    is TBuildConf -> {
                        obj.create(project)
                    }
                    is TTemplate -> {
                        obj.create(project)
                    }
                    is TVcsRoot -> {
                        obj.create(project)
                    }
                }
            }

            return project
        }


        fun create(): ProjectEx {
            return create(myFixture.projectManager.rootProject)
        }
    }

    inner class TBuildConf(val id: String, vararg val objects: TestObject) :
        TestStorableObject<BuildTypeEx, ProjectEx>() {

        override val storage = buildConfs

        override fun createInner(pr: ProjectEx): BuildTypeEx {
            val bt = pr.createBuildType(id, id)

            objects.forEach { obj ->
                when (obj) {
                    is TTempDependency -> obj.create(bt)
                    is TTrigger -> obj.create(bt)
                    is TStep -> obj.create(bt)
                    is TFeature -> obj.create(bt)
                    is TADependency -> obj.create(bt)
                    is TSDependency -> obj.create(bt)
                    is TParam -> obj.create(bt)
                    is TVcsInst -> obj.create(bt)
                    is TOption -> obj.create(bt)
                }
            }

            return bt
        }
    }

    inner class TTemplate(val id: String, vararg val objects: TestObject) :
        TestStorableObject<BuildTypeTemplateEx, ProjectEx>() {

        override val storage = templates

        override fun createInner(pr: ProjectEx): BuildTypeTemplateEx {
            val temp = pr.createBuildTypeTemplate(id, id)

            objects.forEach { obj ->
                when (obj) {
                    is TTrigger -> obj.create(temp)
                    is TStep -> obj.create(temp)
                    is TFeature -> obj.create(temp)
                    is TADependency -> obj.create(temp)
                    is TSDependency -> obj.create(temp)
                    is TParam -> obj.create(temp)
                    is TVcsInst -> obj.create(temp)
                    is TOption -> obj.create(temp)
                }
            }
            return temp
        }
    }

    inner class TVcsRoot(
        val name: String, val type: String, vararg val objects: TestObject
    ) : TestStorableObject<SVcsRoot, ProjectEx>()
    {
        override val storage = vcsRoots

        override fun createInner(context: ProjectEx): SVcsRoot {
            val params = mutableListOf<Pair<String, String>>()
            objects.forEach {
                when(it) {
                    is TParam -> params.add(Pair(it.name, it.v))
                }
            }
            myFixture.registerVcsSupport(type)
            return context.createVcsRoot(type, name, params.toMap())
        }
    }

    inner class TTrigger(val type: String, vararg val params: Pair<String, String>) :
        TestStorableObject<BuildTriggerDescriptor, BuildTypeSettings>() {

        override val storage = triggers

        override fun createInner(bt: BuildTypeSettings): BuildTriggerDescriptor {
            return bt.addBuildTrigger(type, params.toMap())
        }
    }
    inner class TStep(val type: String, vararg val params: Pair<String, String>) :
        TestStorableObject<BuildRunnerDescriptor, BuildTypeSettings>() {

        override val storage = steps

        override fun createInner(bt: BuildTypeSettings): BuildRunnerDescriptor {
            return bt.addBuildRunner(type, type, params.toMap())
        }
    }

    inner class TFeature(val type: String, vararg val params: Pair<String, String>) :
        TestStorableObject<SBuildFeatureDescriptor, BuildTypeSettings>()
    {

        override val storage = features

        override fun createInner(bt: BuildTypeSettings): SBuildFeatureDescriptor {
            return bt.addBuildFeature(type, params.toMap())
        }
    }

    inner class TSDependency() :
        TestReferenceObject<DependencySettings, BuildTypeEx>()
    {
        override val storage = buildConfs

        private var options = listOf<TOption>()

        constructor(ref_: String, vararg options_: TOption): this() {
            options = options_.toList()
            ref = ref_
        }

        constructor(obj_ : BuildTypeEx, vararg options_: TOption): this() {
            options = options_.toList()
            obj = obj_
        }

        override fun createInner(to: DependencySettings, from: BuildTypeEx) {
            val dep = myFixture.addDependency(to, from, true)
            options.forEach { it.create(dep) }
        }
    }
    inner class TADependency() :
        TestReferenceObject<BuildTypeSettings, BuildTypeEx>()
    {
        override val storage = buildConfs

        constructor(ref_: String): this() {
            ref = ref_
        }

        constructor(obj_: BuildTypeEx): this() {
            obj = obj_
        }

        override fun createInner(to: BuildTypeSettings, from: BuildTypeEx) {
            val dep = myFixture.artifactDependencyFactory.createArtifactDependency(from, "", RevisionRules.LAST_FINISHED_RULE)
            to.addArtifactDependency(dep)
        }
    }
    inner class TTempDependency() :
        TestReferenceObject<BuildTypeEx, BuildTypeTemplateEx>() {

        override val storage = templates

        constructor(ref_: String): this() {
            ref = ref_
        }

        constructor(temp: BuildTypeTemplateEx): this() {
            obj = temp
        }

        override fun createInner(bt: BuildTypeEx, temp: BuildTypeTemplateEx) {
            bt.addTemplate(temp, true)
        }
    }

    inner class TVcsInst() : TestReferenceObject<BuildTypeSettings, SVcsRoot>() {
        override val storage = vcsRoots

        constructor(ref_ : String): this() {
            ref = ref_
        }

        constructor(vcs: SVcsRoot) : this() {
            obj = vcs
        }

        override fun createInner(context: BuildTypeSettings, obj: SVcsRoot) {
            context.addVcsRoot(obj)
        }
    }

    inner class TParam(val name: String, val v: String) : TestObject {
        fun create(bt: UserParametersHolder) {
            bt.addParameter(SimpleParameter(name, v))
        }
    }

    inner class TOption(val name: String, val value: String) : TestObject {
        fun create(bt: OptionSupport) {
            bt.setOption(StringOption(name, ""), value)
        }
    }

    inner class TestDataProvider {

        init {
            setUp()
        }

        private val tests: MutableList<Pair<String, List<String>>> = mutableListOf()

        fun addCase(query: String, vararg resultIds: String): TestDataProvider {
            tests.add(Pair(query, resultIds.toList()))
            return this
        }

        fun addProjectCase(query: String, vararg resultRefs: String): TestDataProvider {
            return addCase(query, *(resultRefs.map {projects[it]!!.externalId}.toTypedArray()))
        }

        fun addBCCase(query: String, vararg resultRefs: String): TestDataProvider {
            return addCase(query, *(resultRefs.map {buildConfs[it]!!.externalId}.toTypedArray()))
        }

        fun addTempCase(query: String, vararg resultRefs: String): TestDataProvider {
            return addCase(query, *(resultRefs.map {templates[it]!!.externalId}.toTypedArray()))
        }

        fun addVcsCase(query: String, vararg resultRefs: String): TestDataProvider {
            return addCase(query, *(resultRefs.map {vcsRoots[it]!!.externalId}.toTypedArray()))
        }

        fun end(): MutableIterator<Array<Any>> {
            return tests.map {p ->
                arrayOf(p.first, p.second)
            }.toMutableList().iterator()
        }
    }

    inner class TestFailedDataProvdier {
        private val tests: MutableList<Pair<Any, Any>> = mutableListOf()

        fun addCase(query: String, exc: Class<out Exception>): TestFailedDataProvdier {
            tests.add(Pair(query, exc))
            return this
        }

        fun addParseCase(query: String): TestFailedDataProvdier {
            return addCase(query, ParsingException::class.java)
        }

        fun end(): MutableIterator<Array<Any>> {
            return tests.map {p ->
                arrayOf(p.first, p.second)
            }.toMutableList().iterator()
        }
    }
}