package com.example.admin.week5codechallengetry2.model.data;

import com.example.admin.week5codechallengetry2.model.constants.Constants;
import com.example.admin.week5codechallengetry2.model.entity.PlaceDatum;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class PlaceDatumHelper {
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private PlaceDatumService placeDatumService;
    OkHttpClient.Builder builder;

    private static class Singleton {
        private static final PlaceDatumHelper INSTANCE = new PlaceDatumHelper();
    }

    public static PlaceDatumHelper INSTANCE = new PlaceDatumHelper();

    private PlaceDatumHelper() {
        builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constants.WEATHER_BASE_URL)
                .build();
        placeDatumService = retrofit.create(PlaceDatumService.class);

        public void getPlaceDatum(Subscriber<PlaceDatum> subscriber, int start, int count){
            placeDatumService.getPlaceDatum(start, count)
                    .map(new Func1<Response<List<PlaceDatum>>, List<PlaceDatum>>() {
                        @Override
                        public List<PlaceDatum> call(Response<List<PlaceDatum>> listResponse) {
                            return listResponse.);
                        }
                    })
                    .flatMap(new Func1<List<Movie>, Observable<Movie>>() {
                        @Override
                        public Observable<Movie> call(List<Movie> movies) {
                            return Observable.from(movies);
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        }
    }
}
