package jetbrains.buildServer.server.querylang.filter

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.BuildTypeSettings
import jetbrains.buildServer.serverSide.ParametersDescriptor

object ParHolderFilterBuilder : FilterBuilder<ParameterHolderFilterType, ParametersDescriptor> {
    override fun createFilter(filter: ParameterHolderFilterType, context: Any?): ObjectFilter<ParametersDescriptor> {
        return when (filter) {
            is TypeFilter -> {
                ObjectFilter {parHolder ->
                    parHolder.type == filter.str
                }
            }
            is ParameterFilter -> {
                val conditionVal = StringFilterBuilder.createFilter(filter.valueCondition)
                ObjectFilter {parHolder ->
                    parHolder.parameters.containsKey(filter.option)
                            && conditionVal.accepts(parHolder.parameters[filter.option])
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