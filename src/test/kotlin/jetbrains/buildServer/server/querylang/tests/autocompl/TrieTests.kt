package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.indexing.AutocompletionIndexer
import jetbrains.buildServer.server.querylang.indexing.CompressedTrie
import jetbrains.buildServer.server.querylang.indexing.ExternalAutocompletionIndexer
import jetbrains.buildServer.server.querylang.indexing.Trie
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.test.*

@Test
class TrieTests {
    private var patht = createTempDir().toPath()

    private fun getTrie(): List<AutocompletionIndexer<String>> {
        return listOf(CompressedTrie(), Trie(), ExternalAutocompletionIndexer(patht))
    }

    @BeforeMethod
    private fun setUp() {
        patht = createTempDir().toPath()
    }

    @AfterMethod
    private fun tearDown() {
        patht.toFile().deleteRecursively()
    }

    fun simpleTest() {
        getTrie().forEach { t ->
            t.addString("abacaba")

            assertTrue(t.exists("abacaba"))
        }
    }

    
    fun testAddAndGet() {
        getTrie().forEach { t ->
            t.addString("abacaba")
            t.addString("abadaba")
            t.addString("abadaca")
            t.addString("adababa")
            t.addString("badabab")
            t.addString("abacab")

            assertTrue(t.exists("abacaba"))
            assertTrue(t.exists("abadaba"))
            assertTrue(t.exists("abadaca"))
            assertTrue(t.exists("adababa"))
            assertTrue(t.exists("badabab"))
            assertTrue(t.exists("abacab"))
            assertFalse(t.exists("aba"))
            assertFalse(t.exists("abada"))
            assertFalse(t.exists("abadac"))
        }
    }

    
    fun testCompleteString() {
        getTrie().forEach { t ->
            t.addString("abac")
            t.addString("aba")
            t.addString("abad")
            t.addString("abacDD")
            t.addString("abacDA")
            t.addString(("abacDDD"))
            t.addString("abacAAAA")
            t.addString("abacDDDD")
            t.addString("abacDADD")


            val l = t.complete("abac", 4).sorted()
            val expected = listOf(
                "", "DA", "DD", "DDD"
            )
            assertEquals(expected, l)
        }
    }

    fun testCommonPrefix() {
        getTrie().forEach { t ->
            t.addString("Base_Project1")
            t.addString("Base_Project1_Project5")
            t.addString("Base_Project2")

            assertTrue(t.exists("Base_Project1"))
            assertTrue(t.exists("Base_Project1_Project5"))
            assertTrue(t.exists("Base_Project2"))
        }
    }
}