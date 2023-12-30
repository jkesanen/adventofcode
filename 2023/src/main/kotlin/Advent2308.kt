import java.io.File

class Advent2308 {
    private val nodeRegex =
        """^((?<instructions>[LR]+)|(?<name>[A-Z]{3}) = \((?<left>[A-Z]{3}), (?<right>[A-Z]{3})\))$""".toRegex()

    data class Node(val left: String, val right: String)

    fun getStepsRequired(filename: String): Int {
        lateinit var instructions: CharArray
        val nodes = mutableMapOf<String, Node>()

        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            val matches = nodeRegex.find(line)
            if (matches != null) {
                if (matches.groups["name"] != null) {
                    nodes[matches.groups["name"]!!.value] =
                        Node(matches.groups["left"]!!.value, matches.groups["right"]!!.value)
                } else {
                    instructions = matches.value.toCharArray()
                }
            }
        }

        var currentNode = "AAA"
        var steps = 0

        while (currentNode != "ZZZ") {
            currentNode = when (instructions[steps % instructions.size]) {
                'L' -> nodes[currentNode]!!.left
                else -> nodes[currentNode]!!.right
            }
            ++steps
        }

        return steps
    }
}
