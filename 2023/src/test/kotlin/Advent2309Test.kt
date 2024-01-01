import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2309Test {
    @Test
    fun `day 09 part1`() {
        val a = Advent2309()
        assertEquals(2101499000, a.getExtrapolatedSum("09.txt"))
    }
}
