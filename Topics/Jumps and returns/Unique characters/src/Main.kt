import java.util.Scanner

const val HASHL = 97
const val HASHU = 65

fun main() {
    val console = Scanner(System.`in`)
    val line = console.nextLine()
    var maxSize = 0

    for (i in line.indices) {
        if (line[i].isLowerCase()) {
            if (line[i].code - HASHL + 1 > maxSize) {
                maxSize = line[i].code - HASHL + 1
            }
        } else {
            if (line[i].code - HASHU + 1 > maxSize) {
                maxSize = line[i].code - HASHU + 1
            }
        }
    }

    val searchArray = Array(maxSize, init = { 0 })

    for (i in line.indices) {
        searchArray[line[i].code - HASHL]++
    }

    var sum = 0
    for (i in 0 until maxSize) {
        if (searchArray[i] == 1) {
            sum++
        }
    }

    print(sum)
}