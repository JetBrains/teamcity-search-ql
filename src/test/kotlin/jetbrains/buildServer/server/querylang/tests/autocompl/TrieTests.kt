package jetbrains.buildServer.server.querylang.tests.autocompl

import jetbrains.buildServer.server.querylang.autocompl.Trie
import org.testng.annotations.Test
import kotlin.test.*

@Test
class TrieTests {
    private fun getTrie(): Trie<Any> {
        return Trie<Any>()
    }

    
    fun testAddAndGet() {
        val t = getTrie()
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

    
    fun testMultipleString() {
        val t = getTrie()
        t.addString("abacaba")
        t.addString("abacaba")
        t.addString("abacabad")
        t.addString("abacab")

        assertEquals(2, t.getCnt("abacaba"))
        assertEquals(1, t.getCnt(("abacabad")))
        assertEquals(1, t.getCnt("abacab"))
    }

    
    fun testDelete() {
        val t = getTrie()
        t.addString("abacaba")
        t.addString("abacaba")
        t.addString("abadaba")
        t.addString("abadaca")
        t.addString("adababa")
        t.addString("badabab")
        t.addString("abacab")

        t.deleteString("abacaba")
        t.deleteString("abacab")

        assertFalse(t.exists("abacab"))
        assertEquals(1, t.getCnt("abacaba"))
    }

    
    fun testCompleteString() {
        val t = getTrie()
        t.addString("abac")
        t.addString("aba")
        t.addString("abad")
        t.addString("abacDD")
        t.addString("abacDA")
        t.addString(("abacDDD"))
        t.addString("abacAAAA")
        t.addString("abacDDDD")
        t.addString("abacDADD")

        val l = t.completeString("abac", 4).sorted()
        assertEquals(4, l.size)
        assertEquals("", l[0])
        assertEquals("DA", l[1])
        assertEquals("DD", l[2])
        assertEquals("DDD", l[3])
    }
}