package jetbrains.buildServer.server.querylang.indexing

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.index.*
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.WildcardQuery
import org.apache.lucene.store.RAMDirectory
import org.apache.lucene.queryparser.classic.QueryParser

abstract class LuceneSubstringIndexer : LuceneIndexer() {
    override val analyzer = StandardAnalyzer()

    override fun addString(str: String, obj: String?) {
        val doc = Document()
        doc.add(StringField("str", str, Field.Store.YES))
        doc.add(StringField("obj", obj.toString(), Field.Store.NO))
        indexWriter.addDocument(doc)
    }

    override fun complete(str: String, limit: Int): List<String> {
        val reader: IndexReader = DirectoryReader.open(indexWriter)
        val searcher = IndexSearcher(reader)

        val text = QueryParser.escape(str)
        val query = WildcardQuery(Term("str", "*${text}*"))
        val doc = searcher.search(query, limit)
        return doc.scoreDocs.map {searcher.doc(it.doc).get("str")}
    }
}