package com.example.admin.mvvmarchitecturecomp.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.example.admin.mvvmarchitecturecomp.AppController;
import com.example.admin.mvvmarchitecturecomp.data.remote.RepositoryModule.Repository;
import com.example.admin.mvvmarchitecturecomp.data.remote.RepositoryModule.RepositoryImpl;
import com.example.admin.mvvmarchitecturecomp.data.remote.models.ApiList;
import com.example.admin.mvvmarchitecturecomp.data.remote.models.Weather;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends AndroidViewModel {

    private Application aplication;
    private MutableLiveData<String> message = new MutableLiveData<>();

    @Inject
    Repository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        ((AppController)application).getAppComponent().Inject(this);
    }

    public LiveData<List<List<Weather>>> getWeatherForcast() {
        repository.getWeatherForecast();
        return Transformations.map(((RepositoryImpl)repository).getWeatherForecastLiveData(), input -> {
            List<List<Weather>> weatherList = new ArrayList<>();
            for (ApiList list: input) {
                list.getWeather().get(0).setDate(list.getDtTxt());
                weatherList.add(list.getWeather());
            }

            message.setValue("We're done!");

            return weatherList;
        });
    }

    public MutableLiveData<String> getMessage() {
        return message;
    }
}
