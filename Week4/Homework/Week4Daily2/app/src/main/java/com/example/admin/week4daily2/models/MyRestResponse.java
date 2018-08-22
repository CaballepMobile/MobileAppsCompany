package com.example.admin.week4daily2.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyRestResponse {
    @SerializedName("messages")
    private List<String> messages;

    @SerializedName("userResult")
    private User userResult;

    public User getUserResult() {
        return userResult;
    }

    public List<String> getMessages() {
        return messages;
    }

    @SerializedName("respositoryResult")
    private List<Repository> repositoryResult;

    private List<Repository> getRepositoryResult(){ return repositoryResult; }

    //private List<String> getMessages() { return messages; }
}
