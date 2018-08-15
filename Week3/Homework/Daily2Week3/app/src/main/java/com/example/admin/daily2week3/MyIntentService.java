package com.example.admin.daily2week3;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public static final String TAG = "MyIntentService_LOGTAG";

    public MyIntentService(){
        super("MyIntentService");
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: ");
        Intent newIntent = new Intent();

        //String message = intent.getStringExtra("data");
        //newIntent.putExtra("data", message);
        Person person = intent.getParcelableExtra("data");
        newIntent.putExtra("data", person);

        newIntent.setAction(Constants.MY_SERVICE_BROADCAST);
        newIntent.setPackage(getPackageName());
        sendBroadcast(newIntent);
    }
}