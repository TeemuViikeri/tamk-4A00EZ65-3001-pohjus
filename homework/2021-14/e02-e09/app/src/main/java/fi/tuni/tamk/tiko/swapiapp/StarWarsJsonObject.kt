package fi.tuni.tamk.tiko.swapiapp

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class StarWarsJsonObject(var results: MutableList<Person>? = null)