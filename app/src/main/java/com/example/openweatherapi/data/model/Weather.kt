package com.example.openweatherapi.data.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("temp")
    val tempData: TempData,
    @SerializedName("weather")
    val weatherDetail: List<WeatherDetail>

)