package com.example.admin.services.Services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public static final String TAG = "MyIntentService_LOGTAG";

    public MyIntentService(){
        super("");
    }

    public MyIntentService(String name){
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (intent.getAction()){
            case "getRepo":
                Log.d(TAG, "onHandleIntent: " + intent.getStringExtra("KEY") + Thread.currentThread());
                break;

            case "getProfile":
                Log.d(TAG, "onHandleIntent: " + intent.getStringExtra("KEY") + Thread.currentThread());
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
