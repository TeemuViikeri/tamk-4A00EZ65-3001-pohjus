import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import kotlin.concurrent.thread
import kotlin.random.*

class MyWindow : JFrame {
    var changeTitle: JButton
    var animate: JButton
    var isRunning: Boolean

    constructor (title: String) : super(title) {
        setLayout(FlowLayout())       
        add(changeTitle)
        add(animate)
    }

    init {
        changeTitle = JButton("change title")
        animate = JButton("animate")
        isRunning = false
    }
}

fun main() {
    val window: MyWindow = MyWindow("Kotlin is Fun!")
    window.pack()
    window.setVisible(true)
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

    window.changeTitle.addActionListener { window.setTitle("Hello world") }

    window.animate.addActionListener {       
        if (window.isRunning == false) {
            window.isRunning = true

            thread() {
                val screen: Dimension = Toolkit.getDefaultToolkit().getScreenSize()
                val w = screen.width - window.getWidth()
                val h = screen.height - window.getHeight()

                while (window.isRunning) {
                    window.setLocation(Random.nextInt(w), Random.nextInt(h))
                    Thread.sleep(1000)
                }
            }
        } else {
            window.isRunning = false
        }
    }
}

fun randomizePosition () : Array<Int> = arrayOf(Random.nextInt(500), Random.nextInt(500))