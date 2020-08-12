package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.serverSide.artifacts.SArtifactDependency
import jetbrains.buildServer.serverSide.dependency.Dependency
import jetbrains.buildServer.util.Option


interface FIdContainer {
    val id: String
}

interface FProjectContainer {
    val project: WProject
}

interface FBuildConfContainer {
    val buildConfs : List<WBuildConf>
}

interface FVcsRootContainer {
    val vcsRoots : List<WVcsRoot>
}

interface FParentContainer {
    val parent: WProject?
}

interface FTriggerContainer : EnabledChecker {
    val triggers: List<WTrigger>
    val ownTriggers: List<WTrigger>
}

interface FStepContainer : EnabledChecker {
    val steps: List<WStep>
    val ownSteps: List<WStep>
}

interface FFeatureContainer : EnabledChecker {
    val features: List<WFeature>
    val ownFeatures: List<WFeature>
}

interface FTemplateContainer {
    val templates: List<WTemplate>
}

interface FParamContainer {
    val ownParams: Map<String, String>
    val params: Map<String, String>
}

interface FEnabledContainer

interface FAncestorContainer {
    val firstAncestor: WProject?
}

interface FVcsRootEntryContainer {
    val vcsRootEntry: WVcsRootEntry
}

interface FDependencyContainer {
    val dependencies: List<WDependency>
    val ownDependencies: List<WDependency>
}

interface OnlyArtifactDependency {
    val adep: SArtifactDependency
}

interface OnlySnapshotDependency {
    val sdep: Dependency
}

interface FOptionContainer {
    val options: Collection<Option<Any>>
    val ownOptions: Collection<Option<Any>>

    fun getOption(opt: Option<Any>) : Any
}