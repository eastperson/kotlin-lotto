package lotto.domain

data class Lotto(
    val numbers: Set<Int>
) {

    init {
        require(numbers.all { isInRange(it) } && numbers.size == LOTTO_NUMBER_COUNT) {
            "Lotto should have 6 numbers between 1 to 45"
        }
    }

    constructor(vararg numbers: Int) : this(numbers.toSet())

    fun checkResult(winner: Lotto, bonusNumber: Int): Price {
        return when (correctNumberCounts(winner.numbers)) {
            6 -> Price.FIRST
            5 -> checkSecondOrThirdPrice(winner, bonusNumber)
            4 -> Price.FOURTH
            3 -> Price.FIFTH
            else -> Price.NONE
        }
    }

    private fun checkSecondOrThirdPrice(winner: Lotto, bonusNumber: Int): Price {
        return if ((winner.numbers + bonusNumber).containsAll(this.numbers)) Price.SECOND
        else Price.THIRD
    }

    private fun correctNumberCounts(numbers: Set<Int>): Int =
        this.numbers.intersect(numbers).count()

    private fun isInRange(number: Int): Boolean {
        return number in LOTTO_NUMBER_RANGE
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
    }
}