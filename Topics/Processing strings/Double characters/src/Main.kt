import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val str = console.nextLine()

    for (i in str.indices) {
        print("${str[i]}${str[i]}")
    }
}