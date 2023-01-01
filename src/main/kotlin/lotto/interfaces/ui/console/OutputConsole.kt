package lotto.interfaces.ui.console

import lotto.common.value.Money

object OutputConsole {
    fun printTicketCount(manualTicketCount: Int, autoTicketCount: Int) {
        println()
        println("수동으로 ${manualTicketCount}장, 자동으로 ${autoTicketCount}개를 구매했습니다.")
    }

    fun printPrize() {
        println()
        println("당첨 통계")
        println("---------")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        print("총 수익률은 ${rateOfReturn}입니다.")
        val resultLiteral = if (rateOfReturn >= 1) "이익" else "손해"
        println("(기준이 1이기 때문에 결과적으로 ${resultLiteral}라는 의미임)")
    }

    fun printWinPrize(equalNumberCount: Long, amount: Money, winCount: Int, isBonusPrize: Boolean) {
        if (isBonusPrize) println("${equalNumberCount}개 일치, 보너스 볼 일치(${amount}원) - ${winCount}개")
        else println("${equalNumberCount}개 일치 (${amount}원) - ${winCount}개")
    }

    fun printLotteryNumbers(lotteryNumbers: List<String>) {
        println("[${lotteryNumbers.joinToString(separator = ", ")}]")
    }
}
