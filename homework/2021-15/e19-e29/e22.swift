class Mammal {
	var weight: Double = 0
}

class Dog : Mammal {
	var name: String?

	func bark() {
		if name != nil {
			print("\(name!) barking")
		} else {
			print("barking")
		}
	}
}

class Human : Mammal {
	var name: String?

	func createArt() {
		if name != nil {
			print("\(name!) creates art")
		} else {
			print("creates art")
		}
	}
}

func main() {
	let spot = Dog()
    spot.name = "Spot"
    spot.weight = 10

    let jack = Human()
    jack.name = "Jack"
    jack.weight = 80

	makeAction(mammal: spot)
	makeAction(mammal: jack)
}

func makeAction(mammal: Mammal) {
	if let dog = mammal as? Dog {
		dog.bark()
	}

	if let human = mammal as? Human {
		human.createArt()
	}
}

main()