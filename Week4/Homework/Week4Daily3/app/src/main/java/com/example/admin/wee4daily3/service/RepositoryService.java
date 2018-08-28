package com.example.admin.wee4daily3.service;

import com.example.admin.week4daily1.constants.ConstantsServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryService {

    private Retrofit retrofit = null;

    public RepositoryAPI getAPI() {
        String BASE_URL = ConstantsServices.BASE_URL;

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RepositoryAPI.class);
    }
}
