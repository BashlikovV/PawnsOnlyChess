import java.util.Scanner

const val DIVIDEINDEX = 2

fun main() {
    val console = Scanner(System.`in`)
    val number = console.nextLine().toInt()
    print("The obtained value is $number and its Int representation after division on 2 is ${number / DIVIDEINDEX}")
}