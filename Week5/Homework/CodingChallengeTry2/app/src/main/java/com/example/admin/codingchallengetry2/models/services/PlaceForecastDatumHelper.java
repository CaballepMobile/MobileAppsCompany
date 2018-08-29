package com.example.admin.codingchallengetry2.models.services;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module(includes = {OkHttpModule})
public class PlaceForecastDatumHelper {

    @Provides
    public Retrofit getRetrofit (OkHttpClient okHttpClient) {



    }
}
