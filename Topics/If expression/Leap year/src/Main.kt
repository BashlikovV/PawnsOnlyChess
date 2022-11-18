import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val year = console.nextInt()

    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) print("Leap") else print("Regular")
}