package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.CompressedTrie

class ParameterValueFinder: StringFinder {
    val nameTrie = CompressedTrie<Any>()
    val params: MutableMap<String, CompressedTrie<Any>> = mutableMapOf()

    override fun completeString(prefix: String, limit: Int): List<String> {
        val wordRegex = """[\w.-_]*?""".toRegex()
        val withQuoteRegex = """"[\s\S]*?""".toRegex()
        val paramOnlyRegex = """$wordRegex|$withQuoteRegex""".toRegex()
        val withValueRegex = """(([\w.-_]+?)|("[\s\S]+?"))\s*=\s*($withQuoteRegex|$wordRegex)""".toRegex()
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

    fun addParam(paramName: String, paramValue: String) {
        if (!params.contains(paramName)) {
            params[paramName] = CompressedTrie()
        }
        params[paramName]!!.addString(paramValue)
        nameTrie.addString(paramName)
    }

    private fun completeParamName(paramPrefix: String, limit: Int): List<String> {
        return nameTrie.complete(paramPrefix, limit)
    }

    private fun completeParamValue(paramName: String, valuePrefix: String, limit: Int): List<String> {
        return params[paramName]?.complete(valuePrefix, limit) ?: emptyList()
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