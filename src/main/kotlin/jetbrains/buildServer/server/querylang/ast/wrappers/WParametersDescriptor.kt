package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.buildTriggers.BuildTriggerDescriptor
import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.serverSide.*

abstract class WParametersDescriptor(
    val obj: ParametersDescriptor
) : FParamContainer,
    FEnabledContainer,
    FTypeContainer,
    FValueContainer
{
    abstract val resolver: ValueResolver
    override val params: List<WResolvableParam>
        get() = obj.parameters.map { (a, b) -> WResolvableParam(a, b, resolver) }

    override val ownParams: List<WResolvableParam>
        get() = params

    override val type: String
        get() = obj.type

    override val values: List<ResolvableString>
        get() = params.map { it.toValue() }
}

fun BuildTriggerDescriptor.wrap(bt: SBuildType) = WTrigger(this, bt.valueResolver, bt.isEnabled(this.id))
fun BuildTriggerDescriptor.wrap(bt: BuildTypeTemplate) = WTrigger(this, bt.valueResolver, bt.isEnabled(this.id))

class WTrigger(
    strigger: BuildTriggerDescriptor,
    override val resolver: ValueResolver,
    override val isEnabled: Boolean
) : WParametersDescriptor(strigger)

fun BuildRunnerDescriptor.wrap(bt: SBuildType) = WStep(this, bt.valueResolver, bt.isEnabled(this.id))
fun BuildRunnerDescriptor.wrap(bt: BuildTypeTemplate) = WStep(this, bt.valueResolver, bt.isEnabled(this.id))

class WStep(
    sstep: BuildRunnerDescriptor,
    override val resolver: ValueResolver,
    override val isEnabled: Boolean
) : WParametersDescriptor(sstep)

fun SBuildFeatureDescriptor.wrap(bt: SBuildType) = WBuildTypeFeature(this, bt.valueResolver, bt.isEnabled(this.id))
fun SBuildFeatureDescriptor.wrap(bt: BuildTypeTemplate) = WBuildTypeFeature(this, bt.valueResolver, bt.isEnabled(this.id))

fun SProjectFeatureDescriptor.wrap(bt: SProject) = WProjectFeature(this, bt.valueResolver, true)

abstract class WFeature(
    paramDescriptor: ParametersDescriptor,
    override val resolver: ValueResolver,
    override val isEnabled: Boolean
) : WParametersDescriptor(paramDescriptor)

class WBuildTypeFeature(
    sfeature: SBuildFeatureDescriptor,
    resolver: ValueResolver,
    isEnabled: Boolean
) : WFeature(sfeature, resolver, isEnabled)

class WProjectFeature(
    sfeature: SProjectFeatureDescriptor,
    resolver: ValueResolver,
    isEnabled: Boolean
) : WFeature(sfeature, resolver, isEnabled)