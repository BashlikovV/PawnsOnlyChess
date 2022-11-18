import java.util.Scanner

fun main() {
    val console = Scanner(System.`in`)
	val line = console.nextLine()

	for (i in line.indices) {
		if (line[i].isDigit()) {
			print(line[i])
			break
		}
	}
}