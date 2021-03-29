package fi.tuni.tamk.tiko.isitpalindrome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var secondTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        Log.d("SecondActivity", "in second")

        secondTextView = findViewById(R.id.isIntentPalindrome)
        val intent = intent
        secondTextView.text = intent.getStringExtra("isPalindrome")
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("name", "hello world")
        setResult(RESULT_OK, intent)

        Log.d("SecondActivity", "in back")

        super.onBackPressed()
    }
}