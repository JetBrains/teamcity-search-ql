package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.AutocompletionIndexer
import jetbrains.buildServer.server.querylang.autocompl.CompressedTrie
import jetbrains.buildServer.server.querylang.autocompl.Trie
import org.testng.annotations.Test
import kotlin.test.*

@Test
class TrieTests {
    private fun getTrie(): List<AutocompletionIndexer<Any>> {
        return listOf(CompressedTrie())
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

    
    fun testMultipleString() {
        getTrie().forEach { t ->
            t.addString("abacaba")
            t.addString("abacaba")
            t.addString("abacabad")
            t.addString("abacab")

            assertEquals(2, t.getCnt("abacaba"))
            assertEquals(1, t.getCnt(("abacabad")))
            assertEquals(1, t.getCnt("abacab"))
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
            assertEquals(4, l.size)
            assertEquals("", l[0])
            assertEquals("DA", l[1])
            assertEquals("DD", l[2])
            assertEquals("DDD", l[3])
        }
    }
}