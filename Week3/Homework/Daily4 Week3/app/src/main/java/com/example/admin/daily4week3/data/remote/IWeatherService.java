package com.example.admin.daily4week3.data.remote;

import com.example.admin.daily4week3.models.LocationWeather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWeatherService {
    @GET("data/2.5/forecast")
    Single<LocationWeather> getWeatherByZIP(@Query("zip") String zip, @Query("units") String units, @Query("appid") String appId);
}