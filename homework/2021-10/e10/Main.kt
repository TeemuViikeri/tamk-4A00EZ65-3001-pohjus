import kotlin.random.*
import kotlin.system.exitProcess

var weeks: Int = 0
var matches: Int = 0

fun main(args: Array<String>) {
	val inputToValidate: List<Int?> = args.map { it.toIntOrNull() }
	val lottoNumbers: List<Int> = validateInput(inputToValidate)

	while (matches != 3) {
		playLotto(lottoNumbers)
	}

}

fun playLotto(lottoNumbers: List<Int>) {
	weeks++
	val luckyNumbers: List<Int> = generateNumbers(7)
	compareNumbers(lottoNumbers, luckyNumbers)
}

fun generateNumbers(amount: Int) : List<Int> {
	val numbers: MutableSet<Int> = mutableSetOf<Int>()
	
	while (numbers.size < amount) {
		numbers.add(Random.nextInt(1, 41))
	}

	return numbers.toList()
}

fun compareNumbers(lottoNumbers: List<Int>, luckyNumbers: List<Int>) {
	var comparedMatches: Int = 0;

	for (i in lottoNumbers.indices) {
		if (luckyNumbers.contains(lottoNumbers[i])) comparedMatches++
	}

	displayLotto(lottoNumbers, luckyNumbers, comparedMatches)

	if (comparedMatches > matches) {
		matches++
		displayHighscore()
	}
}

fun displayLotto(lottoNumbers: List<Int>, luckyNumbers: List<Int>, correct: Int) {
	val sortedLottoNumbers: MutableList<Int> = lottoNumbers.toMutableList()
	val sortedLuckyNumbers: MutableList<Int> = luckyNumbers.toMutableList()
	sortedLottoNumbers.sort()
	sortedLuckyNumbers.sort()
	val lottoRow: String = sortedLottoNumbers.joinToString(prefix = "[", postfix = "]") { it.toString().padStart(2, '0') }
	val luckyRow: String = sortedLuckyNumbers.joinToString(prefix = "[", postfix = "]") { it.toString().padStart(2, '0') }
	println(lottoRow)
	println("$luckyRow - correct = $correct")
}

fun displayHighscore() {
	val years: Double = (weeks * 1.0 / 52)
	val text = "You got $matches correct, it took %.2f years".format(years)
	println(text)
}

fun validateInput(input: List<Int?>) : List<Int> {
	lateinit var listOfIntegers: List<Int>

	try {
		validateAmountOfArguments(input)
		listOfIntegers = validateArgumentsAreIntegers(input)
		validateArgumentsAreLottoNumbers(listOfIntegers)
		validateArgumentsAreNonDuplicates(listOfIntegers)
	}
	catch(e: IllegalArgumentException) {
		e.printStackTrace()
		exitProcess(1)
	}

	return listOfIntegers
}

@Throws(IllegalArgumentException::class)
fun validateAmountOfArguments(input: List<Int?>) {
	val amountOfArguments = input.size

	if (amountOfArguments < 7) {
		throw IllegalArgumentException("Program was initialized with less than seven (7) arguments.")
	} else if (amountOfArguments > 7) {
		throw IllegalArgumentException("Program was initialized with more than seven (7) arguments.")
	}
}

@Throws(IllegalArgumentException::class)
fun validateArgumentsAreIntegers(input: List<Int?>) : List<Int> {
	input.forEach { if (it == null) throw IllegalArgumentException("Program was initialized with non-integer(s).") }
	return listOfNotNull(*input.toTypedArray())
}

@Throws(IllegalArgumentException::class)
fun validateArgumentsAreLottoNumbers(input: List<Int>) {
	val isLottoNumber: (Int) -> Boolean = { it >= 1 && it <= 40 }
	val numbersAreLottoNumbers: Boolean = input.all { isLottoNumber(it) }
	if (!numbersAreLottoNumbers) throw IllegalArgumentException("Program should be initialized with lotto numbers: from 1 to 40.") 
}

@Throws(IllegalArgumentException::class)
fun validateArgumentsAreNonDuplicates(input: List<Int>) {
	val set: Set<Int> = input.toSet()
	if (set.size != input.size) throw IllegalArgumentException("Program should not be initialized with duplicates.") 
}

