package com.example.admin.week5codingchallenge.network;

import com.example.admin.week5codingchallenge.models.PlaceForecastDatum;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface PlaceForecastService {

    @GET("location/{placeId}")
    Single<PlaceForecastDatum> getPlaceForecastDatum(@Path("placeId") String placeId);
}
