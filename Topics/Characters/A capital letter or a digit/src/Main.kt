fun main() {
    val a = readln().first()

    if (a in '1'..'9' || a in 'A'..'Z') {
        print(true)
    } else {
        print(false)
    }
}