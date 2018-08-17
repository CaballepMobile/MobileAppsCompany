package com.example.admin.restcallsexample.data.remote;

import com.example.admin.restcallsexample.Constants;
import com.example.admin.restcallsexample.models.WeatherData;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceHelper {

    //The reason why this is a singleton is because it is more efficient to have only one connection
    public static final String ZIP = "94040";
    public static final String APP_ID = "b1b15e88fa797225412429c1c50c122a1";
    private OkHttpClient okHttpClient;
    private static RemoteServiceHelper INSTANCE;

    private RemoteServiceHelper(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static RemoteServiceHelper getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new RemoteServiceHelper();
        }

        return INSTANCE;
    }

    //IMPORTANT!!!! THIS IS A RETROFIT CALL NOT A HTTP CALL
    public Call<ResponseBody> GetWeatherData(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.WEATHER_BASE_URL)
                .build();
        RemoteService service = retrofit.create(RemoteService.class);
        return service.getWeatherData(ZIP, APP_ID);
    }

    public Single<WeatherData> GetWeatherData_2() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.WEATHER_BASE_URL)
                .build();
        RemoteService remoteService = retrofit.create(RemoteService.class); //this thing uses a dynamic proxy
        return remoteService.getWeatherData_2(ZIP, APP_ID);
    }
}