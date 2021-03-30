package fi.tuni.tamk.tiko.isitpalindrome

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var editText : EditText
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate()")

        editText = findViewById(R.id.isPalindromeEditText)
        textView = findViewById(R.id.isPalindromeTextView)

        editText.addMyKeyListener {
            textView.text = if (it.isPalindrome()) "YES" else "NO"
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy()")
    }

    fun isPalindromeButtonClicked(button: View) {
        val b = button as Button
        b.setOnClickListener {
            val s: String = editText.text.toString()
            val isPalindrome = if (s.isPalindrome()) "YES" else "NO"

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("isPalindrome", isPalindrome)
            startActivityForResult(intent, 10)
        }
    }

    fun phoneButtonClicked(button: View) {
        val b = button as Button
        b.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel://1232123"))
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 10) {
            if (resultCode == RESULT_OK) {
                val value = data?.getStringExtra("name")
                Log.d("MainActivity", value.toString())
            }
        }
    }

}

private fun EditText.addMyKeyListener(action: (String) -> Unit) {
    this.addTextChangedListener { action(it.toString()) }
}

private fun String.isPalindrome(
    ignoreCase: Boolean = false,
    ignoreWhiteSpaces: Boolean = false
): Boolean {
    var s = this

    if (ignoreCase) s = s.toLowerCase()
    if (ignoreWhiteSpaces) s = s.filter { !it.isWhitespace() }

    val r = s.reversed()

    Log.d("MainActivity", s)
    Log.d("MainActivity", r)

    return r == s
}
