package lotto.policy

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.domain.policy.LotteryNumberAutoGenerateStrategy
import lotto.domain.vo.LotteryNumber
import lotto.domain.vo.LotteryNumbers

class LotteryNumberAutoGenerateStrategyTest : FreeSpec({

    val wholeLotteryNumbers = generateWhileLotteryNumbers()

    "자동으로 추첨 번호를 생성할 수 있다" - {
        val randomLotteryNumbers = LotteryNumberAutoGenerateStrategy.generate()
        randomLotteryNumbers.shouldNotBeNull()

        "중복되지 않는 ${LotteryNumbers.LOTTERY_NUMBER_SIZE}개의 추첨 번호를 가지고 있다" {
            val sameNumber = wholeLotteryNumbers.filter { randomLotteryNumbers.contains(it) }.size
            sameNumber shouldBe LotteryNumbers.LOTTERY_NUMBER_SIZE
        }
    }
})

private fun generateWhileLotteryNumbers(): Set<LotteryNumber> {
    val lotteryNumbers = mutableSetOf<LotteryNumber>()
    var initNumber = LotteryNumber.MIN_NUMBER
    repeat(LotteryNumber.MAX_NUMBER) { lotteryNumbers.add(LotteryNumber(initNumber++)) }
    return lotteryNumbers.toSet()
}