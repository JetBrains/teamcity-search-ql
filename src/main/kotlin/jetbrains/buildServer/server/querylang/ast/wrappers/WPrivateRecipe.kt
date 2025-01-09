package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.runners.recipes._private.spec.PrivateRecipeSpec

fun PrivateRecipeSpec.wrap(valueResolver: ValueResolver): WPrivateRecipe? {
    return this.configLocation.project?.let {
        if (!checkPermission(it.projectId)) null
        else WPrivateRecipe(this, valueResolver)
    }
}

class WPrivateRecipe :
    FIdContainer,
    FProjectContainer,
    FParentContainer,
    FParamContainer,
    FNameContainer,
    FStepContainer
{
    private val mySpec: PrivateRecipeSpec
    private val myResolver: ValueResolver

    internal constructor(spec: PrivateRecipeSpec, resolver: ValueResolver) {
        mySpec = spec
        myResolver = resolver
    }

    override val name: String
        get() = mySpec.runTypeInfo.displayName

    override val id: String
        get() = mySpec.runTypeInfo.type

    override val project: WProject
        get() = mySpec.configLocation.project!!.wrap()!!

    override val parent: WProject?
        get() = mySpec.configLocation.project?.wrap()

    override val ownParams: List<WResolvableParam>
        get() = params

    override val params: List<WResolvableParam>
        get() = mySpec.parameters.parametersCollection.map {
            WResolvableParam(it, myResolver)
        }

    override val ownSteps: List<WStep>
        get() = mySpec.steps.map {
            it.wrap(myResolver)
        }

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        return true
    }

    override val steps: List<WStep>
        get() = ownSteps

    override fun hashCode(): Int {
        return this.mySpec.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return other is WPrivateRecipe && other.mySpec == mySpec
    }
}