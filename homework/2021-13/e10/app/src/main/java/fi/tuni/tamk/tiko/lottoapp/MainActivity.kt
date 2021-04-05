package fi.tuni.tamk.tiko.lottoapp

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var numbers: MutableSet<Int>
    private lateinit var luckyButton: Button

    inner class MyLocalBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            thread {
                val randoms: IntArray = intent?.getIntArrayExtra("randoms")!!
                Log.d("numbers", "in receiver")

                randoms.forEach {
                    val id = resources.getIdentifier("button$it", "id", packageName)
                    val b = findViewById<Button>(id)

                    runOnUiThread {
                        b.setBackgroundColor(Color.WHITE)
                    }

                    Thread.sleep(20)

                    if (b.tag == true) {
                        runOnUiThread { b.setBackgroundColor(darkerColor()) }
                    } else {
                        runOnUiThread { b.setBackgroundColor(defaultColor()) }
                    }
                }
            }
        }
    }

    var receiver = MyLocalBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numbers = mutableSetOf()
        luckyButton = findViewById(R.id.lucky_button)
        luckyButton.isEnabled = false
        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(receiver, IntentFilter("highlight"))
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver)
        super.onDestroy()
    }

    fun addNumber(button: View) {
        val b = button as Button
        b.setOnClickListener {
            b.tag = true
            b.setBackgroundColor(darkerColor())

            if (numbers.size < 7) {
                val number = b.text.toString().toInt()
                numbers.add(number)

                if (numbers.size == 7) {
                    luckyButton.isEnabled = true
                }
            }
        }
    }

    fun printNumbers(button: View) {
        val b = button as Button
        b.setOnClickListener {
            numbers = numbers.toSortedSet()
            val intent = Intent(this, LottoService::class.java)
            intent.putExtra("numbers", numbers.toIntArray())
            startService(intent)
        }
    }

    fun defaultColor(): Int {
        return ContextCompat.getColor(this@MainActivity, R.color.purple_200)
    }

    fun darkerColor(): Int {
        return ContextCompat.getColor(this@MainActivity, R.color.purple_500)
    }
}