enum class DaysOfTheWeek(var description: String) {
    SUNDAY("Sunday"),
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday");
}

fun main() {
    for (enum in DaysOfTheWeek.values()) {
		println(enum.name)
	}
}