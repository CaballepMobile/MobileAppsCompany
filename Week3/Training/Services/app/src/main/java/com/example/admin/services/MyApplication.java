package com.example.admin.services;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication_LOGTAG";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
