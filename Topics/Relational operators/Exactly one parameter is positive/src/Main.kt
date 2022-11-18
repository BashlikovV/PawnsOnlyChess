fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val array = arrayOf(a, b, c)
    var count = 0
    for (element in array) {
        if (element > 0) {
            count++
        }
    }
    if (count == 1) {
        print(true)
    } else {
        print(false)
    }
}