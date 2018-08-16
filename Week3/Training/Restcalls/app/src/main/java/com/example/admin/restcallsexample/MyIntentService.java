package com.example.admin.restcallsexample;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MyIntentService extends IntentService {
    public static final String TAG = "MyIntentService";

    public MyIntentService(){
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: ");
        String url = intent.getStringExtra(Constants.KEY.URL);
        Intent newIntent = new Intent();
        Scanner scanner = null;

        try {
            URL connectionUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) connectionUrl.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            scanner = new Scanner(inputStream);
            StringBuilder stringBuilder = new StringBuilder();
            while(scanner.hasNext()){
                stringBuilder.append(scanner.nextLine());
            }
            int statusCode = httpURLConnection.getResponseCode();
            String statusMessage = httpURLConnection.getResponseMessage();
            newIntent.setAction(Constants.NATIVR_RECEIVER_ACTION);
            newIntent.putExtra(Constants.KEY.CODE, statusCode);
            newIntent.putExtra(Constants.KEY.MESSAGE, statusMessage);
            newIntent.putExtra(Constants.KEY.RESPONSE, stringBuilder.toString());
            sendBroadcast(newIntent);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
