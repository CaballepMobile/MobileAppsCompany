package com.example.admin.codingchallengetry2.models.services;

import android.util.Log;

import com.example.admin.codingchallengetry2.utils.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {})
public class PlaceForecastDatumHelper {

    private static final String TAG = "PlaceForecastDatumHelpe_LOG";

    public Retrofit getRetrofit (OkHttpClient okHttpClient) {

        Log.d(TAG, "getPlaceForecastDatum: ");
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
