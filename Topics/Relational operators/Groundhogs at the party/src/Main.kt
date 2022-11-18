fun main() {
    val cupsCount = readln().toInt()
    val isWeekend = readln().toBoolean()
    if (isWeekend && cupsCount >= 15 && cupsCount <= 25) {
        print(true)
    } else if (!isWeekend && cupsCount >= 10 && cupsCount <= 20) {
        print(true)
    } else {
        print(false)
    }
}