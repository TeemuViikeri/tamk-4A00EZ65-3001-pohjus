class PointC {
	var x: Int = 0
	var y: Int = 0

	init() {}

	init(x: Int, y: Int) {
		self.x = x
		self.y = y
	}
}

struct PointS {
	var x: Int = 0
	var y: Int = 0
}

var a = PointC()
var b = PointS()

var referenceA = a
var copyB = b

print(a.x)
print(b.x)

referenceA.x = 1
copyB.x = 1

// original a.x is changed due to class reference type accesses the same class 
// object
print(a.x) 
// original b.x is NOT changed due to struct being a value type so when
// existing struct is assigned to a new variable, changes apply only to the 
// new copy
print(b.x) 

// works through memberwise initialization
let test1 = PointS(x: 0, y: 1) 
print("test1 | x: \(test1.x), y: \(test1.y)") 
// doesn't work without both init blocks in class
// first init takes care of empty object initialization, PointC()
// second init takes care of this initialization below, PointC(x: 0, y: 1)
let test2 = PointC(x: 0, y: 1)
print("test2 | x: \(test2.x), y: \(test2.y)") 