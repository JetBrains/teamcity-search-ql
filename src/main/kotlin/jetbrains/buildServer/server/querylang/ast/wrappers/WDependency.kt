package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.serverSide.artifacts.SArtifactDependency
import jetbrains.buildServer.serverSide.dependency.Dependency
import jetbrains.buildServer.util.Option
import java.lang.IllegalStateException

sealed class WDependency {
    abstract val dependsOn: WBuildConf?
}

fun SArtifactDependency.wrap() = WArtifactDependency(this)

class WArtifactDependency(override val adep: SArtifactDependency): WDependency(), OnlyArtifactDependency {
    override val dependsOn: WBuildConf?
        get() = adep.sourceBuildType?.wrap()
}

fun Dependency.wrap() = WSnapshotDependency(this)

class WSnapshotDependency(override val sdep: Dependency): WDependency(), OnlySnapshotDependency, FOptionContainer {
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

class WCombinedDependency(override val sdep: Dependency, override val adep: SArtifactDependency): WDependency(), OnlySnapshotDependency, OnlyArtifactDependency {
    override val dependsOn: WBuildConf?
        get() =
            if (adep.sourceBuildType?.externalId != sdep.dependOn?.externalId) null
            else adep.sourceBuildType?.wrap()
}

fun List<WDependency>.uniteEqual(): List<WDependency> {
    val idMap = this.groupBy { it.dependsOn?.id }

    return idMap.map {(_, deps) ->
        when {
            deps.size == 1 -> deps.first()
            deps.size == 2 -> {
                val dep1 = deps[0]
                val dep2 = deps[1]

                if (dep1 is WArtifactDependency && dep2 is WSnapshotDependency) {
                    WCombinedDependency(dep2.sdep, dep1.adep)
                }
                if (dep1 is WSnapshotDependency && dep2 is WArtifactDependency) {
                    WCombinedDependency(dep1.sdep, dep2.adep)
                }
                throw IllegalStateException()
            }
            else -> throw IllegalStateException()
        }
    }
}