import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
    val list: List<String> = console.nextLine().split(" ")

    var length = 0
    for (str in list) {
        if (str.length > length) {
            length = str.length
        }
    }
    for (str in list) {
        if (str.length == length) {
            print(str)
            break
        }
    }
}