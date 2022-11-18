import java.util.*

fun main() {
    val console = Scanner(System.`in`)
    val a = console.nextInt()
    val b = console.nextInt()
    val n = console.nextInt()

    var count = 0
    for (i in a until b + 1) {
        if (i % n == 0) {
            count++
        }
    }
    println(count)
}