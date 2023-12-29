import java.io.File
import kotlin.math.max

class Advent2302 {
    fun getPossibleGames(filename: String): Int {
        val game = """^Game (\d+): (.*)""".toRegex()
        val round = """(\d+) (blue|red|green)([,;]?)""".toRegex()
        var sum = 0
        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            val matches = game.find(line)
            var gameNum = matches!!.groupValues[1].toInt()
            val rounds = matches.groupValues[2]
            round.findAll(rounds).forEach {
                var reds = 12
                var greens = 13
                var blues = 14
                val value = it.groupValues[1].toInt()
                when (it.groupValues[2]) {
                    "red" -> reds -= value
                    "green" -> greens -= value
                    "blue" -> blues -= value
                }
                if (reds < 0 || blues < 0 || greens < 0) {
                    // Impossible game.
                    gameNum = 0
                }
            }
            sum += gameNum
        }
        return sum
    }

    fun getMinimumPowers(filename: String): Int {
        val round = """(\d+) (blue|red|green)([,;]?)""".toRegex()
        var sum = 0
        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            var reds = 0
            var greens = 0
            var blues = 0
            round.findAll(line).forEach {
                val value = it.groupValues[1].toInt()
                when (it.groupValues[2]) {
                    "red" -> reds = max(reds, value)
                    "green" -> greens = max(greens, value)
                    "blue" -> blues = max(blues, value)
                }
            }
            sum += reds * greens * blues
        }
        return sum
    }
}
