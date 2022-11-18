import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
	val count = console.nextInt()
    var sum = 0

	repeat(count) {
    	sum += console.nextInt()
    }
	print(sum)
}