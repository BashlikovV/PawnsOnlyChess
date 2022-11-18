fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    if (a in b..c || a in c..b) {
        print(true)
    } else {
        print(false)
    }
}