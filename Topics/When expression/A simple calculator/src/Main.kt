import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val firstNumber = console.nextLong()
    val operator = console.next()
    val secondNumber = console.nextLong()

    calc(firstNumber, secondNumber, operator[0])
}

fun calc(firstNumber: Long, secondNumber: Long, operator: Char) {
    when (operator) {
        '+' -> println(firstNumber + secondNumber)
        '-' -> println(firstNumber - secondNumber)
        '/' -> {
            if (secondNumber != 0L) {
                println(firstNumber / secondNumber)
            } else {
                println("Division by 0!")
            }
        }
        '*' -> println(firstNumber * secondNumber)
        else -> println("Unknown operator")
    }
}