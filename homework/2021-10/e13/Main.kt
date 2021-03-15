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

fun main(args: Array<String>) {
    val numberOfPersons : Int? = validate(args)
    println(numberOfPersons)
    
    if(numberOfPersons != null) {
        val listOfPersons : MutableList<Person> = createList(numberOfPersons)
        output(listOfPersons)
    } else {
        println("please give integer > 0")
    }
}

fun generateRandomBoolean() : Boolean {
	return Random.nextBoolean()
}

// Validates user input from command line
fun validate(args: Array<String>) : Int? {
    if (args.isEmpty()) throw throw IllegalArgumentException("please give integer > 0")

    val input: Int? = args[0].toIntOrNull()

    if (input != null && input < 0) throw IllegalArgumentException("please give integer > 0")

    return input
}

// Creates a MutableList of Person objects
fun createList(amount: Int) : MutableList<Person> {
    val list = mutableListOf<Person>()

    for (i in 0 until amount) {
        list.add(Person())
    }

    return list
}

// Iterates over the listOfPersons and outputs each list items usb-C speed or error output
fun output(listOfPersons: List<Person>) {
    listOfPersons.forEach { println(it.computer?.display?.usbc?.speed ?: "could not fetch the speed") }
}
