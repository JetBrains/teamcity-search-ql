package jetbrains.buildServer.server.querylang.ast

interface ObjectVisitor<in Obj> {
    fun generateVisitor(): RealObjectFilter<Obj>
}