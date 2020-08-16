package jetbrains.buildServer.server.querylang.indexing

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.index.*
import org.apache.lucene.index.IndexReader
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.PrefixQuery
import org.apache.lucene.store.NIOFSDirectory
import java.nio.file.Path

class ExternalPrefixIndexer(val path: Path) : LuceneIndexer() {
    override val directory = NIOFSDirectory(path)
    override  val analyzer = StandardAnalyzer()

    override fun complete(str: String, limit: Int): List<String> {
        val reader: IndexReader = DirectoryReader.open(indexWriter)
        val searcher = IndexSearcher(reader)

        val query = PrefixQuery(Term("str", str))
        val doc = searcher.search(query, limit)
        return doc.scoreDocs.map {searcher.doc(it.doc).get("str")}
    }
}