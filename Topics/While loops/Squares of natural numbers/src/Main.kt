import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val num = console.nextInt()
    var i = 1

    while (i * i <= num) {
        println(i * i)
        i++
    }
}

fun lskv(): Unit {

}