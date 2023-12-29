import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2307Test {
    @Test
    fun `day 07 part 1`() {
        val a = Advent2307()
        assertEquals(246163188, a.getCamelCardTotalWinnings("07.txt"))
    }
}