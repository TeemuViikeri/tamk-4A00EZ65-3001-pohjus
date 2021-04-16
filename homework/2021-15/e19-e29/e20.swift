class Mammal {
	var weight: Double = 0
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
    let jack = Human()
    jack.name = "Jack"
    jack.weight = 50
    jack.createArt()

    let human = Human()
    human.createArt()
}

main()