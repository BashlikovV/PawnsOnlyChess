import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val list: List<String> = console.next().split('-')

    print("${list[1]}/${list[2]}/${list[0]}")
}