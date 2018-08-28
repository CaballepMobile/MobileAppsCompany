package com.example.admin.wee4daily3.service;

import com.example.admin.wee4daily3.model.Data;
import com.example.admin.week4daily1.model.MyData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositoryAPI {

    @GET("users/{userName}/repos")
    Call<Data> getAllRepositories(@Path("userName") String userName);
}
