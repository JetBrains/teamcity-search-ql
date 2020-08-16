package jetbrains.buildServer.server.querylang.indexing

import org.apache.lucene.store.NIOFSDirectory
import java.nio.file.Path

class ExternalSubstringIndexer(path: Path) : LuceneSubstringIndexer() {
    override val directory = NIOFSDirectory(path)
}