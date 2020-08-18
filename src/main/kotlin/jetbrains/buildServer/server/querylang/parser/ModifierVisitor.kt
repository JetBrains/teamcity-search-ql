package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import org.antlr.v4.runtime.ParserRuleContext

class ModifierVisitor(val filter: Filter<*>) : QLangGrammarBaseVisitor<FilterModifier<*>>() {
    inline fun <reified T> FilterModifier<T>.applyAndCheck(): FilterModifier<T> {
        if (!FilterRegistration.canBeModifier(filter::class, this::class)) {
            throw ParsingException("${this.names.first()} is not a modifier of ${filter.names[0]}")
        }
        this.apply((filter as T))
        return this
    }

    override fun visitWithInheritedModifier(ctx: QLangGrammarParser.WithInheritedModifierContext?): FilterModifier<*> {
        return WithInheritedFilterModifier().applyAndCheck()
    }

    override fun visitResolvedModifier(ctx: QLangGrammarParser.ResolvedModifierContext?): FilterModifier<*> {
        return ResolvedFilterModifier().applyAndCheck()
    }
}