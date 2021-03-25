import kotlin.concurrent.thread

fun main() {
    println(MyMath.abs(-4))
    Test.fly() { println("kotlin flies") }

    val count = {
        for (i in 1..5) {
            println(Thread.currentThread().getName() + ": $i")
            Thread.sleep(500)
        }
    }

    thread { count() }

    thread { count() }
}