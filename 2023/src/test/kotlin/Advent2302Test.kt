import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2302Test {
    @Test
    fun `day 02 part 1`() {
        val a = Advent2302()
        assertEquals(2237, a.getPossibleGames("02.txt"))
    }

    @Test
    fun `day 02 part 2`() {
        val a = Advent2302()
        assertEquals(66681, a.getMinimumPowers("02.txt"))
    }
}
