class Person {
    var name : String?

	init(name: String) {
		self.name = name
	}
}

class Programmer : Person {
    var salary : Int?

    init(name: String, salary : Int) {
        // self.name = name
        self.salary = salary
		super.init(name: name)
    }

	override convenience init(name: String) {
		self.init(name: name, salary: 4000)
	}

	convenience init() {
		self.init(name: "tina", salary: 4000)
	}
}

// Salary will be 4000
var jack = Programmer(name: "jack")
print("\(jack.name!), \(jack.salary!)") // jack, 4000

var tina = Programmer()
print("\(tina.name!), \(tina.salary!)") // tina, 4000