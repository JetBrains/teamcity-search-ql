package jetbrains.buildServer.server.querylang.indexing

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.*
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.PrefixQuery
import org.apache.lucene.search.TermQuery
import org.apache.lucene.store.NIOFSDirectory
import java.nio.file.Path

class ExternalAutocompletionIndexer(val path: Path) : AutocompletionIndexer<String> {
    private val directory = NIOFSDirectory(path)
    private val analyzer = StandardAnalyzer()
    private val config = IndexWriterConfig(analyzer)
    private val indexWriter = IndexWriter(directory, config)

    private fun addStringtoIndex(str: String, obj: String?) {
        val doc = Document()
        doc.add(StringField("str", str, Field.Store.YES))
        doc.add(StringField("obj", obj.toString(), Field.Store.NO))
        indexWriter.addDocument(doc)
    }

    override fun addString(str: String, obj: String?) {
        addStringtoIndex(str, obj)
    }

    override fun exists(str: String): Boolean {
        val reader: IndexReader = DirectoryReader.open(indexWriter)
        val searcher = IndexSearcher(reader)

        val query = TermQuery(Term("str", str))
        val doc = searcher.search(query, 10)
        return doc.scoreDocs.isNotEmpty()
    }

    override fun complete(str: String, limit: Int): List<String> {
        val reader: IndexReader = DirectoryReader.open(indexWriter)
        val searcher = IndexSearcher(reader)

        val query = PrefixQuery(Term("str", str))
        val doc = searcher.search(query, limit)
        return doc.scoreDocs.map {searcher.doc(it.doc).get("str")}.map {it.drop(str.length)}
    }
}