package com.example.caballep.isschallenge.remote;

import com.example.caballep.isschallenge.di.OkHttpClientModule;
import com.example.caballep.isschallenge.di.RetrofitModule;
import com.example.caballep.isschallenge.helper.Constants;
import com.example.caballep.isschallenge.model.ISSData;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class ISSService {

    public Single<ISSData> getISSData(double lat, double lon){

        RetrofitModule retrofitModule = new RetrofitModule();
        OkHttpClientModule okHttpClientModule = new OkHttpClientModule();

        IISSService iissService = retrofitModule
                .getRetrofit(Constants.BASE_URL, okHttpClientModule.getOkHttpClient())
                .create(IISSService.class);

        return iissService.getISSData(lat, lon);
    }
}
