package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.serverSide.BuildTypeEx
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.util.Option

fun SBuildType.wrap() = WBuildConf(this)

abstract class AbstractWBuildConf :
    FIdContainer,
    FProjectContainer,
    FParentContainer,
    FTriggerContainer,
    FStepContainer,
    FFeatureContainer,
    FTemplateContainer,
    FParamContainer,
    FDependencyContainer,
    FOptionContainer,
    FVcsRootEntryContainer,
    FValueContainer,
    FNameContainer
{
    abstract val sbuildConf: SBuildType

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

    override val features: List<WFeature>
        get() = sbuildConf.buildFeatures.map {it.wrap()}

    override val ownFeatures: List<WFeature>
        get() = buildTypeEx.settings.ownBuildFeatures.map {it.wrap()}

    override val templates: List<WTemplate>
        get() = sbuildConf.templates.map {it.wrap()}

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        if (obj !is WParametersDescriptor) {
            throw IllegalStateException()
        }
        return  sbuildConf.isEnabled(obj.obj.id)
    }

    override val ownParams: Map<String, String>
        get() = sbuildConf.ownParameters

    override val params: Map<String, String>
        get() = sbuildConf.parameters

    override val options: Collection<Option<Any>>
        get() = sbuildConf.options

    override val ownOptions: Collection<Option<Any>>
        get() = sbuildConf.ownOptions

    override fun getOption(opt: Option<Any>): Any {
        return sbuildConf.getOption(opt)
    }

    override val vcsRootEntries: List<WVcsRootEntry>
        get() = sbuildConf.vcsRootEntries.map {it.wrap()}

    override val ownVcsRootEntries: List<WVcsRootEntry>
        get() = sbuildConf.ownVcsRootEntries.map {it.wrap()}

    override val dependencies: List<SuperDependency>
        get() = (sbuildConf.dependencies.map {it.wrap()} + sbuildConf.artifactDependencies.map {it.wrap()}).toSuperDependencies()

    override val ownDependencies: List<SuperDependency>
        get() = (sbuildConf.ownDependencies.map {it.wrap()} + buildTypeEx.settings.ownArtifactDependencies.map {it.wrap()}).toSuperDependencies()

    override val values: List<String>
        get() = ownParams.values +
                ownOptions.map {getOption(it).toString()} +
                ownTriggers.flatMap { it.values } +
                ownSteps.flatMap { it.values } +
                ownFeatures.flatMap { it.values }

    override val name: String
        get() = sbuildConf.name
}

class WBuildConf(
    override val sbuildConf: SBuildType
) : AbstractWBuildConf(), TopLevelObject