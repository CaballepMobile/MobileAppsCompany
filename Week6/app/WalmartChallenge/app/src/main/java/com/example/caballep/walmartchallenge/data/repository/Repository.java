package com.example.caballep.walmartchallenge.data.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.caballep.walmartchallenge.data.model.Item;


public interface Repository
{
    MutableLiveData<Item> walmartSearchLiveData = null;

    void getSearchResults(String srchItm);
}
