fun main() {
	print("What's your name: ")
	val name : String? = readLine()?.trim()
	print("How many times you want to repeat: ")
	val value : Int? = readLine()?.toIntOrNull()

	if (value != null) {
        val amount : Int = value

		for (i in 1..amount) {
			print(name)
		}
    }
}