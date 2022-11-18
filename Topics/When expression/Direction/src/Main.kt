import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)

    val result = when (console.nextInt()) {
        0 -> "do not move"
        1 -> "move up"
        2 -> "move down"
        3 -> "move left"
        4 -> "move right"
        else -> "error!"
    }
    print(result)
}