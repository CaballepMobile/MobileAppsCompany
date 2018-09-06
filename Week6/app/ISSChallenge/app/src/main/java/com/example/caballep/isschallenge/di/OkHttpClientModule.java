package com.example.caballep.isschallenge.di;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientModule {

    public OkHttpClient getOkHttpClient(){

        HttpLoggingInterceptor myInterceptor = new HttpLoggingInterceptor();

        myInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(myInterceptor)
                .build();
    }
}
