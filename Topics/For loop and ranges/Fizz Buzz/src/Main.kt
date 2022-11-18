import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val first = console.nextInt()
    val second = console.nextInt()

    for (i in first until second + 1) {
        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else {
            println(i)
        }
    }
}