package com.example.caballep.intentservicebutton;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MessageHandler extends Handler {

    public static final String TAG = "MessageHandler_LOG";
    private MainActivity activity;

    public MessageHandler(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void handleMessage(Message message) {
        Log.d(TAG, "handleMessage: ");
        Bundle bundle = message.getData();
        int value = bundle.getInt("BundleValue");
        Log.d(TAG, "handleMessage: Getting message from bundle: " + value);
        activity.tv.setText(String.valueOf(value));
    }
}
