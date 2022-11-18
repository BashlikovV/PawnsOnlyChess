import java.util.Scanner

// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    val console = Scanner(System.`in`)
    var str = console.nextLine()
    val subStr = console.nextLine()

    var count = 0

    while (str.contains(subStr)) {
        str = str.replaceFirst(subStr, "")
        count++
    }

    print(count)
}
