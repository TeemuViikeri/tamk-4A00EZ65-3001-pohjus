import kotlin.random.*

class Person {
	val computer : Computer? = if (generateRandomBoolean()) Computer() else null	
}

class Computer {
	val display : Display? = if (generateRandomBoolean()) Display() else null
}

class Display {
	val usbc : UsbC? = if (generateRandomBoolean()) UsbC() else null
}

class UsbC {
	val speed = if (generateRandomBoolean()) 40 else 20
}

fun main() {
	val jack = Person()	

	// a) with several if sentences (if something is null, it does not output anything)
	val computer = jack.computer
	if (computer != null) {
		val display = computer.display
		if (display != null) {
			val usbc = display.usbc
			if (usbc != null) {
				println(usbc.speed)
			}
		}
	}

	// b) using save call (if something is null, output “null”, otherwise output the speed, do this with one line)
	println(jack.computer?.display?.usbc?.speed)

	// c) using !! (which crashes the app if something is null)
	println(jack.computer!!.display!!.usbc!!.speed)

	// d) by using elvis operator, output the speed or output “could not fetch the speed” (implement this with one line)
	println(jack.computer?.display?.usbc?.speed ?: "could not fetch the speed")
}

fun generateRandomBoolean() : Boolean {
	return Random.nextBoolean()
}