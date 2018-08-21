package com.example.admin.week4daily1.service;

import com.example.admin.week4daily1.model.Repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositoryAPI {

    @GET("users/{userName}/repos")
    Call<Repository> getAllRepositories(@Path("userName") String userName);

}
