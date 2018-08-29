package com.example.admin.codingchallengetry2.models.services;

import com.example.admin.codingchallengetry2.models.entities.PlaceForecastDatum;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlaceForecastDatumService {

    @GET("/api/location/{woeid}")
    Single<PlaceForecastDatum> get_place_weather(@Path("woeid") String woeid);
}
