import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val number = console.nextInt()

    print(
        when (number) {
            1, 3, 4 -> "No!"
            2 -> "Yes!"
            else -> "Unknown number"
        }
    )
}