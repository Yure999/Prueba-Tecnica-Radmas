package com.example.openweatherapi.data.repository.remote

import com.example.openweatherapi.data.model.Weather

interface RemoteRepository {
    suspend fun getWeather(): List<Weather>
}