import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val val1 = console.next().toIntOrNull()
    val val2 = console.next().toIntOrNull()
    val val3 = console.next().toIntOrNull()
    val val4 = console.next().toIntOrNull()

    val value = 4

    if (val1 != null) {
        println(true)
    } else {
        println(false)
    }
    if (val2 != null) {
        println(true)
    } else {
        println(false)
    }
    if (val3 != null) {
        println(true)
    } else {
        println(false)
    }
    if (val4 != null) {
        println(true)
    } else {
        println(false)
    }
}