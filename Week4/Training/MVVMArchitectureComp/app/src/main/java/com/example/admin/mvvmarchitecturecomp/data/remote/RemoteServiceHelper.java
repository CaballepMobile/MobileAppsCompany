package com.example.admin.mvvmarchitecturecomp.data.remote;

import com.example.admin.mvvmarchitecturecomp.data.remote.models.WeatherApiResponse;
import com.example.admin.mvvmarchitecturecomp.utils.Constants;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceHelper {

    public Single<WeatherApiResponse> getWeatherForecast() {

        Retrofit retrofit = getRetrofit(Constants.URLS.WEATHER_API_BASE_URL);
        RemoteService service = retrofit.create(RemoteService.class);
        return service.getWeatherForecast("5210847", "b82b90e31b3b9b2723540c4b31afb584");
    }

    private Retrofit getRetrofit(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
