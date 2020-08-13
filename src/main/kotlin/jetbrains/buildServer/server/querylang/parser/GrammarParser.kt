package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.MainQuery
import org.antlr.v4.runtime.CommonTokenStream

class GrammarParser(tokenStream: CommonTokenStream): QLangGrammarParser(tokenStream) {
    fun parse(): MainQuery {
        return MainQueryVisitor.visit(this.start())
    }
}