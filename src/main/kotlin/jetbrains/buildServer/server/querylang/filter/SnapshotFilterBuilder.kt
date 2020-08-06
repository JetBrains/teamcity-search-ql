package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.OptionFilter
import jetbrains.buildServer.server.querylang.ast.SnapshotDepFilterType
import jetbrains.buildServer.serverSide.SBuildType

object SnapshotFilterBuilder: FilterBuilder<SnapshotDepFilterType, DependencyFilterBuilder.MySnapshotDependency> {
    override fun createFilter(filter: SnapshotDepFilterType, context: Any?): ObjectFilter<DependencyFilterBuilder.MySnapshotDependency> {
        return when(filter) {
            is OptionFilter -> {
                val nameFilter = StringFilterBuilder.createFilter(filter.nameCondition)
                val valFilter = StringFilterBuilder.createFilter(filter.valueCondition)
                ObjectFilter {obj ->
                    obj.dep.options.any {opt ->
                        nameFilter.accepts(opt.key) && valFilter.accepts(obj.dep.getOption(opt).toString())
                    }
                }
            }
            else -> throw IllegalStateException("Unknown SnapshotDepFilterType")
        }
    }
}