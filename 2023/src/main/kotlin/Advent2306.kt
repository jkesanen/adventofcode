import java.io.File
import kotlin.math.max

class Advent2306 {
    private fun chargeToDistance(charge: Long, duration: Long): Long {
        val timeLeft = duration - charge
        return charge * max(0, timeLeft)
    }

    private fun getBestResults(filename: String): List<Pair<Long, Long>> {
        val times = mutableListOf<Long>()
        val distances = mutableListOf<Long>()
        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            val parts = line.split(":")

            when (parts[0]) {
                "Time" -> times += Regex("""\d+""").findAll(parts[1]).map { it.value.toLong() }.toList()
                "Distance" -> distances += Regex("""\d+""").findAll(parts[1]).map { it.value.toLong() }.toList()
            }
        }

        assert(times.size == distances.size)

        val races = mutableListOf<Pair<Long, Long>>()
        for (i in 0..<times.size) {
            races += Pair(times[i], distances[i])
        }

        return races
    }

    fun getWaysToWin1(filename: String): Int {
        val races = getBestResults(filename)
        var waysToWinMultiplied = 0
        races.forEach {
            val duration = it.first
            val distance = it.second
            var wins = 0
            for (charge in 0..<duration) {
                if (chargeToDistance(charge, duration) > distance) {
                    wins++
                }
            }

            waysToWinMultiplied = if (waysToWinMultiplied == 0) {
                wins
            } else {
                waysToWinMultiplied * wins
            }
        }

        return waysToWinMultiplied
    }

    private fun getResult(filename: String): Pair<Long, Long> {
        var duration = 0L
        var distance = 0L
        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            val parts = line.split(":")
            when (parts[0]) {
                "Time" -> duration = parts[1].replace(" ", "").toLong()
                "Distance" -> distance = parts[1].replace(" ", "").toLong()
            }
        }

        return Pair(duration, distance)
    }

    fun getWaysToWin2(filename: String): Int {
        val result = getResult(filename)
        var waysToWin = 0
        for (charge in 0..<result.first) {
            if (chargeToDistance(charge, result.first) > result.second) {
                ++waysToWin
            }
        }

        return waysToWin
    }
}
