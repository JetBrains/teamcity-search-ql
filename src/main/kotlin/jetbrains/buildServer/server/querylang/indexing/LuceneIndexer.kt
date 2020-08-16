package jetbrains.buildServer.server.querylang.indexing

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.index.*
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.TermQuery
import org.apache.lucene.store.Directory

abstract class LuceneIndexer : AutocompletionIndexer<String> {
    protected abstract val directory: Directory
    protected abstract val analyzer: Analyzer
    protected val config : IndexWriterConfig by lazy {
        IndexWriterConfig(analyzer)
    }
    protected val indexWriter: IndexWriter by lazy {
        IndexWriter(directory, config)
    }

    open fun formField(str: String): Field = StringField("str", str, Field.Store.YES)

    override fun addString(str: String, obj: String?) {
        val doc = Document()
        doc.add(formField(str))
        doc.add(StringField("obj", obj.toString(), Field.Store.NO))
        indexWriter.addDocument(doc)
    }

    override fun exists(str: String): Boolean {
        val reader: IndexReader = DirectoryReader.open(indexWriter)
        val searcher = IndexSearcher(reader)

        val query = TermQuery(Term("str", str))
        val doc = searcher.search(query, 10)
        return doc.scoreDocs.isNotEmpty()
    }
}