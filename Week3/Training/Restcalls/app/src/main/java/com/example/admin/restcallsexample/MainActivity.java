package com.example.admin.restcallsexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.restcallsexample.data.remote.RemoteServiceHelper;
import com.example.admin.restcallsexample.models.WeatherData;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOGTAG";
    private NativeReceiver nativeReceiver;
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nativeReceiver = new NativeReceiver();
        tvText = findViewById(R.id.tvText);
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

        switch (view.getId()) {
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

    @SuppressLint("CheckResult")
    public void MakeOkHttpCallRetrofitSync(View view) {

        RemoteServiceHelper remoteServiceHelper = RemoteServiceHelper.getINSTANCE();
        Gson gson = new Gson();

        //Instead of using thread we are using rxjava
        Single.fromCallable(() -> {
            retrofit2.Response<ResponseBody> response = remoteServiceHelper.GetWeatherData().execute();
            String json = response.body().string(); //since we know is json...
            WeatherData data = gson.fromJson(json, WeatherData.class);
            return data;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess((data) -> {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    }).subscribe(data -> tvText.setText(data.getCity().getName() + " " + data.getCity().getPopulation()), Throwable::printStackTrace);
    }

    public void MakeOkHttpCallRetrofitASync(View view) {

        RemoteServiceHelper remoteServiceHelper = RemoteServiceHelper.getINSTANCE();
        Gson gson = new Gson();

        remoteServiceHelper.GetWeatherData().enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                runOnUiThread(() -> {
                    try {
                        String json = response.body().string();
                        WeatherData weatherData = gson.fromJson(json, WeatherData.class);
                        Log.d(TAG, "onResponse: " + json);
                        Toast.makeText(MainActivity.this, weatherData.getCod(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @SuppressLint("CheckResult")
    public void MakeOkHttpCallRetrofitRx(View view) {

        RemoteServiceHelper remoteServiceHelper = RemoteServiceHelper.getINSTANCE();
        remoteServiceHelper.GetWeatherData_2()
                .subscribeOn(Schedulers.io())
                .doOnSuccess(data ->
                        runOnUiThread(() -> {
                            Toast.makeText(this, data.getCity().getCountry() + " " + data.getCity().getName(), Toast.LENGTH_SHORT).show();
                        }))
                .subscribe(data -> Log.d(TAG, "MakeOkHttpCallRetrofitRx: "), Throwable::printStackTrace);
    }
}