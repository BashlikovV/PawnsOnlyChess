import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val a = console.nextInt()
    val b = console.nextInt()
    val c = console.nextInt()
    val d = console.nextInt()

    for (i in 0..1000) {
        val equation = a * (i * i * i) + b * (i * i) + c * i + d
        if (equation == 0) {
            println(i)
        }
    }
}