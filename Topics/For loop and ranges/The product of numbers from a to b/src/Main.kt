import java.util.*

fun main() {
    val console = Scanner(System.`in`)
    val a = console.nextInt()
    val b = console.nextInt()

    var res: Long = 1
    for (i in a until b) {
        res *= i
    }
    print(res)
}