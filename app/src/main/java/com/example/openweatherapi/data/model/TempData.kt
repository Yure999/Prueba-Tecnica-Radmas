package com.example.openweatherapi.data.model

import com.google.gson.annotations.SerializedName

data class TempData(
    @SerializedName("day")
    val dayTemp: Float,
    @SerializedName("min")
    val minTemp: Float,
    @SerializedName("max")
    val maxTemp: Float
)