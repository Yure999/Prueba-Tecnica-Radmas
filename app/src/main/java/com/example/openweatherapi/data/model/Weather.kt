package com.example.openweatherapi.data.model

import com.google.gson.annotations.SerializedName

data class Weather (
    @SerializedName("temp.day")
    val dayTemp: Int,
    @SerializedName("temp.min")
    val minTemp: Int,
    @SerializedName("temp.max")
    val maxTemp: Int,
    @SerializedName("weather.main")
    val weatherName: String,
    @SerializedName("weather.description")
    val weatherDescription: String,
    @SerializedName("weather.icon")
    val weatherIcon: String
)