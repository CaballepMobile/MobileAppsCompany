package com.example.admin.week5codechallengetry2.model.data;

import com.example.admin.week5codechallengetry2.model.entity.PlaceDatum;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface PlaceDatumService {

    @GET("api/location/search/")
    Observable<Response<List<PlaceDatum>>> getPlaceDatum(@Query("query") String query);
}
