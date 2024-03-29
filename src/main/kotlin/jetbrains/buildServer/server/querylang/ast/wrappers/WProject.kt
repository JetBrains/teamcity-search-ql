package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.serverSide.*
import jetbrains.buildServer.serverSide.impl.ProjectEx


interface EnabledChecker {
    fun isEnabled(obj: FEnabledContainer): Boolean
}

fun SProject.wrap(): WProject? {
    if (!checkPermission(this.projectId)) return null
    return WProject(this)
}

class WProject(
    val sproject: SProject
) : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FFeatureContainer,
    FAncestorContainer,
    FParamContainer,
    TopLevelObject,
    FVcsRootContainer,
    FValueContainer,
    FNameContainer,
    FBuildConfContainer,
    FTemplateContainer,
    FSubProjectContainer,
    FArchivedContainer
{
    val projectEx: ProjectEx by lazy { sproject as ProjectEx }

     val resolver: ValueResolver
        get() = sproject.valueResolver

    override val id: String
        get() = sproject.externalId

    override val parent: WProject?
        get() = sproject.parentProject?.wrap()

    override val ownFeatures: List<WFeature>
        get() = sproject.ownFeatures.map {it.wrap(sproject)}

    override val features: List<WFeature>
        get() = sproject.availableFeatures.map {it.wrap(sproject)}

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        return true
    }

    override val firstAncestor: WProject?
        get() = sproject.parentProject?.wrap()

    override val project: WProject
        get() = sproject.wrap()!!

    override val ownParams: List<WResolvableParam>
        get() = sproject.ownParametersCollection.map { WResolvableParam(it, sproject.valueResolver) }

    override val params: List<WResolvableParam>
        get() = sproject.parametersCollection.map { WResolvableParam(it, sproject.valueResolver) }

    override val vcsRoots: List<WVcsRoot>
        get() = sproject.vcsRoots.mapNotNull {it.wrap(sproject.valueResolver)}

    override val values: List<ResolvableString>
        get() = ownFeatures.flatMap { it.values } + ownParams.map {it.toValue()}

    override val name: String
        get() = sproject.name

    override val isArchived: Boolean
        get() = sproject.isArchived

    override fun equals(other: Any?): Boolean {
        return other is WProject && other.id == this.id
    }

    override fun hashCode(): Int {
        return this.id.hashCode()
    }

    override val buildConfs: List<WBuildConf>
        get() = sproject.ownBuildTypes.mapNotNull {it.wrap()}

    override val templates: List<WTemplate>
        get() = sproject.ownBuildTypeTemplates.mapNotNull {it.wrap()}

    override val subProjects: List<WProject>
        get() = sproject.ownProjects.mapNotNull {it.wrap()}
}