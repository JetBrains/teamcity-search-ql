package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.server.querylang.mySecurityContext
import jetbrains.buildServer.serverSide.auth.Permission

fun checkPermission(projectId: String): Boolean {
    return mySecurityContext.authorityHolder.isPermissionGrantedForProject(projectId, Permission.EDIT_PROJECT) ||
            mySecurityContext.authorityHolder.isPermissionGrantedForProject(projectId, Permission.VIEW_BUILD_CONFIGURATION_SETTINGS)
}

interface TopLevelObject

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
    val ownParams: List<WResolvableParam>
    val params: List<WResolvableParam>
}

interface FEnabledContainer {
    val isEnabled: Boolean
}

interface FAncestorContainer {
    val firstAncestor: WProject?
}

interface FVcsRootEntryContainer {
    val ownVcsRootEntries: List<WVcsRootEntry>
    val vcsRootEntries: List<WVcsRootEntry>
}

interface FDependencyContainer {
    val dependencies: List<SuperDependency>
    val ownDependencies: List<SuperDependency>
}

interface FOptionContainer {
    val resolver: ValueResolver
    val optionRetriever: DefaultOptions
    val options: List<WResolvableParam>
        get() = optionRetriever.getOptions().map { WResolvableParam(it.first, it.second, resolver) }
}

interface FTypeContainer {
    val type: String
}

interface FRulesContainer {
    val rules: List<ResolvableString>
}

interface FValueContainer {
    val values: List<ResolvableString>
}

interface FNameContainer {
    val name: String
}

interface FSubProjectContainer {
    val subProjects: List<WProject>
}

interface FArchivedContainer {
    val isArchived: Boolean
}