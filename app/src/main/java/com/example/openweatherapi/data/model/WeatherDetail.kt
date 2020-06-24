package com.example.openweatherapi.data.model

import com.google.gson.annotations.SerializedName

data class WeatherDetail(
    @SerializedName("main")
    val weatherName: String,
    @SerializedName("description")
    val weatherDescription: String,
    @SerializedName("icon")
    val weatherIcon: String
)