package com.example.caballep.walmartchallenge.data.service;

import com.example.caballep.walmartchallenge.data.model.WalmartData;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService
{
    @GET("v1/search")
    Single<WalmartData> getSearchResults(@Query("query") String searchText,
                                         @Query("format") String responseFormat,
                                         @Query("apiKey") String apiKey);
}
