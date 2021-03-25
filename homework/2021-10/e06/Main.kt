import java.time.LocalDate

fun main() {
	val days : Int = daysInCurrentMonth()
	println(days)
}

fun daysInCurrentMonth() : Int {
	val date = LocalDate.now()
	val month = date.getMonthValue()

	when (month) {
		1, 3, 5, 7, 8, 10, 12  -> return 31
		4, 6, 9, 11 -> return 30
		else -> {
			if (date.isLeapYear()) return 29 else return 28
		}
	}
}
