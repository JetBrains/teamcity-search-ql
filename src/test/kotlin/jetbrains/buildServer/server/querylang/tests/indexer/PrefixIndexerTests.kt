package jetbrains.buildServer.server.querylang.tests.indexer

import jetbrains.buildServer.server.querylang.indexing.SynchronizedIndexer
import jetbrains.buildServer.server.querylang.indexing.SynchronizedCompressedTrie
import jetbrains.buildServer.server.querylang.indexing.SynchronizedTrie
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.test.*

@Test
class PrefixIndexerTests {
    private var patht = createTempDir().toPath()

    private fun getTrie(): List<SynchronizedIndexer<String>> {
        return listOf(SynchronizedCompressedTrie(), SynchronizedTrie())
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


            val l = t.complete("abac", 4).map {it.str}.sorted()
            val expected = listOf(
                "abac", "abacDA", "abacDD", "abacDDD"
            )
            assertEquals(expected, l)
        }
    }

    fun testCompleteWithSpecialCharachter() {
        getTrie().forEach { t ->
            t.addString("?*@aba")
            t.addString("?*@caba")
            t.addString("?*@daba")
            t.addString("?@&&&&")


            val l = t.complete("?*@", 4).map {it.str}.sorted()
            val expected = listOf(
                "?*@aba", "?*@caba", "?*@daba"
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