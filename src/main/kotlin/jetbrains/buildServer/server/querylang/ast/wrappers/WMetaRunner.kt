package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.runners.metaRunner.config.MetaSpec

fun MetaSpec.wrap(valueResolver: ValueResolver): WMetaRunner? {
    return this.configLocation.project?.let {
        if (!checkPermission(it.projectId)) null
        else WMetaRunner(this, valueResolver)
    }
}

class WMetaRunner :
    FIdContainer,
    FProjectContainer,
    FParentContainer,
    FParamContainer,
    FNameContainer,
    FStepContainer
{
    private val mySpec: MetaSpec
    private val myResolver: ValueResolver

    internal constructor(metaRunner: MetaSpec, resolver: ValueResolver) {
        mySpec = metaRunner
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
        return other is WMetaRunner && other.mySpec == mySpec
    }
}