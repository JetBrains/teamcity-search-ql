package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.serverSide.*


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
    FParamContainer,
    TopLevelObject,
    FVcsRootContainer,
    FValueContainer,
    FNameContainer
{
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
        get() = sproject.wrap()

    override val ownParams: List<WResolvableParam>
        get() = sproject.ownParameters.map { (a, b) -> WResolvableParam(a, b, sproject.valueResolver) }

    override val params: List<WResolvableParam>
        get() = sproject.parameters.map { (a, b) -> WResolvableParam(a, b, sproject.valueResolver) }

    override val vcsRoots: List<AbstractWVcsRoot>
        get() = sproject.vcsRoots.map {it.wrap(sproject.valueResolver)}

    override val values: List<ResolvableString>
        get() = ownFeatures.flatMap { it.values } + ownParams.map {it.toValue()}

    override val name: String
        get() = sproject.fullName
}