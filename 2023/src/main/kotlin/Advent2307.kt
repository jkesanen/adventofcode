import java.io.File

class Advent2307 {
    private val order = listOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')

    enum class Type {
        High,
        OnePair,
        TwoPairs,
        ThreeOfAKind,
        FullHouse,
        FourOfAKind,
        FiveOfAKind
    }

    data class Hand(val cards: List<Int>, val type: Type, val bid: Int) : Comparable<Hand> {
        override fun compareTo(other: Hand): Int {
            if (this.type.ordinal > other.type.ordinal) {
                return 1
            } else if (this.type.ordinal < other.type.ordinal) {
                return -1
            } else {
                for (i in 0..<this.cards.size) {
                    if (this.cards[i] > other.cards[i]) {
                        return 1
                    }
                    if (this.cards[i] < other.cards[i]) {
                        return -1
                    }
                }
            }

            return 0
        }
    }

    private fun getHandType(cards: List<Int>): Type {
        val values = mutableMapOf<Int, Int>()
        cards.forEach {
            if (values.putIfAbsent(it, 1) != null) {
                values[it] = values[it]!!.inc()
            }
        }

        return when (values.size) {
            1 -> Type.FiveOfAKind
            2 -> {
                val maxLabels = values.maxBy { it.value }.value
                if (maxLabels == 4) {
                    Type.FourOfAKind
                } else {
                    Type.FullHouse
                }
            }

            3 -> {
                val maxLabels = values.maxBy { it.value }.value
                if (maxLabels == 3) {
                    Type.ThreeOfAKind
                } else {
                    Type.TwoPairs
                }
            }

            4 -> Type.OnePair
            else -> Type.High
        }
    }

    private fun getCamelCardHand(handString: String, handBid: Int): Hand {
        val cards = mutableListOf<Int>()
        handString.forEach { cards.add(order.indexOf(it)) }
        return Hand(cards, getHandType(cards), handBid)
    }

    fun getCamelCardTotalWinnings(filename: String): Long {
        val lineRegex = """^(?<hand>[23456789TJQKA]+) (?<bid>(\d)+)""".toRegex()
        val hands = mutableListOf<Hand>()

        File(this::class.java.getResource(filename)!!.file).forEachLine { line ->
            val matches = lineRegex.find(line)!!
            hands.add(getCamelCardHand(matches.groups["hand"]!!.value, matches.groups["bid"]!!.value.toInt()))
        }

        // Calculate the winnings for all hands.
        var rank = 1
        var winnings = 0L
        hands.sorted().forEach {
            winnings += it.bid * rank++
        }

        return winnings
    }
}
