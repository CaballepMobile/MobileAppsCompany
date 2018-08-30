package com.example.admin.codechallengekotlin.data.repository

import android.arch.lifecycle.MutableLiveData
import com.example.admin.codechallengekotlin.data.remote.models.MetaWeatherResponse

interface Repository {

    val weatherForecastLiveData: MutableLiveData<List<MetaWeatherResponse>>
    fun getWeatherForecast(woeId:String)
}