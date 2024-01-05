import java.io.File

class Advent2310 {
    enum class Direction {
        N, E, S, W
    }

    private val tiles = mapOf(
        '|' to Pair(Direction.N, Direction.S),
        '-' to Pair(Direction.W, Direction.E),
        'L' to Pair(Direction.N, Direction.E),
        'J' to Pair(Direction.N, Direction.W),
        '7' to Pair(Direction.S, Direction.W),
        'F' to Pair(Direction.S, Direction.E)
    )

    data class Spot(var row: Int, var column: Int)

    private fun newSpot(spot: Spot, direction: Direction): Spot {
        return when (direction) {
            Direction.N -> Spot(spot.row - 1, spot.column)
            Direction.E -> Spot(spot.row, spot.column + 1)
            Direction.S -> Spot(spot.row + 1, spot.column)
            Direction.W -> Spot(spot.row, spot.column - 1)
        }
    }

    private fun getTile(map: List<String>, spot: Spot): Char = map[spot.row][spot.column]

    private fun getTile(map: List<String>, spot: Spot, direction: Direction): Char? {
        val newSpot = newSpot(spot, direction)
        if (newSpot.row < 0 || newSpot.row >= map.size || newSpot.column < 0 || newSpot.column >= map[0].length) {
            return null
        }
        return map[newSpot.row][newSpot.column]
    }

    private fun getDirection(direction: Direction, pipe: Char): Direction? {
        val arrival = when (direction) {
            Direction.N -> Direction.S
            Direction.S -> Direction.N
            Direction.E -> Direction.W
            Direction.W -> Direction.E
        }

        if (arrival == tiles[pipe]?.first) {
            return tiles[pipe]!!.second
        } else if (arrival == tiles[pipe]?.second) {
            return tiles[pipe]!!.first
        }

        return null
    }

    fun getFarthestPoint(map: List<String>): Int {
        val startIndex = map.joinToString("").indexOfFirst { it == 'S' }

        var current = Spot(startIndex / map.size, startIndex % map[0].length)
        var direction: Direction? = null

        // Determine where to go from the Start.
        Direction.entries.forEach {
            val pipe = getTile(map, current, it)
            if (pipe != null) {
                val dir = getDirection(it, pipe)
                if (dir != null) {
                    direction = dir
                    return@forEach
                }
            }
        }

        assert(direction != null) { "Could not determine the direction from Start." }
        current = newSpot(current, direction!!)

        var steps = 1
        var pipe = getTile(map, current)

        // Follow the loop until back at the Start.
        while (pipe != 'S') {
            direction = getDirection(direction!!, pipe)!!
            current = newSpot(current, direction!!)
            pipe = getTile(map, current)
            ++steps
        }

        return steps / 2
    }

    fun getFarthestPoint(filename: String): Int {
        val map = File(this::class.java.getResource(filename)!!.file).readLines()
        return getFarthestPoint(map)
    }
}
