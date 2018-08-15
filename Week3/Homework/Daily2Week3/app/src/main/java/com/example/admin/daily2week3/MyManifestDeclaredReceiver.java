package com.example.admin.daily2week3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyManifestDeclaredReceiver extends BroadcastReceiver {
    public static final String TAG = "MyManifestDeclaredReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        String message = intent.getStringExtra("data");
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }
}
