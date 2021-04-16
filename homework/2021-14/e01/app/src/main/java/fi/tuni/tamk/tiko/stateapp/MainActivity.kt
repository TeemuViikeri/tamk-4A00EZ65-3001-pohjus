    package fi.tuni.tamk.tiko.stateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("main", "oncCreate()")
        setContentView(R.layout.activity_main)
        val cal = Calendar.getInstance()
        title = cal.time.toString()
    }

    fun clicked(view: View) {
        val b = view as Button
        b.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("main", "onSaveInstanceState()")
        outState.putString("title", title.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        title = savedInstanceState.getString("title")
        Log.d("main", "onRestoreInstanceState()")
    }
}