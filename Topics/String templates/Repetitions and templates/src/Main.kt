import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val str = console.nextLine()
    println("${str.length} repetitions of the word $str: ${str.repeat(str.length)}")
}