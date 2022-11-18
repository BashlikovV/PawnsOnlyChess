import java.util.Scanner

const val PLUS = "plus"
const val EQUALS = "equals"
const val ENDS_WITH = "endsWith"

fun main() {
    val console = Scanner(System.`in`)
    val firstStr = console.nextLine()
    val operation = console.nextLine()
    val secondStr = console.nextLine()

    val result = when (operation) {
        PLUS -> firstStr + secondStr
        EQUALS -> firstStr.equals(secondStr)
        ENDS_WITH -> firstStr.endsWith(secondStr)
        else -> "Unknown operation"
    }
    print(result)
}