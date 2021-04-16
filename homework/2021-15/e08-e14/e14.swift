extension Int {
    func hello() {
        print("moro")
    }

	func repeats(function repeatedFunction: () -> Void ) {
		for _ in 1...self {
			repeatedFunction()
		}
	}
}

// outputs 4 time hello
3.repeats() {
   print("hello")
}

// outputs 4 times jack
4.repeats() {
   print("jack")
}