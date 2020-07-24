package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.FindMultipleTypes
import org.antlr.v4.runtime.CommonTokenStream

class GrammarParser(tokenStream: CommonTokenStream): QLangGrammarParser(tokenStream) {
    fun parse(): FindMultipleTypes {
        return MainQueryVisitor.visit(this.start())
    }
}