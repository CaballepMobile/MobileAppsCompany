package com.example.admin.mvvmarchitecturecomp.data.remote.RepositoryModule;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;

import com.example.admin.mvvmarchitecturecomp.data.remote.RemoteServiceHelper;
import com.example.admin.mvvmarchitecturecomp.data.remote.models.ApiList;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepositoryImpl implements Repository {

    private MutableLiveData<List<ApiList>> weatherForecastLiveData = new MutableLiveData<>();
    private RemoteServiceHelper remoteServiceHelper;

    public RepositoryImpl(RemoteServiceHelper remoteServiceHelper){
        this.remoteServiceHelper = remoteServiceHelper;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getWeatherForecast() {
        remoteServiceHelper.getWeatherForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ->
                    weatherForecastLiveData.setValue(response.getApiList())
                , Throwable::printStackTrace);
    }

    public MutableLiveData<List<ApiList>> getWeatherForecastLiveData() {
        return weatherForecastLiveData;
    }
}
