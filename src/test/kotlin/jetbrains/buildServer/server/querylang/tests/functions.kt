package jetbrains.buildServer.server.querylang.tests

import jetbrains.buildServer.server.querylang.ast.ConditionAST
import jetbrains.buildServer.server.querylang.ast.EqualsStringFilter
import jetbrains.buildServer.server.querylang.ast.FilterConditionNode
import jetbrains.buildServer.server.querylang.ast.StringFilter

internal fun String.wrapEq(): ConditionAST<StringFilter> {
    return FilterConditionNode(EqualsStringFilter(this))
}