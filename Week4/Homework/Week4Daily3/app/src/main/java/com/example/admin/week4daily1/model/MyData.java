package com.example.admin.week4daily1.model;

import com.google.gson.annotations.SerializedName;

public class MyData {

    @SerializedName("RestResponse")
    private MyRestResponse restResponse;

    public MyRestResponse getRestResponse() {
        return restResponse;
    }
}
