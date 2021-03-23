import kotlin.random.*

data class Person(var name: String, var age: Int)

fun main(args: Array<String>) {
	val jack1 = Person("jack", 30)
	val jack2 = Person("jack", 30)

	println(jack1)
	println(jack2)
	println(jack1.equals(jack2))

	// By default:
	// toString() outputs a string representation of the object and its memory address
	// equals() compares the memory addresses of two objects

	// When Data classes are used:
	// toString() now outputs a string representation of the object with its properties
	// equals() now compares the property values of two objects

	val jack3 = jack2.copy(age = 25)
	println(jack3)

	// Copy function:
	// copy() lets you create a copied object of an existing object but you can also change some
	// of the properties of the target object when creating new copy
	// copy() doesn't exist for normal classes which have a common and default superlcass Any

	validateArgument(args)
	val numberOfPersons = args[0].toInt()

	val names = arrayOf("tina", "jack", "hannah")

	var personList = MutableList(numberOfPersons) { 
		Person(names[Random.nextInt(names.size)], Random.nextInt(1, 101)) 
	}

	// Loop until personList includes less than three Persons so that distinct() is used
	while (personList.size == 3) {
		personList = MutableList(numberOfPersons) { 
			Person(names[Random.nextInt(names.size)], Random.nextInt(1, 101))
		}
		println(personList) // You can 
		personList = personList.distinct().toMutableList()
	}

	// distinct() wihout data classes:
	// distinct() uses objects' toString() method as the comparable subject so when Data Classes ARE used,
	// it means that the comparable subject is the object and its properties.
	// When distinct() is used without Data Classes, distinct() is trying to compare objects' memory addresses
}

fun validateArgument(args: Array<String>) {
	if (args.size != 1) {
		throw IllegalArgumentException("Argument should be an integer greater than 0")
	}
}