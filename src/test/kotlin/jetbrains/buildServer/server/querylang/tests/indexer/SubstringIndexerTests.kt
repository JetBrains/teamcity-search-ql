package jetbrains.buildServer.server.querylang.tests.indexer

import jetbrains.buildServer.server.querylang.indexing.*
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.test.assertEquals

@Test
class SubstringIndexerTests {
    private var patht = createTempDir().toPath()

    private fun getIndexer(): List<SynchronizedIndexer<String>> {
        return listOf(RAMSubstringIndexer(), ExternalSubstringIndexer(patht))
    }

    @BeforeMethod
    private fun setUp() {
        patht = createTempDir().toPath()
    }

    @AfterMethod
    private fun tearDown() {
        patht.toFile().deleteRecursively()
    }


    fun testFindSubstring() {
        getIndexer().forEach {indexer ->
            indexer.addString("abacaba")
            indexer.addString("prefix.value.abacaba")
            indexer.addString("path=home/user")
            indexer.addString("%param% + abacaba")
            indexer.addString("ab?caba*?daba")

            val res = indexer.complete("cab", 100)
            val expected = listOf(
                "abacaba",
                "prefix.value.abacaba",
                "%param% + abacaba",
                "ab?caba*?daba"
            )

            assertEquals(expected, res)
        }
    }

    fun testFindSubstringWithSpecial() {
        getIndexer().forEach {indexer ->
            indexer.addString("abacaba")
            indexer.addString("prefix.value.abacaba")
            indexer.addString("path=home/user/?caba/dababa")
            indexer.addString("%param% + abacaba")
            indexer.addString("ab?caba*?daba")

            val res = indexer.complete("?cab", 100)
            val expected = listOf(
                "path=home/user/?caba/dababa",
                "ab?caba*?daba"
            )

            assertEquals(expected, res)
        }
    }
}