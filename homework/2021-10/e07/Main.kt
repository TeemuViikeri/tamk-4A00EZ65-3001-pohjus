// Create traditional palindrome app. Ask a string and output if given value was a palindrome. Reverse the given string using for - loop. 

// Tips for Strings

// - Notice that accessing character in Kotlin, use the array syntax: `"hello"[0]` returns `h`
// - Notice that length of String is int, not a method: `"hello".length`, not `"hello".length()`

// Tips for Comparison

// - In Kotlin, == is the same as `equals` - method in Java. In Kotlin === is the same than == in Java
// - See ranges how to decrement

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

