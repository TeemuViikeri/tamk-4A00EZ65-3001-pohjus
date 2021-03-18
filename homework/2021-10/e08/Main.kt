fun main(args: Array<String>) {
	// A
    sum(4,5) { println(it) }

	// B
	isPositive(0, { println("Is positive!")} ) {
		println("Is not positive")
	}

	// C
	args.filter() { it.length <= 5 }.map() { it.toUpperCase() }.forEach() { println(it) } 
}

// A
fun sum(a: Int, b: Int, callback: (sum : Int) -> Unit) {
	callback(a + b)
}

// B
fun isPositive(a: Int, success: () -> Unit, error: () -> Unit) {
	if (a > 0) {
		success()
	} else {
		error()
	}
}