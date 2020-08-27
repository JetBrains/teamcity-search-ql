package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.parameters.ValueResolver
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.artifacts.SArtifactDependency
import jetbrains.buildServer.serverSide.dependency.Dependency
import jetbrains.buildServer.util.Option

class SuperDependency(
    val snapshotDep: WSnapshotDependency?,
    val artifactDependencies: List<WArtifactDependency>,
    override val sbuildConf: SBuildType
): AbstractWBuildConf()


sealed class WDependency {
    abstract val dependsOn: WBuildConf?
}

fun SArtifactDependency.wrap(sbuildConf: SBuildType, resolver: ValueResolver): WArtifactDependency? {
    if (!checkPermission(sbuildConf.projectId)) {
        return null
    }
    return WArtifactDependency(this, sbuildConf, resolver)
}

class WArtifactDependency(
    val adep: SArtifactDependency,
    val sbuildConf: SBuildType,
    val resolver: ValueResolver
): WDependency(), FRulesContainer {
    override val dependsOn: WBuildConf
        get() = sbuildConf.wrap()!!

    override val rules: List<ResolvableString>
        get() = adep.sourcePaths
            .lines()
            .filter {it.isNotBlank()}
            .map { ResolvableString(it, resolver) }
}

fun Dependency.wrap(sbuildConf: SBuildType, resolver: ValueResolver): WSnapshotDependency? {
    if (!checkPermission(sbuildConf.projectId)) {
        return null
    }
    return WSnapshotDependency(this, sbuildConf, resolver)
}

class WSnapshotDependency(val sdep: Dependency, val sbuildConf: SBuildType, val resolver: ValueResolver): WDependency(), FOptionContainer{
    override val dependsOn: WBuildConf
        get() = sbuildConf.wrap()!!

    override val options: List<WResolvableParam>
        get() = sdep.options.map { WResolvableParam(it.key, getOption(it).toString(), resolver) }

    override val ownOptions: List<WResolvableParam>
        get() = sdep.ownOptions.map { WResolvableParam(it.key, getOption(it).toString(), resolver) }

    override fun getOption(opt: Option<Any>): Any {
        return sdep.getOption(opt)
    }
}

fun List<WDependency>.toSuperDependencies(): List<SuperDependency> {
    return this.groupBy { it.dependsOn?.sbuildConf?.externalId }.mapNotNull { (key, value) ->
        if (key == null) null
        else {
            var sdep: WSnapshotDependency? = null
            val adep = mutableListOf<WArtifactDependency>()
            value.forEach { dep ->
                when (dep) {
                    is WSnapshotDependency -> {
                        if (sdep != null) throw IllegalStateException("Build configuration has two snapshot dependencies on the same configuration")
                        sdep = dep
                    }
                    is WArtifactDependency -> {
                        adep.add(dep)
                    }
                }
            }
            val sbuildType = sdep?.dependsOn?.sbuildConf ?: adep.firstOrNull()?.adep?.sourceBuildType
            sbuildType?.let {SuperDependency(sdep, adep, it)}
        }
    }
}