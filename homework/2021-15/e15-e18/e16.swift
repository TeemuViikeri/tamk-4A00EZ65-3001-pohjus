class PointC : Equatable {
	var x: Int = 0
	var y: Int = 0

	init() {}

	init(x: Int, y: Int) {
		self.x = x
		self.y = y
	}

	static func == (left: PointC, right: PointC) -> Bool {
		return (left.x == right.x)
	}
}

struct PointS : Equatable {
	var x: Int = 0
	var y: Int = 0

	// static func == (left: PointS, right: PointS) -> Bool {
	// 	return (left.x == right.x)
	// }
}

let a1 = PointC()
let b1 = PointC()
print(a1 === b1) // false


let a2 = PointC()
let b2 = a2
print(a2 === b2) // true


let a3 = PointS()
let b3 = PointS()
// print(a3 === b3) -> error: argument type 'PointS' expected to be an instance of a class or class-constrained type


let a4 = PointS(x: 0, y: 8)
let b4 = PointS(x: 0, y: 9)
// 1. error: by default without Equatable
// 2. fail: when Equatable protocol is implemented and default "==" is used
// 3. true: when Equatable protocol is implemented and own "==" is implemented
print(a4 == b4)


let a5 = PointC()
let b5 = PointC()
// 1. error: by default without Equatable
// 2. error: when Equatable is implemented, own "==" is not implemented
// 3. true: when Equatable protocol is implemented and own "==" is implemented
print(a5 == b5)