package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.buildTriggers.BuildTriggerDescriptor
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.vcs.VcsRootEntry
import jetbrains.buildServer.vcs.VcsRootInstanceEntry

interface EnabledChecker {
    fun isEnabled(obj: FEnabledContainer): Boolean
}

fun SProject.wrap(): WProject {
    return WProject(this)
}

class WProject(
    val sproject: SProject
) : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FFeatureContainer,
    FAncestorContainer,
    FParamContainer
{
    override val id: String
        get() = sproject.externalId

    override val parent: WProject?
        get() = sproject.parentProject?.wrap()

    override val ownFeatures: List<WFeature>
        get() = sproject.ownFeatures.map {it.wrap()}

    override val features: List<WFeature>
        get() = sproject.availableFeatures.map {it.wrap()}

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        return true
    }

    override val firstAncestor: WProject?
        get() = sproject.parentProject?.wrap()

    override val project: WProject
        get() = sproject.wrap()

    override val ownParams: Map<String, String>
        get() = sproject.ownParameters

    override val params: Map<String, String>
        get() = sproject.parameters
}

fun SBuildType.wrap() = WBuilConf(this)

class WBuilConf(
    val sbuildConf: SBuildType
) : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FTriggerContainer,
    FStepContainer,
    FTemplateContainer,
    FParamContainer
{
    val buildTypeEx: BuildTypeEx by lazy {
        sbuildConf as? BuildTypeEx ?: throw IllegalStateException("Should be BuildTypeEx")
    }

    override val id: String
        get() = sbuildConf.externalId

    override val project: WProject
        get() = sbuildConf.project.wrap()

    override val parent: WProject?
        get() = sbuildConf.project.wrap()

    override val ownTriggers: List<WTrigger>
        get() = buildTypeEx.settings.ownBuildTriggers.map { it.wrap() }

    override val triggers: List<WTrigger>
        get() = sbuildConf.buildTriggersCollection.map { it.wrap() }

    override val ownSteps: List<WStep>
        get() = buildTypeEx.settings.ownBuildRunners.map {it.wrap()}

    override val steps: List<WStep>
        get() = sbuildConf.buildRunners.map { it.wrap() }

    override val templates: List<WTemplate>
        get() = sbuildConf.templates.map {it.wrap()}

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        if (obj !is WParametersDescriptor) {
            throw IllegalStateException()
        }
        return sbuildConf.isEnabled(obj.obj.id)
    }

    override val ownParams: Map<String, String>
        get() = sbuildConf.ownParameters

    override val params: Map<String, String>
        get() = sbuildConf.parameters
}

fun BuildTypeTemplate.wrap() = WTemplate(this)

class WTemplate(
    val stemplate: BuildTypeTemplate
) : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FTriggerContainer,
    FStepContainer,
    FParamContainer
{
    override val id: String
        get() = stemplate.externalId

    override val project: WProject
        get() = stemplate.project.wrap()

    override val parent: WProject?
        get() = stemplate.project.wrap()

    override val ownTriggers: List<WTrigger>
        get() = stemplate.buildTriggersCollection.map { it.wrap() }

    override val triggers: List<WTrigger>
        get() = ownTriggers

    override val ownSteps: List<WStep>
        get() = stemplate.buildRunners.map {it.wrap()}

    override val steps: List<WStep>
        get() = ownSteps

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        if (obj !is WParametersDescriptor) {
            throw IllegalStateException()
        }
        return stemplate.isEnabled(obj.obj.id)
    }

    override val ownParams: Map<String, String>
        get() = stemplate.ownParameters

    override val params: Map<String, String>
        get() = stemplate.parameters
}

fun SVcsRoot.wrap() = WSimpleVcsRoot(this)

abstract class WVcsRoot() : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FParamContainer
{
    abstract val svcsRoot: SVcsRoot

    override val id: String
        get() = svcsRoot.externalId

    override val project: WProject
        get() = svcsRoot.project.wrap()

    override val parent: WProject?
        get() = svcsRoot.project.wrap()

    override val ownParams: Map<String, String>
        get() = svcsRoot.properties

    override val params: Map<String, String>
        get() = ownParams
}

class WSimpleVcsRoot(override val svcsRoot: SVcsRoot) : WVcsRoot()


abstract class WParametersDescriptor(val obj: ParametersDescriptor): FParamContainer, FEnabledContainer {
    override val params: Map<String, String>
        get() = obj.parameters

    override val ownParams: Map<String, String>
        get() = params
}

fun BuildTriggerDescriptor.wrap() = WTrigger(this)

class WTrigger(strigger: BuildTriggerDescriptor) : WParametersDescriptor(strigger)

fun BuildRunnerDescriptor.wrap() = WStep(this)

class WStep(sstep: BuildRunnerDescriptor) : WParametersDescriptor(sstep)

fun SBuildFeatureDescriptor.wrap() = WBuildTypeFeature(this)

fun SProjectFeatureDescriptor.wrap() = WProjectFeature(this)

abstract class WFeature(paramDescriptor: ParametersDescriptor) : WParametersDescriptor(paramDescriptor)

class WBuildTypeFeature(sfeature: SBuildFeatureDescriptor) : WFeature(sfeature)

class WProjectFeature(sfeature: SProjectFeatureDescriptor) : WFeature(sfeature)


abstract class WVcsRootEntry : WVcsRoot() {
    abstract val rules: String
    abstract override val svcsRoot: SVcsRoot
}

fun VcsRootEntry.wrap() = MyVcsRootEntry(this)

class MyVcsRootEntry(val svcsEntry: VcsRootEntry): WVcsRootEntry() {
    val internalVcsRoot: SVcsRoot by lazy {
        svcsEntry.vcsRoot as? SVcsRoot ?: throw IllegalStateException("VcsRootEntry.vcsRoot should be SVcsRoot")
    }

    override val rules: String
        get() = svcsEntry.checkoutRules.asString

    override val svcsRoot: SVcsRoot
        get() = internalVcsRoot
}

fun VcsRootInstanceEntry.wrap() = MyVcsRootInstanceEntry(this)

class MyVcsRootInstanceEntry(val svcsInstanceEntry: VcsRootInstanceEntry): WVcsRootEntry() {
    override val rules: String
        get() = svcsInstanceEntry.checkoutRules.asString

    override val svcsRoot: SVcsRoot
        get() = svcsInstanceEntry.vcsRoot.parent
}