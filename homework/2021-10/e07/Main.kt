fun main() {
	val string : String? = readLine()?.trim()
	if (string != null) println(isPalindrome(string))
}

fun isPalindrome(string: String) : Boolean {
	val reversed = string.reversed()
	
	for (i in 0 until string.length) {
		if (reversed[i] != string[i]) return false
	}

	return true
}
