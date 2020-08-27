package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.vcs.SVcsRoot
import jetbrains.buildServer.vcs.VcsRootEntry
import jetbrains.buildServer.vcs.VcsRootInstanceEntry

fun SVcsRoot.wrap(resolver: ValueResolver): WVcsRoot? {
    if (!checkPermission(this.project.projectId)) {
        return null
    }
    return WVcsRoot(this, resolver)
}

abstract class AbstractWVcsRoot :
    FIdContainer,
    FProjectContainer,
    FParentContainer,
    FParamContainer,
    FTypeContainer,
    FValueContainer,
    FNameContainer
{
    abstract val svcsRoot: SVcsRoot
    abstract val resolver: ValueResolver

    override val id: String
        get() = svcsRoot.externalId

    override val project: WProject
        get() = svcsRoot.project.wrap()!!

    override val parent: WProject?
        get() = svcsRoot.project.wrap()

    override val ownParams: List<WResolvableParam>
        get() = svcsRoot.properties.map {(a, b) -> WResolvableParam(a, b, resolver)}

    override val params: List<WResolvableParam>
        get() = ownParams

    override val type: String
        get() = svcsRoot.vcsName

    override val values: List<ResolvableString>
        get() = ownParams.map {ResolvableString(it.value, resolver)}

    override val name: String
        get() = svcsRoot.name
}

class WVcsRoot(
    override val svcsRoot: SVcsRoot,
    override val resolver: ValueResolver
) : AbstractWVcsRoot(), TopLevelObject

abstract class WVcsRootEntry : AbstractWVcsRoot(), FRulesContainer {
    abstract override val svcsRoot: SVcsRoot
}

fun VcsRootEntry.wrap(resolver: ValueResolver) = MyVcsRootEntry(this, resolver)

class MyVcsRootEntry(val svcsEntry: VcsRootEntry, override val resolver: ValueResolver): WVcsRootEntry() {
    val internalVcsRoot: SVcsRoot by lazy {
        svcsEntry.vcsRoot as? SVcsRoot ?: throw IllegalStateException("VcsRootEntry.vcsRoot should be SVcsRoot")
    }

    override val rules: List<ResolvableString>
        get() = svcsEntry.checkoutRules.body.map { ResolvableString(it, resolver)}

    override val svcsRoot: SVcsRoot
        get() = internalVcsRoot
}

fun VcsRootInstanceEntry.wrap(resolver: ValueResolver) = MyVcsRootInstanceEntry(this, resolver)

class MyVcsRootInstanceEntry(
    val svcsInstanceEntry: VcsRootInstanceEntry,
    override val resolver: ValueResolver
): WVcsRootEntry() {
    override val rules: List<ResolvableString>
        get() = svcsInstanceEntry.checkoutRules.body.map {ResolvableString(it, resolver)}

    override val svcsRoot: SVcsRoot
        get() = svcsInstanceEntry.vcsRoot.parent

    override fun equals(other: Any?): Boolean {
        return other is WVcsRoot && other.id == this.id
    }

    override fun hashCode(): Int {
        return this.id.hashCode()
    }
}