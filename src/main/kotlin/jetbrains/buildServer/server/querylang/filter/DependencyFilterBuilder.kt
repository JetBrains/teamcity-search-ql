package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.ArtifactFilter
import jetbrains.buildServer.server.querylang.ast.BuildConfFilterType
import jetbrains.buildServer.server.querylang.ast.DependencyFilterType
import jetbrains.buildServer.server.querylang.ast.SnapshotFilter
import jetbrains.buildServer.serverSide.BuildTypeSettings
import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.artifacts.SArtifactDependency
import jetbrains.buildServer.serverSide.dependency.Dependency
import jetbrains.buildServer.serverSide.dependency.DependencySettings

object DependencyFilterBuilder : FilterBuilder<DependencyFilterType, DependencyFilterBuilder.MyDependency> {
    override fun createFilter(filter: DependencyFilterType, context: Any?): ObjectFilter<MyDependency> {
        return when (filter) {
            is BuildConfFilterType -> {
                val bcFilter = BuildConfFilterBuilder.createFilter(filter)
                ObjectFilter {obj ->
                    bcFilter.accepts(obj.dependOn)
                }
            }
            is ArtifactFilter -> {
                val buildType = context as? BuildTypeSettings ?: throw IllegalStateException("Context should be BuildTypeSettings")
                ObjectFilter {obj ->
                    buildType.artifactDependencies.any {it.sourceBuildType!!.externalId == obj.dependOn?.externalId}
                }
            }
            is SnapshotFilter -> {
                val condFilter = SnapshotFilterBuilder.createFilter(filter.condition)
                ObjectFilter {obj ->
                    (obj is MySnapshotDependency) && condFilter.accepts(obj)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown dependency filter")
        }
    }

    interface MyDependency {
        val dependOn: SBuildType?
    }

    class MySnapshotDependency(val dep: Dependency) : MyDependency {
        override val dependOn: SBuildType?
           get() = dep.dependOn
    }
    class MyArtifactDependency(val dep: SArtifactDependency) : MyDependency {
        override val dependOn: SBuildType?
            get() = dep.sourceBuildType
    }
}