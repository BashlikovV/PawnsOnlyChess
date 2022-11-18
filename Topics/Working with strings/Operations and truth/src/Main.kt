import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val str = console.next() + console.next()
    val tmpStr = console.next()

    if (str == tmpStr) {
        print(true)
    } else {
        print(false)
    }
}