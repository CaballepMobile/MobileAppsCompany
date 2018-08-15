package com.example.admin.services.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyBoundService extends Service {

    private static final String TAG = "MyBoundService_LOGTAG";
    public IBinder binder = new MyBinder();
    public MyBoundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public class MyBinder extends Binder{
        public MyBoundService getService(){
            return MyBoundService.this;
        }
    }

    public int GetRandomData(){
        return new Random().nextInt(100)+1;
    }
}