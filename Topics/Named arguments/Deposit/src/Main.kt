import java.util.Scanner
import kotlin.math.pow

fun calcFinalAmount(amount: Int = 1000, percent: Int = 5, years: Int = 10): Int {
    val tmpResult = (1.0 + percent.toDouble() / 100.0).pow(years)
    return (amount.toDouble() * tmpResult).toInt()
}

fun main() {
    val console = Scanner(System.`in`)
    val argument = console.nextLine()
    val number = console.nextInt()

    when (argument) {
        "amount" -> println(calcFinalAmount(amount = number))
        "percent" -> println(calcFinalAmount(percent = number))
        "years" -> println(calcFinalAmount(years = number))
    }
}