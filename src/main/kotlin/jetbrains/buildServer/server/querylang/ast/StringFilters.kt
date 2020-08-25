package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.server.querylang.ast.wrappers.WParam
import jetbrains.buildServer.server.querylang.autocompl.StringStorage
import jetbrains.buildServer.server.querylang.toIdentOrString

data class EqualsStringFilter(val str: String) : StringFilter(), ObjectEvaluator<String> {
    override val names = emptyList<String>()
    override fun createStr() = str.toIdentOrString()

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.equals(str, !isCaseSensitive)}
    }

    override fun evalSimple(): List<String> {
        return listOf(str)
    }
}

data class PrefixStringFilter(val str: String) : StringFilter() {
    override val names = emptyList<String>()
    override fun createStr() = str.toIdentOrString() + '*'

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.startsWith(str, !isCaseSensitive)}
    }
}

data class SuffixStringFilter(val str: String) : StringFilter() {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str.toIdentOrString()

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.endsWith(str, !isCaseSensitive)}
    }
}

data class SubstringFilter(val str: String) : StringFilter() {
    override val names = emptyList<String>()
    override fun createStr() = '*' + str.toIdentOrString() + '*'

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {obj -> obj.contains(str, !isCaseSensitive)}
    }
}

data class StringParamFilter(
    val nameCondition: ConditionAST<String>,
    val valueCondition:  ConditionAST<String>
) : Filter<WParam>,
    ConditionSplitter<String>
{
    override val names: List<String> = emptyList()
    override fun createStr() = "${nameCondition.createStr()}=${valueCondition.createStr()}"

    val nameFilter:RealObjectFilter<String> by lazy { nameCondition.build() }
    val valueFilter:RealObjectFilter<String> by lazy { valueCondition.build() }

    override fun build():RealObjectFilter<WParam> = buildFrom(nameFilter, valueFilter)

    fun buildFrom(
        nameFilter: RealObjectFilter<String>, valueFilter: RealObjectFilter<String>
    ): RealObjectFilter<WParam> {
        return RealObjectFilter {obj ->
            nameFilter.accepts(obj.name) && valueFilter.accepts(obj.value)
        }
    }
}

interface CollectorFilter {
    fun setCollector(collector_: StringCollector)
}

class CollectorStringParamFilter : Filter<WParam>, CollectorFilter {
    override val names = emptyList<String>()
    override fun createStr() = "?"

    private lateinit var collector: StringCollector

    override fun setCollector(collector_: StringCollector) {
        collector = collector_
    }

    override fun build(): RealObjectFilter<WParam> {
        return RealObjectFilter { obj ->
            collector.addString(obj.name)
            false
        }
    }
}

data class AnyStringFilter(
    private val placeholder: String = ""
) : Filter<String> {
    override val names: List<String> = emptyList()
    override fun createStr() = "*"

    override fun build():RealObjectFilter<String> {
        return RealObjectFilter {true}
    }
}

class StringCollector {
    private val storage = StringStorage()

    fun addString(str: String) {
        storage.addString(str)
    }

    fun addAll(strList: List<String>) {
        strList.forEach { addString(it) }
    }

    fun toList(): List<String> = storage.getAllStrings()
}

class CollectorStringFilter: Filter<String>, CollectorFilter {
    override val names = emptyList<String>()

    private lateinit var collector: StringCollector

    override fun setCollector(collector_: StringCollector) {
        collector = collector_
    }

    override fun build(): RealObjectFilter<String> {
        return RealObjectFilter { obj ->
            collector.addString(obj)
            false
        }
    }

    override fun createStr() = "?"
}
