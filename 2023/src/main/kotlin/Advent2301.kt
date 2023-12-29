import java.io.File

class Advent2301 {
    fun getCalibrationSumPart1(filename: String): Int {
        val first = """^\D*(\d)""".toRegex()
        val last = """(\d)\D*$""".toRegex()
        var sum = 0
        File(this::class.java.getResource(filename)!!.file).forEachLine {
            sum += first.find(it)!!.groupValues[1].toInt() * 10
            sum += last.find(it)!!.groupValues[1].toInt()
        }
        return sum
    }

    private fun toValue(number: String): Int {
        try {
            return number.toInt()
        } catch (e: NumberFormatException) {
            return when (number) {
                "one" -> 1
                "two" -> 2
                "three" -> 3
                "four" -> 4
                "five" -> 5
                "six" -> 6
                "seven" -> 7
                "eight" -> 8
                "nine" -> 9
                else -> 0
            }
        }
    }

    fun getCalibrationSumPart2(filename: String): Int {
        val first = """^.*?(one|two|three|four|five|six|seven|eight|nine|\d)""".toRegex()
        val last = """(?!.*(\d|one|two|three|four|five|six|seven|eight|nine))""".toRegex()
        var sum = 0
        File(this::class.java.getResource(filename)!!.file).forEachLine {
            val firstDigit = toValue(first.find(it)!!.groupValues[1])
            val lastDigit = toValue(last.find(it)!!.groupValues[1])
            sum += firstDigit * 10 + lastDigit
        }
        return sum
    }
}
