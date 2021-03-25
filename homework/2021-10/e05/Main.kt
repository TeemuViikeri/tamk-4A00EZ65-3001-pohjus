fun main() {
	val stock : String? = giveStock()
	println(stock?.toLowerCase())
}

fun giveStock() : String? {
	println("Give company")
	val company : String? = readLine()?.trim()
	
	when (company) {
		"Microsoft" -> return "MSFT"
		"Apple" -> return "APPL"
		"Nokia" -> return "NOK"
		else -> {
			return null
		}
	}
}