package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.buildTriggers.BuildTriggerDescriptor
import jetbrains.buildServer.serverSide.BuildRunnerDescriptor
import jetbrains.buildServer.serverSide.ParametersDescriptor
import jetbrains.buildServer.serverSide.SBuildFeatureDescriptor
import jetbrains.buildServer.serverSide.SProjectFeatureDescriptor

abstract class WParametersDescriptor(val obj: ParametersDescriptor): FParamContainer, FEnabledContainer {
    override val params: Map<String, String>
        get() = obj.parameters

    override val ownParams: Map<String, String>
        get() = params
}

fun BuildTriggerDescriptor.wrap() = WTrigger(this)

class WTrigger(strigger: BuildTriggerDescriptor) : WParametersDescriptor(strigger)

fun BuildRunnerDescriptor.wrap() = WStep(this)

class WStep(sstep: BuildRunnerDescriptor) : WParametersDescriptor(sstep)

fun SBuildFeatureDescriptor.wrap() = WBuildTypeFeature(this)

fun SProjectFeatureDescriptor.wrap() = WProjectFeature(this)

abstract class WFeature(paramDescriptor: ParametersDescriptor) : WParametersDescriptor(paramDescriptor)

class WBuildTypeFeature(sfeature: SBuildFeatureDescriptor) : WFeature(sfeature)

class WProjectFeature(sfeature: SProjectFeatureDescriptor) : WFeature(sfeature)