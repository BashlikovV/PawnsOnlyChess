import java.lang.System
import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val a = console.nextInt()
    val b = console.nextInt()
    val c = console.nextInt()

    print(if (a + b <= c || a + c <= b || c + b <= a) "NO" else "YES")
}