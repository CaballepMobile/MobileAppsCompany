package com.example.caballep.walmartchallenge.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;


import com.example.caballep.walmartchallenge.AppController;
import com.example.caballep.walmartchallenge.data.model.Item;
import com.example.caballep.walmartchallenge.data.repository.Repository;
import com.example.caballep.walmartchallenge.data.repository.RepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainViewModel
        extends AndroidViewModel
{
    @Inject
    Repository myRepo;

    public MainViewModel(@NonNull Application application)
    {
        super(application);


        ((AppController) application).getAppComponet().inject(this);
    }



    public LiveData<List<Item>> getWeatherForecast(String srchItm)
    {
        myRepo.getSearchResults(srchItm);

        return Transformations.map(((RepositoryImpl) myRepo)
                        .getWalmartSearchLiveData(),
                input ->
                {
                    List<Item> weaatherList = new ArrayList<>();

                    for(Item list : input)
                    {
                        weaatherList.add(list);
                    }
                    return weaatherList;
                });
    }
}
