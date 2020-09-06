package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.StringInfo
import jetbrains.buildServer.server.querylang.indexing.SynchronizedCompressedTrie
import jetbrains.buildServer.serverSide.auth.SecurityContext
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.locks.ReentrantReadWriteLock

class ParameterValueFinder<T>(
    override val securityContext: SecurityContext,
    override val systemAdminOnly: Boolean,
    val defaultValueSysAdminOnly: Boolean,
    override var disabled: AtomicBoolean,
    val disabledValue: Boolean,
    val lengthLimit: Int,
    val cntLimit: Int
): SecuredStringFinder<T>() {

    val nameTrie = SynchronizedCompressedTrie<T>()
    val params: MutableMap<String, SimpleStringFinder<T>> = mutableMapOf()

    private val paramNameLock = ReentrantReadWriteLock()

    override val symbolsTotal: Long
        get() {
            paramNameLock.readLock().lock()
            val res = params.values.fold(0L, {acc, sf -> acc + sf.symbolsTotal}) + nameTrie.symbolsTotal.get()
            paramNameLock.readLock().unlock()
            return res
        }
    override val nodesTotal: Long
        get() {
            paramNameLock.readLock().lock()
            val res = params.values.fold(0L, {acc, sf -> acc + sf.nodesTotal}) + nameTrie.nodesTotal.get()
            paramNameLock.readLock().unlock()
            return res
        }

    override fun completeStringUnsafe(prefix: String, limit: Int): List<StringInfo<T>> {
        val wordRegex = """[\w.\-_]*?""".toRegex()
        val withQuoteRegex = """"[\s\S]*?""".toRegex()
        val paramOnlyRegex = """$wordRegex|$withQuoteRegex""".toRegex()
        val withValueRegex = """(([\w.\-_]+?)|("[\s\S]+?"))\s*=\s*($withQuoteRegex|$wordRegex)""".toRegex()
        return when {
            prefix.matches(withValueRegex) -> {
                val paramName = prefix.substringBefore("=").trim().removeQuotationMarks()
                val paramValue = prefix.substringAfter("=").trimStart().removeStartMarks()
                val vars = completeParamValue(paramName, paramValue, limit)
                vars.map {StringInfo(paramName.escape1() + "=" + it.str, it.meta)}
            }
            prefix.matches(paramOnlyRegex) || prefix.isEmpty() ->
                completeParamName(prefix.removeStartMarks(), limit)
                    .map {StringInfo(it.str.escape1(), it.meta)}
            else -> listOf()
        }
    }

    fun addParam(paramName: String, paramValue: String, valSystemAdminOnly: Boolean = defaultValueSysAdminOnly) {
        if (disabled.get()) {
            return
        }
        if (paramValue.length > lengthLimit || paramName.contains("\n") || paramValue.contains("\n")) {
            return
        }

        paramNameLock.writeLock().lock()

        if (!params.contains(paramName)) {
            params[paramName] = SimpleStringFinder(securityContext, valSystemAdminOnly, AtomicBoolean(disabledValue))
        }

        if (!paramName.startsWith("secure:")) {
            val ptrie = params[paramName]!!
            ptrie.addString(paramValue)
            if (ptrie.trie.stringsTotal.get() > cntLimit) {
                ptrie.clear()
                ptrie.disabled.set(true)
            }
        }

        paramNameLock.writeLock().unlock()

        nameTrie.addString(paramName)
    }

    override fun clear() {
        nameTrie.clear()

        paramNameLock.writeLock().lock()
        params.clear()
        paramNameLock.writeLock().unlock()
    }

    private fun completeParamName(paramPrefix: String, limit: Int): List<StringInfo<T>> {
        return nameTrie.complete(paramPrefix, limit)
    }

    private fun completeParamValue(paramName: String, valuePrefix: String, limit: Int): List<StringInfo<T>> {
        paramNameLock.readLock().lock()
        val res = params[paramName]?.completeString(valuePrefix, limit) ?: emptyList()
        paramNameLock.readLock().unlock()
        return res
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