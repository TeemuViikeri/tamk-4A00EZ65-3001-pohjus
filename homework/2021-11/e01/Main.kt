import kotlin.math.*

class Person (var name : String)

class Circle (var radius : Int) {

	var color : String? = null

	constructor(radius : Int, color : String) : this(radius) {
		this.color = color
	}

	fun printSurfaceArea() = println(PI * radius.toDouble().pow(2))

	fun attributesToString() : String = 
		if (color != null) 
			"radius = $radius, color = $color"
		else 
			"radius = $radius" 
}

fun main() {
	// A
	var jack = Person("jack smith")
	println(jack.name)

	// B
	val c1 = Circle(radius = 5, color = "red")
	val c2 = Circle(radius = 5)

	println(c1.radius)
	c1.printSurfaceArea()
	println(c1.attributesToString())

	println(c2.radius)
	c2.printSurfaceArea()
	println(c2.attributesToString())
}