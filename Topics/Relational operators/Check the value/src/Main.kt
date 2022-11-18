import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val range = 1..9
    val number = console.nextInt()

    println(number in range)
}