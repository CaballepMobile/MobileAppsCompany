package com.example.caballep.walmartchallenge.data.service;

import com.example.caballep.walmartchallenge.data.model.WalmartData;
import com.example.caballep.walmartchallenge.util.Constants;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceHelper
{
    private Retrofit getRetrofit (String inBaseUrl)
    {
        HttpLoggingInterceptor myInterceptor = new HttpLoggingInterceptor();

        myInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient myClient = new OkHttpClient.Builder()
                                                .addInterceptor(myInterceptor)
                                                .build();

        return new Retrofit.Builder()
                            .baseUrl(inBaseUrl)
                            .client(myClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
    }

    public Single<WalmartData> getSearchResults(String srchItm)
    {
        Retrofit myRetrofit = getRetrofit(Constants.WALMART_API_BASE_URL);
        RemoteService myService = myRetrofit.create(RemoteService.class);

        return myService.getSearchResults(srchItm,
                                            Constants.WALMART_RESPONSE_FORMAT,
                                            Constants.WALMART_API_KEY);
    }

}
