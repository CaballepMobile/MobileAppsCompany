package com.example.admin.week4weekend.remote;

import com.example.admin.week4weekend.models.PlacesData;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

    @GET("maps/api/place/nearbysearch/json")
    Single<PlacesData> getPlacesData(@Query("location") String coord,
                                     @Query("rankby") String distance,
                                     @Query("name") String name,
                                     @Query("key") String apiKey);
}
