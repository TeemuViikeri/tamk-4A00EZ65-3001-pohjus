package fi.tuni.tamk.tiko

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_TIME_TICK
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button

    inner class MyBroadCastReceiver2 : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("TAG", Thread.currentThread().name)
            intent?.getStringExtra("value")?.let {
                startButton.text = "i = $it"
            }
        }
    }

//    private var receiver = MyBroadCastReceiver()
    var receiver2 = MyBroadCastReceiver2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startButton = findViewById(R.id.startServiceButton)
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume()")
        registerReceiver(receiver2, IntentFilter("fi.tuni.tamk.test"))
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause()")
        unregisterReceiver(receiver2)
    }

    fun startMyService(button: View) {
        val b = button as Button
        b.setOnClickListener {
            startService(Intent(this, MyBackgroundService::class.java))
        }
    }

    fun stopMyService(button: View) {
        val b = button as Button
        b.setOnClickListener {
            stopService(Intent(this, MyBackgroundService::class.java))
        }
    }
}