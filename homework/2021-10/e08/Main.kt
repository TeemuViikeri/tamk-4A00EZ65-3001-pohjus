// A) One lambda

// Write a simple function `sum`. Then function gets two integer arguments and a function. The sum of the given integers are passed as an argument of the given function. So the usage:


//     fun main() {
//         sum(4,5, {msg -> println(msg)})
//     }

// This should output “Result was 9”

// When you declare function type:


//     val x : (argumentType1, argumentType2, ...) -> returnType

// Example


//     val x : (Int, Int) -> Int

// Remember that `Unit` is the same then void in Java/C++.

// Implement the invoke also with

// a) trailing lamdba
// b) keyword `it` in trailing lamdba.


// B) Several Lambdas

// Write a function `isPositive`. This function receives integer and one function as argument. If given integer is positive, it will invoke the first function


//     fun isPositive(a: Int, success: ??) {
//         if(a > 0) {
//             success()
//         }
//     }

// The given function do not return anything and do not have arguments. Try to call the isPositive function with positive value. Create lambda that outputs “it was positive”. Use trailing lambda.

// Add also error argument (function) (so three arguments to the isPositive function). If given value is negative, it will invoke the error function. Try to use both trailing lambda and “normal lambda”.


// C) Kotlin library functions

// Write following app:


//     kotlin myappKt hello world

// It will filter away every word containing >= 5 chars and it will put all the rest to uppercase. In the end it will print all the given arguments. Implement your app in one line:


//     fun main(arguments: Array<String>) {
//         // implement in one line
//     }

// Use trailing lambdas and `it`. Try to find proper methods from Array documentation of kotlin and use those. This exercise can be implemented with just one line.

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
	if(a > 0) {
		success()
	} else {
		error()
	}
}