import java.io.File
import kotlin.math.pow

class Advent2304 {
    private fun toList(numbers: String): List<Int> =
        Regex("""\d+""").findAll(numbers).map { it.value.toInt() }.toList()

    fun getPoints(filename: String): Int {
        val winningRegex = """: ([\d\s]+) \|""".toRegex()
        val yourRegex = """\| ([\d\s]+)$""".toRegex()
        var points = 0.0

        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            val winning = toList(winningRegex.find(line)!!.groupValues[1])
            val your = toList(yourRegex.find(line)!!.groupValues[1])
            val matches = your.intersect(winning).count()
            if (matches > 0) {
                points += 2.0.pow(matches - 1)
            }
        }

        return points.toInt()
    }
}
