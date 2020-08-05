package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.BuildTypeSettings
import jetbrains.buildServer.serverSide.ParametersDescriptor

object ParHolderFilterBuilder : FilterBuilder<ParameterHolderFilterType, ParametersDescriptor> {
    override fun createFilter(filter: ParameterHolderFilterType, context: Any?): ObjectFilter<ParametersDescriptor> {
        return when (filter) {
            is TypeFilter -> {
                val strFilter = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {parHolder ->
                    strFilter.accepts(parHolder.type)
                }
            }
            is ParameterFilter -> {
                val conditionVal = StringFilterBuilder.createFilter(filter.valueCondition)
                val conditionName = StringFilterBuilder.createFilter(filter.nameCondition)
                ObjectFilter {parHolder ->
                    parHolder.parameters.any {(key, value) ->
                        conditionName.accepts(key) && conditionVal.accepts(value)
                    }
                }
            }
            is ValueFilter -> {
                val conditionVal = StringFilterBuilder.createFilter(filter.strCondition)
                ObjectFilter {parHolder ->
                    parHolder.parameters.values.any {conditionVal.accepts(it)}
                }
            }
            is EnabledFilter -> {
                val buildType = context as? BuildTypeSettings
                    ?: throw java.lang.IllegalStateException("Context for ParameterHolder should be SBuildType")
                ObjectFilter {parHolder ->
                    buildType.isEnabled(parHolder.id)
                }
            }
            else -> throw java.lang.IllegalStateException("Unknown ParHolderFilter")
        }
    }
}