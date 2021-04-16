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

	printWeight(mammal: spot)
	printWeight(mammal: jack)
}

func printWeight(mammal: Mammal) {
	print(mammal.weight)
}

main()