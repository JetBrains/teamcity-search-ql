package jetbrains.buildServer.server.querylang.ast.wrappers


interface FIdContainer {
    val id: String
}

interface FProjectContainer {
    val project: WProject
}

interface FBuildConfContainer {
    val buildConfs : List<WBuilConf>
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
