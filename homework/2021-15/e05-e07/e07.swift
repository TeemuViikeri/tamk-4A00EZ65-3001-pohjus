class Mammal { }

class Dog : Mammal { 
  func wuh() -> Void {
      print("Wuh Wuh!");
  }
}

class Cat : Mammal { 
  func meow() -> Void {
      print("Meow!");
  }
}

func main() {
  // mammals array, results an warning because no use for it yet.
  var mammals = [Mammal]();
  for _ in 1...5 {
      let diceRoll = Bool.random()
	  diceRoll ? mammals.append(Dog()) : mammals.append(Cat())
  }

  for mammal in mammals {
	  if let dog = mammal as? Dog {
		  dog.wuh()
	  }

	  if let cat = mammal as? Cat {
		  cat.meow()
	  }
  }
}

main();