package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.AllElementsVisitor
import jetbrains.buildServer.server.querylang.ast.wrappers.AnyElementValidator
import jetbrains.buildServer.server.querylang.ast.wrappers.ElementValidator
import jetbrains.buildServer.server.querylang.ast.wrappers.MAllContainer

abstract class MultipleObjectsConditionFilter<Obj, NestedObj> : MAllContainer, ConditionFilter<Obj, NestedObj>() {
    override var searchAll: ElementValidator<*> = AnyElementValidator<NestedObj>()
    override fun buildVisitorFrom(subVisitor: RealObjectFilter<NestedObj>): RealObjectFilter<Obj> {
        val oldElementValidator = this.searchAll
        this.searchAll = AllElementsVisitor<NestedObj>()
        return buildFrom(subVisitor).also { this.searchAll = oldElementValidator }
    }
}

abstract class SingleObjectConditionFilter<Obj, NestedObj> : ConditionFilter<Obj, NestedObj>() {
    override fun buildVisitorFrom(subVisitor: RealObjectFilter<NestedObj>) = buildFrom(subVisitor)
}

abstract class StringFilter: Filter<String> {
    var isCaseSensitive = false
}