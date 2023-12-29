import org.junit.Assert.assertEquals
import org.junit.Test

class Advent2301Test {
    @Test
    fun `day 01 part 1`() {
        val a = Advent2301()
        assertEquals(54601, a.getCalibrationSumPart1("01.txt"))
    }

    @Test
    fun `day 01 part 2`() {
        val a = Advent2301()
        assertEquals(54078, a.getCalibrationSumPart2("01.txt"))
    }

}