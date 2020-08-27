package jetbrains.buildServer.server.querylang.autocompl

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

    override fun completeStringUnsafe(prefix: String, limit: Int): List<Pair<String, T?>> {
        val realPrefix = if (prefix.startsWith("\"")) prefix.drop(1) else prefix
        return trie.complete(realPrefix, limit).map {Pair(it.first.escape1(), it.second)}
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