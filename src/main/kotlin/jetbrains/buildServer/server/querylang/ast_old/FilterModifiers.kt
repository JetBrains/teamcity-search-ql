package jetbrains.buildServer.server.querylang.ast_old

data class AllFilterModifier(private val placeholder: String = "") : FilterModifier {
    companion object : FilterClasses(
        listOf("all"),
        TriggerFilter::class.java.connect { it.includeInherited = true },
        StepFilter::class.java.connect { it.includeInherited = true },
        FeatureFilter::class.java.connect { it.includeInherited = true },
        ParameterFilter::class.java.connect { it.includeInherited = true },
        DependencyFilter::class.java.connect { it.includeInhereted = true },
        OptionFilter::class.java.connect { it.includeInherited = true }
    )

    override val names = Companion.names
}