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
		// Assigning a (new) value to inherited property
		// must be done after super.init()
		self.x = 0
    }
}

let p = Pixel(x: 1, y: 0, color: "red")
print("\(p.x), \(p.y), \(p.color)") // 0, 0, red