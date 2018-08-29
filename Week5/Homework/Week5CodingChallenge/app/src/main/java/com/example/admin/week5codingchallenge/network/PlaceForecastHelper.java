package com.example.admin.week5codingchallenge.network;

import android.util.Log;

import com.example.admin.week5codingchallenge.models.PlaceForecastDatum;
import com.example.admin.week5codingchallenge.utils.Constants;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceForecastHelper {

    public static final String TAG = "PlaceForecastHelper_LOG";
    private OkHttpClient okHttpClient;
    private static PlaceForecastHelper INSTANCE;

    private PlaceForecastHelper() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static PlaceForecastHelper getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PlaceForecastHelper();
        }

        return INSTANCE;
    }

    private Single<PlaceForecastDatum> getPlaceForecastDatum(String placeId) {

        Log.d(TAG, "getPlaceForecastDatum: ");
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        PlaceForecastService placeForecastService = retrofit.create(PlaceForecastService.class);

        //Log.d(TAG, "getPlaceForecastDatum: " + placeForecastService.getPlaceForecastDatum(placeId));
        return placeForecastService.getPlaceForecastDatum(placeId);
    }

    public List<PlaceForecastDatum> getAllPlaceForecasts() {

        Log.d(TAG, "getAllPlaceForecasts: ");

        //Hardcoded, after this work will do it the right way
        String[] arrayPlaceId = {"890869", "906057", "2455920", "44418", "2459115"};

        List<PlaceForecastDatum> placeForecastDatumList = new ArrayList<>();

        for (String placeId : arrayPlaceId) {

            getPlaceForecastDatum(placeId)
                    .subscribeOn(Schedulers.io())

                    .doOnSuccess(data -> {
                        Log.d(TAG, "getAllPlaceForecasts: " + data.toString());
                        placeForecastDatumList.add(data); //0 for Today, 1 for Tomorrow
                    })
                    .subscribe();



        }

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return placeForecastDatumList;
    }
}
