package fi.tuni.tamk.tiko.swapiapp

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlin.math.pow
import kotlin.math.roundToInt

@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(
    var name: String? = null,
    var mass: Int = 0,
    var height: Int = 0,
) {
    fun getBmi(): Int {
        return (mass / (height / 100.0).pow(2)).roundToInt()
    }

    override fun toString(): String {
        return "name = $name, bmi = ${getBmi()}"
    }
}