package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.ArtifactFilter
import jetbrains.buildServer.server.querylang.ast.BuildConfFilterType
import jetbrains.buildServer.server.querylang.ast.DependencyFilterType
import jetbrains.buildServer.server.querylang.ast.SnapshotFilter
import jetbrains.buildServer.serverSide.BuildTypeSettings
import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.dependency.DependencySettings

object DependencyFilterBuilder : FilterBuilder<DependencyFilterType, SBuildType> {
    override fun createFilter(filter: DependencyFilterType, context: Any?): ObjectFilter<SBuildType> {
        return when (filter) {
            is BuildConfFilterType -> {
                BuildConfFilterBuilder.createFilter(filter)
            }
            is ArtifactFilter -> {
                val buildType = context as? BuildTypeSettings ?: throw IllegalStateException("Context should be BuildTypeSettings")
                ObjectFilter {obj ->
                    buildType.artifactDependencies.any {it.sourceBuildType!!.externalId == obj.externalId}
                }
            }
            is SnapshotFilter -> {
                val buildType = context as? DependencySettings ?: throw IllegalStateException("Context should be DependencySettings")
                ObjectFilter {obj ->
                    buildType.dependencies.any {it.dependOn?.externalId == obj.externalId}
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown dependency filter")
        }
    }
}