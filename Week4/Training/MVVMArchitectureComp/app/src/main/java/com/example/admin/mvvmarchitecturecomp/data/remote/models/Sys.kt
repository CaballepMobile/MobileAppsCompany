package com.example.admin.mvvmarchitecturecomp.data.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sys {

    @SerializedName("pod")
    @Expose
    var pod: String? = null

}