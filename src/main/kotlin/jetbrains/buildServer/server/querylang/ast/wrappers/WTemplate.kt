package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.util.Option

fun BuildTypeTemplate.wrap() = WTemplate(this)

class WTemplate(
    val stemplate: BuildTypeTemplate
) : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FTriggerContainer,
    FStepContainer,
    FFeatureContainer,
    FParamContainer,
    FDependencyContainer,
    FOptionContainer,
    TopLevelObject,
    FVcsRootEntryContainer,
    FValueContainer,
    FNameContainer
{
    val resolver: ValueResolver
        get() = stemplate.valueResolver

    override val id: String
        get() = stemplate.externalId

    override val project: WProject
        get() = stemplate.project.wrap()

    override val parent: WProject?
        get() = stemplate.project.wrap()

    override val ownTriggers: List<WTrigger>
        get() = stemplate.buildTriggersCollection.map { it.wrap(stemplate) }

    override val triggers: List<WTrigger>
        get() = ownTriggers

    override val ownSteps: List<WStep>
        get() = stemplate.buildRunners.map {it.wrap(stemplate)}

    override val steps: List<WStep>
        get() = ownSteps

    override val features: List<WFeature>
        get() = stemplate.buildFeatures.map {it.wrap(stemplate)}

    override val ownFeatures: List<WFeature>
        get() = features

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        if (obj !is WParametersDescriptor) {
            throw IllegalStateException()
        }
        return stemplate.isEnabled(obj.obj.id)
    }

    override val ownParams: List<WResolvableParam>
        get() = stemplate.ownParametersCollection.map { WResolvableParam(it, stemplate.valueResolver) }

    override val params: List<WResolvableParam>
        get() = stemplate.parametersCollection.map { param ->
            WResolvableParam(param, stemplate.valueResolver)
        }

    override val options: List<WResolvableParam>
        get() = stemplate.options.map {WResolvableParam(it.key, getOption(it).toString(), resolver)}

    override val ownOptions: List<WResolvableParam>
        get() = stemplate.ownOptions.map {WResolvableParam(it.key, getOption(it).toString(), resolver)}

    override fun getOption(opt: Option<Any>): Any {
        return stemplate.getOption(opt)
    }

    override val vcsRootEntries: List<WVcsRootEntry>
        get() = stemplate.vcsRootEntries.map {it.wrap(resolver)}

    override val ownVcsRootEntries: List<WVcsRootEntry>
        get() = vcsRootEntries

    override val dependencies: List<SuperDependency>
        get() = (
                stemplate.dependencies.mapNotNull {dep ->
                    dep.dependOn?.let {dep.wrap(it, resolver)}
                }
                + stemplate.artifactDependencies.mapNotNull {dep ->
                    dep.sourceBuildType?.let { dep.wrap(it, resolver) }
                }
                ).toSuperDependencies()

    override val ownDependencies: List<SuperDependency>
        get() = dependencies

    override val values: List<ResolvableString>
        get() = ownParams.map {it.toValue()} +
                ownOptions.map {it.toValue()} +
                ownTriggers.flatMap { it.values } +
                ownSteps.flatMap { it.values } +
                ownFeatures.flatMap { it.values } +
                ownDependencies.flatMap {it.artifactDependencies.flatMap {it.rules}} +
                ownVcsRootEntries.flatMap { it.rules }

    override val name: String
        get() = stemplate.name

    override fun equals(other: Any?): Boolean {
        return other is WTemplate && other.id == this.id
    }

    override fun hashCode(): Int {
        return this.id.hashCode()
    }
}