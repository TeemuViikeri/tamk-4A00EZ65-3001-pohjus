/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package e06

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.*
import kotlin.concurrent.thread

data class Character(
    var name: String,
    var height: Int,
    var mass: Int,
    var bmi: Double
)

fun main(args: Array<String>) {
    fetchAndParse(args[0].toInt()) {
        println(it.name)
        println(it.bmi)
    }
}

fun bmi(mass: Int, height: Double) : Double {
    return mass / height.pow(2)
}

fun fetchAndParse(peopleId: Int, callback: (Character) -> Unit) {
    thread() {
        try {
            val swapi = "https://swapi.dev/api/people/$peopleId/"
            val url = URL(swapi)
            val http: HttpURLConnection = url.openConnection() as HttpURLConnection
            http.setRequestMethod("GET")
            http.setRequestProperty("Accept", "application/json");
            http.setRequestProperty("Content-Type", "application/json");

            val stream: InputStream = http.getInputStream()
            val reader = InputStreamReader(stream)

            val gson = Gson()
            val character: Character = gson.fromJson(reader, Character::class.java)
            
            val m = character.mass
            val h = character.height.toDouble() / 100

            val bmi = bmi(m, h)
            character.bmi = bmi;

            callback(character)    
        }
        catch(e: Exception) {
            e.printStackTrace()
        }
    }
}
