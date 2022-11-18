import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    print(if (console.nextInt() % 2 == 0) "EVEN" else "ODD")
}