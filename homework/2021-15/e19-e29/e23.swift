class PersonA {
	var name: String = ""
	var age: Int = 0
}

class PersonB {
	var name: String?
	var age: Int?
}

class PersonC {
	var name: String
	var age: Int

	init () {
		name = ""
		age = 0
	}
}

// Fails without initializers or initial values for stored properties
var a = PersonA()
var b = PersonB()
var c = PersonC()
print(a)
print(b)
print(c)