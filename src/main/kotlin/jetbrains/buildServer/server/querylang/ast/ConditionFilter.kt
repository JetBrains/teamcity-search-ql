package jetbrains.buildServer.server.querylang.ast

import java.lang.IllegalStateException
import kotlin.reflect.full.primaryConstructor

abstract class ConditionFilter<Object, NestedObject>
    : Filter<Object>,
    ConditionContainer<NestedObject>,
    ConditionSplitter<NestedObject>
{
    abstract fun buildFrom(filter: RealObjectFilter<NestedObject>): RealObjectFilter<Object>

    private val conditionFilter: RealObjectFilter<NestedObject> by lazy { condition.build() }

    override fun build(): RealObjectFilter<Object> = buildFrom(conditionFilter)

    override fun evalInner(): EvalResult<NestedObject> = condition.eval()

    override fun createStr(): String = """${names.first()} ${condition.createStr()}"""

    fun transformedEval(): Pair<ObjectFilter<Object>, ObjectContainer<NestedObject>> {
        val (remFilter, objs) = eval()
        if (remFilter is RealObjectFilter) {
            return Pair(buildFrom(remFilter), objs)
        }
        else {
            return Pair(NoneObjectFilter(), objs)
        }
    }

    fun createInstance(condition: ConditionAST<NestedObject>): ConditionFilter<Object, NestedObject> {
        return this.javaClass.kotlin.primaryConstructor?.call(condition)
            ?: throw IllegalStateException("Condition filter should have primary constructor with one parameter")
    }

    abstract fun buildVisitorFrom(subVisitor: RealObjectFilter<NestedObject>): RealObjectFilter<Object>

    fun split(): VisitorStorage<Object> {
        val (remCondition, pathToCollector, straightPath) = condition.splitCondition()
        val nPathToCollector = buildVisitorFrom(pathToCollector)
        val nStraightPath = buildVisitorFrom(straightPath)
        if (remCondition is NoneConditionAST) {
            return VisitorStorage(NoneConditionAST(), nPathToCollector, nStraightPath)
        } else {
            return VisitorStorage(FilterConditionNode(createInstance(remCondition)), nPathToCollector, nStraightPath)
        }
    }
}