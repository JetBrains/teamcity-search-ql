package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.server.querylang.fromIdentOrString

object StringFilterVisitor : QLangGrammarBaseVisitor<StringFilter>() {
    override fun visitStringFilter(ctx: QLangGrammarParser.StringFilterContext?): StringFilter {
        return ctx!!.children.first().accept(this)
    }

    override fun visitStringEqualsFilter(ctx: QLangGrammarParser.StringEqualsFilterContext?): StringFilter {
        return EqualsStringFilter(ctx!!.text.fromIdentOrString())
    }

    override fun visitStringPrefixFilter(ctx: QLangGrammarParser.StringPrefixFilterContext?): StringFilter {
        return PrefixStringFilter(ctx!!.PREFIXS().text.dropLast(1).fromIdentOrString())
    }

    override fun visitStringSuffixFilter(ctx: QLangGrammarParser.StringSuffixFilterContext?): StringFilter {
        return SuffixStringFilter(ctx!!.SUFFIXS().text.drop(1).fromIdentOrString())
    }

    override fun visitStringSubstringFilter(ctx: QLangGrammarParser.StringSubstringFilterContext?): StringFilter {
        return SubstringFilter(ctx!!.SUBSTRINGS().text.drop(1).dropLast(1).fromIdentOrString())
    }
}