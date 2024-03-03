package Inlämningsuppgift2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class TomtelandTest {

    var tl: Tomteland = Tomteland()

    var uTomten: List<String> = mutableListOf(
            "Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten", "Glader", "Butter",
            "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen")

    var uGlader: List<String> = mutableListOf("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten")
    var uButter: List<String> = mutableListOf("Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen")
    var uTrötter: List<String> = mutableListOf("Dammråttan", "Skumtomten")
    var uSkumtomten: List<String> = mutableListOf("Dammråttan")
    var uRäven: List<String> = mutableListOf("Gråsuggan", "Myran", "Bladlusen")
    var uMyran: List<String> = mutableListOf("Bladlusen")


    @Test
    fun underlingsBladlusenTest() {
        val underlings: List<String> = tl.getUnderlings("Bladlusen")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsTrögerTest() {
        val underlings: List<String> = tl.getUnderlings("Tröger")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsBlygerTest() {
        val underlings: List<String> = tl.getUnderlings("Blyger")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsDammråttanTest() {
        val underlings: List<String> = tl.getUnderlings("Dammråttan")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsGråsugganTest() {
        val underlings = tl.getUnderlings("Gråsuggan")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsHarenTest() {
        val underlings: List<String> = tl.getUnderlings("Haren")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsNyckelpiganTest() {
        val underlings: List<String> = tl.getUnderlings("Nyckelpigan")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsRådjuretTest() {
        val underlings: List<String> = tl.getUnderlings("Rådjuret")
        assertEquals(underlings.size, 0)
    }

    @Test
    fun underlingsMyranTest() {
        val underlings = tl.getUnderlings("Myran")
        assertEquals(underlings.size, uMyran.size)
        assertFalse(underlings.retainAll(uMyran))
    }

    @Test
    fun underlingsRävenTest() {
        val underlings = tl.getUnderlings("Räven")
        assertEquals(underlings.size, uRäven.size)
        assertFalse(underlings.retainAll(uRäven))
    }

    @Test
    fun underlingsSkumtomtenTest() {
        val underlings = tl.getUnderlings("Skumtomten")
        assertEquals(underlings.size, uSkumtomten.size)
        assertFalse(underlings.retainAll(uSkumtomten))
    }

    @Test
    fun underlingsTrötterTest() {
        val underlings = tl.getUnderlings("Trötter")
        assertEquals(underlings.size, uTrötter.size)
        assertFalse(underlings.retainAll(uTrötter))
    }


    @Test
    fun underlingsButterTest() {
        val underlings = tl.getUnderlings("Butter")
        assertEquals(underlings.size, uButter.size)
        assertFalse(underlings.retainAll(uButter))
    }

    @Test
    fun underlingsGladerTest() {
        val underlings = tl.getUnderlings("Glader")
        assertEquals(underlings.size, uGlader.size)
        assertFalse(underlings.retainAll(uGlader))
    }

    @Test
    fun underlingsTomtenTest() {
        val underlings = tl.getUnderlings("Tomten")
        assertEquals(underlings.size, uTomten.size)
        assertFalse(underlings.retainAll(uTomten))
    }
}