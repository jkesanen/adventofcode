import java.io.File
import kotlin.math.min
import kotlin.math.max

class Advent2303 {
    private val digits = """(\d+)""".toRegex()
    private val symbols = """[,;:\-_!"*#%&/()=+$?\\@£{}\[\]<>|]""".toRegex()

    fun getGearRatios1(filename: String): Int {
        var sum = 0

        val lines = File(this::class.java.getResource(filename)!!.file).readLines()

        lines.indices.forEach { row ->
            val above = if (row > 0) lines[row-1] else ""
            val current = lines[row]
            val below = if (row < lines.size-1) lines[row+1] else ""

            digits.findAll(current).forEach { hit ->
                val digit = hit.value.toInt()

                // Indexes for the digit, one before, one after.
                val start = max(0, hit.range.first-1)
                val end = min(current.length-1, hit.range.last+1)

                // In the same line before.
                if (symbols.matches(current[start].toString())) {
                    sum += digit
                    return@forEach
                }

                // In the same line after.
                if (symbols.matches(current[end].toString())) {
                    sum += digit
                    return@forEach
                }

                // The line above.
                if (above.isNotEmpty()) {
                    if (symbols.containsMatchIn(above.subSequence(start, end+1))) {
                        sum += digit
                        return@forEach
                    }
                }

                // The line below.
                if (below.isNotEmpty()) {
                    if (symbols.containsMatchIn(below.subSequence(start, end+1))) {
                        sum += digit
                        return@forEach
                    }
                }
            }
        }

        return sum
    }
}
