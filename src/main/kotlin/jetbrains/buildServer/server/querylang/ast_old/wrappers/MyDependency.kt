package jetbrains.buildServer.server.querylang.ast_old.wrappers

import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.artifacts.SArtifactDependency
import jetbrains.buildServer.serverSide.dependency.Dependency

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