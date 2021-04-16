struct Person {
    var age : Int = Int.random(in: 1...100)
}

var persons : [Person] = []

for _ in 1...20 {
    persons.append(Person())
}

persons.sort { $0.age < $1.age }
let ages = persons.map { $0.age }
print(ages)