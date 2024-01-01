import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2309Test {
    @Test
    fun `day 09 part 1`() {
        val a = Advent2309()
        assertEquals(2101499000, a.getExtrapolatedSum("09.txt"))
    }

    @Test
    fun `day 09 part 2`() {
        val a = Advent2309()
        assertEquals(1089, a.getExtrapolatedHistorySum("09.txt"))
    }
}
