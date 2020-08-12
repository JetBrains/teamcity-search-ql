package jetbrains.buildServer.server.querylang.tests

import jetbrains.buildServer.server.querylang.ast_old.ConditionAST
import jetbrains.buildServer.server.querylang.ast_old.EqualsStringFilter
import jetbrains.buildServer.server.querylang.ast_old.FilterConditionNode
import jetbrains.buildServer.server.querylang.ast_old.StringFilter

internal fun String.wrapEq(): ConditionAST<StringFilter> {
    return FilterConditionNode(EqualsStringFilter(this))
}