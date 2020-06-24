package com.example.openweatherapi.data.network

import com.example.openweatherapi.data.model.Weather
import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenWeatherApi {
    @GET("lat={lat}&lon={lon}&units=metric& exclude=hourly,minutely&appid=b309c509b4db229542a777324db99b4b")
    suspend fun getWeather(@Path("lat") latitude: String, @Path("lon") longitude: String): Response?
}

data class Response(
    @SerializedName("daily")
    val weatherList: List<Weather>
)

object ApiFactory {
    fun get(): OpenWeatherApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/onecall?")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(OpenWeatherApi::class.java)
    }
}