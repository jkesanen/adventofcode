import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2310Test {
    @Test
    fun `day 10 part 1`() {
        val a = Advent2310()
        assertEquals(6907, a.getFarthestPoint("10.txt"))
    }

    @Test
    fun `day 10 part 1 test fixed map`() {
        val a = Advent2310()
        val map = listOf(
            "..F7.",
            ".FJ|.",
            "SJ.L7",
            "|F--J",
            "LJ..."
        )
        assertEquals(8, a.getFarthestPoint(map))
    }
}