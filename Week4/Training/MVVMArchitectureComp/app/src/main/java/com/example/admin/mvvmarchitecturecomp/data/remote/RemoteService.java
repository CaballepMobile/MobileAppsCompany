package com.example.admin.mvvmarchitecturecomp.data.remote;

import com.example.admin.mvvmarchitecturecomp.data.remote.models.WeatherApiResponse;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

    @GET("data/2.5/forecast")
    Single<WeatherApiResponse> getWeatherForecast(@Query("id") String cityId, @Query("APPID") String apiKey);
}
