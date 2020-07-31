package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.ArtifactFilter
import jetbrains.buildServer.server.querylang.ast.BuildConfFilterType
import jetbrains.buildServer.server.querylang.ast.DependencyFilterType
import jetbrains.buildServer.server.querylang.ast.SnapshotFilter
import jetbrains.buildServer.serverSide.SBuildType

object DependencyFilterBuilder : FilterBuilder<DependencyFilterType, SBuildType> {
    override fun createFilter(filter: DependencyFilterType, context: Any?): ObjectFilter<SBuildType> {
        return when (filter) {
            is BuildConfFilterType -> {
                BuildConfFilterBuilder.createFilter(filter)
            }
            is ArtifactFilter -> {
                val buildType = context as? SBuildType ?: throw IllegalStateException("Context should be SBuildType")
                ObjectFilter {obj ->
                    buildType.artifactDependencies.any {it.sourceBuildType!!.externalId == obj.externalId}
                }
            }
            is SnapshotFilter -> {
                val buildType = context as? SBuildType ?: throw IllegalStateException("Context should be SBuildType")
                ObjectFilter {obj ->
                    buildType.dependencies.any {it.dependOn?.externalId == obj.externalId}
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown dependency filter")
        }
    }
}