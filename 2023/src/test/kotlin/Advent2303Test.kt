import org.junit.Assert.*
import org.junit.Test

class Advent2303Test {
    @Test
    fun `day 03 part 1`() {
        val a = Advent2303()
        assertEquals(539433, a.getGearRatios1("03.txt"))
    }
}
