open class Person (var name : String) {
	open fun drink() = println("$name drinks water")

	fun sleep() = println("$name sleeps")

	override fun toString() = "name = $name"
}

class Programmer (name : String, var salary : Int) : Person(name) {

	override fun drink() = println("$name drinks energy drink")

	override fun toString() = super.toString() + ", salary = $salary"

	fun codeApps() = println("$name codes apps")
}

fun main() {
    val tina = Programmer("tina", 4000)
    // outputs "tina drinks energy drink"
    tina.drink()
    // "tina sleeps"
    tina.sleep()  
    // "tina code apps"
    tina.codeApps()
    // "name = tina, salary = 4000"
    println(tina.toString())

	println()

    val jack = Person("jack")
    // "jack drinks water"
    jack.drink()
    // "jack sleeps"
    jack.sleep()
    // "name = jack"
    println(jack.toString())
}