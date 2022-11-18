import java.lang.System
import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val a = console.nextInt()
    // should sleep >= an hours in day
    val b = console.nextInt()
    // should sleep <= b hours in day
    val h = console.nextInt()
    // sleep h hours in day

    if (h < a) {
        print("Deficiency")
    } else if (h > b) {
        print("Excess")
    } else {
        print("Normal")
    }
}
