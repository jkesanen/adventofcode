import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2308Test {
    @Test
    fun `day 08 part1`() {
        val a = Advent2308()
        assertEquals(21251, a.getStepsRequired("08.txt"))
    }
}
