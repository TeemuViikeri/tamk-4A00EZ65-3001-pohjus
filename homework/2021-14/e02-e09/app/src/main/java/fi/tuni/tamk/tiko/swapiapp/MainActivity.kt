package fi.tuni.tamk.tiko.swapiapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import com.fasterxml.jackson.databind.ObjectMapper

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)

    }

    override fun onResume() {
        super.onResume()
        downloadUrlAsync("https://swapi.dev/api/people/") {
            // Jackson JSONObject mapping
            val mp = ObjectMapper()
            val myObject: StarWarsJsonObject = mp.readValue(it, StarWarsJsonObject::class.java)
            val persons: MutableList<Person>? = myObject.results

            persons?.sortByDescending {
                it.getBmi()
            }

            // Using ArrayAdapter
            val adapter: ArrayAdapter<Person> = ArrayAdapter(
                this, R.layout.item, R.id.myTextView, ArrayList<Person>())
            adapter.addAll(persons as MutableCollection<out Person>)
            listView.adapter = adapter
        }
    }

    private fun getUrl(url: String) : String? {
        val myUrl = URL(url)
        val conn = myUrl.openConnection() as HttpURLConnection
        val reader = BufferedReader(InputStreamReader(conn.inputStream));
        var input = ""

        reader.use {
            var line = it.readLine()

            while (line != null) {
                input += line
                line = it.readLine()
            }
        }

        return input
    }

    private fun downloadUrlAsync(url: String, callback: (String) -> Unit) {
        thread {
            val json = getUrl(url).toString()

            runOnUiThread {
                callback(json)
            }
        }
    }
}