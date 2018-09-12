package com.example.caballep.intentservicebutton.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class CounterService extends IntentService {

    public static final String TAG = "CounterService_LOG";
    private Messenger messageHandler;
    int count = 0;

    public CounterService() {
        super("");
        Log.d(TAG, "CounterService: ");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        
        Log.d(TAG, "onHandleIntent: ");
        Bundle extras = intent.getExtras();
        messageHandler = (Messenger) extras.get("Messenger");

        new Thread(new Runnable() {
            @Override
            public void run() {

                while(true) {
                    try {
                        Log.d(TAG, "run (before count++): " + count);
                        Thread.sleep(1000);
                        count++;
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putInt("BundleValue", count);
                        message.setData(bundle);
                        messageHandler.send(message);
                    } catch (InterruptedException e) {
                        Log.d(TAG, "run: Interrupted Exception");
                        e.printStackTrace();
                    } catch (RemoteException e) {
                        Log.d(TAG, "run: Remote Exception");
                        e.printStackTrace();
                    }


                }
            }
        }).start();
    }
}
