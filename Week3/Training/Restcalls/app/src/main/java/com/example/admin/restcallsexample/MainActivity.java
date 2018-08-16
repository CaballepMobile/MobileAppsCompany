package com.example.admin.restcallsexample;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOGTAG";
    private NativeReceiver nativeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nativeReceiver = new NativeReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.NATIVR_RECEIVER_ACTION);
        registerReceiver(nativeReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(nativeReceiver);
    }

    public void MakeCall(View view) {

        switch (view.getId()){
            case R.id.btnNativeHttp:
                Intent intent = new Intent(this, MyIntentService.class);
                intent.putExtra(Constants.KEY.URL, Constants.INTENT_SERVICE_BASE_URL);
                startService(intent);
                break;
        }
    }

    public void MakeOkHttpCall(View view) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request syncRequest = new Request.Builder()
                .url(Constants.PERSON_BASE_URL)
                .build();

        new Thread(() -> {
            Response response = null;
            try {
                response = okHttpClient.newCall(syncRequest).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                runOnUiThread(() -> {
                    try {
                        Toast.makeText(this, jsonObject.getString("name"), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }).start();
    }

    public void MakeOkHttpCallAsync(View view) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Constants.PERSON_BASE_URL)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(() -> {

                    try {
                        Gson gson = new Gson();
                        String personJson = response.body().string();
                        Person person = gson.fromJson(personJson, Person.class);
                        Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });

    }

    public void MakeOkHttpCallRetrofitSync(View view) {

    }
}
