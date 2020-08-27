package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.serverSide.BuildTypeEx
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.util.Option

fun SBuildType.wrap(): WBuildConf? {
    if (!checkPermission(this.projectId)) return null
    return WBuildConf(this)
}

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

    override val resolver: ValueResolver
        get() = sbuildConf.valueResolver

    override val id: String
        get() = sbuildConf.externalId

    override val project: WProject
        get() = sbuildConf.project.wrap()!!

    override val parent: WProject?
        get() = sbuildConf.project.wrap()

    override val ownTriggers: List<WTrigger>
        get() = buildTypeEx.settings.ownBuildTriggers.map { it.wrap(sbuildConf) }

    override val triggers: List<WTrigger>
        get() = sbuildConf.buildTriggersCollection.map { it.wrap(sbuildConf) }

    override val ownSteps: List<WStep>
        get() = buildTypeEx.settings.ownBuildRunners.map {it.wrap(sbuildConf)}

    override val steps: List<WStep>
        get() = sbuildConf.buildRunners.map { it.wrap(sbuildConf) }

    override val features: List<WFeature>
        get() = sbuildConf.buildFeatures.map {it.wrap(sbuildConf)}

    override val ownFeatures: List<WFeature>
        get() = buildTypeEx.settings.ownBuildFeatures.map {it.wrap(sbuildConf)}

    override val templates: List<WTemplate>
        get() = sbuildConf.templates.mapNotNull {it.wrap()}

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        if (obj !is WParametersDescriptor) {
            throw IllegalStateException()
        }
        return  sbuildConf.isEnabled(obj.obj.id)
    }

    override val ownParams: List<WResolvableParam>
        get() = sbuildConf.ownParametersCollection.map{
            WResolvableParam(it, sbuildConf.valueResolver)
        }

    override val params: List<WResolvableParam>
        get() = sbuildConf.parametersCollection.map {
            WResolvableParam(it, sbuildConf.valueResolver)
        }

    override val optionRetriever: DefaultOptions
        get() = DefaultOptions(sbuildConf)

    override val vcsRootEntries: List<WVcsRootEntry>
        get() = sbuildConf.vcsRootEntries.map {it.wrap(resolver)}

    override val ownVcsRootEntries: List<WVcsRootEntry>
        get() = sbuildConf.ownVcsRootEntries.map {it.wrap(resolver)}

    override val dependencies: List<SuperDependency>
        get() = (
                sbuildConf.dependencies.mapNotNull {dep -> dep.dependOn?.let{dep.wrap(it, resolver)}}
                        + sbuildConf.artifactDependencies.mapNotNull {dep -> dep.sourceBuildType?.let{dep.wrap(it, resolver)}}
                ).toSuperDependencies()

    override val ownDependencies: List<SuperDependency>
        get() = (
                sbuildConf.ownDependencies.mapNotNull {dep -> dep.dependOn?.let{dep.wrap(it, resolver)}}
                        + buildTypeEx.settings.ownArtifactDependencies.mapNotNull {
                        dep -> dep.sourceBuildType?.let{dep.wrap(it, resolver)
                }}
                ).toSuperDependencies()

    override val values: List<ResolvableString>
        get() = ownParams.map {it.toValue()} +
                options.map {it.toValue()} +
                ownTriggers.flatMap { it.values } +
                ownSteps.flatMap { it.values } +
                ownFeatures.flatMap { it.values } +
                ownDependencies.flatMap {it.artifactDependencies.flatMap {it.rules}} +
                ownVcsRootEntries.flatMap { it.rules }

    override val name: String
        get() = sbuildConf.name

    override fun equals(other: Any?): Boolean {
        return other is WBuildConf && other.id == this.id
    }

    override fun hashCode(): Int {
        return this.id.hashCode()
    }
}

class WBuildConf(
    override val sbuildConf: SBuildType
) : AbstractWBuildConf(), TopLevelObject