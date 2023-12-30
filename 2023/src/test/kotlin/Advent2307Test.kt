import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2307Test {
    @Test
    fun `day 07 part 1`() {
        val a = Advent230701()
        assertEquals(246163188, a.getCamelCardTotalWinnings("07.txt"))
    }

    @Test
    fun `day 07 part 2`() {
        val a = Advent230702()
        assertEquals(245794069, a.getCamelCardTotalWinnings("07.txt"))
    }

}