import java.io.File

class Advent2309 {
    private fun extrapolateNextValue(sequence: List<Long>): Long {
        val seqs = mutableListOf(sequence)
        var zeros = false
        while (!zeros) {
            val current = mutableListOf<Long>()
            for (i in 0..<seqs.last().size - 1) {
                current.add(seqs.last()[i + 1] - seqs.last()[i])
            }
            seqs.add(current)
            zeros = current.all { it == 0L }
        }

        return seqs.sumOf { it.last() }
    }

    fun getExtrapolatedSum(filename: String): Long {
        var sum = 0L
        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            val sequence = line.split(" ").map { it.toLong() }.toList()
            sum += extrapolateNextValue(sequence)
        }

        return sum
    }
}
