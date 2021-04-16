class Person {
   var name : String = ""
   var age : Int = 0

   init(name: String, age: Int) {
	   self.name = name
	   self.age = age
   }

   convenience init() {
	   self.init(name: "Tina", age: 20)
   }
}

class Programmer : Person {
	var salary: Int

	init(salary: Int) {
		self.salary = salary
		// super.init() fails due to Programmer not inheriting convenience init
		super.init(name: "tina", age: 12)
	}
}

// var jack1 = Programmer(name: "Jack", age: 12)
// print("\(jack1.name), \(jack1.age)")
// var tina = Programmer()
// print("\(tina.name), \(tina.age)")
var jack2 = Programmer(salary: 4000)
print("\(jack2.name), \(jack2.age), \(jack2.salary)") // prints tina, 12, 4000

