fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    if (a + b == 20) {
        print(true)
    } else if (a + c == 20) {
        print(true)
    } else if (b + c == 20) {
        print(true)
    } else {
        print(false)
    }
}