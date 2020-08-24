package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.server.querylang.indexing.CompressedTrie
import jetbrains.buildServer.serverSide.auth.SecurityContext
import java.util.concurrent.atomic.AtomicBoolean

class SimpleStringFinder(
    override val securityContext: SecurityContext,
    override val systemAdminOnly: Boolean,
    override var disabled: AtomicBoolean
) : SecuredStringFinder()
{

    val trie = CompressedTrie<Any>()
    override val nodesTotal
        get() = trie.nodesTotal.get()
    override val symbolsTotal
        get() = trie.symbolsTotal.get()

    override fun completeStringUnsafe(prefix: String, limit: Int): List<String> {
        val realPrefix = if (prefix.startsWith("\"")) prefix.drop(1) else prefix
        return trie.complete(realPrefix, limit).map {it.escape()}
    }

    fun addString(s: String) {
        if (disabled.get()) {
            return
        }
        if (s.contains("\n")) {
            return
        }
        return trie.addString(s)
    }

    override fun clear() {
        trie.clear()
    }
}