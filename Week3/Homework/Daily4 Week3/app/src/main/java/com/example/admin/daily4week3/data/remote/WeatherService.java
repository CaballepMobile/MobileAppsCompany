package com.example.admin.daily4week3.data.remote;

import com.example.admin.daily4week3.constants.WeatherAPIConstants;
import com.example.admin.daily4week3.models.LocationWeather;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherService {

    //HTTP is the way modern applications network.
    //It’s how we exchange data & media. Doing HTTP efficiently makes your stuff load faster and saves bandwidth.
    private OkHttpClient okHttpClient;

    //For the singleton pattern
    private IWeatherService iWeatherService;
    private static WeatherService INSTANCE;

    private WeatherService(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static WeatherService getWeatherService(){
        if(INSTANCE == null){
            INSTANCE = new WeatherService();
        }

        return INSTANCE;
    }

    public Single<LocationWeather> getWeatherData(String zipCode){
        Retrofit retrofit = new Retrofit.Builder() //Retrofit is a type-safe HTTP client for Android and Java

                .client(okHttpClient) //Retrofit uses a okHttp client
                .baseUrl(WeatherAPIConstants.SERVICE_ROOT_URL) //Base url of the API

                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build();

        IWeatherService service = retrofit.create(IWeatherService.class);
        return service.getWeatherByZIP(zipCode, WeatherAPIConstants.SERVICE_KEY);
    }
}
