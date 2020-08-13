package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.AllFilterModifier
import jetbrains.buildServer.server.querylang.ast.Filter
import jetbrains.buildServer.server.querylang.ast.FilterModifier
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

    override fun visitAllModifier(ctx: QLangGrammarParser.AllModifierContext?): FilterModifier {
        return AllFilterModifier()
    }
}