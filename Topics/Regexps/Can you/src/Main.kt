fun main() {
    val str1 = "a2c"
    val str2 = "ab1"
    val str3 = "77а"
    val noStr1 = "^ 2a"
    val noStr2 = "b3&"
    val regex = "\\w\\d\\D".toRegex()

    println(regex.matches(str1))
    println(regex.matches(str2))
    println(regex.matches(str3))
    println(regex.matches(noStr1))
    println(regex.matches(noStr2))
}