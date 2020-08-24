package jetbrains.buildServer.server.querylang.indexing

import java.util.concurrent.locks.ReentrantReadWriteLock

abstract class AutoSynchronizedIndexer<T>: SynchronizedIndexer<T> {
    protected val lock = ReentrantReadWriteLock()

    protected abstract fun addStringUnsafe(str: String, obj: T?)

    protected abstract fun completeUnsafe(str: String, limit: Int): List<String>

    protected abstract fun existsUnsafe(str: String): Boolean

    protected abstract fun clearUnsafe()

    final override fun addString(str: String, obj: T?) {
        lock.writeLock().lock()
        addStringUnsafe(str, obj)
        lock.writeLock().unlock()
    }

    final override fun complete(str: String, limit: Int): List<String> {
        lock.readLock().lock()
        val res = completeUnsafe(str, limit)
        lock.readLock().unlock()
        return res
    }

    final override fun exists(str: String): Boolean {
        lock.readLock().lock()
        val res = existsUnsafe(str)
        lock.readLock().unlock()
        return res
    }

    final override fun clear() {
        lock.writeLock().lock()
        clearUnsafe()
        lock.writeLock().unlock()
    }
}