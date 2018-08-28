package com.example.admin.wee4daily3.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse {

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    @SerializedName("repositories")
    private List<Repository> repositories;

    public List<Repository> getRepositories;
}