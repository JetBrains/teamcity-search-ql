package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.StringInfo
import jetbrains.buildServer.server.querylang.indexing.SynchronizedCompressedTrie
import jetbrains.buildServer.serverSide.auth.SecurityContext
import java.util.concurrent.atomic.AtomicBoolean

class SimpleStringFinder<T>(
    override val securityContext: SecurityContext,
    override val systemAdminOnly: Boolean,
    override var disabled: AtomicBoolean
) : SecuredStringFinder<T>()
{

    val trie = SynchronizedCompressedTrie<T>()
    override val nodesTotal
        get() = trie.nodesTotal.get()
    override val symbolsTotal
        get() = trie.symbolsTotal.get()

    override fun completeStringUnsafe(prefix: String, limit: Int): List<StringInfo<T>> {
        val realPrefix = if (prefix.startsWith("\"")) prefix.drop(1) else prefix
        return trie.complete(realPrefix, limit).map {StringInfo(it.str.escape1(), it.meta)}
    }

    fun addString(s: String, context: T? = null) {
        if (disabled.get()) {
            return
        }
        if (s.contains("\n")) {
            return
        }
        return trie.addString(s, context)
    }

    override fun clear() {
        trie.clear()
    }
}