package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.buildTriggers.BuildTriggerDescriptor
import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.serverSide.BuildRunnerDescriptor
import jetbrains.buildServer.serverSide.ParametersDescriptor
import jetbrains.buildServer.serverSide.SBuildFeatureDescriptor
import jetbrains.buildServer.serverSide.SProjectFeatureDescriptor

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

fun BuildTriggerDescriptor.wrap(resolver: ValueResolver) = WTrigger(this, resolver)

class WTrigger(strigger: BuildTriggerDescriptor, override val resolver: ValueResolver) : WParametersDescriptor(strigger)

fun BuildRunnerDescriptor.wrap(resolver: ValueResolver) = WStep(this, resolver)

class WStep(sstep: BuildRunnerDescriptor, override val resolver: ValueResolver) : WParametersDescriptor(sstep)

fun SBuildFeatureDescriptor.wrap(resolver: ValueResolver) = WBuildTypeFeature(this, resolver)

fun SProjectFeatureDescriptor.wrap(resolver: ValueResolver) = WProjectFeature(this, resolver)

abstract class WFeature(
    paramDescriptor: ParametersDescriptor,
    override val resolver: ValueResolver
) : WParametersDescriptor(paramDescriptor)

class WBuildTypeFeature(sfeature: SBuildFeatureDescriptor, resolver: ValueResolver) : WFeature(sfeature, resolver)

class WProjectFeature(sfeature: SProjectFeatureDescriptor, resolver: ValueResolver) : WFeature(sfeature, resolver)