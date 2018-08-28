package com.example.admin.mvvmarchitecturecomp.data.remote.RepositoryModule;

import android.arch.lifecycle.MutableLiveData;

import com.example.admin.mvvmarchitecturecomp.data.remote.models.ApiList;

import java.util.List;

public interface Repository {

    MutableLiveData<List<ApiList>> weatherForecastLiveData = null;
    void getWeatherForecast();
}
