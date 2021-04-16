import Foundation

struct Circle {
	var radius: Double = 0

	init (radius: Double) {
		self.radius = radius
	}

	var surfaceArea: Double {
		get {
			return (Double.pi * (pow(self.radius, 2)))
		}
		set {
			self.radius = (newValue / Double.pi).squareRoot() 
		}
	}
}

var c = Circle(radius: 5)
print(c.radius)
print(c.surfaceArea)

c.radius = 3
print(c.radius)
print(c.surfaceArea)

c.surfaceArea = 10
print(c.radius)
print(c.surfaceArea)
