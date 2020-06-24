package com.example.openweatherapi.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapi.R
import com.example.openweatherapi.data.model.Weather
import com.squareup.picasso.Picasso

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>() {

    private var weatherList: List<Weather> = emptyList()

    fun addItems(items: List<Weather>){
        this.weatherList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherViewHolder {
        return WeatherViewHolder.from(parent)
    }

    override fun getItemCount() = weatherList.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)
    }

    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val stateImg = view.findViewById<ImageView>(R.id.stateImg)
        private val weatherTxt = view.findViewById<TextView>(R.id.weatherTxt)
        private val descriptionTxt = view.findViewById<TextView>(R.id.descriptionTxt)
        private val tempTxt = view.findViewById<TextView>(R.id.tempTxt)
        private val maxTempTxt = view.findViewById<TextView>(R.id.maxTempTxt)
        private val minTempTxt = view.findViewById<TextView>(R.id.minTempTxt)

        fun bind(weather: Weather){
            with(weather){
                val icon = weatherDetail[0].weatherIcon
                Picasso.get()
                    .load("http://openweathermap.org/img/wn/$icon@2x.png")
                    .into(stateImg)
                weatherTxt.text = weatherDetail[0].weatherName
                descriptionTxt.text = weatherDetail[0].weatherDescription
                tempTxt.text = tempData.dayTemp.toString()
                maxTempTxt.text = tempData.maxTemp.toString()
                minTempTxt.text = tempData.minTemp.toString()
            }
        }

        companion object{
            fun from(parent: ViewGroup): WeatherViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.weather_item, parent, false)
                return WeatherViewHolder(view)
            }
        }
    }
}