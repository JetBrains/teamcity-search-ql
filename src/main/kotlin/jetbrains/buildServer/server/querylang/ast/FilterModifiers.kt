package jetbrains.buildServer.server.querylang.ast

data class AllFilterModifier(private val placeholder: String = "") : FilterModifier {
    companion object : FilterClasses(
        listOf("all"),
        TriggerFilter::class.java.connect { it.includeInherited = true }
    )

    override val names = Companion.names
}