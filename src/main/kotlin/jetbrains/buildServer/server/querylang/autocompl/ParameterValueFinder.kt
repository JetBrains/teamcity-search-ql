package jetbrains.buildServer.server.querylang.autocompl

class ParameterValueFinder: StringFinder {
    val nameTrie: Trie<Any> = Trie()
    val params: MutableMap<String, Trie<Any>> = mutableMapOf()

    override fun completeString(prefix: String, limit: Int): List<String> {
        val onlyParamRegex = """[\w\.]*""".toRegex()
        val withValueRegex = """[\w\.]+\s*=\s*\".*?""".toRegex()
        return when {
            prefix.matches(onlyParamRegex) -> completeParamName(prefix, limit)
            prefix.matches(withValueRegex) -> {
                val paramName = prefix.substringBefore("=").trim()
                val paramValue = prefix.substringAfter("\"")
                completeParamValue(paramName, paramValue, limit)
            }
            else -> listOf()
        }
    }

    fun addParam(paramName: String, paramValue: String) {
        if (!params.contains(paramName)) {
            params[paramName] = Trie()
        }
        params[paramName]!!.addString(paramValue)
        nameTrie.addString(paramName)
    }

    private fun completeParamName(paramPrefix: String, limit: Int): List<String> {
        return nameTrie.completeString(paramPrefix, limit)
    }

    private fun completeParamValue(paramName: String, valuePrefix: String, limit: Int): List<String> {
        return params[paramName]?.completeString(valuePrefix, limit) ?: emptyList()
    }
}