package com.example.admin.daily4week3;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.location.LocationManager;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.daily4week3.adapters.LocationWeatherRecyclerAdapter;
import com.example.admin.daily4week3.data.remote.IWeatherService;
import com.example.admin.daily4week3.data.remote.WeatherService;
import com.example.admin.daily4week3.models.List;
import com.example.admin.daily4week3.models.LocationWeather;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOG";
    EditText etZip;
    TextView tvCurrentCity;
    LocationWeather locationWeather;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeViews();
    }

    private void InitializeViews(){
        etZip = findViewById(R.id.etZip);
        tvCurrentCity = findViewById(R.id.tvCurrentCity);
        recyclerView = findViewById(R.id.rvForecast);
    }

    @SuppressLint("CheckResult")
    private LocationWeather getLocationWeatherByZIP(String zipCode){

        WeatherService weatherService = WeatherService.getWeatherService();
        weatherService.getWeatherData(zipCode)


                .subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())

                .doOnSuccess(data -> {

                    //I Tried to run in the UI Thread but did not work...
                    Log.d(TAG, "getLocationWeatherByZIP: " + data.getCity().getName().toString());
                    locationWeather = data;

                }).subscribe(data -> Log.d(TAG, "MakeOkHttpCallRetrofitRx: "), Throwable::printStackTrace);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return locationWeather;
    }

    private void fillRecyclerView(LocationWeather locationWeather){

        recyclerView = findViewById(R.id.rvForecast);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        LocationWeatherRecyclerAdapter locationWeatherRecyclerAdapter = new LocationWeatherRecyclerAdapter(locationWeather.getList());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(locationWeatherRecyclerAdapter);
        recyclerView.setItemAnimator(itemAnimator);
    }

    @SuppressLint("CheckResult")
    public void evtFindWeatherByZip(View view) {

        String zipCode = etZip.getText().toString();
        if(zipCode.matches("[0-9]+") && zipCode.length() > 4){

            //locationWeather = getLocationWeatherByZIP(etZip.getText().toString());
            WeatherService.getWeatherService()
                    .getWeatherData(zipCode)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(locationWeather1 ->{
                        String cityStateName = locationWeather1.getCity().getName() + ", " + locationWeather1.getCity().getCountry();
                        tvCurrentCity.setText(cityStateName);
                        fillRecyclerView(locationWeather1);
                    }, Throwable::printStackTrace);

//            String city = locationWeather.getCity().getName();
//            String country = locationWeather.getCity().getCountry();

            //String cityStateName = locationWeather.getCity().getName() + ", " + locationWeather.getCity().getCountry();
            //tvCurrentCity.setText(cityStateName);



        }else{
            new Thread(()->{
                runOnUiThread(()->{
                    tvCurrentCity.setText("That zip code is not valid.");
                    tvCurrentCity.setTextColor(Color.RED);
                });
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(()->{
                    tvCurrentCity.setText("Please introduce a Zip code...");
                    tvCurrentCity.setTextColor(Color.GRAY);
                });
            }).start();
        }
    }
}