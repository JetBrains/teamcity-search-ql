package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.CompressedTrie
import jetbrains.buildServer.serverSide.impl.audit.finders.StringFinder

class ParameterValueFinder(
    override val compl: CompletionManager,
    override val systemAdminOnly: Boolean,
    val defaultValueSysAdminOnly: Boolean,
    override var disabled: Boolean,
    val disabledValue: Boolean,
    val lengthLimit: Int,
    val cntLimit: Int
): SecuredStringFinder() {
    val nameTrie = CompressedTrie<Any>()
    val params: MutableMap<String, SimpleStringFinder> = mutableMapOf()

    override val symbolsTotal: Long
        get() = params.values.fold(0L, {acc, sf -> acc + sf.symbolsTotal}) + nameTrie.symbolsTotal
    override val nodesTotal: Long
        get() = params.values.fold(0L, {acc, sf -> acc + sf.nodesTotal}) + nameTrie.nodesTotal

    override fun completeStringUnsafe(prefix: String, limit: Int): List<String> {
        val wordRegex = """[\w.\-_]*?""".toRegex()
        val withQuoteRegex = """"[\s\S]*?""".toRegex()
        val paramOnlyRegex = """$wordRegex|$withQuoteRegex""".toRegex()
        val withValueRegex = """(([\w.\-_]+?)|("[\s\S]+?"))\s*=\s*($withQuoteRegex|$wordRegex)""".toRegex()
        return when {
            prefix.matches(withValueRegex) -> {
                val paramName = prefix.substringBefore("=").trim().removeQuotationMarks()
                val paramValue = prefix.substringAfter("=").trimStart().removeStartMarks()
                val vars = completeParamValue(paramName, paramValue, limit)
                vars.map {paramName.escape() + "=" + (it).escape()}
            }
            prefix.matches(paramOnlyRegex) || prefix.isEmpty() -> completeParamName(prefix.removeStartMarks(), limit).map {(it).escape()}
            else -> listOf()
        }
    }

    fun addParam(paramName: String, paramValue: String, valSystemAdminOnly: Boolean = defaultValueSysAdminOnly) {
        if (disabled) {
            return
        }
        if (paramValue.length > lengthLimit || paramName.contains("\n") || paramValue.contains("\n")) {
            return
        }

        if (!params.contains(paramName)) {
            params[paramName] = SimpleStringFinder(compl, valSystemAdminOnly, disabledValue)
        }

        if (!paramName.startsWith("secure:")) {
            val ptrie = params[paramName]!!
            ptrie.addString(paramValue)
            if (ptrie.trie.stringsTotal > cntLimit) {
                ptrie.clear()
                ptrie.disabled = true
            }
        }

        nameTrie.addString(paramName)
    }

    override fun clear() {
        nameTrie.clear()
        params.clear()
    }

    private fun completeParamName(paramPrefix: String, limit: Int): List<String> {
        return nameTrie.complete(paramPrefix, limit)
    }

    private fun completeParamValue(paramName: String, valuePrefix: String, limit: Int): List<String> {
        return params[paramName]?.completeString(valuePrefix, limit) ?: emptyList()
    }

    private fun String.removeStartMarks(): String {
        if (this.startsWith("\"")) {
            return this.drop(1)
        }
        else {
            return this
        }
    }
}