package jetbrains.buildServer.server.querylang.ast

data class WithInheritedFilterModifier(private val placeholder: String = "") : FilterModifier {
    companion object : FilterClasses(
        listOf("withInherited"),
        TriggerFilter::class.java.connect { it.includeInherited = true },
        StepFilter::class.java.connect { it.includeInherited = true },
        FeatureFilter::class.java.connect { it.includeInherited = true },
        ParameterFilter::class.java.connect { it.includeInherited = true },
        DependencyFilter::class.java.connect { it.includeInhereted = true },
        OptionFilter::class.java.connect { it.includeInherited = true }
    )

    override val names = Companion.names
}

data class ResolvedFilterModifier(private val placeholder: String = "") : FilterModifier {
    companion object : FilterClasses(
        listOf("resolved"),
        ParameterFilter::class.java.connect { it.searchResolved = true },
        OptionFilter::class.java.connect { it.searchResolved = true },
        ValueFilter::class.java.connect { it.searchResolved = true },
        RulesFilter::class.java.connect { it.searchResolved = true }
    )

    override val names = Companion.names
}