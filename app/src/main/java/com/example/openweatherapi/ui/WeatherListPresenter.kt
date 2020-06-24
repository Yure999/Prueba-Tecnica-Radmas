package com.example.openweatherapi.ui

import android.accounts.NetworkErrorException
import com.example.openweatherapi.data.model.Weather
import com.example.openweatherapi.data.repository.remote.RemoteRepository
import com.example.openweatherapi.data.repository.remote.RetrofitRemoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherListPresenter(private val view: View) {

    private val remoteRepository: RemoteRepository = RetrofitRemoteRepository()

    fun init() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val weatherList = withContext(Dispatchers.IO) {
                    remoteRepository.getWeather()
                }
                view.showWeather(weatherList)
            } catch (e: NetworkErrorException) {
                view.showError(e.message!!)
            }
        }
    }

    fun onRefresh() {
        view.hideWeatherList()
        init()
    }

    interface View {
        fun showWeather(weatherData: List<Weather>)
        fun hideWeatherList()
        fun showError(message: String)
    }
}