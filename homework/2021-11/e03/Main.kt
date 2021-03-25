open class Person (var name: String) {
	open fun drink() = println("$name drinks water")

	fun sleep() = println("$name sleeps")

	override fun toString() = "name = $name"
}

class Programmer (name: String, salary: Int) : Person(name) {
  var salary: Int = 0
    get() = field
    set(value) { 
      if (value > 0) {
        field = value
      } else {
        throw IllegalArgumentException("salary must be > 0.")
      }
    } 

  init {
    this.salary = salary
  }

	override fun drink() = println("$name drinks energy drink")

	override fun toString() = super.toString() + ", salary = $salary"

	fun codeApps() = println("$name codes apps")
}

fun main() {
  // val tina = Programmer("tina", -4000) THROWS AN EXCEPTION
  val tina = Programmer("tina", 4000)
  // tina.salary = -2 THROWS AN EXCEPTION
}