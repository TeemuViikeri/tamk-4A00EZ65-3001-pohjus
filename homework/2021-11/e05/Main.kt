import kotlin.random.*

interface Drawable {
	fun draw()
}

data class Rectangle (var width: Int, var height: Int) : Drawable {
	init {
		this.width = width
		this.height = height
	}

	override fun draw() {
		for (h in 1..height) {
			for (w in 1..width) {
				print("X")
			}
			
			println()
		}

		println()
	}
}

data class RectTriangle (var height: Int) : Drawable {
	init {
		this.height = height
	}

	override fun draw() {
		for (h in 1..height) {
			println("X".repeat(h))
		}

		println()
	}
}

fun main() {
	val drawables : MutableList<Drawable> = generateRandomArray(amount = 5)
	drawables.forEach { it.draw() }
}

fun generateRandomArray (amount: Int): MutableList<Drawable> {
	return MutableList(amount) { 
		if (Random.nextInt(2) == 0) createRectangle() else createRectTriangle() 
	}
}

fun createRectangle(): Rectangle = Rectangle(Random.nextInt(3, 6), Random.nextInt(3, 6))
fun createRectTriangle(): RectTriangle = RectTriangle(Random.nextInt(3, 6))