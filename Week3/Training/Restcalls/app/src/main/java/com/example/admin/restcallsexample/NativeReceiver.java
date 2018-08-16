package com.example.admin.restcallsexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class NativeReceiver extends BroadcastReceiver {

    public static final String TAG = "NativeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getIntExtra(Constants.KEY.CODE, 0)
                + "\n" + intent.getStringExtra(Constants.KEY.MESSAGE));

        String response = intent.getStringExtra(Constants.KEY.RESPONSE);

        try {
            JSONObject reader = new JSONObject(response);
            JSONObject widget = reader.getJSONObject("widget");
            JSONObject text = widget.getJSONObject("text");
            String style = text.getString("style");
            Toast.makeText(context, style, Toast.LENGTH_LONG).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}