package jetbrains.buildServer.server.querylang.ast.wrappers

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

fun SArtifactDependency.wrap() = WArtifactDependency(this)

class WArtifactDependency(val adep: SArtifactDependency): WDependency(), FRulesContainer {
    override val dependsOn: WBuildConf?
        get() = adep.sourceBuildType?.wrap()

    override val rules: String
        get() = adep.sourcePaths
}

fun Dependency.wrap() = WSnapshotDependency(this)

class WSnapshotDependency(val sdep: Dependency): WDependency(), FOptionContainer{
    override val dependsOn: WBuildConf?
        get() = sdep.dependOn?.wrap()

    override val options: Collection<Option<Any>>
        get() = sdep.options

    override val ownOptions: Collection<Option<Any>>
        get() = sdep.ownOptions

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