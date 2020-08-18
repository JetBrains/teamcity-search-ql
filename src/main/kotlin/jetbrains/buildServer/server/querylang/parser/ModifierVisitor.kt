package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.WithInheritedFilterModifier
import jetbrains.buildServer.server.querylang.ast.Filter
import jetbrains.buildServer.server.querylang.ast.FilterModifier
import jetbrains.buildServer.server.querylang.ast.ResolvedFilterModifier
import org.antlr.v4.runtime.ParserRuleContext

object ModifierVisitor : QLangGrammarBaseVisitor<FilterModifier>() {
    fun FilterModifier.applyAndCheck(filter: Filter<*>): FilterModifier {
        if (!this.apply(filter)) {
            throw ParsingException("${this.names.first()} is not a modifier of ${filter.names[0]}")
        }
        else {
            return this
        }
    }

    fun visitAndApply(ctx: ParserRuleContext, filter: Filter<*>): FilterModifier {
        return ctx.accept(this).applyAndCheck(filter)
    }

    override fun visitWithInheritedModifier(ctx: QLangGrammarParser.WithInheritedModifierContext?): FilterModifier {
        return WithInheritedFilterModifier()
    }

    override fun visitResolvedModifier(ctx: QLangGrammarParser.ResolvedModifierContext?): FilterModifier {
        return ResolvedFilterModifier()
    }
}