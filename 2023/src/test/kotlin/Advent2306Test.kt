import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2306Test {
    @Test
    fun `day 06 part 1`() {
        val a = Advent2306()
        assertEquals(588588, a.getWaysToWin1("06.txt"))
    }

    @Test
    fun `day 06 part 2`() {
        val a = Advent2306()
        assertEquals(34655848, a.getWaysToWin2("06.txt"))
    }

}