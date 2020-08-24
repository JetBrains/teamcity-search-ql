package jetbrains.buildServer.server.querylang.indexing

import org.apache.lucene.store.RAMDirectory

class RAMSubstringIndexer : LuceneSubstringIndexer() {
    override val directory = RAMDirectory()

    override fun clear() {
        TODO()
    }
}