package fi.tuni.tamk.tiko.soundplayerapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var startButton: Button
    private lateinit var stopButton: Button

    inner class CompletedReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            startButton.isEnabled = true
            stopButton.isEnabled = false
        }
    }

    private var receiver = CompletedReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        startButton = findViewById(R.id.startButton)
        startButton.isEnabled = true
        stopButton = findViewById(R.id.stopButton)
        stopButton.isEnabled = false
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, IntentFilter("fi.tuni.tamk.COMPLETED"))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    fun start(button: View) {
        val b = button as Button
        b.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            intent.putExtra("uri", editText.text.toString())
            startService(intent)
            it.isEnabled = false
            stopButton.isEnabled = true
        }
    }

    fun stop(button: View) {
        val b = button as Button
        b.setOnClickListener {
            stopService(Intent(this, MusicService::class.java))
            it.isEnabled = false
            startButton.isEnabled = true
        }
    }
}