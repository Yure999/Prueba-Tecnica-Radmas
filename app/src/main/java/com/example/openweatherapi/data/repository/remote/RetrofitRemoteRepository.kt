package com.example.openweatherapi.data.repository.remote

import android.accounts.NetworkErrorException
import com.example.openweatherapi.data.model.Weather
import com.example.openweatherapi.data.network.ApiFactory
import java.lang.Exception

class RetrofitRemoteRepository: RemoteRepository {

    private val weatherApi = ApiFactory.get()

    override suspend fun getWeather(lat: String, long: String): List<Weather> {
        try {
            val response = weatherApi.getWeather(lat, long)
                ?: throw NetworkErrorException("Error fetching weather")
            return response.weatherList
        }catch (e: Exception){
            throw NetworkErrorException("Error fetching weather")
        }
    }
}