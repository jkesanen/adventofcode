import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2304Test {
    @Test
    fun `day 04 part 1`() {
        val a = Advent2304()
        assertEquals(21568, a.getPoints("04.txt"))
    }
}