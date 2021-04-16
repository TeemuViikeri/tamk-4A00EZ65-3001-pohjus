class Point {
    var x : Int
    var y : Int

	init (x: Int, y: Int) {
		self.x = x
		self.y = y
	}

	convenience init () {
		self.init(x: 0, y: 0)
	}
}

class Pixel : Point {
    var color : String

	init(x: Int, y: Int, color: String) {
        self.color = color
        super.init(x: x, y: y)
    }
}

// Designated init
let p2 = Point(x: 1, y: 2)
print("\(p2.x), \(p2.y)") // 1, 2
// Convenience init 
let p1 = Point() // x = 0, y = 0
print("\(p1.x), \(p1.y)") // 0, 0

// fails if inherited init(s) doesn't include 'color' property
let p = Pixel(x: 0, y: 0, color: "red")