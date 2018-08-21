package com.example.admin.week4daily1.service;

import com.example.admin.week4daily1.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserAPI {

    @GET("users/{userName}")
    Call<User> getUser(@Path("userName") String userName);

}
