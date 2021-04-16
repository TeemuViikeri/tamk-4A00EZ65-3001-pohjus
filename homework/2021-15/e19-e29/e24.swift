class Person {
    private var name : String?

	init(name: String) {
		self.name = name
	}
}

class Programmer : Person {
    private var salary : Int?


    init(name: String, salary : Int) {
        // self.name = name
        self.salary = salary
		super.init(name: name)
    }
}

// 1. Fails because 'name' is private on Person
// 2. Fails due to superclass init not called
// 3. OK due to Programmer object calls Person superclass init which
// initializes 'name' for Programmer in superclass
var jack = Programmer(name: "jack", salary: 4000)