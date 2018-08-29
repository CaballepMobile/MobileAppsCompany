package com.example.admin.codingchallengetry2.di.modules;

import com.example.admin.codingchallengetry2.models.services.PlaceForecastDatumService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class WeatherModule {

    @Provides
    public PlaceForecastDatumService getEndPoints(Retrofit retrofit){
        return retrofit.create(PlaceForecastDatumService.class);
    }

}
