package jetbrains.buildServer.server.querylang.ast.wrappers

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