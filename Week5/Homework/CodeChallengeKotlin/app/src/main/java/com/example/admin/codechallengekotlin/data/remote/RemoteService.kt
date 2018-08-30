package com.example.admin.codechallengekotlin.data.remote

import com.example.admin.codechallengekotlin.data.remote.models.MetaWeatherResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService {
    @GET("api/location/{woeid}/{date}")
    fun getWeatherForecast(@Path("woeid") woeid:String, @Path("date") date:String) : Deferred<List<MetaWeatherResponse>>
}