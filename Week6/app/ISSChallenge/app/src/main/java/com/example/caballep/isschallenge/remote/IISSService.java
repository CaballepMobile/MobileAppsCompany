package com.example.caballep.isschallenge.remote;

import com.example.caballep.isschallenge.model.ISSData;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IISSService {

    @GET("iss-pass.json")
    Single<ISSData> getISSData(@Query("lat") double lat, @Query("lon") double lon);
}
