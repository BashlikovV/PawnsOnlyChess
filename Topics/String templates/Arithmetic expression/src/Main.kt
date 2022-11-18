import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
	val firstNum = console.nextInt()
	val secondNumber = console.nextInt()
	println("$firstNum plus $secondNumber equals ${firstNum + secondNumber}")
}