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

func main() {
    let spot = Dog()
    spot.name = "Spot"
    spot.weight = 50
    spot.bark()

    let dog = Dog()
    dog.bark()
}

main()