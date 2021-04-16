import Foundation

struct Circle {
	var _radius: Double = 0

	init (radius: Double) {
		self.radius = radius
	}

	var radius: Double {
		get {
			return self._radius
		}
		set {
			if newValue >= 0 {
				self._radius = newValue
			} else {
				self._radius = 0
			}
		}
	}
}

var posC = Circle(radius: 5)
print(posC) // Circle(_radius: 5.0)

var negC = Circle(radius: -5)
print(negC) // Circle(_radius: 0.0)