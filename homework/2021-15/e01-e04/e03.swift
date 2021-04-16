// tuple1
let tuple1: (Double, Int) = (0.14, 3)
let (d, i) = tuple1
let PI = Double(i) + d
print(PI)

let (_, i2) = tuple1
print("1 + 2 + \(i2) = \(1 + 2 + i2)")

// tuple2
let information: (String, (String, String, String, String)) = (
	name: "jack", 
	address: (
		line: "Hämeenkatu",
		city: "Tampere",
		zip: "33100",
		country: "Finland"
	) 
)

print(information)