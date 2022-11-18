package chess

import java.util.Scanner
import kotlin.system.exitProcess

const val PAWNB = 10
const val PAWNW = 11
const val DELIMITER = "+---+---+---+---+---+---+---+---+"
const val BAR = '|'
var prevStep = Array(4, init = { 0 })

class ChessCount(var white: Int = 8, var black: Int = 8) {

	fun decCounts(count: Int) {
		if (count % 2 == 0) {
			this.black--
		} else {
			this.white--
		}
	}
}
val chessCount = ChessCount()

fun getPlayersNames(): Array<String> {
	val console = Scanner(System.`in`)
	println("First Player's name:")
	val firstPlayerName = console.nextLine()
	println("Second Player's name:")
	val secondPlayerName = console.nextLine()

	return arrayOf(firstPlayerName, secondPlayerName)
}

fun stepPart(firstName: String, secondName: String, count: Int): String {
	val regex = Regex("[a-h][1-8][a-h][1-8]|exit")
	val console = Scanner(System.`in`)

	if (count % 2 == 0) {
		println("$firstName's turn:")
	} else {
		println("$secondName's turn:")
	}

	var stepPoints = console.nextLine()

	if (stepPoints == "exit") {
		return stepPoints
	}

	while (!regex.matches(stepPoints)) {
		println("Invalid Input")
		if (count % 2 == 0) {
			println("$firstName's turn:")
		} else {
			println("$secondName's turn:")
		}
		stepPoints = console.nextLine()
	}

	return stepPoints
}

fun isNotCorrect(count: Int, firstName: String, secondName: String, flag: Boolean): String {
	val console = Scanner(System.`in`)

	if (flag) {
		println("Invalid Input")
	}

	if (count % 2 == 0) {
		println("$firstName's turn:")
	} else {
		println("$secondName's turn:")
	}

	return console.nextLine()
}

fun checkKing(chessBoard: MutableList<MutableList<Int>>): Boolean {
	for (i in 1 until 8 step 1) {
		if (chessBoard[0][i] == PAWNW) {
			return true
		}
		if (chessBoard[7][i] == PAWNB) {
			return true
		}
	}
	return false
}

fun isStalemate(chessBoard: MutableList<MutableList<Int>>): Boolean {
	class Data(var chess: Int, var isCanStep: Boolean = true)
	val chesses = ArrayList<Data>()
	var chessCountW = 0
	var chessCountB = 0

	for (i in 1 until 8 step 1) {
		for (j in 1 until 9 step 1) {
			if (chessBoard[i][j] == PAWNB) {
				chessCountB++
				if (chessBoard[i + 1][j] == PAWNW) {
					chesses.add(Data(
						chess = PAWNB,
						isCanStep = false
					))
				} else {
					chesses.add(Data(
						chess = PAWNB
					))
				}
			}
			if (chessBoard[i][j] == PAWNW) {
				chessCountW++
				if (chessBoard[i - 1][j] == PAWNB) {
					chesses.add(Data(
						chess = PAWNW,
						isCanStep = false
					))
				} else {
					chesses.add(Data(
						chess = PAWNW
					))
				}
			}
		}
	}

	chessCount.black = chessCountB
	chessCount.white = chessCountW

	var falseBCount = 0
	var falseWCount = 0
	var flagB = true
	var flagW = true
	for (i in chesses.indices) {
		if (chesses[i].chess == PAWNB) {
			if (chesses[i].isCanStep) {
				flagB = false
			}
		}
		if (chesses[i].chess == PAWNW) {
			if (chesses[i].isCanStep) {
				flagW = false
			}
		}
		if (!chesses[i].isCanStep) {
			if (chesses[i].chess == PAWNB) {
				falseBCount++
			} else {
				falseWCount++
			}
		}
	}

	if (flagB || flagW) return true

	if (falseBCount == chessCountB || falseWCount == chessCountW)  {
		return true
	}

	return false
}

fun stepFun(firstName: String, secondName: String, count: Int, chessBoard: MutableList<MutableList<Int>>): String {
	if (chessCount.white == 0) {
		println("Black Wins!")
		return "exit"
	}

	if (chessCount.black == 0) {
		println("White Wins!")
		return "exit"
	}

	if (checkKing(chessBoard)) {
		return if (count % 2 == 0) {
			println("Black Wins!")
			"exit"
		} else {
			println("White Wins!")
			"exit"
		}
	}

	val stepPoints = stepPart(firstName, secondName, count)

	if (stepPoints == "exit") {
		return stepPoints
	}

	stepReg(chessBoard, stepPoints, count, firstName, secondName)

	if (isStalemate(chessBoard)) {
		val stepsCheck1 = mutableListOf<Int>()
		val stepsCheck2 = mutableListOf<Int>()
		if (count % 2 == 0) {
			val tmpStr = "" +
					"${stepPoints[0]}" +
					"${stepPoints[1]}" +
					"${if (stepPoints[2] != 'h') (stepPoints[2].code + 1).toChar() else stepPoints[2]}" +
					"${stepPoints[3]}"
			stepsCheck1.add(x1Num(tmpStr))
			stepsCheck1.add(x0num(tmpStr))
			stepsCheck1.add(y1Num(tmpStr))
			stepsCheck1.add(y0Num(tmpStr))

			var flag = true
			val tmpStr2 = "" +
					"${stepPoints[0]}" +
					"${stepPoints[1]}" +
					"${if (stepPoints[2] != 'h') (stepPoints[2].code + 1).toChar() else flag = false}" +
					"${stepPoints[3]}"

			stepsCheck2.add(x1Num(tmpStr2))
			stepsCheck2.add(x0num(tmpStr2))
			stepsCheck2.add(y1Num(tmpStr2))
			stepsCheck2.add(y0Num(tmpStr2))

			var isNCanCapture = true
			if (flag) {
				isNCanCapture = !isCanCapture(
					chessBoard = chessBoard,
					count = count,
					steps = stepsCheck2.toList()
				)
			}

			if (
				!isCanCapture(chessBoard = chessBoard, count = count, steps = stepsCheck1.toList()) &&
				isNCanCapture
			) {
				if (chessCount.black == 0) {
					println("White Wins!")
					return "exit"
				} else if (chessCount.white == 0) {
					println("Black Wins!")
					return "exit"
				} else {
					println("Stalemate!")
					return "exit"
				}
			}
		} else {
			val tmpStr = "" +
					"${stepPoints[0]}" +
					"${stepPoints[1]}" +
					"${if (stepPoints[2] != 'a') (stepPoints[2].code - 1).toChar() else stepPoints[2]}" +
					"${stepPoints[3]}"
			stepsCheck1.add(x1Num(tmpStr))
			stepsCheck1.add(x0num(tmpStr))
			stepsCheck1.add(y1Num(tmpStr))
			stepsCheck1.add(y0Num(tmpStr))

			var flag = false
			val tmpStr2 = "" +
					"${stepPoints[0]}" +
					"${stepPoints[1]}" +
					"${if (stepPoints[2] != 'h') (stepPoints[2].code - 1).toChar() else flag = true}" +
					"${stepPoints[3]}"

			stepsCheck2.add(x1Num(tmpStr2))
			stepsCheck2.add(x0num(tmpStr2))
			stepsCheck2.add(y1Num(tmpStr2))
			stepsCheck2.add(y0Num(tmpStr2))

			var isNCanCapture = true
			if (flag) {
				isNCanCapture = !isCanCapture(
					chessBoard = chessBoard,
					count = count,
					steps = stepsCheck2.toList()
				)
			}

			if (
				!isCanCapture(chessBoard = chessBoard, count = count, steps = stepsCheck1.toList()) &&
				isNCanCapture
			) {
				if (chessCount.black == 0) {
					println("White Wins!")
					return "exit"
				} else if (chessCount.white == 0) {
					println("Black Wins!")
					return "exit"
				} else {
					println("Stalemate!")
					return "exit"
				}
			}
		}
	}

	return stepPoints
}

fun x0num(stepPoint: String): Int {
	return when (stepPoint[0]) {
		'a' -> 1
		'b' -> 2
		'c' -> 3
		'd' -> 4
		'e' -> 5
		'f' -> 6
		'g' -> 7
		'h' -> 8
		else -> -1
	}
}

fun x1Num(stepPoint: String): Int {
	return when (stepPoint[1].code) {
		49 -> 7
		50 -> 6
		51 -> 5
		52 -> 4
		53 -> 3
		54 -> 2
		55 -> 1
		56 -> 0
		else -> -1
	}
}

fun y0Num(stepPoint: String): Int {
	return when (stepPoint[2]) {
		'a' -> 1
		'b' -> 2
		'c' -> 3
		'd' -> 4
		'e' -> 5
		'f' -> 6
		'g' -> 7
		'h' -> 8
		else -> -1
	}
}

fun y1Num(stepPoint: String): Int {
	return when (stepPoint[3].code) {
		49 -> 7
		50 -> 6
		51 -> 5
		52 -> 4
		53 -> 3
		54 -> 2
		55 -> 1
		56 -> 0
		else -> -1
	}
}

fun getX(stepPoint: String): ArrayList<Int> {
	val result = ArrayList<Int>()

	val x0Num = x0num(stepPoint)

	val x1Num = x1Num(stepPoint)
	result.add(x1Num)
	result.add(x0Num)

	return result
}

fun getY(stepPoint: String): ArrayList<Int> {
	val result = ArrayList<Int>()

	val y0Num = when (stepPoint[2]) {
		'a' -> 1
		'b' -> 2
		'c' -> 3
		'd' -> 4
		'e' -> 5
		'f' -> 6
		'g' -> 7
		'h' -> 8
		else -> -1
	}

	val y1Num = when (stepPoint[3].code) {
		49 -> 7
		50 -> 6
		51 -> 5
		52 -> 4
		53 -> 3
		54 -> 2
		55 -> 1
		56 -> 0
		else -> -1
	}
	result.add(y1Num)
	result.add(y0Num)

	return result
}

fun getNoNum(steps: List<Int>): Int {
	return when (steps[0]) {
		0 -> 8
		1 -> 7
		2 -> 6
		3 -> 5
		4 -> 4
		5 -> 3
		6 -> 2
		7 -> 1
		8 -> 0
		else -> -1
	}
}

fun getNoLetter(steps: List<Int>): Char {
	return when (steps[1]) {
		1 -> 'a'
		2 -> 'b'
		3 -> 'c'
		4 -> 'd'
		5 -> 'e'
		6 -> 'f'
		7 -> 'g'
		8 -> 'h'
		else -> '0'
	}
}

fun getPoints(stepPoint: String): List<Int> {
	if (stepPoint == "exit") {
		println("Bye!")
		exitProcess(0)
	}

	val result = ArrayList<Int>()
	val first = getX(stepPoint)
	val second = getY(stepPoint)

	result.add(first[0])
	result.add(first[1])
	result.add(second[0])
	result.add(second[1])

	return result
}

fun swapElements(chessBoard: MutableList<MutableList<Int>>, steps: List<Int>) {
	val tmp = chessBoard[steps[0]][steps[1]]
	chessBoard[steps[0]][steps[1]] = chessBoard[steps[2]][steps[3]]
	chessBoard[steps[2]][steps[3]] = tmp
}

fun swapCaptureElement(chessBoard: MutableList<MutableList<Int>>, steps: List<Int>) {
	chessBoard[steps[2]][steps[3]] = chessBoard[steps[0]][steps[1]]
	chessBoard[steps[0]][steps[1]] = 0
}

fun passantCapture(chessBoard: MutableList<MutableList<Int>>, steps: List<Int>, count: Int) {
	chessBoard[steps[2]][steps[3]] = chessBoard[steps[0]][steps[1]]
	chessBoard[steps[0]][steps[1]] = 0
	if (count % 2 == 0) {
		chessBoard[steps[2] + 1][steps[3]] = 0
	} else {
		chessBoard[steps[2] - 1][steps[3]] = 0
	}
}

fun checkCorrect(steps: List<Int>, count: Int, isCanCapture: Boolean, isCanPassantCapture: Boolean): Boolean {
	if (!isCanCapture && !isCanPassantCapture) {
		if (steps[1] != steps[3]) {
			return false
		}
	}

	if (steps[0] == steps[2] && steps[1] == steps[3]) {
		return false
	}

	if (count % 2 == 0) {
		if (steps[0] == 6) {
			if (steps[2] < 4) {
				return false
            }
			if (steps[0] < steps[2]) {
				return false
			}
		} else {
			if (steps[0] - steps[2] > 1) {
				return false
			}
			if (steps[0] < steps[2]) {
				return false
			}
		}
	} else {
		if (steps[0] == 1) {
			if (steps[2] > 4) {
				return false
			}
			if (steps[2] < steps[0]) {
				return false
			}
            if (steps[2] - steps[0] > 2) {
				return false
            }
		} else {
			if (steps[2] - steps[0] > 1) {
				return false
			}
			if (steps[2] < steps[0]) {
				return false
			}
		}
	}
	return true
}

fun isCanCapture(chessBoard: MutableList<MutableList<Int>>, count: Int, steps: List<Int>): Boolean {
	if (steps[3] < 0 || steps[3] > 8) {
		return true
	}
	if (steps[3] - steps[1] > 1) {
		return false
	}
	if (count % 2 == 0) {
		if (chessBoard[steps[2]][steps[3]] == PAWNB && steps[1] != steps[3]) {
			return true
		}
		if (steps[1] == steps[3] && chessBoard[steps[2]][steps[3]] == PAWNB) {
			return false
		}
	} else {
		if (chessBoard[steps[2]][steps[3]] == PAWNW && steps[1] != steps[3]) {
			return true
		}
		if (steps[1] == steps[3] && chessBoard[steps[2]][steps[3]] == PAWNW) {
			return false
		}
	}
	return false
}

fun isCanPassantCapture(chessBoard: MutableList<MutableList<Int>>, count: Int, steps: List<Int>): Boolean {
	if (steps[3] - steps[1] > 1) {
		return false
	}
	if (count % 2 == 0) {
		if (chessBoard[steps[0]][steps[1]] == PAWNW && prevStep[2] - 1 == steps[2] && prevStep[3] == steps[3]) {
			if (chessBoard[steps[2] + 1][steps[3]] == PAWNB) {
				return true
			}
		}
	} else {
		if (chessBoard[steps[0]][steps[1]] == PAWNB && prevStep[2] + 1 == steps[2] && prevStep[3] == steps[3]) {
			if (chessBoard[steps[2] - 1][steps[3]] == PAWNW) {
				return true
			}
		}
	}
	return false
}

fun stepReg(chessBoard: MutableList<MutableList<Int>>, stepPoint: String, count: Int, firstName: String, secondName: String) {
	var steps = getPoints(stepPoint)
	var test = true

	val isCanCapture: Boolean = isCanCapture(chessBoard, count, steps)
	val isCanPassantCapture: Boolean = isCanPassantCapture(chessBoard, count, steps)
	var flag = checkCorrect(steps, count, isCanCapture, isCanPassantCapture)

	if (!isCanCapture && !isCanPassantCapture) {
		if (chessBoard[steps[0]][steps[1]] == PAWNW && chessBoard[steps[2]][steps[3]] == PAWNB) {
			flag = false
		}
		if (chessBoard[steps[0]][steps[1]] == PAWNB && chessBoard[steps[2]][steps[3]] == PAWNW) {
			flag = false
		}
	}
    
	while (!flag) {
		flag = checkCorrect(steps, count, isCanCapture, isCanPassantCapture)

		if (!isCanCapture && !isCanPassantCapture) {
			if (chessBoard[steps[0]][steps[1]] == PAWNW && chessBoard[steps[2]][steps[3]] == PAWNB) {
				flag = false
			}
			if (chessBoard[steps[0]][steps[1]] == PAWNB && chessBoard[steps[2]][steps[3]] == PAWNW) {
				flag = false
			}
		}
        
        if (flag) break
		if (count % 2 == 0) {
			if (chessBoard[steps[0]][steps[1]] != PAWNW) {
				flag = false
				test = false
				println("No white pawn at ${getNoLetter(steps)}${getNoNum(steps)}")
			}
		} else {
			if (chessBoard[steps[0]][steps[1]] != PAWNB) {
				flag = false
				println("No black pawn at ${getNoLetter(steps)}${getNoNum(steps)}")
				test = false
			}
		}
		steps = getPoints(isNotCorrect(count, firstName, secondName, test))
		test = true
	}

	prevStep = steps.toTypedArray()

	if (count % 2 == 0) {
		while (chessBoard[steps[0]][steps[1]] != PAWNW) {
			println("No white pawn at ${getNoLetter(steps)}${getNoNum(steps)}")
			steps = getPoints(stepPart(firstName, secondName, count))
		}

		if (isCanCapture) {
			swapCaptureElement(chessBoard, steps)
			chessCount.decCounts(count)
		} else if (isCanPassantCapture) {
			passantCapture(chessBoard, steps, count)
			chessCount.decCounts(count)
		} else {
			swapElements(chessBoard, steps)
		}

		chessBoardPrint(chessBoard, arrayOf(firstName, secondName))
	} else {
		while (chessBoard[steps[0]][steps[1]] != PAWNB) {
			println("No black pawn at ${getNoLetter(steps)}${getNoNum(steps)}")
			steps = getPoints(stepPart(firstName, secondName, count))
		}

		if (isCanCapture) {
			swapCaptureElement(chessBoard, steps)
			chessCount.decCounts(count)
		} else if (isCanPassantCapture) {
			passantCapture(chessBoard, steps, count)
			chessCount.decCounts(count)
		} else {
			swapElements(chessBoard, steps)
		}

		chessBoardPrint(chessBoard, arrayOf(firstName, secondName))
	}
}

fun setHeader(): Array<String> {
	println("Pawns-Only Chess")
	return getPlayersNames()
}

fun chessBoardPrint(chessBoard: MutableList<MutableList<Int>>, names: Array<String>): Array<String> {
	println("  $DELIMITER")
	for (i in chessBoard.indices) {
		for (j in chessBoard[i].indices) {
			if (chessBoard[i][j] == 0) {
				print("   ")
			}
			if (chessBoard[i][j] in 1..8) {
				print("${chessBoard[i][j]} ")
			}
			if (chessBoard[i][j] == PAWNB) {
				print(" B ")
			}
			if (chessBoard[i][j] == PAWNW) {
				print(" W ")
			}
			if (chessBoard[i][j] >= 'a'.code) {
				print(" ${chessBoard[i][j].toChar()}  ")
			}
			if (i != 8) {
				print("$BAR")
			}
		}
		if (i != 8) {
			print("\n  $DELIMITER\n")
		}
	}
	println()

	return names
}

fun moving(names: Array<String>, chessBoard: MutableList<MutableList<Int>>) {
	var inputStr: String
	var count = 0
	while (true) {
		inputStr = stepFun(names[0], names[1], count, chessBoard)
		if (inputStr == "exit") {
			println("Bye!")
			break
		}
		count++
	}
}

fun main() {
	val chessBoard = mutableListOf(
		mutableListOf(8, 0 ,0, 0, 0, 0, 0, 0, 0),
		mutableListOf(7, PAWNB, PAWNB, PAWNB, PAWNB, PAWNB, PAWNB, PAWNB, PAWNB),
		mutableListOf(6, 0 ,0, 0, 0, 0, 0, 0, 0),
		mutableListOf(5, 0 ,0, 0, 0, 0, 0, 0, 0),
		mutableListOf(4, 0 ,0, 0, 0, 0, 0, 0, 0),
		mutableListOf(3, 0 ,0, 0, 0, 0, 0, 0, 0),
		mutableListOf(2, PAWNW, PAWNW, PAWNW, PAWNW, PAWNW, PAWNW, PAWNW, PAWNW),
		mutableListOf(1, 0 ,0, 0, 0, 0, 0, 0, 0),
		mutableListOf(0, 'a'.code, 'b'.code, 'c'.code, 'd'.code, 'e'.code, 'f'.code, 'g'.code, 'h'.code)
	)

	val names = setHeader()
	moving(chessBoardPrint(chessBoard, names), chessBoard)
}
